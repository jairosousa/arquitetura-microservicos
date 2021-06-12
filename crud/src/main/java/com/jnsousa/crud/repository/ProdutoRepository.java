package com.jnsousa.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.jnsousa.crud.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
