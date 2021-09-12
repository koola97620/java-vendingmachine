package vendingMachine.controller;

import vendingMachine.domain.*;
import vendingMachine.view.InputView;
import vendingMachine.view.OutputView;

public class VendingMachineController {
    public void operate() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Money vendingMachineMoney = new Money(inputView.settingVendingMachinePossessedMoney());
        Products products = new Products(inputView.inputProducts());
        VendingMachine vendingMachine = new VendingMachine(vendingMachineMoney, products);

        Money inputMoney = new Money(inputView.inputMoney());
        vendingMachine.inputMoney(inputMoney);

        outputView.printRemainMoney(vendingMachine);
        boolean successSellingProduct = vendingMachine.sell(new Name(inputView.inputProductName()));
        if (!successSellingProduct) {
            outputView.printBalance();
        }


    }
}
