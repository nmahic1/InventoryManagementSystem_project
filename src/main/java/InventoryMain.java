public class InventoryMain {
    public static void main(String[] args) {

        IMSApp.observers.add(new InventoryPrinter());
        IMSApp.productInputStrategy = new ConsoleProductInputStrategy();
        IMSApp.main(args);
    }
}
