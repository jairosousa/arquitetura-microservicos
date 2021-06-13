package com.jnsousa.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

/**
 * Author Jairo Nascimento em 13/06/2021 as 17:57
 */

@JsonPropertyOrder({"id", "idProduto","quantidade"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> implements Serializable {

  private static final long serialVersionUID = -6992868535850012514L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("idProduto")
  private Long idProduto;

  @JsonProperty("quantidade")
  private Integer quantidade;

  public static ProdutoVendaVO create(ProdutoVendaVO produtoVenda) {
    return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
  }

}
