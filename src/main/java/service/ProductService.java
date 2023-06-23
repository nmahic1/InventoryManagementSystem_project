package service;

import controller.ProductController;
import javafx.collections.ObservableList;
import repository.ProductRepository;

/**
 * Klasa ProductService pruža funkcionalnosti za upravljanje proizvodima.
 * Omogućava dodavanje, ažuriranje, brisanje i dohvaćanje proizvoda iz repozitorija.
 */
public class ProductService {

    private ProductRepository productRepository;

    /**
     * Konstruktor koji inicijalizira ProductService objekat.
     * Kreira novu instancu ProductRepository.
     */
    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    /**
     * Dodaje novi proizvod u repozitorij.
     *
     * @param product Podaci o proizvodu (brand, category, costPrice, retailPrice, quantity, barcode, description)
     */
    public void addProduct(ProductController.Data product) {
        productRepository.addProduct(product);
    }

    /**
     * Ažurira postojeći proizvod u repozitoriju.
     *
     * @param product Podaci o proizvodu (brand, category, costPrice, retailPrice, quantity, barcode, description)
     */
    public void updateProduct(ProductController.Data product) {
        productRepository.updateProduct(product);
    }

    /**
     * Briše proizvod iz repozitorija.
     *
     * @param product Podaci o proizvodu (brand, category, costPrice, retailPrice, quantity, barcode, description)
     */
    public void deleteProduct(ProductController.Data product) {
        productRepository.deleteProduct(product);
    }

    /**
     * Vraća sve proizvode iz repozitorija.
     *
     * @return Lista proizvoda
     */
    public ObservableList<ProductController.Data> getAllProducts() {
        return productRepository.getAllProducts();
    }

    /**
     * Dohvaća proizvod na temelju zadatog bar koda.
     *
     * @param barcode Bar kod proizvoda
     * @return Podaci o proizvodu (brand, category, costPrice, retailPrice, quantity, barcode, description)
     */
    public ProductController.Data getProductByBarcode(int barcode) {
        return productRepository.getProductByBarcode(barcode);
    }

}
