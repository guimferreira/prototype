# API de Cadastro de Estudantes
Este projeto foi desenvolvido para a disciplina de **Padrões de Projetos** do curso de **Sistemas para Internet** da **Uniesp**. A aplicação exemplifica o uso do padrão de projeto **Prototype**, implementado em uma API de cadastro de estudantes utilizando o framework **Spring Boot**.

## 📚 Informações Gerais
- **Instituição**: Uniesp  
- **Disciplina**: Padrões de Projetos  
- **Professor**: Álekiss Melo  
- **Objetivo**: Demonstrar a aplicação do padrão de projeto **Prototype** em uma API de cadastro de estudantes.

## Autores
- [@claraferraz](https://github.com/claraferraz)
- [@gazinmarks](https://github.com/gazinmarks)
- [@guimferreira](https://github.com/guimferreira)
- [@hallanpf](https://github.com/hallanpf)
- [@JhonyDomingos](https://github.com/JhonyDomingos)

## 🚀 Tecnologias e Configurações
A aplicação foi desenvolvida com as seguintes tecnologias e configurações:

### Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.0**
- **Banco de Dados H2** (em memória)
- **Maven** como gerenciador de dependências

### Dependências do Projeto
- **spring-boot-starter-web**: Para criação de endpoints REST.
- **spring-boot-starter-data-jpa**: Para interação com o banco de dados.
- **spring-boot-starter-test**: Para testes automatizados.
- **spring-boot-devtools**: Para facilitar o desenvolvimento com hot reload.
- **Lombok**: Para reduzir o código boilerplate.

### Configurações do Banco de Dados
A aplicação utiliza o banco **H2** em memória. As configurações estão definidas no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:estudantesdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

Acesse o console do banco de dados H2 através do link: http://localhost:8080/h2-console.

### Endpoints
- POST ```/api/estudantes```: Cria um novo estudante.
- POST ```/api/estudantes/{id}/clone```: Clona um estudante existente.
- GET ```/api/estudantes```: Retorna todos os estudantes cadastrados.
- PUT ```/api/estudantes/{id}```: Atualiza um estudante.
- DELETE ```/api/estudantes/{id}```: Remove um estudante.
