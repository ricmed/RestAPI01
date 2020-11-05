package com.pensamentogeek.RestAPI.services;

import com.pensamentogeek.RestAPI.models.Produto;

import java.util.List;

public interface ProdutoService {
    public List<Produto> findAll();
    public Produto find();
    public Produto create();
    public Produto update();
    public void delete();
}
