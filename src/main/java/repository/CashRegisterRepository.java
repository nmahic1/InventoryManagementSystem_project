package repository;

import controller.CashRegisterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CashRegisterRepository {
    private ObservableList<CashRegisterController.Data> dataListCashRegister;

    public CashRegisterRepository() {
        dataListCashRegister = FXCollections.observableArrayList();
    }

    public void addData(CashRegisterController.Data data) {
        dataListCashRegister.add(data);
    }

    public void removeData(CashRegisterController.Data data) {
        dataListCashRegister.remove(data);
    }

    public ObservableList<CashRegisterController.Data> getDataList() {
        return dataListCashRegister;
    }
}
