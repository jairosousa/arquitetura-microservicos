package com.jnsousa.pagamento.repository;

import com.jnsousa.pagamento.entity.ProdutoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author Jairo Nascimento em 13/06/2021
 */
@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {

}
