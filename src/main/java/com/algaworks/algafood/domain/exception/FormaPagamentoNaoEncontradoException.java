package com.algaworks.algafood.domain.exception;

public class FormaPagamentoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FormaPagamentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public FormaPagamentoNaoEncontradoException(Long formaPagamentoID) {
		this(String.format("Não existe cadastro de FormaPagamento com o código %d!", formaPagamentoID));
	}

}
