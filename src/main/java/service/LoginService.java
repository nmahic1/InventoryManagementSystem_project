
//Dependency Injection koristi konstruktor injekciju kako bi dobavio objekt LoginDBConnectionRepository i omogućio pristup bazi podataka.
package service;

import repository.LoginDBConnectionRepository;

/**
 * Klasa LoginService pruža funkcionalnosti za provjeru i validaciju korisničkih prijava.
 * Omogućava provjeru korisničkog imena i lozinke koristeći LoginDBConnectionRepository za pristup bazi podataka.
 */
public class LoginService {
    private LoginDBConnectionRepository loginRepo;

    public LoginService() {
        this.loginRepo = new LoginDBConnectionRepository();
    }

    public LoginService(LoginDBConnectionRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    public boolean validateLogin(String username, String password) {
        // Ovdje možete dodati dodatnu poslovnu logiku, provjeru i validaciju
        // npr. provjeru duljine korisničkog imena/lozinke, enkripciju itd.


        return loginRepo.validateLogin(username, password);
    }
}



