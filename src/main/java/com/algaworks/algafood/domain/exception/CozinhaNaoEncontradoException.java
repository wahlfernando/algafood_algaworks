package com.algaworks.algafood.domain.exception;

public class CozinhaNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;


	public CozinhaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	

	public CozinhaNaoEncontradoException(Long cozinhaID) {
		 this("Não existe cadastro de Cozinha com o código %d!".formatted(cozinhaID));
	}

}
