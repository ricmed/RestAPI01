package com.pensamentogeek.RestAPI.resources;

import com.pensamentogeek.RestAPI.models.Produto;
import com.pensamentogeek.RestAPI.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Produto find(@PathVariable(value = "id") Long id){
        return null;

    }

    @PostMapping
    @ResponseBody
    public Produto create(@RequestBody Produto produto){
        return null;

    }

    @PostMapping(value ="/{id}")
    @ResponseBody
    public Produto update(@PathVariable(value="id") Long id, @RequestBody Produto produto){
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value= "id") Long id){


    }
}
