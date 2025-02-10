package Controle_de_Estoque;

public class Product {
   // Variaáveis para armazenar informações do produto
    private int id;
    private int quantity;
    private double price;
    private String name;

    // Metodo construtor para criar o produto
    Product(int id, int quantity, double price, String name){
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    // Getters
    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    // Metodo Set para decrementar quantidade do produto quando vendido
    public int setQuantity(int quantity){
        return this.quantity -= quantity;
    }

    // Metodo para exibir informações do produto cadastrado
    public String toString() {
        return "Produto [ID: " + id + ", Nome: " + name + ", Estoque: " + quantity + ", Preço: R$" + price + "]";
    }
}
