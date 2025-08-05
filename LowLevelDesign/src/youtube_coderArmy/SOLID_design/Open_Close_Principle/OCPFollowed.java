package youtube_coderArmy.SOLID_design.Open_Close_Principle;

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
class ShoppingCartPrinter1 {
    private ShoppingCart1 cart;

    public ShoppingCartPrinter1(ShoppingCart1 cart) {
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

interface Persistence {
    void save(ShoppingCart1 cart);
}

class SQLPersistence implements Persistence {
    @Override
    public void save(ShoppingCart1 cart) {
        System.out.println("Saving shopping cart to SQL DB...");
    }
}

class MongoPersistence implements Persistence {
    @Override
    public void save(ShoppingCart1 cart) {
        System.out.println("Saving shopping cart to MongoDB...");
    }
}

class FilePersistence implements Persistence {
    @Override
    public void save(ShoppingCart1 cart) {
        System.out.println("Saving shopping cart to a file...");
    }
}

public class OCPFollowed {
    public static void main(String[] args) {
        ShoppingCart1 cart = new ShoppingCart1();
        cart.addProduct(new Product1("Laptop", 50000));
        cart.addProduct(new Product1("Mouse", 2000));

        ShoppingCartPrinter1 printer = new ShoppingCartPrinter1(cart);
        printer.printInvoice();

        Persistence db    = new SQLPersistence();
        Persistence mongo = new MongoPersistence();
        Persistence file  = new FilePersistence();

        db.save(cart);    // Save to SQL database
        mongo.save(cart); // Save to MongoDB
        file.save(cart);  // Save to File
    }
}