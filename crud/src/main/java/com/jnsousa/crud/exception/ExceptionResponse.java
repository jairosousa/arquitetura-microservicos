package com.jnsousa.crud.exception;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Author Jairo Nascimento em 13/06/2021
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

  private static final long serialVersionUID = -7654408805993089324L;

  private Date timestamp;
  private String mensagem;
  private String details;
}
