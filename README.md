# 📌 Sistema de Controle de Estoque de Produtos: 

## Objetivo
Criar um sistema para gerenciar o estoque de produtos de uma loja, permitindo adicionar novos produtos, listar os produtos cadastrados e registrar vendas, atualizando automaticamente o estoque.

## Funcionalidades
- Adicionar produtos ao estoque: O usuário pode inserir o ID, nome, preço e quantidade disponível de um produto para cadastrá-lo no sistema.
- Listar produtos em estoque: O sistema exibe a lista de produtos cadastrados, mostrando o nome, preço e quantidade disponível de cada um.
- Registrar venda: O usuário pode escolher um produto e registrar uma venda, decrementando a quantidade de estoque do produto. O valor total da venda é calculado automaticamente com base no preço do produto e na quantidade vendida.

## Estrutura das Classes

### Produto (Product)
Representa os produtos disponíveis na loja.

**Atributos:**
- id: Identificador único do produto.
- name: Nome do produto.
- price: Preço unitário do produto.
- quantity: Quantidade disponível em estoque.

**Métodos:**
- getPrice(): Retorna o preço do produto.
- getQuantity(): Retorna a quantidade disponível em estoque.
- setQuantity(int quantity): Decrementa a quantidade do produto no estoque.
- toString(): Exibe as informações do produto (ID, nome, estoque e preço).

### Venda (Sale)
Representa uma venda de produto na loja.

**Atributos:**
- id: Identificador único da venda.
- product: Produto vendido.
- quantity: Quantidade vendida.
- valueSale: Valor total da venda.

**Métodos:**
- SellInfo(): Exibe as informações detalhadas da venda, incluindo ID, quantidade e valor total.

### Loja (Store)
Representa a loja, contendo listas de produtos e vendas.

**Atributos:**
- products: Lista de produtos cadastrados.
- sales: Lista de vendas realizadas.

### Main (Main)
Classe principal que gerencia a interação com o usuário, oferece um menu para as opções de cadastro de produtos, listagem de produtos e registro de vendas.

**Funcionalidades:**
- Exibe um menu interativo com opções para adicionar produtos, listar produtos e registrar vendas.
- Permite ao usuário adicionar produtos ao estoque, visualizar os produtos cadastrados e registrar uma venda.
- Realiza o tratamento de exceções para garantir que os dados inseridos sejam válidos.
