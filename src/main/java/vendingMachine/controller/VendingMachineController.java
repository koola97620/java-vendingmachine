package vendingMachine.controller;

import vendingMachine.domain.Money;
import vendingMachine.view.InputView;

public class VendingMachineController {
    public void operate() {
        InputView inputView = new InputView();

        Money vendingMachineMoney = inputView.inputVendingMachineMoney();



    }
}
