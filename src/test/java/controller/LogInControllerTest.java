package controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import repository.LoginDBConnectionRepository;
import service.LoginService;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class LogInControllerTest {

 /*   @Test
    public void login() {

    }

    @Test
    public void validateLogin() {
    }
}

  */

    @Test
    public void testValidCredentials() {
        LoginService loginService = new LoginService();
        boolean result = loginService.validateLogin("nmahic1", "12345");
        assertTrue(result);

    }

}