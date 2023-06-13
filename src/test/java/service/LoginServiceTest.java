package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.LoginDBConnectionRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class LoginServiceTest {
    @Mock
    private LoginDBConnectionRepository loginRepo;
    private LoginService loginService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        loginService = new LoginService(loginRepo);
    }

    @Test
    public void testValidateLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String username = "nmahic1";
        String password = "12345";

        // Mock behavior
        when(loginRepo.validateLogin(username, password)).thenReturn(true);

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertTrue(isValid);
    }


    @Test
    public void testValidateLogin_InvalidCredentials_ReturnsFalse() {
        // Arrange
        String username = "nmahic";
        String password = "123456";

        // Mock behavior
        when(loginRepo.validateLogin(username, password)).thenReturn(false);

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }

    @Test
    public void testValidateLogin_BlankCredentials_ReturnsFalse() {
        // Arrange
        String username = "";
        String password = "";

        // Mock behavior
        when(loginRepo.validateLogin(username, password)).thenReturn(false);

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }

}
