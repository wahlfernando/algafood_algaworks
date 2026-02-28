package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jakarta.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradoException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@SpringBootTest
class testes_integracao_CadastroCozinhaIT {

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Test
    void deveCadastroCozinhaComSucesso() {
        // Cenário
        Cozinha novCozinha = new Cozinha();
        novCozinha.setNome("Chinesa");

        // Ação
        novCozinha = cadastroCozinha.salvar(novCozinha);

        // Validação
        assertThat(novCozinha).isNotNull();
        assertThat(novCozinha.getId()).isNotNull();
    }

    @Test()
    void deveFalharAoCadastrarCozinha_QuandoSemNome() {
        Cozinha novCozinha = new Cozinha();
        novCozinha.setNome(null);

        assertThrows(ConstraintViolationException.class, () -> {
            cadastroCozinha.salvar(novCozinha);
        });
    }

    @Test()
    void deveFalharQuandoExcluiCozinhaEmUso() {
        assertThrows(EntidadeEmUsoException.class, () -> {
            cadastroCozinha.excluir(1L);
        });
    }

    @Test()
    void deveFalharQuandoExcluiCozinhaInexistente() {
        assertThrows(CozinhaNaoEncontradoException.class, () -> {
            cadastroCozinha.excluir(999999L);
        });
    }

}
