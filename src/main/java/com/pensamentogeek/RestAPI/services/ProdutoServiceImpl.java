package com.pensamentogeek.RestAPI.services;

import com.pensamentogeek.RestAPI.models.Produto;
import com.pensamentogeek.RestAPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    @Override
    public Produto find() {
        return null;
    }

    @Override
    public Produto create() {
        return null;
    }

    @Override
    public Produto update() {
        return null;
    }

    @Override
    public void delete() {

    }
}
