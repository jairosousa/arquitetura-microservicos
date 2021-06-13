package com.jnsousa.pagamento.services;

import com.jnsousa.pagamento.data.vo.ResourceNotFoundException;
import com.jnsousa.pagamento.data.vo.VendaVO;
import com.jnsousa.pagamento.entity.ProdutoVenda;
import com.jnsousa.pagamento.entity.Venda;
import com.jnsousa.pagamento.repository.ProdutoVendaRepository;
import com.jnsousa.pagamento.repository.VendaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Author Jairo Nascimento em 13/06/2021 as 18:07
 */
@Service
public class VendaService {

  private static final String MESSAGE_EXCEPTION = "No records foud for this ID";
  private final VendaRepository vendaRepository;
  private final ProdutoVendaRepository produtoVendaRepository;

  public VendaService(VendaRepository vendaRepository,
      ProdutoVendaRepository produtoVendaRepository) {
    this.vendaRepository = vendaRepository;
    this.produtoVendaRepository = produtoVendaRepository;
  }

  public VendaVO create(VendaVO vendaVO) {
    Venda venda = vendaRepository.save(Venda.create(vendaVO));
    List<ProdutoVenda> produtosSalvos = new ArrayList<>();
    vendaVO.getProdutos().forEach(pvVO -> {
      ProdutoVenda pv = ProdutoVenda.create(pvVO);
      pv.setVenda(venda);
      produtosSalvos.add(produtoVendaRepository.save(pv));
    });
    venda.setProdutos(produtosSalvos);
    return VendaVO.create(venda);
  }

  public Page<VendaVO> findAll(Pageable pageable){
    var page = vendaRepository.findAll(pageable);
    return page.map(this::convertTovendaVO);
  }

  private VendaVO convertTovendaVO(Venda venda) {
    return VendaVO.create(venda);
  }

  public VendaVO findById(Long id) {
    var entity = vendaRepository.findById(id)
        .orElseThrow(() -> {
          return new ResourceNotFoundException(MESSAGE_EXCEPTION);
        });

    return VendaVO.create(entity);
  }


}
