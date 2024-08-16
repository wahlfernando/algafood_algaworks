package com.algaworks.algafood.jpa.restaurante;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository RestauranteRepository = (RestauranteRepository) applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Estilho um");
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Estilo Dois 2");

		restaurante1 = RestauranteRepository.salvar(restaurante1);
		restaurante2 = RestauranteRepository.salvar(restaurante2);

		System.out.printf("%s - %s\n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%s - %s\n", restaurante2.getId(), restaurante2.getNome());
		
		Restaurante Restaurante = RestauranteRepository.buscar(2L);
		System.out.println(Restaurante.getNome());
	}

}
