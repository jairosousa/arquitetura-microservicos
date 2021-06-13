package com.jnsousa.pagamento.entity;

import com.jnsousa.pagamento.data.vo.ProdutoVendaVO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

/**
 * Author Jairo Nascimento em 13/06/2021
 */

@Entity
@Table(name = "produto_venda")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProdutoVenda implements Serializable {

  private static final long serialVersionUID = -2898317097544727509L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "id_produto", nullable = false, length = 10)
  private Long idProduto;

  @Column(name = "quantidade", nullable = false, length = 10)
  private Integer quantidade;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_venda")
  private Venda venda;

  public static ProdutoVenda create(ProdutoVendaVO produtoVenda) {
    return new ModelMapper().map(produtoVenda, ProdutoVenda.class);
  }

}
