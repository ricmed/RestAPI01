package com.pensamentogeek.RestAPI.services;

import com.pensamentogeek.RestAPI.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    public List<Produto> findAll();
    public Optional<Produto> find(Long id);
    public Produto create(Produto produto);
    public Produto update(Long id, Produto produto);
    public void delete(Long id);
}
