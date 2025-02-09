set foreign_key_checks = 0;
delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupo;
delete from pedido;
delete from item_pedido;
set foreign_key_checks = 1;
alter table cidade auto_increment = 1;
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table grupo_permissao auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table restaurante_forma_pagamento auto_increment = 1;
alter table usuario auto_increment = 1;
alter table usuario_grupo auto_increment = 1;
insert into cozinha (id, nome)
values (1, 'Tailandesa');
insert into cozinha (id, nome)
values (2, 'Indiana');
insert into cozinha (id, nome)
values (3, 'Argentina');
insert into cozinha (id, nome)
values (4, 'Brasileira');
insert into cozinha (id, nome)
values (5, 'Mexicana');
insert into cozinha (id, nome)
values (6, 'Italiana');
insert into cozinha (id, nome)
values (7, 'Chinesa');
insert into cozinha (id, nome)
values (8, 'Japonesa');
insert into cozinha (id, nome)
values (9, 'Francesa');
insert into cozinha (id, nome)
values (10, 'Espanhola');
insert into cozinha (id, nome)
values (11, 'Portuguesa');
insert into cozinha (id, nome)
values (12, 'Coreana');
insert into cozinha (id, nome)
values (13, 'Libanesa');
insert into cozinha (id, nome)
values (14, 'Peruana');
insert into estado (id, nome)
values (1, 'Minas Gerais');
insert into estado (id, nome)
values (2, 'São Paulo');
insert into estado (id, nome)
values (3, 'Ceará');
insert into estado (id, nome)
values (4, 'Acre');
insert into estado (id, nome)
values (5, 'Alagoas');
insert into estado (id, nome)
values (6, 'Amapá');
insert into estado (id, nome)
values (7, 'Amazonas');
insert into estado (id, nome)
values (8, 'Bahia');
insert into estado (id, nome)
values (9, 'Distrito Federal');
insert into estado (id, nome)
values (10, 'Espírito Santo');
insert into estado (id, nome)
values (11, 'Goiás');
insert into estado (id, nome)
values (12, 'Maranhão');
insert into estado (id, nome)
values (13, 'Mato Grosso');
insert into estado (id, nome)
values (14, 'Mato Grosso do Sul');
insert into estado (id, nome)
values (15, 'Pará');
insert into estado (id, nome)
values (16, 'Paraíba');
insert into estado (id, nome)
values (17, 'Paraná');
insert into estado (id, nome)
values (18, 'Pernambuco');
insert into estado (id, nome)
values (19, 'Piauí');
insert into estado (id, nome)
values (20, 'Rio de Janeiro');
insert into estado (id, nome)
values (21, 'Rio Grande do Norte');
insert into estado (id, nome)
values (22, 'Rio Grande do Sul');
insert into estado (id, nome)
values (23, 'Rondônia');
insert into estado (id, nome)
values (24, 'Roraima');
insert into estado (id, nome)
values (25, 'Santa Catarina');
insert into estado (id, nome)
values (26, 'Sergipe');
insert into estado (id, nome)
values (27, 'Tocantins');
insert into cidade (id, nome, estado_id)
values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id)
values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id)
values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id)
values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id)
values (5, 'Fortaleza', 3);
insert into cidade (id, nome, estado_id)
values (6, 'Juiz de Fora', 1);
insert into cidade (id, nome, estado_id)
values (7, 'Ribeirão Preto', 2);
insert into cidade (id, nome, estado_id)
values (8, 'Sorocaba', 2);
insert into cidade (id, nome, estado_id)
values (9, 'Caucaia', 3);
insert into cidade (id, nome, estado_id)
values (10, 'Crato', 3);
insert into cidade (id, nome, estado_id)
values (11, 'Salvador', 8);
insert into cidade (id, nome, estado_id)
values (12, 'Feira de Santana', 8);
insert into cidade (id, nome, estado_id)
values (13, 'Curitiba', 17);
insert into cidade (id, nome, estado_id)
values (14, 'Londrina', 17);
insert into cidade (id, nome, estado_id)
values (15, 'Recife', 18);
insert into restaurante (
        id,
        nome,
        taxa_frete,
        cozinha_id,
        data_cadastro,
        data_atualizacao,
        ativo,
        aberto,
        endereco_cidade_id,
        endereco_cep,
        endereco_logradouro,
        endereco_numero,
        endereco_bairro
    )
values (
        1,
        'Thai Gourmet',
        10,
        1,
        utc_timestamp,
        utc_timestamp,
        true,
        true,
        1,
        '38400-999',
        'Rua João Pinheiro',
        '1000',
        'Centro'
    );
insert into restaurante (
        id,
        nome,
        taxa_frete,
        cozinha_id,
        data_cadastro,
        data_atualizacao,
        ativo,
        aberto
    )
values (
        2,
        'Thai Delivery',
        9.50,
        1,
        utc_timestamp,
        utc_timestamp,
        true,
        true
    );
insert into restaurante (
        id,
        nome,
        taxa_frete,
        cozinha_id,
        data_cadastro,
        data_atualizacao,
        ativo,
        aberto
    )
values (
        3,
        'Tuk Tuk Comida Indiana',
        15,
        2,
        utc_timestamp,
        utc_timestamp,
        true,
        true
    );
insert into restaurante (
        id,
        nome,
        taxa_frete,
        cozinha_id,
        data_cadastro,
        data_atualizacao,
        ativo,
        aberto
    )
values (
        4,
        'Java Steakhouse',
        12,
        3,
        utc_timestamp,
        utc_timestamp,
        true,
        true
    );
insert into restaurante (
        id,
        nome,
        taxa_frete,
        cozinha_id,
        data_cadastro,
        data_atualizacao,
        ativo,
        aberto
    )
values (
        5,
        'Lanchonete do Tio Sam',
        11,
        4,
        utc_timestamp,
        utc_timestamp,
        true,
        true
    );
insert into restaurante (
        id,
        nome,
        taxa_frete,
        cozinha_id,
        data_cadastro,
        data_atualizacao,
        ativo,
        aberto
    )
values (
        6,
        'Bar da Maria',
        6,
        4,
        utc_timestamp,
        utc_timestamp,
        true,
        true
    );
insert into forma_pagamento (id, descricao)
values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao)
values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao)
values (3, 'Dinheiro');
insert into permissao (id, nome, descricao)
values (
        1,
        'CONSULTAR_COZINHAS',
        'Permite consultar cozinhas'
    );
insert into permissao (id, nome, descricao)
values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id)
values (1, 1),
    (1, 2),
    (1, 3),
    (2, 3),
    (3, 2),
    (3, 3),
    (4, 1),
    (4, 2),
    (5, 1),
    (5, 2),
    (6, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Porco com molho agridoce',
        'Deliciosa carne suína ao molho especial',
        78.90,
        1,
        1
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Camarão tailandês',
        '16 camarões grandes ao molho picante',
        110,
        1,
        1
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Salada picante com carne grelhada',
        'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha',
        87.20,
        1,
        2
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Garlic Naan',
        'Pão tradicional indiano com cobertura de alho',
        21,
        1,
        3
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Murg Curry',
        'Cubos de frango preparados com molho curry e especiarias',
        43,
        1,
        3
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Bife Ancho',
        'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé',
        79,
        1,
        4
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'T-Bone',
        'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon',
        89,
        1,
        4
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Sanduíche X-Tudo',
        'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese',
        19,
        1,
        5
    );
insert into produto (nome, descricao, preco, ativo, restaurante_id)
values (
        'Espetinho de Cupim',
        'Acompanha farinha, mandioca e vinagrete',
        8,
        1,
        6
    );
insert into grupo (nome)
values ('Gerente'),
    ('Vendedor'),
    ('Secretária'),
    ('Cadastrador');
insert into grupo_permissao (grupo_id, permissao_id)
values (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (3, 1);
insert into usuario (id, nome, email, senha, data_cadastro)
values (
        1,
        'João da Silva',
        'joao.ger@algafood.com',
        '123',
        utc_timestamp
    ),
    (
        2,
        'Maria Joaquina',
        'maria.vnd@algafood.com',
        '123',
        utc_timestamp
    ),
    (
        3,
        'José Souza',
        'jose.aux@algafood.com',
        '123',
        utc_timestamp
    ),
    (
        4,
        'Sebastião Martins',
        'sebastiao.cad@algafood.com',
        '123',
        utc_timestamp
    );
insert into usuario_grupo (usuario_id, grupo_id)
values (1, 1),
    (1, 2),
    (2, 2);
delete from restaurante_usuario_responsavel;
insert into usuario (id, nome, email, senha, data_cadastro)
values (
        5,
        'Manoel Lima',
        'manoel.loja@gmail.com',
        '123',
        utc_timestamp
    );
insert into pedido (
        id,
        codigo,
        restaurante_id,
        usuario_cliente_id,
        forma_pagamento_id,
        endereco_cidade_id,
        endereco_cep,
        endereco_logradouro,
        endereco_numero,
        endereco_complemento,
        endereco_bairro,
        status,
        data_criacao,
        subtotal,
        taxa_frete,
        valor_total
    )
values (
        1,
        '550e8400-e29b-41d4-a716-446655440000',
        1,
        1,
        1,
        1,
        '38400-000',
        'Rua Floriano Peixoto',
        '500',
        'Apto 801',
        'Brasil',
        'CRIADO',
        utc_timestamp,
        298.90,
        10,
        308.90
    );
insert into item_pedido (
        id,
        pedido_id,
        produto_id,
        quantidade,
        preco_unitario,
        preco_total,
        observacao
    )
values (1, 1, 1, 1, 78.9, 78.9, null);
insert into item_pedido (
        id,
        pedido_id,
        produto_id,
        quantidade,
        preco_unitario,
        preco_total,
        observacao
    )
values (2, 1, 2, 2, 110, 220, 'Menos picante, por favor');
insert into pedido (
        id,
        codigo,
        restaurante_id,
        usuario_cliente_id,
        forma_pagamento_id,
        endereco_cidade_id,
        endereco_cep,
        endereco_logradouro,
        endereco_numero,
        endereco_complemento,
        endereco_bairro,
        status,
        data_criacao,
        subtotal,
        taxa_frete,
        valor_total
    )
values (
        2,
        '123e4567-e89b-12d3-a456-556642440000',
        4,
        1,
        2,
        1,
        '38400-111',
        'Rua Acre',
        '300',
        'Casa 2',
        'Centro',
        'CRIADO',
        utc_timestamp,
        79,
        0,
        79
    );
insert into item_pedido (
        id,
        pedido_id,
        produto_id,
        quantidade,
        preco_unitario,
        preco_total,
        observacao
    )
values (3, 2, 6, 1, 79, 79, 'Ao ponto');
alter table pedido auto_increment = 1;
alter table item_pedido auto_increment = 1;