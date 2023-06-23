package service;

import controller.CashRegisterController;
import repository.CashRegisterRepository;

/**
 * Klasa CashRegisterService pruža funkcionalnosti za manipulaciju kasom (blagajnom).
 * Omogućava dodavanje i brisanje proizvoda iz blagajne.
 */
public class CashRegisterService {

    private CashRegisterRepository cashregisterRepository;

    /**
     * Konstruktor koji inicijalizira CashRegisterService objekat.
     * Kreira novu instancu CashRegisterRepository.
     */
    public CashRegisterService() {
        this.cashregisterRepository = new CashRegisterRepository();
    }

    //dodano za testove
    /**
     * Vraća CashRegisterRepository objekat koji se koristi za pristup podacima blagajne.
     *
     * @return CashRegisterRepository objekat
     */
    public CashRegisterRepository getCashRegisterRepository() {
        return cashregisterRepository;
    }

    /**
     * Dodaje proizvod u blagajnu.
     *
     * @param cashregister Podaci o proizvodu koji se dodaje
     */
    public void addProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.addProduct(cashregister);
    }

    /**
     * Briše proizvod iz blagajne.
     *
     * @param cashregister Podaci o proizvodu koji se briše
     */
    public void deleteProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.deleteProduct(cashregister);
    }

    /**
     * Postavlja CashRegisterRepository objekat koji se koristi za pristup podacima blagajne.
     * Koristi se za mockanje testova.
     *
     * @param cashRegisterRepository CashRegisterRepository objekat
     */
    //za mockanje testova
    public void setCashRegisterRepository(CashRegisterRepository cashRegisterRepository) {
        this.cashregisterRepository = cashRegisterRepository;
    }
}





