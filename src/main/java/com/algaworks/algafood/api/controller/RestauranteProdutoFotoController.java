package com.algaworks.algafood.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.FotoProdutoModelAssembler;
import com.algaworks.algafood.api.model.FotoProdutoModel;
import com.algaworks.algafood.api.model.input.FotoProdutoInput;
import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.service.CadastroProdutoService;
import com.algaworks.algafood.domain.service.CatalogoFotoProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos/{produtoId}/foto")
public class RestauranteProdutoFotoController {

  @Autowired
  private FotoProdutoModelAssembler fotoProdutoModelAssembler;

  @Autowired
  private CadastroProdutoService cadastroProduto;

  @Autowired
  private CatalogoFotoProdutoService catalogoFotoProduto;

  @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public FotoProdutoModel atualizarFoto(
      @PathVariable Long restauranteId,
      @PathVariable Long produtoId,
      @Valid FotoProdutoInput fotoProdutoInput) throws IOException {

    Produto produto = cadastroProduto.buscarOuFalhar(restauranteId, produtoId);

    FotoProduto foto = new FotoProduto();
    foto.setProduto(produto);
    foto.setDescricao(fotoProdutoInput.getDescricao());
    foto.setContentType(fotoProdutoInput.getArquivo().getContentType());
    foto.setTamanho(fotoProdutoInput.getArquivo().getSize());
    foto.setNomeProduto(fotoProdutoInput.getArquivo().getOriginalFilename());

    FotoProduto fotoSalva = catalogoFotoProduto.salvar(foto, fotoProdutoInput.getArquivo().getInputStream());

    return fotoProdutoModelAssembler.toModel(fotoSalva);

  }

  @GetMapping()
  public FotoProdutoModel buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
    FotoProduto fotoProduto = catalogoFotoProduto.buscarOuFalhar(restauranteId, produtoId);

    return fotoProdutoModelAssembler.toModel(fotoProduto);
  }

}
