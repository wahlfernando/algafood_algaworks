package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.CidadeNaoEncontradoException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	private static final String MSG_CIDADE_NAO_PODE_SER_REMOVIDA = "Cidade de código %d, não pode ser removida, pois esta em uso!";
	private static final String MSG_CIDADE_NAO_ENCONTRADA = "Não existe cadastro de Cidade com o código %d!";

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroEstadoService cadastroEstado;

	@Transactional
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = cadastroEstado.buscarOuFalhar(estadoId);
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}

	@Transactional
	public void excluir(Long cidadeID) {
		try {
			cidadeRepository.deleteById(cidadeID);
			cidadeRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradoException(MSG_CIDADE_NAO_ENCONTRADA.formatted(cidadeID));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(MSG_CIDADE_NAO_PODE_SER_REMOVIDA.formatted(cidadeID));
		}
	}

	public Cidade buscarOuFalhar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId).orElseThrow(
				() -> new CidadeNaoEncontradoException(MSG_CIDADE_NAO_ENCONTRADA.formatted(cidadeId)));
	}

}
