package com.pensamentogeek.RestAPI.resources;

import com.pensamentogeek.RestAPI.models.Produto;
import com.pensamentogeek.RestAPI.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @ResponseBody
    public List<Produto> findAll() {
        return this.produtoService.findAll() ;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Produto> find(@PathVariable(value = "id") Long id){
        return this.produtoService.find(id);

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Produto produto, Errors erros){
        if(!erros.hasErrors()){
            Produto produtoCriado = this.produtoService.create(produto);
            return new ResponseEntity<Produto>(produtoCriado, HttpStatus.CREATED);
        }
        return ResponseEntity
                .badRequest()
                .body(erros.
                        getAllErrors()
                        .stream().
                        map(msg  -> msg.getDefaultMessage())
                        .collect(Collectors.joining(",")));
    }

    @PutMapping(value ="/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@Valid @PathVariable(value="id") Long id, @RequestBody Produto produto, Errors erros){
        if(!erros.hasErrors()){
            Produto produtoAtualizado = this.produtoService.update(id, produto);
            return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
        }

        return ResponseEntity
                .badRequest()
                .body(erros.
                        getAllErrors()
                        .stream().
                                map(msg  -> msg.getDefaultMessage())
                        .collect(Collectors.joining(",")));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value= "id") Long id, HttpServletResponse response){
        this.produtoService.delete(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
