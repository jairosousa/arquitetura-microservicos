package com.jnsousa.pagamento.repository;

import com.jnsousa.pagamento.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author Jairo Nascimento em 13/06/2021
 */
@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
