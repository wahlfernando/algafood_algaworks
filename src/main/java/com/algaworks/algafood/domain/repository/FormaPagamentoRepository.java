package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	
	FormaPagamento salvar(FormaPagamento formaPgamento);
	List<FormaPagamento> listar();
	FormaPagamento buscar(Long id);
	void remover(FormaPagamento formaPgamento);
	

}
