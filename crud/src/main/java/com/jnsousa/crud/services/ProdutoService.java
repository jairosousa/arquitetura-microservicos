package com.jnsousa.crud.services;

import com.jnsousa.crud.data.vo.ProdutoVO;
import com.jnsousa.crud.data.vo.ResourceNotFoundException;
import com.jnsousa.crud.entity.Produto;
import com.jnsousa.crud.repository.ProdutoRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Author Jairo Nascimento em 12/06/2021
 */

@Service
public class ProdutoService {

  private static final String MESSAGE_EXCEPTION = "No records foud for this ID";
  private final ProdutoRepository produtoRepository;


  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public ProdutoVO create(ProdutoVO produtoVO) {
    Produto produto = produtoRepository.save(Produto.create(produtoVO));
    return ProdutoVO.create(produto);
  }

  public Page<ProdutoVO> findAll(Pageable pageable){
    var page = produtoRepository.findAll(pageable);
    return page.map(this::convertToProdutoVo);
  }

  private ProdutoVO convertToProdutoVo(Produto produto) {
    return ProdutoVO.create(produto);
  }

  public ProdutoVO findById(Long id) {
    var entity = produtoRepository.findById(id)
        .orElseThrow(() -> {
          return new ResourceNotFoundException(MESSAGE_EXCEPTION);
        });

    return ProdutoVO.create(entity);
  }

  public ProdutoVO update(ProdutoVO produtoVO) {
    final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());

    if (!optionalProduto.isPresent()) {
      throw new ResourceNotFoundException(MESSAGE_EXCEPTION);
    }
    return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
  }

  public void delete(Long id) {
    var entity = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(MESSAGE_EXCEPTION));

    produtoRepository.delete(entity);
  }
}
