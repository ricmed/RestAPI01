package com.pensamentogeek.RestAPI.resources;

import com.pensamentogeek.RestAPI.models.Produto;
import com.pensamentogeek.RestAPI.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(value = "API REST - Model Produto")
@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {

        this.produtoService = produtoService;
    }

    @ApiOperation(value = "Encontra todos os produtos no banco de dados")
    @GetMapping (produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        List<Produto> list = this.produtoService.findAll();
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra um produto por id no banco de dados")
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> find(@PathVariable(value = "id") Long id){
        Optional<Produto> produto = this.produtoService.find(id);
        return new ResponseEntity<Produto>( produto.get(), HttpStatus.OK);

    }

    @ApiOperation(value = "Cria um novo produto no banco de dados")
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

    @ApiOperation(value = "Atualiza produto por id no banco de dados")
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

    @ApiOperation(value = "Deleta um produto por id no banco de dados")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value= "id") Long id){
        this.produtoService.delete(id);
    }
}
