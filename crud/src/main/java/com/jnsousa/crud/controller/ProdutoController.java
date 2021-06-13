package com.jnsousa.crud.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.jnsousa.crud.data.vo.ProdutoVO;
import com.jnsousa.crud.services.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author Jairo Nascimento em 12/06/2021
 */

@RestController
@RequestMapping("/produto")
public class ProdutoController {

  private final ProdutoService produtoService;
  private final PagedResourcesAssembler<ProdutoVO> assembler;

  public ProdutoController(ProdutoService produtoService,
      PagedResourcesAssembler<ProdutoVO> assembler) {
    this.produtoService = produtoService;
    this.assembler = assembler;
  }

  @GetMapping(value = "/{id}", produces = {"application/json", "application/xml",
      "application/x-yaml"})
  public ProdutoVO findById(@PathVariable("id") Long id) {
    ProdutoVO produtoVO = produtoService.findById(id);
    produtoVO.add(linkTo(methodOn(ProdutoController.class).findById(id)).withSelfRel());

    return produtoVO;
  }

  @GetMapping(produces = {"application/json", "application/xml",
      "application/x-yaml"})
  public ResponseEntity<?> findAll(Pageable pageable) {

    Page<ProdutoVO> produtos = produtoService.findAll(pageable);

    produtos.stream()
        .forEach(produtoVO -> produtoVO.add(
            linkTo(methodOn(ProdutoController.class).findById(produtoVO.getId())).withSelfRel()));
    PagedModel<EntityModel<ProdutoVO>> pagedModel = assembler.toModel(produtos);
    return new ResponseEntity<>(pagedModel, HttpStatus.OK);
  }

  @PostMapping(produces = {"application/json", "application/xml",
      "application/x-yaml"}, consumes = {"application/json", "application/xml",
      "application/x-yaml"})
  public ProdutoVO create(@RequestBody ProdutoVO produtoVO) {
    ProdutoVO proVO = produtoService.create(produtoVO);
    proVO.add(
        linkTo(methodOn(ProdutoController.class).findById(proVO.getId())).withSelfRel());
    return proVO;
  }

  @PutMapping(produces = {"application/json", "application/xml",
      "application/x-yaml"}, consumes = {"application/json", "application/xml",
      "application/x-yaml"})
  public ProdutoVO update(@RequestBody ProdutoVO produtoVO) {
    ProdutoVO proVO = produtoService.update(produtoVO);
    produtoVO.add(
        linkTo(methodOn(ProdutoController.class).findById(proVO.getId())).withSelfRel());
    return proVO;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    produtoService.delete(id);
    return ResponseEntity.ok().build();
  }
}
