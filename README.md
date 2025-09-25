# 🎬 Projeto Controle de Filmes - Spring Boot

## 📌 Descrição
Este projeto é um **exercício prático com Spring Boot e Spring Data JPA** que implementa um sistema simples de **controle de filmes e avaliações**.  
Ele foi criado com o objetivo de praticar **CRUD, relacionamentos, validação e repositórios customizados**.

---

## 🚀 Funcionalidades
- Cadastro de **Filmes** (título, ano de lançamento, gênero).  
- Cadastro de **Avaliações** (usuário, nota, comentário, filme associado).  
- Relacionamento **1:N** (um filme pode ter várias avaliações).  
- Consultas personalizadas com **Spring Data JPA**.  

---

## 🗃️ Modelagem

### 🎥 Filme
- `id` (Long, @Id, @GeneratedValue)  
- `titulo` (String, obrigatório)  
- `anoLancamento` (Integer)  
- `genero` (String)  

### ⭐ Avaliacao
- `id` (Long, @Id, @GeneratedValue)  
- `usuario` (String, obrigatório)  
- `nota` (Integer, obrigatório, 0 a 10)  
- `comentario` (String, opcional)  
- `filme` (ManyToOne → Filme)  

