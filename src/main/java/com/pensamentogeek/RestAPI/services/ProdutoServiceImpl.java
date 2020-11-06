package com.pensamentogeek.RestAPI.services;

import com.pensamentogeek.RestAPI.models.Produto;
import com.pensamentogeek.RestAPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Produto> find(Long id) {
        return this.produtoRepository.findById(id);
    }

    @Override
    public Produto create( Produto produto) {
        return this.produtoRepository.save(produto);
    }

    @Override
    public Produto update(Long id, Produto produto) {
        Produto produtoExiste = this.produtoRepository.getOne(id);
        if(produtoExiste != null){
            produto.setId(produtoExiste.getId());
            this.produtoRepository.save(produto);
            return produto;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Produto produto = this.produtoRepository.getOne(id);
        if (produto != null)  this.produtoRepository.delete(produto);


    }
}
