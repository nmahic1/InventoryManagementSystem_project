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

    public void addProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.addProduct(cashregister);
    }

    public void deleteProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.deleteProduct(cashregister);
    }

    //za mockanje testova
    public void setCashRegisterRepository(CashRegisterRepository cashRegisterRepository) {
        this.cashregisterRepository = cashRegisterRepository;
    }
}





