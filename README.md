## Rodando o projeto Spring Boot

Este projeto usa **Spring Boot** e **Maven Wrapper**, então não é necessário instalar o Maven globalmente. Basta seguir os passos abaixo.

---

### 1. Abrir o terminal

Abra o **PowerShell** no Windows ou um terminal no Linux/Mac na raiz do projeto.

---

### 2. Baixar dependências e compilar

No **Windows** (PowerShell):

```powershell
.\mvnw clean install
No Linux/Mac:
./mvnw clean install
```
Esse comando baixa todas as dependências definidas no pom.xml e compila o projeto.

3. Rodar a aplicação
```No Windows:
.\mvnw spring-boot:run
No Linux/Mac:
./mvnw spring-boot:run
```
Isso inicia o servidor Spring Boot. Por padrão, a aplicação estará disponível em http://localhost:8080.
