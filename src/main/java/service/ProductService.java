package service;

import controller.ProductController;
import javafx.collections.ObservableList;
import repository.ProductRepository;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    public static void addProduct(ProductController.Data product) {
        ProductRepository.addProduct(product);
    }

    public static void updateProduct(ProductController.Data product) {
        ProductRepository.updateProduct(product);
    }

    public static void deleteProduct(ProductController.Data product) {
        ProductRepository.deleteProduct(product);
    }

    public static ObservableList<ProductController.Data> getAllProducts() {
        return  ProductRepository.getAllProducts();
    }


}
