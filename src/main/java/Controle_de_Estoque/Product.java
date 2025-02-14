package Controle_de_Estoque;

public class Product {
   // Variáveis para armazenar informações do produto
    private int id;
    private int quantity;
    private double price;
    private String name;

    // Método construtor para criar o produto
    Product(int id, int quantity, double price, String name){
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    // Getter para retornar o preço do produto
    public double getPrice() {
        return price;
    }

     // Getter para retornar a quantidade do produto
    public int getQuantity(){
        return quantity;
    }

    // Método Set para decrementar a quantidade no estoque do produto quando vendido
    public int setQuantity(int quantity){
        return this.quantity -= quantity;
    }

    // Método para exibir informações do produto cadastrado
    public String toString() {
        return "Produto [ID: " + id + ", Nome: " + name + ", Estoque: " + quantity + ", Preço: R$" + price + "]";
    }
}
