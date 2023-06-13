package service;

import controller.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @Mock
    private ProductRepository productrepository;

    @BeforeEach
    public void setUp() {
        productRepository = new ProductRepository();
        productService = new ProductService();
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testDeleteProduct() {
        // Arrange
        ProductController.Data product = new ProductController.Data(8, "coca cola", "Beverages", 2, 38, 3, 11223344, "drink");
        productRepository.addProduct(product);

        // Act
        productService.deleteProduct(product);
        ProductController.Data deletedProduct = productService.getProductByBarcode(123);

        // Assert
        assertEquals(null, deletedProduct);
    }


    @Test
    public void testGetProductByBarcode_NonExistingProduct() {
        // Arrange

        // Act
        ProductController.Data actualProduct = productService.getProductByBarcode(99999999);

        // Assert
        assertEquals(null, actualProduct);
    }
}
