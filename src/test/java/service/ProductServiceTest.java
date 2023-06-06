package service;
import controller.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.ProductRepository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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



/*
    @Test
    public void testAddProduct() {
        // Arrange
        ProductController.Data product = new ProductController.Data(13, "coca cola", "Beverages", 2, 60, 3, 7777777, "drink");
        ObservableList<ProductController.Data> expectedProducts = FXCollections.observableArrayList(product);

        // Mock behavior of productRepository
        doNothing().when(productrepository).addProduct(any(ProductController.Data.class));
        when(productrepository.getAllProducts()).thenReturn(expectedProducts);

        // Act
        productService.addProduct(product);
        ObservableList<ProductController.Data> actualProducts = productService.getAllProducts();

        // Assert
        assertEquals(expectedProducts, actualProducts);

        // Verify that addProduct method was called on productRepository
        verify(productrepository, times(1)).addProduct(product);
    }

 */

    /*
    @Test
    public void testAddProduct() {
        // Arrange
        ProductController.Data product = new ProductController.Data(13, "coca cola", "Beverages",2,60,3,7777777,"drink" );
        ObservableList<ProductController.Data> expectedProducts = FXCollections.observableArrayList(product);

        // Act
        productService.addProduct(product);
        ObservableList<ProductController.Data> actualProducts = productService.getAllProducts();

        // Assert
        assertEquals(expectedProducts.size(), actualProducts.size());
        for (ProductController.Data expectedProduct : expectedProducts) {
            assertTrue(actualProducts.contains(expectedProduct));
        }
    }


     */


/*

    @Test
    public void testUpdateProduct() {
        // Arrange
        ProductController.Data existingProduct = new ProductController.Data(8, "coca cola", "Beverages", 2, 38, 3, 11223344, "drink");
        ProductController.Data updatedProduct = new ProductController.Data(8, "coca cola1", "Beverages1", 3, 40, 4, 11223345, "drink1");
        productRepository.addProduct(existingProduct);

        // Act
        productService.updateProduct(updatedProduct);
        ProductController.Data actualProduct = productService.getProductByBarcode(11223344);

        // Assert
        assertEquals(updatedProduct.getId(), actualProduct.getId());
        assertEquals(updatedProduct.getBrand(), actualProduct.getBrand());
        assertEquals(updatedProduct.getCategory(), actualProduct.getCategory());
        assertEquals(updatedProduct.getQuantity(), actualProduct.getQuantity());
        assertEquals(updatedProduct.getRetailPrice(), actualProduct.getRetailPrice());
        assertEquals(updatedProduct.getCostPrice(), actualProduct.getCostPrice());
        assertEquals(updatedProduct.getBarcode(), actualProduct.getBarcode());
        assertEquals(updatedProduct.getDescription(), actualProduct.getDescription());
    }

 */





    @Test
    public void testDeleteProduct() {
        // Arrange
        ProductController.Data product = new ProductController.Data(8, "coca cola", "Beverages",2,38,3,11223344,"drink" );
        productRepository.addProduct(product);

        // Act
        productService.deleteProduct(product);
        ProductController.Data deletedProduct = productService.getProductByBarcode(123);

        // Assert
        assertEquals(null, deletedProduct);
    }

    /*
    @Test
    public void testGetAllProducts() {
        // Arrange
        ProductController.Data product1 = new ProductController.Data("Product1", 123, 10);
        ProductController.Data product2 = new ProductController.Data("Product2", 456, 20);
        productRepository.addProduct(product1);
        productRepository.addProduct(product2);

        // Act
        ObservableList<ProductController.Data> actualProducts = productService.getAllProducts();
        ObservableList<ProductController.Data> expectedProducts = FXCollections.observableArrayList(product1, product2);

        // Assert
        assertEquals(expectedProducts, actualProducts);
    }

     */


  /*  @Test
    public void testGetProductByBarcode_ExistingProduct() {
        // Arrange
        ProductController.Data existingProduct = new ProductController.Data(8, "coca cola", "Beverages",2,38,3,11223344,"drink" );
        productRepository.addProduct(existingProduct);

        // Act
        ProductController.Data actualProduct = productService.getProductByBarcode(11223344);

        // Assert
        assertEquals(existingProduct, actualProduct);
    }

   */



    @Test
    public void testGetProductByBarcode_NonExistingProduct() {
        // Arrange

        // Act
        ProductController.Data actualProduct = productService.getProductByBarcode(99999999);

        // Assert
        assertEquals(null, actualProduct);
    }
}
