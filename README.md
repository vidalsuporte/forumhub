# API Forum Hub

 A Forum Hub API é um projeto desenvolvido no âmbito do Desafio de Codificação promovido pelo programa Oracle Next Education (ONE). Essa API fornece uma plataforma robusta para gerenciar perfis, cursos, tópicos, respostas e usuários. Suas funcionalidades incluem operações CRUD completas, autenticação e autorizção de perfil baseada em JWT (JSON Web Token) e suporte à paginação em recursos que retornam Todos os elementos cadastrados.
 
## Desenvolvedor

- [André Gonçalves Vidal](https://github.com/vidalsuporte)


## Informações Gerais

**Título:** Forum Hub API

**Versão da API:** 1.0b

**Licença:** [![License: MIT](https://img.shields.io/badge/License-MIT-gree.svg)](https://opensource.org/licenses/MIT)

**Contato:** André Gonçalves Vidal (vidalsuporte@gmail.com)

**URL Base do Servidor:** http://localhost:8080
## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

## Ambiente de Desenvolvimento

![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)

## Técnicas Utilizadas
   O projeto foi desenvolvido Com Java 17+, utilizei o spring initializr para criar a base do projeto com as depêndencias principais.
   Projeto foi versionado com GITHUB, banco de dados mysql com versionado pelo FlywayDB e manipulção dos dado com Spring JPA
   Criado uma API Retfull com Spring Boot autenticação de usuário com Spring Security e TokenJWT, documentado com Swagger/OpenAPI.
   
## Como Configurar e Executar o Projeto
**1 - Pré-requisitos:**

- **Java 17+**

- **Maven**

- **Mysql**

**2 - Clonar o Repositório:**

```
git clone https://github.com/seu-usuario/forum-hub.git
cd forum-hub
```
**3 - Estrutura de Pastas**
````
ForumHub/
├── .mvn/                      # Arquivos de configuração do Maven Wrapper.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.vidalsuporte.forumhub/
│   │   │       ├── controller/
│   │   │       │   ├── springdoc/
│   │   │       │   │   ├── AutenticacaoController.java
│   │   │       │   │   ├── CursoController.java
│   │   │       │   │   ├── PerfilController.java
│   │   │       │   │   ├── RespostaController.java
│   │   │       │   │   ├── TopicoController.java
│   │   │       │   │   └── UsuarioController.java
│   │   │       ├── domain/
│   │   │       │   ├── curso/
│   │   │       │   ├── perfil/
│   │   │       │   ├── resposta/
│   │   │       │   ├── topico/
│   │   │       │   └── usuario/
│   │   │       ├── infra/
│   │   │       │   ├── exception/
│   │   │       │   ├── security/
│   │   │       │   └── springdoc/
│   │   │       └── ForumDesafioApplication.java
│   │   ├── resources/
│   │   │   ├── db.migration/
│   │   │   │   ├── V1_create-table-cursos.sql
│   │   │   │   ├── V2_create-table-perfis.sql
│   │   │   │   ├── V3_create-table-usuarios.sql
│   │   │   │   ├── V4_create-table-usuario_perfil.sql
│   │   │   │   ├── V5_alter-table-usuarios-add-column-ativo.sql
│   │   │   │   ├── V6_create-table-Topicos.sql
│   │   │   │   └── V7_create-table-respostas.sql
│   │   │   └── application.properties
│   │   └── test/              # Testes automatizados do projeto.
├── target/                    # Diretório gerado pelo Maven com artefatos da compilação.
├── .gitignore                 # Configuração para ignorar arquivos no Git.
├── HELP.md                    # Arquivo de ajuda sobre o projeto.
├── mvnw                       # Script do Maven Wrapper.
├── mvnw.cmd                   # Script do Maven Wrapper para Windows.
├── pom.xml                    # Arquivo de configuração principal do Maven.
└── README.md                  # Arquivo de documentação do projeto.
````
## Tabela de Informações

| **Caminho**                           | **Descrição**                                                                           |
|---------------------------------------|---------------------------------------------------------------------------------------|
| **.mvn/**                             | Configurações do Maven Wrapper para execução do projeto sem uma instalação local.     |
| **src/main/java/**                    | Contém o código-fonte principal do projeto.                                           |
| **controller/**                       | Define os controladores responsáveis por processar requisições e respostas da API.    |
| **springdoc/**                        | Interface dos controladores que documentam os endpoints utilizando Swagger/OpenAPI.                 |
| **domain/**                           | Contém as entidades do modelo de dados do sistema organizadas por domínio.            |
| **infra/**                            | Reúne funcionalidades de suporte, como exceções, segurança e documentação.            |
| **ForumDesafioApplication.java**      | Classe principal responsável por inicializar a aplicação Spring Boot.                 |
| **resources/**                        | Arquivos de configuração e recursos auxiliares para a aplicação.                      |
| **db.migration/**                     | Scripts de migração de banco de dados para criação e modificação de tabelas (Flyway). |
| **application.properties**            | Configurações gerais do Spring Boot (ex.: banco de dados, autenticação, etc.).        |
| **test/**                             | Código para realização de testes automatizados.                                       |
| **target/**                           | Diretório gerado pelo Maven com os artefatos da aplicação, como `JAR` ou logs.        |
| **.gitignore**                        | Arquivo para configurar exclusão de arquivos no controle de versão Git.               |
| **HELP.md**                           | Documentação auxiliar sobre o projeto.                                                |
| **mvnw** / **mvnw.cmd**               | Scripts do Maven Wrapper que permitem executar o Maven sem instalá-lo diretamente.    |
| **pom.xml**                           | Configuração de dependências e plugins necessários para o projeto Maven.              |
| **README.md**                         | Documentação principal do projeto, contendo detalhes de funcionamento, instalação, etc.|

---





**4 - Configurar o Banco de Dados:**

Crie um banco de dados no MySQL.

Atualize as informações no arquivo application.properties:

``` 
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha 
```
ou utilize as variáveis de ambiente
```
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PASSWORD}
```

**5 - SecretKey JWT**

Atualize as informações no arquivo application.properties ou crie variáveis de ambiente :

```
api.security.token.secret=${Secretkey}
```


**6 - Iniciar o Projeto:**
```
mvn spring-boot:run
```

**7 - Acessar a Documentação:**

Abra http://localhost:8080/swagger-ui.html no navegador.

## Installation

Install my-project with npm

```bash
  npm install my-project
  cd my-project
```
    
## Endpoints Principais

### Autenticação

- **POST** `/login`
  - Autentica os usuários na aplicação.
  - **Corpo da Requisição:**
    ```json
    {
      "login": "string",
      "senha": "string"
    }
    ```
  - **Resposta:** Gera um token JWT que deve ser usado para autenticação nos demais endpoints.

### Usuários

- **GET** `/usuarios`
  - Lista todos os usuários cadastrados.
  - **Parâmetros Opcionais:**
    - `page`: Número da página (iniciado em 0).
    - `size`: Quantidade de registros por página.
    - `sort`: Critério de ordenação (ex.: `nome,asc`).
- **POST** `/usuarios`
  - Registra um novo usuário.
  - **Corpo da Requisição:**
    ```json
    {
      "nome": "string",
      "email": "string",
      "senha": "string",
      "perfis": [
        {
          "perfil": "string"
        }
      ]
    }
    ```
- **PUT** `/usuarios`
  - Atualiza as informações de um usuário existente.
  - **Corpo da Requisição:**
    ```json
    {
      "id": 1,
      "nome": "string",
      "email": "string",
      "senha": "string"
    }
    ```
- **GET** `/usuarios/{id}`
  - Recupera os dados de um usuário específico pelo seu `id`.
- **GET** `/usuarios/todos`
  - Lista todos os usuários com suporte a paginação e filtros.

### Tópicos

- **GET** `/topicos`
  - Retorna uma lista de tópicos.
  - **Parâmetros Opcionais:**
    - `page`: Número da página (iniciado em 0).
    - `size`: Quantidade de registros por página.
    - `sort`: Critério de ordenação (ex.: `titulo,desc`).
- **POST** `/topicos`
  - Adiciona um novo tópico à base de dados.
  - **Corpo da Requisição:**
    ```json
    {
      "titulo": "string",
      "mensagem": "string",
      "cursoId": 1,
      "autorId": 1
    }
    ```
- **PUT** `/topicos`
  - Modifica os dados de um tópico já existente.
  - **Corpo da Requisição:**
    ```json
    {
      "id": 1,
      "titulo": "string",
      "mensagem": "string",
      "cursoId": 1,
      "autorId": 1
    }
    ```
- **GET** `/topicos/{id}`
  - Fornece os detalhes de um tópico específico pelo `id`.
- **DELETE** `/topicos/{id}`
  - Exclui um tópico identificado pelo `id`.

### Respostas

- **GET** `/respostas`
  - Lista as respostas disponíveis no sistema.
  - **Parâmetros Opcionais:**
    - `page`: Número da página (iniciado em 0).
    - `size`: Quantidade de registros por página.
    - `sort`: Critério de ordenação (ex.: `dataCriacao,asc`).
- **POST** `/respostas`
  - Adiciona uma nova resposta a um tópico.
  - **Corpo da Requisição:**
    ```json
    {
      "mensagem": "string",
      "topico_id": 1,
      "autor_id": 1
    }
    ```
- **PUT** `/respostas`
  - Atualiza uma resposta cadastrada.
  - **Corpo da Requisição:**
    ```json
    {
      "id": 1,
      "mensagem": "string",
      "solucao": true
    }
    ```
- **GET** `/respostas/{id}`
  - Busca os detalhes de uma resposta com base em seu `id`.
- **DELETE** `/respostas/{id}`
  - Remove uma resposta utilizando seu `id` como referência.

### Cursos

- **GET** `/cursos`
  - Recupera uma lista de cursos com suporte à paginação.
  - **Parâmetros Opcionais:**
    - `page`: Número da página (iniciado em 0).
    - `size`: Quantidade de registros por página.
    - `sort`: Critério de ordenação (ex.: `nome,desc`).
- **POST** `/cursos`
  - Registra um novo curso no sistema.
  - **Corpo da Requisição:**
    ```json
    {
      "nome": "string",
      "categoria": "string"
    }
    ```

### Perfis

- **GET** `/perfis`
  - Retorna a lista de todos os perfis cadastrados no sistema.

---
## Segurança

Os endpoints Login, Listar e buscar tópicos e respostas estão liberados o outros endpoints protegidos requerem autenticação por meio de um token JWT. Após o login, o token gerado deve ser incluído no cabeçalho das requisições subsequentes:

```
Authorization: Bearer {token}
```

Os tokens têm validade limitada e devem ser renovados periodicamente.



## Aprimoramentos Futuros

- Validação de proprietário do tópico/resposta;
- Delete de tópico somente proprietário, admin e moderador;
- Edição de tópico somente proprietário, admin e moderador;
