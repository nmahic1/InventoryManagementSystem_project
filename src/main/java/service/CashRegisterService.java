package service;
import controller.CashRegisterController;
import repository.CashRegisterRepository;

public class CashRegisterService {


    private CashRegisterRepository cashregisterRepository;
   // private CashRegisterRepository cashRegisterRepository;

    public CashRegisterService() {
        this.cashregisterRepository = new CashRegisterRepository();
    }

    //dodano za testove
    public CashRegisterRepository getCashRegisterRepository() {
        return cashregisterRepository;
    }

    public void addProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.addProduct(cashregister);
    }

    public void deleteProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.deleteProduct(cashregister);
    }


}





