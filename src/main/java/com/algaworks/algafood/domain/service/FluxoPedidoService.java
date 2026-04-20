package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Pedido;

@Service
public class FluxoPedidoService {

    @Autowired
    private EnvioEmailService emailService;

    @Autowired
    private EmissaoPedidoService emissaoPedidoService;

    @Transactional
    public void confirmar(String codigoPedido) {
        Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
        pedido.confirmar();

//        var mensagem = EnvioEmailService.Mensagem.builder().assunto(pedido.getRestaurante().getNome() + " Pedido confirmado!")
//                .corpo("O pedido de código <strong>" + pedido.getCodigo() + "</strong> está confirmado!")
//                .variavel("pedido", pedido)
//                .destinatario("wahlfernando@yahoo.com.br").build();
//
//        emailService.enviar(mensagem);

    }

    @Transactional
    public void canelamento(String codigoPedido) {
        Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
        pedido.cancelar();
    }

    @Transactional
    public void entregue(String codigoPedido) {
        Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
        pedido.entregar();
    }
}
