# Projeto ControllStock

O Projeto ControllStock é uma aplicação para gerenciamento de estoque de produtos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Maven
- JUnit
- Spring REST Docs

## Requisitos

- Java 8 ou superior
- Maven

## Executando o Projeto

Para executar o projeto, siga os passos abaixo:

1. Clone o repositório para o seu ambiente local.
2. Abra o projeto em sua IDE preferida.
3. Configure o banco de dados de acordo com as instruções no arquivo `application.properties`.
4. Execute a aplicação.

## Executando os Testes

Para executar os testes, utilize o seguinte comando:

mvn test

## Estrutura do Projeto

A estrutura do projeto segue o padrão MVC:

- `src/main/java/com/felipe/controllstock/model`: Contém as classes que representam os objetos de negócio, como `Product` e `Order`.
- `src/main/java/com/felipe/controllstock/controllers`: Contém os controladores responsáveis por receber as requisições e determinar qual view deve ser renderizada.
- `src/main/resources/templates`: Contém os templates utilizados para renderizar as views.

