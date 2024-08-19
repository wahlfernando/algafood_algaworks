package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping()
	public List<Cidade> listar() {
		return cidadeRepository.listar();
	}

	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
		Cidade cidade = cidadeRepository.buscar(cidadeId);
		
		if (cidade != null) {			
			return ResponseEntity.status(HttpStatus.OK).body(cidade);
		}
		
		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade Cidade) {
		return cadastroCidade.salvar(Cidade);
	}

	@PutMapping("/{cidadeId}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {

		Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);

		if (cidadeAtual != null) {
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");

			cadastroCidade.salvar(cidadeAtual);

			return ResponseEntity.ok(cidadeAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId) {
		try {
			cadastroCidade.excluir(cidadeId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

}
