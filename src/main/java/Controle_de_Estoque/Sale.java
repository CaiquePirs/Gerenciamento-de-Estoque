package Controle_de_Estoque;

public class Sale {
    private int id;
    private Product product;
    private int quantity;
    private double valueSale;

    // Método Construtor para criar a venda do produto
    Sale(int id, Product product, int quantity){
        this.id = id;
        this.product = product;
        this.quantity = quantity;

        // Realizando o calculo total da venda do produto
        valueSale = product.getPrice() * quantity;

        // Decrementando quantidade do estoque
        product.setQuantity(quantity);
    }

    // Método para exibir as informações da venda
    public void SellInfo(){
        System.out.println("\n\t--------INFORMAÇÕES DA VENDA--------");
        System.out.println("Id: " + id + " Qtd: " + quantity + " Valor total R$" + valueSale);
    }
}
