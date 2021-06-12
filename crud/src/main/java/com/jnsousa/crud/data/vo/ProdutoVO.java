package com.jnsousa.crud.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jnsousa.crud.entity.Produto;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

/**
 * Author Jairo Nascimento em 12/06/2021
 */

@JsonPropertyOrder({"id", "nome", "estoque", "preco"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProdutoVO implements Serializable {

  private static final long serialVersionUID = -3284413986657665610L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("estoque")
  private Integer estoque;

  @JsonProperty("preco")
  private Double preco;

  public static ProdutoVO create(Produto produto) {
    return new ModelMapper().map(produto, ProdutoVO.class);
  }

}
