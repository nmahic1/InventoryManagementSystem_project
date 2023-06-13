package service;

import controller.CashRegisterController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CashRegisterRepository;

import static org.mockito.Mockito.*;

public class CashRegisterServiceTestMock {
    @Mock
    private CashRegisterRepository cashRegisterRepository;
    private CashRegisterService cashRegisterService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cashRegisterService = new CashRegisterService();
        cashRegisterService.setCashRegisterRepository(cashRegisterRepository);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        CashRegisterController.Data cashRegisterData = new CashRegisterController.Data(12345123, 2);

        // Act
        cashRegisterService.addProduct(cashRegisterData);

        // Assert
        verify(cashRegisterRepository, times(1)).addProduct(cashRegisterData);
    }

    //deleting with mock
    @Test
    public void testDeleteProduct() {
        // Arrange
        CashRegisterController.Data cashRegisterData = new CashRegisterController.Data(12345123, 2);

        // Act
        cashRegisterService.deleteProduct(cashRegisterData);

        // Assert
        verify(cashRegisterRepository, times(1)).deleteProduct(cashRegisterData);
    }


}
