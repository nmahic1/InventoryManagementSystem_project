/**
 * Glavna klasa za pokretanje Inventory aplikacije.
 */
public class InventoryMain {
    /**
     * Metoda koja se poziva pri pokretanju aplikacije.
     * Inicijalizira promatrače, strategiju unosa proizvoda i pokreće Inventory aplikaciju.
     *
     * @param args Argumenti komandne linije
     */
    public static void main(String[] args) {

        IMSApp.observers.add(new InventoryPrinter());
        IMSApp.productInputStrategy = new ConsoleProductInputStrategy();
        IMSApp.main(args);

    }
}
