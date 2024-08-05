package Exercise02;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    // Method to add a product to the catalog
    public void addProduct(String id, String name, double price) {
        products.put(id, new Product(id, name, price));
    }

    // Method to find a product by id
    public Product findProductById(String id) throws ProductNotFoundException {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found.");
        }
        return products.get(id);
    }

    // Inner class representing a Product
    public class Product {
        private String id;
        private String name;
        private double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "{id='" + id + "', name='" + name + "', price=" + price + "}";
        }
    }

    // Inner exception class for handling ProductNotFoundException
    public static class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String message) {
            super(message);
        }
        public ProductNotFoundException() {
            super();
        }
    }

    // Method to display all products
    public void displayAllProducts() {
        products.values().forEach(System.out::println);
    }
}
