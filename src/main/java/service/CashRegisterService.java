package service;
import controller.CashRegisterController;
import repository.CashRegisterRepository;

public class CashRegisterService {

    private CashRegisterRepository cashregisterRepository;

    public CashRegisterService() {
        this.cashregisterRepository = new CashRegisterRepository();
    }

    public void addProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.addProduct(cashregister);
    }

    public void deleteProduct(CashRegisterController.Data cashregister) {
        cashregisterRepository.deleteProduct(cashregister);
    }


}





