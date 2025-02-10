package Controle_de_Estoque;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para ler dados do digitados pelo usuário
        scanner.useLocale(Locale.forLanguageTag("pt-BR")); // Metodo Locale para usar padrão BR (Brasil)
        Store store = new Store(); // Instanciando classe "store" para usá-la futuramente

        // Inicio do sistema
        System.out.println("\t-------GERENCIAMENTO DE ESTOQUE--------");

        // Variavel para armazenar opção de menu do usuário
        int option;

        // Laço do while para mostrar menu para o usuário
        do {
            System.out.println("Menu");
            System.out.println("(1) - Adcionar produto ao estoque");
            System.out.println("(2) - Listar produtos do estoque");
            System.out.println("(3) - Registrar venda");
            System.out.println("(4) - Sair do sistema");
            System.out.printf("Opção: ");
            option = scanner.nextInt(); // Lendo opção do usuário

            // Switch case para exibir a opção do menu escolhida pelo usuário
            switch (option){
                // Case 1 para cadastrar o produto no sistema
                case 1:
                    // Bloco try Catch para tratamento de erros inesperados
                    try {
                        System.out.println("\n\t------CADASTRO DE PRODUTO------");
                        System.out.printf("Informe o id do produto: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.printf("Informe o nome do produto: ");
                        String name = scanner.nextLine();

                        System.out.printf("Informe a quantidade em estoque: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.printf("Informe o preço do produto: R$");
                        double price = scanner.nextDouble();

                        // Chamando metodo construtor para criar o produto
                        Product product = new Product(id, quantity, price, name);

                        // Adicionando o produto cadastrado dentro do array list
                        store.products.add(product);
                        System.out.println("\t-----PRODUTO CADASTRADO------\n");

                        // Bloco catch caso o usuário insira um tipo de dado invalido
                    }catch (InputMismatchException e) {
                        System.out.println("Erro inesperado. Certifique-se de inserir o valor valido.\n");

                        // Bloco catch caso haja algum erro ao cadastrar o produto
                    } catch (Exception e){
                        System.out.println("\t-----Erro ao cadastrar o produto-----");
                        System.err.println("\t" + e.getMessage() + "\n");
                    }
                    break;

                    // Case 2 para listar produtos cadastrados no sistema
                case 2:
                    System.out.println("\n\t-------LISTA DE PRODUTOS-----");

                        // Bloco try catch para tratamento de erros inesperados
                    try {
                        // Verificando e exibindo menssagem caso não tenha produto cadastrado
                        if (store.products.isEmpty()){
                            System.out.println("Você não tem produtos cadastrados!\n");

                            // Caso contrario exibe a lista de produtos
                        } else {
                            // Laço for each para listar produtos cadastrados
                            for(Product list : store.products){
                                System.out.println(list.toString());
                            }
                        }

                        // Capturando o erro e exibindo menssagem personalizada
                    } catch (Exception erro){
                        System.err.println("\t-----Erro ao acessar a lista de produtos-----\n");
                        System.out.println("\t" + erro.getMessage() + "\n");
                    }
                    break;

                    // Case 3 para registrar a venda do produto
                case 3:
                    System.out.println("\t------REGISTRAR VENDA--------");

                    // Bloco try catch para capturar algum erro e exibir uma menssagem personalizada
                    try {
                        // Condição caso não haja produto cadastrado
                        if(store.products.isEmpty()){
                            System.out.println("Você não tem produtos cadastrados!\n");

                            // Caso contrario exibe a lista de produtos cadastrados
                        } else {
                            System.out.println("Lista de produtos:");

                            // Laço for para exibir os produtos cadastrados de acordo com seu índice
                            for (int i = 0; i < store.products.size(); i++){
                                System.out.println("Indice: " + i + " - " + store.products.get(i));
                            }

                            // Solicitando o indice do produto ao usuário para registrar a venda
                            System.out.printf("\nInforme o indice do produto para registrar a venda: ");
                            int idProduct = scanner.nextInt();

                            // Verificando se o índice digitado está na lista
                            if (idProduct >= 0 && idProduct < store.products.size()) {
                                System.out.println(store.products.get(idProduct));

                                // Solicitando id da venda
                                System.out.printf("\nInforme o id da venda: ");
                                int productId = scanner.nextInt();
                                scanner.nextLine();

                                // Solicitando quantidade vendida do produto
                                System.out.printf("Informe a quantidade vendida: ");
                                int productQtd = scanner.nextInt();
                                scanner.nextLine();

                                // Caso a quantidade vendida seja maior que o estoque
                                if(productQtd > store.products.get(idProduct).getQuantity()) {
                                    System.out.println("Estoque insuficiente para realizar a venda.\n");
                                }

                                // Chamando metodo construtor para Registra a venda do produto
                                Sale sale = new Sale(productId, store.products.get(idProduct), productQtd);

                                // Adicionando e armazenando a venda criada dentro do array List
                                store.sales.add(sale);

                                // Exibindo informações do produto vendido
                                System.out.println("\n\t--------INFORMAÇÕES DO PRODUTO--------");
                                System.out.println(store.products.get(idProduct).toString());

                                // Exibindo informações da venda do produto
                                sale.SellInfo();

                               // Caso o usuário digite o índice de um produto que não exista
                            } else {
                                System.out.println("Índice inválido. Produto não encontrado.");
                            }
                            }

                        // Bloco catch caso haja algum erro ao cadastrar o produto
                    } catch (Exception err){
                        System.out.println("Erro ao registrar a venda do produto");
                        System.err.println("\t" + err.getMessage() + "\n");
                    }
                    break;

                case 4:
                    System.out.println("\t-----Obrigado por utilizar nosso sistema!-----");
                    break;

                default:
                    System.out.println("Selecione a opção do menu valida\n");
                    break;
            }

        } while (option != 4);
        System.out.println("\t-----Obrigado por utilizar nosso sistema!-----");
        scanner.close();
    }
}
