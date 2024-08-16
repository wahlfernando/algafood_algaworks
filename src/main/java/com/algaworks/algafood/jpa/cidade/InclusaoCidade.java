package com.algaworks.algafood.jpa.cidade;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class InclusaoCidade {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		FormaPagamentoRepository formaPagamentoRepository = (FormaPagamentoRepository) applicationContext.getBean(FormaPagamentoRepository.class);

		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setDescricao("Boleto");
		
		formaPagamento = formaPagamentoRepository.salvar(formaPagamento);
		
		System.out.printf("%s - %s\n", formaPagamento.getId(), formaPagamento.getDescricao());
		
		formaPagamentoRepository.buscar(2L);
		System.out.println(formaPagamento.getDescricao());
	}

}
