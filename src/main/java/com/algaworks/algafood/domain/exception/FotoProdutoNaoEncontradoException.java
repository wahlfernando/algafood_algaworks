package com.algaworks.algafood.domain.exception;

public class FotoProdutoNaoEncontradoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public FotoProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public FotoProdutoNaoEncontradoException(Long restauranteId, Long productId) {
		this("Não existe Foto com do produto %d do resutaurante %a!".formatted(productId, restauranteId));
	}

}
