package com.algaworks.algafood.domain.service;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface FotoStorageService {

  void armazenar(NovaFoto novaFoto);

  void remover(String nomeArquivo);

  default void subistituir(String nomeArqiiovoAntigo, NovaFoto novaFoto) {
    this.armazenar(novaFoto);
    if (nomeArqiiovoAntigo != null) {
      this.remover(nomeArqiiovoAntigo);
    }
  }

  default String geraNomeArquivo(String nomeOriginal) {
    return UUID.randomUUID().toString() + "_" + nomeOriginal;
  }

  @Builder
  @Getter
  class NovaFoto {
    private String nomeArquivo;
    private InputStream inputStream;
  }

}
