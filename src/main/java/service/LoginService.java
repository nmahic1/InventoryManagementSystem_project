
//Dependency Injection koristi konstruktor injekciju kako bi dobavio objekt LoginDBConnectionRepository i omogućio pristup bazi podataka.
package service;

import repository.LoginDBConnectionRepository;

/**
 * Klasa LoginService pruža funkcionalnosti za provjeru i validaciju korisničkih prijava.
 * Omogućava provjeru korisničkog imena i lozinke koristeći LoginDBConnectionRepository za pristup bazi podataka.
 */
public class LoginService {
    private LoginDBConnectionRepository loginRepo;

    /**
     * Konstruktor koji inicijalizira LoginService objekat.
     * Kreira novu instancu LoginDBConnectionRepository.
     */
    public LoginService() {
        this.loginRepo = new LoginDBConnectionRepository();
    }

    /**
     * Konstruktor koji koristi Dependency Injection za injekciju LoginDBConnectionRepository objekta.
     *
     * @param loginRepo LoginDBConnectionRepository objekat
     */
    public LoginService(LoginDBConnectionRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    public boolean validateLogin(String username, String password) {
        // Ovdje možete dodati dodatnu poslovnu logiku, provjeru i validaciju
        // npr. provjeru duljine korisničkog imena/lozinke, enkripciju itd.


        return loginRepo.validateLogin(username, password);
    }
}



