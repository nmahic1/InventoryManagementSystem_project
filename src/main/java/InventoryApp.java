//import java.util.*;
/*
public class InventoryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Product>> productsByCategory = new HashMap<>();

    public static void main(String[] args) {
        login();
        boolean running = true;
        while (running) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    printProducts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Nepoznata opcija. Molimo pokušajte ponovo.");
                    break;
            }
        }
        System.out.println("Hvala što ste koristili našu aplikaciju!");
    }

    private static void login() {
        System.out.println("Dobrodošli! Molimo prijavite se.");
        System.out.print("Korisničko ime: ");
        String username = scanner.nextLine();
        System.out.print("Lozinka: ");
        String password = scanner.nextLine();
        // Provjera korisničkog imena i lozinke
        // Implementirajte logiku provjere korisničkih podataka ovdje
        System.out.println("Prijavili ste se kao " + username);
    }

    private static int displayMenu() {
        System.out.println("-----------");
        System.out.println("Izbornik:");
        System.out.println("1. Unesi proizvod");
        System.out.println("2. Izmijeni proizvod");
        System.out.println("3. Obriši proizvod");
        System.out.println("4. Ispiši proizvode");
        System.out.println("5. Izlaz");
        System.out.print("Odaberite opciju: ");
        return scanner.nextInt();
    }

    private static void addProduct() {
        scanner.nextLine(); // Prazni red nakon prethodnog unosa
        System.out.println("Unesite podatke o proizvodu:");
        System.out.print("Brend: ");
        String brand = scanner.nextLine();
        System.out.print("Kategorija: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Cijena: ");
        double price = scanner.nextDouble();

        Product product = new Product(brand, category, quantity, price);

        if (productsByCategory.containsKey(category)) {
            List<Product> productList = productsByCategory.get(category);
            productList.add(product);
        } else {
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            productsByCategory.put(category, productList);
        }

        System.out.println("Proizvod uspješno dodan.");
    }

    private static void editProduct() {
        scanner.nextLine(); // Prazni red nakon prethodnog unosa
        System.out.println("Unesite kategoriju proizvoda koji želite izmijeniti:");
        String category = scanner.nextLine();

        if (productsByCategory.containsKey(category)) {
            System.out.println("Unesite indeks proizvoda za izmjenu:");
            int index = scanner.nextInt();
            List<Product> productList = productsByCategory.get(category);

            if (index >= 0 && index < productList.size()) {
                System.out.println("Unesite nove podatke o proizvodu:");
                System.out.print("Brend: ");
                String brand = scanner.next();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Cijena: ");
                double price = scanner.nextDouble();

                Product product = productList.get(index);
                product.setBrand(brand);
                product.setQuantity(quantity);
                product.setPrice(price);

                System.out.println("Proizvod uspješno izmijenjen.");
            } else {
                System.out.println("Nepostojeći indeks proizvoda.");
            }
        } else {
            System.out.println("Nepostojeća kategorija proizvoda.");
        }
    }

    private static void deleteProduct() {
        scanner.nextLine(); // Prazni red nakon prethodnog unosa
        System.out.println("Unesite kategoriju proizvoda koji želite izbrisati:");
        String category = scanner.nextLine();

        if (productsByCategory.containsKey(category)) {
            System.out.println("Unesite indeks proizvoda za brisanje:");
            int index = scanner.nextInt();
            List<Product> productList = productsByCategory.get(category);

            if (index >= 0 && index < productList.size()) {
                productList.remove(index);
                System.out.println("Proizvod uspješno obrisan.");
            } else {
                System.out.println("Nepostojeći indeks proizvoda.");
            }
        } else {
            System.out.println("Nepostojeća kategorija proizvoda.");
        }
    }

    private static void printProducts() {
        System.out.println("Proizvodi:");
        for (String category : productsByCategory.keySet()) {
            System.out.println("Kategorija: " + category);
            List<Product> productList = productsByCategory.get(category);
            for (Product product : productList) {
                System.out.println("Brend: " + product.getBrand());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Cijena: " + product.getPrice());
                System.out.println("--------------------");
            }
        }
    }
}

class Product {
    private String brand;
    private String category;
    private int quantity;
    private double price;

    public Product(String brand, String category, int quantity, double price) {
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

 */

/*
import java.util.*;

public class InventoryApp {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Product>> productsByCategory = new HashMap<>();
    public static ProductInputStrategy productInputStrategy;
    public static List<InventoryObserver> observers = new ArrayList<>();
    public static void main(String[] args) {
        login();
        boolean running = true;
        while (running) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    productInputStrategy.addProduct(productsByCategory, scanner);
                    notifyObservers(); // Obavijesti promatrače o promjeni
                    break;
                case 2:
                    editProduct();
                    notifyObservers(); // Obavijesti promatrače o promjeni
                    break;
                case 3:
                    deleteProduct();
                    notifyObservers(); // Obavijesti promatrače o promjeni
                    break;
                case 4:
                    printProducts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Nepoznata opcija. Molimo pokušajte ponovo.");
                    break;
            }
        }
        System.out.println("Hvala što ste koristili našu aplikaciju!");
    }

    private static void login() {
        System.out.println("Dobrodošli! Molimo prijavite se.");
        System.out.print("Korisničko ime: ");
        String username = scanner.nextLine();
        System.out.print("Lozinka: ");
        String password = scanner.nextLine();
        // Provjera korisničkog imena i lozinke
        // Implementirajte logiku provjere korisničkih podataka ovdje
        System.out.println("Prijavili ste se kao " + username);
    }

    private static int displayMenu() {
        System.out.println("-----------");
        System.out.println("Izbornik:");
        System.out.println("1. Unesi proizvod");
        System.out.println("2. Izmijeni proizvod");
        System.out.println("3. Obriši proizvod");
        System.out.println("4. Ispiši proizvode");
        System.out.println("5. Izlaz");
        System.out.print("Odaberite opciju: ");
        return scanner.nextInt();
    }

    private static void editProduct() {
        scanner.nextLine(); // Prazni red nakon prethodnog unosa
        System.out.println("Unesite kategoriju proizvoda koji želite izmijeniti:");
        String category = scanner.nextLine();

        if (productsByCategory.containsKey(category)) {
            System.out.println("Unesite indeks proizvoda za izmjenu:");
            int index = scanner.nextInt();
            List<Product> productList = productsByCategory.get(category);

            if (index >= 0 && index < productList.size()) {
                System.out.println("Unesite nove podatke o proizvodu:");
                System.out.print("Brend: ");
                String brand = scanner.next();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Cijena: ");
                double price = scanner.nextDouble();

                Product product = productList.get(index);
                product.setBrand(brand);
                product.setQuantity(quantity);
                product.setPrice(price);

                System.out.println("Proizvod uspješno izmijenjen.");
            } else {
                System.out.println("Nepostojeći indeks proizvoda.");
            }
        } else {
            System.out.println("Nepostojeća kategorija proizvoda.");
        }
    }

    private static void deleteProduct() {
        scanner.nextLine(); // Prazni red nakon prethodnog unosa
        System.out.println("Unesite kategoriju proizvoda koji želite izbrisati:");
        String category = scanner.nextLine();

        if (productsByCategory.containsKey(category)) {
            System.out.println("Unesite indeks proizvoda za brisanje:");
            int index = scanner.nextInt();
            List<Product> productList = productsByCategory.get(category);

            if (index >= 0 && index < productList.size()) {
                productList.remove(index);
                System.out.println("Proizvod uspješno obrisan.");
            } else {
                System.out.println("Nepostojeći indeks proizvoda.");
            }
        } else {
            System.out.println("Nepostojeća kategorija proizvoda.");
        }
    }

    private static void printProducts() {
        System.out.println("Proizvodi:");
        for (String category : productsByCategory.keySet()) {
            System.out.println("Kategorija: " + category);
            List<Product> productList = productsByCategory.get(category);
            for (Product product : productList) {
                System.out.println("Brend: " + product.getBrand());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Cijena: " + product.getPrice());
                System.out.println("--------------------");
            }
        }
    }

    private static void notifyObservers() {
        for (InventoryObserver observer : observers) {
            observer.update(productsByCategory);
        }
    }

    public static ProductInputStrategy getProductInputStrategy() {
        return productInputStrategy;
    }
}

interface ProductInputStrategy {
    void addProduct(Map<String, List<Product>> productsByCategory, Scanner scanner);
}

class ConsoleProductInputStrategy implements ProductInputStrategy {
    @Override
    public void addProduct(Map<String, List<Product>> productsByCategory, Scanner scanner) {
        scanner.nextLine(); // Prazni red nakon prethodnog unosa
        System.out.println("Unesite podatke o proizvodu:");
        System.out.print("Brend: ");
        String brand = scanner.nextLine();
        System.out.print("Kategorija: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Cijena: ");
        double price = scanner.nextDouble();

        InventoryApp.productInputStrategy.addProduct(productsByCategory, scanner);

        Product product = new Product(brand, category, quantity, price);

        if (productsByCategory.containsKey(category)) {
            List<Product> productList = productsByCategory.get(category);
            productList.add(product);
        } else {
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            productsByCategory.put(category, productList);
        }

        System.out.println("Proizvod uspješno dodan.");
    }
}

interface InventoryObserver {
    void update(Map<String, List<Product>> productsByCategory);
}

class InventoryPrinter implements InventoryObserver {
    @Override
    public void update(Map<String, List<Product>> productsByCategory) {
        System.out.println("Promjena u inventaru. Ažurirani podaci:");
        for (String category : productsByCategory.keySet()) {
            System.out.println("Kategorija: " + category);
            List<Product> productList = productsByCategory.get(category);
            for (Product product : productList) {
                System.out.println("Brend: " + product.getBrand());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Cijena: " + product.getPrice());
                System.out.println("--------------------");
            }
        }
    }
}

class Product {
    private String brand;
    private String category;
    private int quantity;
    private double price;

    public Product(String brand, String category, int quantity, double price) {
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class InventoryMain {
    public static void main(String[] args) {
        InventoryApp.observers.add(new InventoryPrinter());
        InventoryApp.productInputStrategy = new ConsoleProductInputStrategy();
        InventoryApp.main(args);
    }
}

 */




