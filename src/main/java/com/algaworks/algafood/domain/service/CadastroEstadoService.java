package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	private static final String ESTADO_DE_CÓDIGO_D_NÃO_PODE_SER_REMOVIDA_POIS_ESTA_EM_USO = "Estado de código %d, não pode ser removida, pois esta em uso!";
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Transactional
	public Estado salvar(Estado Estado) {
		return estadoRepository.save(Estado);
	}

	@Transactional
	public void excluir(Long estadoID) {
		try {
			estadoRepository.deleteById(estadoID);  
		} catch ( EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(estadoID);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(ESTADO_DE_CÓDIGO_D_NÃO_PODE_SER_REMOVIDA_POIS_ESTA_EM_USO, estadoID));
		}
	}
	
	public Estado buscarOuFalhar(Long estadoId) {
	    return estadoRepository.findById(estadoId)
	        .orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
	}

}
