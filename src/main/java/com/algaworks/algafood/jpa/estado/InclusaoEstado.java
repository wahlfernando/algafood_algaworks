package com.algaworks.algafood.jpa.estado;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class InclusaoEstado {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		EstadoRepository estadoRepository = (EstadoRepository) applicationContext.getBean(EstadoRepository.class);

		Estado Estado = new Estado();
		Estado.setNome("Paraná");
		
		Estado = estadoRepository.salvar(Estado);
		
		System.out.printf("%s - %s\n", Estado.getId(), Estado.getNome());
		
		estadoRepository.buscar(2L);
		System.out.println(Estado.getNome());
	}

}
