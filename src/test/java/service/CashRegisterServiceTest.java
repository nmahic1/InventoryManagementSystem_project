package service;

import controller.CashRegisterController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CashRegisterRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashRegisterServiceTest {
//dodati testove

    private CashRegisterService cashRegisterService;

    @BeforeEach
    public void setUp() {
        cashRegisterService = new CashRegisterService();
    }

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
        Assert.assertFalse(cashRegisterRepository.containsProduct(cashregister));
    }

    // Getter for CashRegisterRepository (for testing purposes)
    private CashRegisterRepository getCashRegisterRepository() {
        return cashRegisterService.getCashRegisterRepository();
    }
}
