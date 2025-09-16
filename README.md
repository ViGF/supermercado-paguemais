## Rodando o projeto Spring Boot

Este projeto usa **Spring Boot** e **Maven Wrapper**, então não é necessário instalar o Maven globalmente. Basta seguir os passos abaixo.

---

### 1. Abrir o terminal

Abra o **PowerShell** no Windows ou um terminal no Linux/Mac na raiz do projeto.

---

### 2. Baixar dependências e compilar

```
.\mvnw clean install #No Windows

./mvnw clean install #No Linux/Mac
```
Esse comando baixa todas as dependências definidas no pom.xml e compila o projeto.

3. Rodar a aplicação
```
.\mvnw spring-boot:run #No Windows

./mvnw spring-boot:run #No Linux/Mac
```
Isso inicia o servidor Spring Boot. Por padrão, a aplicação estará disponível em http://localhost:8080.
