package com.jnsousa.pagamento.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.jnsousa.pagamento.data.vo.VendaVO;
import com.jnsousa.pagamento.services.VendaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author Jairo Nascimento em 13/06/2021 as 18:36
 */

@RestController
@RequestMapping("/venda")
public class VendaController {

  private final VendaService vendaService;
  private final PagedResourcesAssembler<VendaVO> assembler;

  public VendaController(VendaService vendaService,
      PagedResourcesAssembler<VendaVO> assembler) {
    this.vendaService = vendaService;
    this.assembler = assembler;
  }


  @GetMapping(value = "/{id}", produces = {"application/json", "application/xml",
      "application/x-yaml"})
  public VendaVO findById(@PathVariable("id") Long id) {
    VendaVO produtoVO = vendaService.findById(id);
    produtoVO.add(linkTo(methodOn(VendaController.class).findById(id)).withSelfRel());

    return produtoVO;
  }

  @GetMapping(produces = {"application/json", "application/xml",
      "application/x-yaml"})
  public ResponseEntity<?> findAll(Pageable pageable) {

    Page<VendaVO> produtos = vendaService.findAll(pageable);

    produtos.stream()
        .forEach(produtoVO -> produtoVO.add(
            linkTo(methodOn(VendaController.class).findById(produtoVO.getId())).withSelfRel()));
    PagedModel<EntityModel<VendaVO>> pagedModel = assembler.toModel(produtos);
    return new ResponseEntity<>(pagedModel, HttpStatus.OK);
  }

  @PostMapping(produces = {"application/json", "application/xml",
      "application/x-yaml"}, consumes = {"application/json", "application/xml",
      "application/x-yaml"})
  public VendaVO create(@RequestBody VendaVO vendaVO) {
    VendaVO venVO = vendaService.create(vendaVO);
    venVO.add(
        linkTo(methodOn(VendaController.class).findById(venVO.getId())).withSelfRel());
    return venVO;
  }

}
