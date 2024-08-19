package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository EstadoRepository;

	public Estado salvar(Estado Estado) {
		return EstadoRepository.salvar(Estado);
	}

	public void excluir(Long estadoID) {
		try {
			EstadoRepository.remover(estadoID);  
		} catch ( EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de Estado com o código %d!", estadoID));	
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d, não pode ser removida, pois esta em uso!", estadoID));
		}
	}

}
