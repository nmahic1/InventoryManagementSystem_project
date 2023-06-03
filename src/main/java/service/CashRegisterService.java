package service;
import controller.CashRegisterController;
import repository.CashRegisterRepository;



public class CashRegisterService {
   /* private CashRegisterRepository cashRegisterRepository;

    public CashRegisterService() {
        cashRegisterRepository = new CashRegisterRepository();
    }

    public void addData(int quantity, String brand, int barcode, int price) {
        CashRegisterController.Data data = new CashRegisterController.Data(barcode,  quantity);
        cashRegisterRepository.addData(data);
    }

    public void removeData(CashRegisterController.Data data) {
        cashRegisterRepository.removeData(data);
    }
*/

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





