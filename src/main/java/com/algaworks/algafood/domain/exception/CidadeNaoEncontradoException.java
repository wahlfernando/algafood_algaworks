package com.algaworks.algafood.domain.exception;

public class CidadeNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;


	public CidadeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	

	public CidadeNaoEncontradoException(Long restauranteID) {
		 this(String.format("Não existe cadastro de Cidade com o código %d!", restauranteID));
	}

}
