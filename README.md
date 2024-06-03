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

## Executar o projeto
- EkanApplication
- port: 8080
- servidor: ApacheTomCat

## Executar H2-CONSOLE
- URL: http://localhost:8080/h2-console/login.jsp?jsessionid=8926ff821d4f2d07e65a9e29746b8ae6
- JDBC URL: jdbc:h2:mem:ekan
- username: ekan
- password: ekan
  
# EKAN - API
## Endpoints
# Beneficiario
- BaseURL: /api/beneficiarios
- POST: create()
- GET: getAll()
- GET: /{id}: getById()
- PUT: /{id}: update()
- DELETE /{id}: deleteById()

## Payload de requisição; MODEL

{
    "nome": "João da Silva",
    "telefone": "123456789",
    "dataNascimento": "1990-01-01",
    "dataInclusao": "2024-05-28",
    "dataAtualizacao": "2024-05-28",
    "documentos": [
        {
            "tipoDocumento": "CPF",
            "descricao": "123.456.789-00",
            "dataInclusao": "2024-05-28",
            "dataAtualizacao": "2024-05-28"
        },
        {
            "tipoDocumento": "RG",
            "descricao": "MG-12.345.678",
            "dataInclusao": "2024-05-28",
            "dataAtualizacao": "2024-05-28"
        }
    ]
}


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
- O arquivo `application.properties` contém configurações de banco de dados.
