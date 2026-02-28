package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.GrupoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.GrupoRepository;

@Service
public class CadastroGrupoService {

	private static final String MSG_GRUPO_NAO_PODE_SER_REMOVIDA = "Grupo de código %d, não pode ser removida, pois esta em uso!";
	private static final String MSG_GRUPO_NAO_ENCONTRADA = "Não existe cadastro de Grupo com o código %d!";

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private CadastroPermissaoService cadastroPermissaoService;

	@Transactional
	public Grupo salvar(Grupo grupo) {
		return grupoRepository.save(grupo);
	}

	@Transactional
	public void excluir(Long grupoID) {
		try {
			grupoRepository.deleteById(grupoID);
			grupoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new GrupoNaoEncontradoException(MSG_GRUPO_NAO_ENCONTRADA.formatted(grupoID));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(MSG_GRUPO_NAO_PODE_SER_REMOVIDA.formatted(grupoID));
		}
	}

	public Grupo buscarOuFalhar(Long grupoId) {
		return grupoRepository.findById(grupoId).orElseThrow(
				() -> new GrupoNaoEncontradoException(MSG_GRUPO_NAO_ENCONTRADA.formatted(grupoId)));
	}

	@Transactional
	public void desassociarPermissao(Long grupoId, Long permissaoId) {
		Grupo grupo = buscarOuFalhar(grupoId);
		Permissao permissao = cadastroPermissaoService.buscarOuFalhar(permissaoId);

		grupo.removerPermissao(permissao);
	}

	@Transactional
	public void associarPermissao(Long grupoId, Long permissaoId) {
		Grupo grupo = buscarOuFalhar(grupoId);
		Permissao permissao = cadastroPermissaoService.buscarOuFalhar(permissaoId);

		grupo.adicionarPermissao(permissao);
	}

}
