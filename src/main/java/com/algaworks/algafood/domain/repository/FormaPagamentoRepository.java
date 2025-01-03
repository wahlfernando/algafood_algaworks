package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository
		extends JpaRepository<FormaPagamento, Long>, JpaSpecificationExecutor<FormaPagamento> {

}
