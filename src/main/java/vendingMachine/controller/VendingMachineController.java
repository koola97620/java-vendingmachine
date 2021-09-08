package vendingMachine.controller;

import vendingMachine.domain.Money;
import vendingMachine.domain.Products;
import vendingMachine.view.InputView;

public class VendingMachineController {
    public void operate() {
        InputView inputView = new InputView();

        Money vendingMachineMoney = new Money(inputView.settingVendingMachinePossessedMoney());
        Products products = new Products(inputView.inputProducts());

        Money inputMoney = new Money(inputView.inputMoney());



    }
}
