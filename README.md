# Blog API

## Descrição
Esta é uma API REST simples para um blog, desenvolvida com Spring Boot, PostgreSQL e JPA. A API permite criar, listar, buscar e excluir postagens de blog.

## Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Estrutura do Projeto
```
blog-api
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── seu-usuario
│       │           └── blog
│       │               ├── controller
│       │               │   └── PostController.java
│       │               ├── model
│       │               │   └── Post.java
│       │               ├── repository
│       │               │   └── PostRepository.java
│       │               ├── service
│       │               │   └── PostService.java
│       │               └── BlogApiApplication.java
│       └── resources
│           ├── application.properties
│           └── static
│               └── index.html
```

## Configuração do Banco de Dados
Antes de iniciar a aplicação, crie o banco de dados PostgreSQL:
```sql
CREATE DATABASE blogdb;
```
No arquivo `src/main/resources/application.properties`, configure as credenciais do banco de dados:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blogdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

## Endpoints
A API expõe os seguintes endpoints:

### Criar uma postagem
- **POST** `/api/posts`
- **Body** (JSON):
```json
{
  "titulo": "Meu primeiro post",
  "conteudo": "Conteúdo da postagem"
}
```
- **Resposta** (201 Created):
```json
{
  "id": 1,
  "titulo": "Meu primeiro post",
  "conteudo": "Conteúdo da postagem"
}
```

### Listar todas as postagens
- **GET** `/api/posts`
- **Resposta**:
```json
[
  {
    "id": 1,
    "titulo": "Meu primeiro post",
    "conteudo": "Conteúdo da postagem"
  }
]
```

### Buscar uma postagem por ID
- **GET** `/api/posts/{id}`
- **Resposta**:
```json
{
  "id": 1,
  "titulo": "Meu primeiro post",
  "conteudo": "Conteúdo da postagem"
}
```

### Excluir uma postagem
- **DELETE** `/api/posts/{id}`
- **Resposta**: `204 No Content`

## Como Rodar o Projeto
1. Clone o repositório.
2. Configure o banco de dados no `application.properties`.
3. Execute o projeto com:
```sh
mvn spring-boot:run
```
4. Acesse `http://localhost:8080/api/posts` para testar a API.

## Testando a API
Você pode testar os endpoints utilizando ferramentas como:
- [Postman](https://www.postman.com/)
- `cURL` no terminal

Exemplo de requisição com cURL para criar um post:
```sh
curl -X POST "http://localhost:8080/api/posts" -H "Content-Type: application/json" -d '{"titulo":"Exemplo","conteudo":"Testando API"}'
```

## Melhorias Futuras
- Autenticação com Spring Security
- Validação de entrada
- Atualização de postagens
- Paginação dos posts

---
Desenvolvido com ❤️ e Spring Boot.

