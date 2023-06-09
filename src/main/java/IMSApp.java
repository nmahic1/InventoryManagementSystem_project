import java.util.*;

//imaju dva patterna observer i inventory
/**
 * IMSApp je glavna klasa aplikacije Inventory Management System (IMS).
 * Omogućava dodavanje, uređivanje, brisanje i ispis proizvoda pomoću korisničkog interfejsa preko konzole.
 * Implementira Observer i Inventory pattern.
 */
public class IMSApp {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Product>> productsByCategory = new HashMap<>();
    public static ProductInputStrategy productInputStrategy;
    public static List<InventoryObserver> observers = new ArrayList<>();

    /**
     * Glavna metoda koja pokreće IMS aplikaciju.
     *
     * @param args Argumenti iz komandne linije
     */
    public static void main(String[] args) {
        observers.add(new InventoryPrinter());
        productInputStrategy = new ConsoleProductInputStrategy();
        login();
        boolean running = true;
        while (running) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    productInputStrategy.addProduct(productsByCategory, scanner);
                    notifyObservers(); // Notify observers about the change
                    break;
                case 2:
                    editProduct();
                    notifyObservers(); // Notify observers about the change
                    break;
                case 3:
                    deleteProduct();
                    notifyObservers(); // Notify observers about the change
                    break;
                case 4:
                    printProducts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option. Please try again.");
                    break;
            }
        }
        System.out.println("Thank you for using our application!");
    }

    /**
     * Metoda za prijavu korisnika.
     * Traži korisničko ime i lozinku od korisnika.
     * Implementirajte logiku za provjeru korisničkih podataka.
     */
    private static void login() {
        System.out.println("Welcome! Please log in.");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        // Check username and password
        // Implement the logic to check user credentials here
        System.out.println("Logged in as " + username);
    }

    /**
     * Metoda koja prikazuje glavni meni korisničkog interfejsa.
     *
     * @return Izabrana opcija
     */
    private static int displayMenu() {
        System.out.println("-----------");
        System.out.println("Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Print Products");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    /**
     * Metoda za uređivanje postojećeg proizvoda.
     * Korisnik unosi kategoriju i indeks proizvoda koji želi urediti.
     * Zatim unosi nove detalje o proizvodu (brand, quantity, price).
     */
    private static void editProduct() {
        scanner.nextLine(); // Clear the line after previous input
        System.out.println("Enter the category of the product you want to edit:");
        String category = scanner.nextLine();

        if (productsByCategory.containsKey(category)) {
            System.out.println("Enter the index of the product to edit:");
            int index = scanner.nextInt();
            List<Product> productList = productsByCategory.get(category);

            if (index >= 0 && index < productList.size()) {
                System.out.println("Enter the new product details:");
                System.out.print("Brand: ");
                String brand = scanner.next();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Price: ");
                double price = scanner.nextDouble();

                Product product = productList.get(index);
                product.setBrand(brand);
                product.setQuantity(quantity);
                product.setPrice(price);

                System.out.println("Product successfully edited.");
            } else {
                System.out.println("Invalid product index.");
            }
        } else {
            System.out.println("Invalid product category.");
        }
    }

    /**
     * Metoda za brisanje postojećeg proizvoda.
     * Korisnik unosi kategoriju i indeks proizvoda koji želi obrisati.
     */
    private static void deleteProduct() {
        scanner.nextLine(); // Clear the line after previous input
        System.out.println("Enter the category of the product you want to delete:");
        String category = scanner.nextLine();

        if (productsByCategory.containsKey(category)) {
            System.out.println("Enter the index of the product to delete:");
            int index = scanner.nextInt();
            List<Product> productList = productsByCategory.get(category);

            if (index >= 0 && index < productList.size()) {
                productList.remove(index);
                System.out.println("Product successfully deleted.");
            } else {
                System.out.println("Invalid product index.");
            }
        } else {
            System.out.println("Invalid product category.");
        }
    }

    /**
     * Metoda za ispis svih proizvoda.
     * Prikazuje sve proizvode po kategorijama.
     */
    private static void printProducts() {
        System.out.println("Products:");
        for (String category : productsByCategory.keySet()) {
            System.out.println("Category: " + category);
            List<Product> productList = productsByCategory.get(category);
            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                System.out.println("Index: " + i);
                System.out.println("Brand: " + product.getBrand());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Price: " + product.getPrice());
                System.out.println("--------------------");
            }
        }
    }

    /**
     * Metoda koja obavještava observeje o promjeni podataka.
     */
    private static void notifyObservers() {
        for (InventoryObserver observer : observers) {
            observer.update(productsByCategory);
        }
    }

    /**
     * Metoda za dobavljanje strategije unosa proizvoda.
     *
     * @return Strategija unosa proizvoda
     */
    public static ProductInputStrategy getProductInputStrategy() {
        return productInputStrategy;
    }
}

/**
 * Sučelje ProductInputStrategy definira metodu za dodavanje proizvoda.
 */
interface ProductInputStrategy {

    /**
     * Dodaje proizvod na temelju unosa korisnika.
     *
     * @param productsByCategory Mapa proizvoda po kategorijama
     * @param scanner            Scanner objekat za unos korisnika
     */
    void addProduct(Map<String, List<Product>> productsByCategory, Scanner scanner);
}

/**
 * ConsoleProductInputStrategy je implementacija ProductInputStrategy sučelja.
 * Koristi korisnički unos preko konzole za dodavanje proizvoda.
 */
class ConsoleProductInputStrategy implements ProductInputStrategy {
    private static int indexCounter = 1; // Promenjena vrednost na 0 za početni indeks

    @Override
    public void addProduct(Map<String, List<Product>> productsByCategory, Scanner scanner) {
        scanner.nextLine(); // Clear the line after previous input
        System.out.println("Enter the product details:");
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(brand, category, quantity, price);

        if (productsByCategory.containsKey(category)) {
            List<Product> productList = productsByCategory.get(category);
            productList.add(product);
            int index = productList.size(); // Get the size as the index
            System.out.println("Product successfully added with index: " + index);
        } else {
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            productsByCategory.put(category, productList);
            int index = ++indexCounter; // Povećaj indexCounter i dodeli vrednost indeksu
            System.out.println("Product successfully added with index: " + index);
        }
    }
}

/**
 * Sučelje InventoryObserver definira metodu za ažuriranje inventara.
 */
interface InventoryObserver {
    /**
     * Ažurira inventar na temelju novih podataka.
     *
     * @param productsByCategory Mapa proizvoda po kategorijama
     */
    void update(Map<String, List<Product>> productsByCategory);
}

/**
 * InventoryPrinter je implementacija InventoryObserver sučelja.
 * Ispisuje promjene u inventaru nakon ažuriranja.
 */
class InventoryPrinter implements InventoryObserver {
    @Override
    public void update(Map<String, List<Product>> productsByCategory) {
        System.out.println("Inventory change. Updated data:");
        for (String category : productsByCategory.keySet()) {
            System.out.println("Category: " + category);
            List<Product> productList = productsByCategory.get(category);
            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                System.out.println("Index: " + i);
                System.out.println("Brand: " + product.getBrand());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Price: " + product.getPrice());
                System.out.println("--------------------");
            }
        }
    }
}

/**
 * Klasa Product predstavlja proizvod u inventaru.
 * Sadrži informacije o brandu, kategoriji, količini i cijeni proizvoda.
 */
class Product {
    private String brand;
    private String category;
    private int quantity;
    private double price;


    /**
     * Konstruktor za inicijalizaciju proizvoda.
     *
     * @param brand    Brand proizvoda
     * @param category Kategorija proizvoda
     * @param quantity Količina proizvoda
     * @param price    Cijena proizvoda
     */
    public Product(String brand, String category, int quantity, double price) {
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Getter za brand proizvoda.
     *
     * @return Brand proizvoda
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter za brand proizvoda.
     *
     * @param brand Novi brand proizvoda
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter za kategoriju proizvoda.
     *
     * @return Kategorija proizvoda
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter za kategoriju proizvoda.
     *
     * @param category Nova kategorija proizvoda
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter za količinu proizvoda.
     *
     * @return Količina proizvoda
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter za količinu proizvoda.
     *
     * @param quantity Nova količina proizvoda
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter za cijenu proizvoda.
     *
     * @return Cijena proizvoda
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter za cijenu proizvoda.
     *
     * @param price Nova cijena proizvoda
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
