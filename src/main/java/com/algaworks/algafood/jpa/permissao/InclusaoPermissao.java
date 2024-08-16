package com.algaworks.algafood.jpa.permissao;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class InclusaoPermissao {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		PermissaoRepository PermissaoRepository = (PermissaoRepository) applicationContext.getBean(PermissaoRepository.class);

		Permissao permissao = new Permissao();
		permissao.setDescricao("Teste");
		
		permissao = PermissaoRepository.salvar(permissao);
		
		System.out.printf("%s - %s\n", permissao.getId(), permissao.getDescricao());
		
		PermissaoRepository.buscar(2L);
		System.out.println(permissao.getDescricao());
	}

}
