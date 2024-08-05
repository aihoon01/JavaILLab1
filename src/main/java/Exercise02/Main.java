package Exercise02;

public class Main {
    public static void main(String[] args){
        var catalog = new ProductCatalog();

        catalog.addProduct("10ff", "Laptop", 999.99);
        catalog.addProduct("11ff", "Keyboard", 77.01);
        catalog.addProduct("12ff", "Monitor", 170.12);

        catalog.displayAllProducts();

        System.out.println();

        try {
            ProductCatalog.Product product = catalog.findProductById("11ff");
            System.out.println("Found!🎉: " + product);

            ProductCatalog.Product product2 = catalog.findProductById("20fff");
        } catch (ProductCatalog.ProductNotFoundException e) {
            System.out.println("NOT FOUND EXCEPTION🤣: " + "requested product cannot be found!" );;
        }

    }
}
