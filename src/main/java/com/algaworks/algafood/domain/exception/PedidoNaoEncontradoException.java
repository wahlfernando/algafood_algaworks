package com.algaworks.algafood.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(String codigoPedido) {
		super("Não existe cadastro de Pedido com o código %d!".formatted(codigoPedido));
	}

}
