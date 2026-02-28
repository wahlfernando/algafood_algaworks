package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.PedidoInputDisassembler;
import com.algaworks.algafood.api.assembler.PedidoModelAssembler;
import com.algaworks.algafood.api.assembler.PedidoResumoModelAssembler;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.api.model.PedidoResumoModel;
import com.algaworks.algafood.api.model.input.PedidoInput;
import com.algaworks.algafood.core.data.PagableTranslator;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.filter.PedidoFilter;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.PedidoRepository;
import com.algaworks.algafood.domain.service.EmissaoPedidoService;
import com.algaworks.algafood.infrastructure.repository.spec.PedidosSpecs;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @Autowired
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Autowired
    private PedidoInputDisassembler pedidoInputDisassembler;

    @GetMapping()
    public Page<PedidoResumoModel> pesquisar(PedidoFilter filtro, Pageable pageable) {
        pageable = traduzirPagable(pageable);

        Page<Pedido> pedidosPage = pedidoRepository.findAll(PedidosSpecs.usandoFiltro(filtro), pageable);
        List<PedidoResumoModel> pedidoResumoModel = pedidoResumoModelAssembler.toCollectionModel(pedidosPage.getContent());
        Page<PedidoResumoModel> pedidoResumoModelPage = new PageImpl<>(pedidoResumoModel, pageable,
                pedidosPage.getTotalElements());
        return pedidoResumoModelPage;
    }

    // Page<Cozinha> cozinhasPage = cozinhaRepository.findAll(pageable);
    // List<CozinhaModel> cozinhasModel =
    // cozinhaModelAssembler.toCollectionModel(cozinhasPage.getContent());
    // Page<CozinhaModel> cozinhasModelPage = new PageImpl<>(cozinhasModel,
    // pageable, cozinhasPage.getTotalElements());
    // return cozinhasModelPage;
    // TODO: Uma forma de fazer filtros como se fosse um select do sql na requisição
    // do api.
    // @GetMapping()
    // public MappingJacksonValue listar(@RequestParam(required = false) String
    // campos) {
    // List<Pedido> pedidos = pedidoRepository.findAll();
    // List<PedidoResumoModel> pedidosModel =
    // pedidoResumoModelAssembler.toCollectionModel(pedidos);
    // MappingJacksonValue pedidoWrapper = new MappingJacksonValue(pedidosModel);
    // SimpleFilterProvider filterProvider = new SimpleFilterProvider();
    // filterProvider.addFilter("pedidoFilter",
    // SimpleBeanPropertyFilter.serializeAll());
    // if (StringUtils.isNotBlank(campos)) {
    // filterProvider.addFilter("pedidoFilter",
    // SimpleBeanPropertyFilter.filterOutAllExcept(campos.split(",")));
    // }
    // pedidoWrapper.setFilters(filterProvider);
    // return pedidoWrapper;
    // }
    @GetMapping("/{codigoPedido}")
    public PedidoModel buscar(@PathVariable String codigoPedido) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
        return pedidoModelAssembler.toModel(pedido);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoModel adicionar(@Valid @RequestBody PedidoInput pedidoInput) {
        try {
            Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);
            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);
            novoPedido = emissaoPedido.emitir(novoPedido);
            return pedidoModelAssembler.toModel(novoPedido);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    private Pageable traduzirPagable(Pageable apiPageable) {
        var mapeamento = Map.of(
                "codigo", "codigo",
                "restaurante.nome", "restaurante.nome",
                "nomeCliente", "cliente.nome",
                "valorTotal", "valorTotal");

        return PagableTranslator.translate(apiPageable, mapeamento);
    }

}
