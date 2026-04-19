# 📌 Sistema de Cadastro e Gerenciamento de Usuários

Este projeto é uma aplicação Java que utiliza **JavaFX** para interface gráfica e **PostgreSQL** como banco de dados.  
O sistema permite cadastrar, atualizar e listar usuários de forma simples e intuitiva.

---

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **JavaFX**
- **PostgreSQL**
- **JDBC**
- **FXML**

---

## 📂 Estrutura do Projeto

---

## ⚙️ Funcionalidades
- **Cadastro de Usuários**: Nome, E-mail, Endereço, Telefone e Senha.
- **Atualização de Dados**: Alterar nome, e-mail, telefone, endereço e senha.
- **Listagem de Usuários**: Exibição em tabela com todos os registros.
- **Navegação entre Telas**: Login, Cadastro, Atualização e Listagem.

---

## 🗄️ Banco de Dados
O sistema utiliza **PostgreSQL**.  
Crie um banco chamado `Usuarios` e uma tabela `usuario` com a seguinte estrutura:

```sql
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    telefone INTEGER NOT NULL,
    senha VARCHAR(50) NOT NULL
);
conn = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/Usuarios",
    "postgres",
    "123456"
);
flowchart TD
    A[Login] --> B[Cadastro]
    A --> C[Listagem de Usuários]
    B --> D[Atualização de Dados]
    C --> D
    D --> A
