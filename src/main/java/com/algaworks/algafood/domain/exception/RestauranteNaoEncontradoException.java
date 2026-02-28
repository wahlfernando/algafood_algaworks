package com.algaworks.algafood.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;


	public RestauranteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	

	public RestauranteNaoEncontradoException(Long restauranteID) {
		 this("Não existe cadastro de Restaurante com o código %d!".formatted(restauranteID));
	}

}
