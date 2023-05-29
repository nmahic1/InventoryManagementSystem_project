/*package service;


import repository.LoginDBConnectionRepository;

public class LoginService {
    private LoginDBConnectionRepository loginRepo;

    public LoginService() {
        this.loginRepo = new LoginDBConnectionRepository();
    }

    public boolean validateLogin(String username, String password) {
        // Ovdje možete dodati dodatnu poslovnu logiku, provjeru i validaciju
        // npr. provjeru duljine korisničkog imena/lozinke, enkripciju itd.

        return loginRepo.validateLogin(username, password);
    }
}
*/

package service;

import repository.LoginDBConnectionRepository;

public class LoginService {
    private LoginDBConnectionRepository loginRepo;

    public LoginService() {
        this.loginRepo = new LoginDBConnectionRepository();
    }

    public boolean validateLogin(String username, String password) {
        // Ovdje možete dodati dodatnu poslovnu logiku, provjeru i validaciju
        // npr. provjeru duljine korisničkog imena/lozinke, enkripciju itd.

        return loginRepo.validateLogin(username, password);
    }
}