package com.pensamentogeek.RestAPI.resources;

import com.pensamentogeek.RestAPI.models.Produto;
import com.pensamentogeek.RestAPI.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

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
    public Produto create(@RequestBody Produto produto){
        return this.produtoService.create(produto);

    }

    @PutMapping(value ="/{id}")
    @ResponseBody
    public Produto update(@PathVariable(value="id") Long id, @RequestBody Produto produto){
        return this.produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value= "id") Long id, HttpServletResponse response){
        this.produtoService.delete(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
