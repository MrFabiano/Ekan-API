# Documentação da Aplicação

## Introdução
Esta aplicação é uma API RESTful desenvolvida em Java com Spring Boot para gerenciar beneficiários e seus documentos.

## Configuração do Ambiente de Desenvolvimento
- JDK 17
- IDE (Eclipse, IntelliJ IDEA)
- Banco de dados H2-database

## Estrutura do Projeto
- `src/main/java`: Contém o código-fonte Java.
- `src/main/resources`: Contém arquivos de configuração, como `application.properties`.

# EKAN - API
## Endpoints
# Beneficiario
- BaseURL: /api/beneficiarios
- POST: create()
- GET: getAll()
- GET: /{id}: getById()
- PUT: /{id}: update()
- DELETE /{id}: deleteById()

# EKAN - API
## Endpoints
# Documentos
- BaseURL: /api/documento
- GET: /beneficiario/{beneficiarioId}

## Configuração do Projeto
- Spring Boot 3.3.0
- Spring Data JPA
- Hibernate
- h2 conector

## Desenvolvimento
A aplicação permite criar, atualizar, buscar e excluir beneficiários e seus documentos. A lógica de negócios é implementada nas classes de serviço e os endpoints REST são definidos nos controladores.

## Gerenciamento de Dependências
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Lombok
- H2database

## Contribuições
Para contribuir com o projeto, siga as instruções no GitHub.
 url: https://github.com/MrFabiano/Ekan-API
 clone: https://github.com/MrFabiano/Ekan-API.git

## Notas Adicionais
- A aplicação utiliza o padrão MVC para separação de responsabilidades.
- O arquivo `application.properties` contém configurações de banco de dados.
