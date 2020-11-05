package com.pensamentogeek.RestAPI.repository;

import com.pensamentogeek.RestAPI.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
