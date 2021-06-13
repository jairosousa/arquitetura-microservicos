package com.jnsousa.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jnsousa.pagamento.entity.Produto;
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
 * Author Jairo Nascimento em 13/06/2021 as 17:54
 */
@JsonPropertyOrder({"id", "estoque"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {

  private static final long serialVersionUID = -1487166614209400779L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("estoque")
  private Integer estoque;

  public static ProdutoVO create(Produto produto) {
    return new ModelMapper().map(produto, ProdutoVO.class);
  }
}
