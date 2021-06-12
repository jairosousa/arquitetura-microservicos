package com.jnsousa.crud.services;

import com.jnsousa.crud.data.vo.ProdutoVO;
import com.jnsousa.crud.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

/**
 * Author Jairo Nascimento em 12/06/2021
 */

@Service
public class ProdutoService {

  private final ProdutoRepository produtoRepository;


  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public ProdutoVO create(ProdutoVO produtoVO) {
    return null;
  }
}
