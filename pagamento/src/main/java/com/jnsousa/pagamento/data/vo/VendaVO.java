package com.jnsousa.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jnsousa.pagamento.entity.ProdutoVenda;
import com.jnsousa.pagamento.entity.Venda;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

/**
 * Author Jairo Nascimento em 13/06/2021
 */

@JsonPropertyOrder({"id", "data", "valorTotal", "produtos"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {

  private static final long serialVersionUID = -7828307869990301685L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("data")
  private Date data;

  @JsonProperty("valorTotal")
  private Double valorTotal;

  @JsonProperty("produtos")
  private List<ProdutoVenda> produtos;

  public static VendaVO create(Venda venda) {
    return new ModelMapper().map(venda, VendaVO.class);
  }

}
