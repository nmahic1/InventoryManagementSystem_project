package service;

import controller.CashRegisterController;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CashRegisterRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testna klasa za CashRegisterService.
 */
public class CashRegisterServiceTest {
//dodati testove

    private CashRegisterService cashRegisterService;

    @BeforeEach
    public void setUp() {
        cashRegisterService = new CashRegisterService();
    }

    /**
     * Test slučaj za dodavanje proizvoda u kasu.
     */
    @Test
    public void testAddProduct() {
        CashRegisterController.Data cashregister = new CashRegisterController.Data(44444444, 3);

        cashRegisterService.addProduct(cashregister);

        // Assert that the product is added to the repository
        CashRegisterRepository cashRegisterRepository = cashRegisterService.getCashRegisterRepository();
        Assert.assertTrue(cashRegisterRepository.containsProduct(cashregister));
    }

    @Test
    public void testDeleteProduct() {
        CashRegisterController.Data cashregister = new CashRegisterController.Data(44444444, 3);

        // Add the product first
        cashRegisterService.addProduct(cashregister);

        // Delete the product
        cashRegisterService.deleteProduct(cashregister);

        // Assert that the product is no longer in the repository
        CashRegisterRepository cashRegisterRepository = cashRegisterService.getCashRegisterRepository();
        assertFalse(cashRegisterRepository.containsProduct(cashregister));
    }

    // Getter for CashRegisterRepository (for testing purposes)
    private CashRegisterRepository getCashRegisterRepository() {
        return cashRegisterService.getCashRegisterRepository();
    }

    @Test
    public void testGetCashRegisterRepository() {
        // Arrange
        CashRegisterRepository expectedRepository = cashRegisterService.getCashRegisterRepository();

        // Act
        CashRegisterRepository actualRepository = cashRegisterService.getCashRegisterRepository();

        // Assert
        assertEquals(expectedRepository, actualRepository);
    }


    @Test
    public void testDeleteProduct_NonExistingProduct() {
        // Arrange
        CashRegisterController.Data cashregister = new CashRegisterController.Data(44444444, 3);

        // Act
        cashRegisterService.deleteProduct(cashregister);

        // Assert
        CashRegisterRepository cashRegisterRepository = cashRegisterService.getCashRegisterRepository();
        assertFalse(cashRegisterRepository.containsProduct(cashregister));
    }


}



