package com.jnsousa.pagamento.data.vo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author Jairo Nascimento em 13/06/2021 as 18:17
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 7651576301788214074L;

  public ResourceNotFoundException(String exception) {
    super(exception);
  }
}
