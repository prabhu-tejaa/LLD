package youtube_coderArmy.SOLID_design.Single_Responsibility_Principle;

import java.util.ArrayList;
import java.util.List;

// Product class representing any item in eCommerce.
class Product1 {
    public String name;
    public double price;

    public Product1(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart1 {
    private List<Product1> products = new ArrayList<>();

    public void addProduct(Product1 p) {
        products.add(p);
    }

    public List<Product1> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (Product1 p : products) {
            total += p.price;
        }
        return total;
    }
}

// 2. ShoppingCartPrinter: Only responsible for printing invoices
class ShoppingCartPrinter {
    private ShoppingCart1 cart;

    public ShoppingCartPrinter(ShoppingCart1 cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product1 p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

// 3. ShoppingCartStorage: Only responsible for saving cart to DB
class ShoppingCartStorage {
    private ShoppingCart1 cart;

    public ShoppingCartStorage(ShoppingCart1 cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class SRPFollowed {
    public static void main(String[] args) {
        ShoppingCart1 cart = new ShoppingCart1();

        cart.addProduct(new Product1("Laptop", 50000));
        cart.addProduct(new Product1("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}