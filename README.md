# 🍔 Algafood Algaworks

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

Projeto desenvolvido durante o curso **Especialista Spring REST** da [AlgaWorks](https://lp.algaworks.com/wp-content/uploads/2021/12/Ementa-ESR-EJPA.pdf).

Este repositório registra minha evolução prática no desenvolvimento de uma **API REST robusta com Java e Spring**, aplicando conceitos modernos de arquitetura, persistência, segurança e boas práticas de mercado.

## 📚 Sumário

- [Sobre o projeto](#-sobre-o-projeto)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Conteúdos abordados](#-conteúdos-abordados)
- [Como executar](#-como-executar)
- [Evolução do aprendizado](#-evolução-do-aprendizado)
- [Fonte de estudo](#-fonte-de-estudo)
- [Observações](#-observações)
- [Autor](#-autor)

## 🚀 Sobre o projeto

O **Algafood** é uma aplicação completa de delivery de comida, utilizada como estudo de caso para explorar o ecossistema Spring. O projeto foca na construção de uma API pragmática, escalável e bem documentada, seguindo os padrões RESTful e níveis de maturidade de Richardson.

## 🛠 Tecnologias utilizadas

- **Java 8/11+**
- **Spring Boot** (MVC, Data JPA, Security, HATEOAS)
- **Hibernate** (ORM)
- **Flyway** (Migrações de banco de dados)
- **MySQL** (Banco de dados relacional)
- **ModelMapper** (Mapeamento de DTOs)
- **OpenAPI / Swagger** (Documentação)
- **JUnit & REST Assured** (Testes automatizados)
- **Lombok** (Produtividade)

## 🧠 Conteúdos abordados

### Backend & Arquitetura
- Injeção de Dependências e Spring IoC.
- Modelagem de Domínio e Domain-Driven Design (DDD).
- Persistência avançada com JPA, Criteria API e Repositórios customizados.
- Tratamento de erros padronizado com **RFC 7807 (Problem Details)**.
- Validações avançadas com Bean Validation.

### API REST & Evolução
- Design de endpoints e boas práticas de URIs.
- Paginação, ordenação e filtros dinâmicos.
- Upload/Download de arquivos e armazenamento em S3.
- Envio de e-mails transacionais com templates FreeMarker.
- Versionamento de API e Cache HTTP.
- Implementação de HATEOAS para Discoverability.

### Segurança & Produção
- Autenticação e Autorização com **OAuth2 e JWT**.
- Fluxos Password Credentials, Authorization Code e Refresh Tokens.
- Configuração de Resource Server e Authorization Server.
- Conceitos Cloud-Native e Deploy em produção.

### Evolução do aprendizado
Este repositório é um reflexo da minha jornada no curso. A evolução acontece de forma incremental:
Começamos com o básico de Spring e JPA.
Refatoramos para padrões de projeto como DTOs e Service Layer.
Implementamos segurança robusta e documentação automática.
Cada commit representa um novo conceito consolidado, desde a simples criação de um endpoint até a implementação de fluxos complexos de OAuth2.

### Fonte de estudo
O conteúdo programático seguido neste projeto pertence à AlgaWorks, especificamente ao treinamento Especialista Spring REST.
Ementa completa: Acesse aqui o PDF oficial.
Plataforma: AlgaWorks.

### Observações
Este projeto tem finalidade estritamente educacional.
O código pode sofrer refatorações constantes à medida que novos módulos do curso são concluídos.
Algumas chaves de configuração ou serviços externos (como AWS S3 ou SMTP) podem exigir variáveis de ambiente locais para funcionamento pleno.

### Autor
Fernando Wahl

GitHub: @wahlfernando
LinkedIn: https://www.linkedin.com/in/fernando-alexandre-wahl-4246b053/
