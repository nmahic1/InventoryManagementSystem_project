package service;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import repository.LoginDBConnectionRepository;
import service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private LoginDBConnectionRepository loginRepo;

    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateLogin_ValidCredentials() {
        // Mockanje metode validateLogin u loginRepo
        Mockito.when(loginRepo.validateLogin("validUsername", "validPassword")).thenReturn(true);

        // Pozivanje metode validateLogin iz LoginService
        boolean result = loginService.validateLogin("validUsername", "validPassword");

        // Provjera očekivanog rezultata
        assertTrue(result);

        // Provjera poziva metode validateLogin u loginRepo
        verify(loginRepo, times(1)).validateLogin("validUsername", "validPassword");
    }

    @Test
    public void testValidateLogin_InvalidCredentials() {
        // Mockanje metode validateLogin u loginRepo
        Mockito.when(loginRepo.validateLogin("invalidUsername", "invalidPassword")).thenReturn(false);

        // Pozivanje metode validateLogin iz LoginService
        boolean result = loginService.validateLogin("invalidUsername", "invalidPassword");

        // Provjera očekivanog rezultata
        assertFalse(result);

        // Provjera poziva metode validateLogin u loginRepo
        verify(loginRepo, times(1)).validateLogin("invalidUsername", "invalidPassword");
    }
}
*/



/*import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void validateLogin() {
    }
}*/

//MOJ KOD
/*
import org.junit.Before;
import org.junit.Test;
import repository.LoginDBConnectionRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {
    private LoginDBConnectionRepository loginRepo;
    private LoginService loginService;

    @Before
    public void setup() {
        // Inicijalizujte LoginDBRepository (ili koristite pravi objekat ili napravite dummy implementaciju)
        loginRepo = new LoginDBConnectionRepository();
        loginService = new LoginService(loginRepo);
    }

    @Test
    public void testValidateLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String username = "nmahic1";
        String password = "12345";

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

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }


    @Test
    public void testValidateLogin_BlankCreditentials_ReturnsFalse() {
        // Arrange
        String username = "";
        String password = "";

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }




}

 */

/*
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.LoginDBConnectionRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LoginServiceTest {
    @Mock
    private LoginDBConnectionRepository loginRepo;
    private LoginService loginService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
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


 */
/*
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

 */


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
