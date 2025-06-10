# 🏷️ Sistema de Leilões Java

Este projeto é um **Sistema de Leilões** desenvolvido em Java com Swing e MySQL. O objetivo é gerenciar o cadastro e a venda de produtos em leilões, oferecendo uma interface gráfica para interação do usuário.

## 🚀 Funcionalidades

- Cadastro de novos produtos com nome e valor.
- Listagem de produtos disponíveis para venda.
- Funcionalidade de venda (marcada para implementação).
- Integração com banco de dados MySQL para persistência de dados.
- Interface gráfica desenvolvida em Java Swing (GUI).
- Separação das responsabilidades entre **View**, **DAO** e **DTO**.

## 🛠️ Tecnologias Utilizadas

- **Java**: linguagem principal para o backend e frontend.
- **Swing**: para a criação da interface gráfica.
- **MySQL**: banco de dados relacional para persistência.
- **JDBC**: para conexão com o banco de dados.
- **NetBeans**: IDE utilizada (templates e código gerado).

## 📂 Estrutura do Projeto

- `cadastroVIEW`: tela de cadastro de produtos.
- `listagemVIEW`: tela de listagem e venda de produtos.
- `ProdutosDAO`: classe de acesso a dados para produtos.
- `ProdutosDTO`: objeto de transferência de dados para produtos.
- `conectaDAO`: classe de conexão com o banco de dados MySQL.

## 📌 Observações

⚠️ Algumas funções ainda não estão implementadas, como a venda real do produto no banco de dados (o método `venderProduto` está comentado). O método `cadastrarProduto` também está parcialmente implementado e requer ajustes para inserir os dados no banco de dados.

💡 É recomendável implementar os métodos pendentes e realizar a configuração do banco de dados no arquivo de conexão (`conectaDAO`).

## 🗂️ Como Rodar

1. Configure o banco de dados MySQL:
   - Nome do banco de dados: `uc11`
   - Usuário: `root`
   - Senha: `root`

2. Importe o projeto no NetBeans ou outra IDE de sua preferência.

3. Execute a classe `cadastroVIEW` para abrir o formulário de cadastro.

4. Execute a classe `listagemVIEW` para abrir a lista de produtos.

---

Este projeto foi desenvolvido com fins educacionais para prática de Java com Swing e banco de dados.