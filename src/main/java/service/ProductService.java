package service;

import controller.ProductController;
import javafx.collections.ObservableList;
import repository.ProductRepository;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    public void addProduct(ProductController.Data product) {
        productRepository.addProduct(product);
    }

    public void updateProduct(ProductController.Data product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(ProductController.Data product) {
        productRepository.deleteProduct(product);
    }

    public ObservableList<ProductController.Data> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public ProductController.Data getProductByBarcode(int barcode) {
        return productRepository.getProductByBarcode(barcode);
    }

}
