package service;
import controller.CashRegisterController;
import repository.CashRegisterRepository;


public class CashRegisterService {
    private CashRegisterRepository cashRegisterRepository;

    public CashRegisterService() {
        cashRegisterRepository = new CashRegisterRepository();
    }

    public void addData(int quantity, String brand, int barcode, int retailprice) {
        CashRegisterController.Data data = new CashRegisterController.Data(barcode,  quantity);
        cashRegisterRepository.addData(data);
    }

    public void removeData(CashRegisterController.Data data) {
        cashRegisterRepository.removeData(data);
    }







}





