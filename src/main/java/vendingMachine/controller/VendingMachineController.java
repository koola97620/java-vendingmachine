package vendingMachine.controller;

import vendingMachine.domain.Money;
import vendingMachine.domain.Name;
import vendingMachine.domain.Products;
import vendingMachine.domain.VendingMachine;
import vendingMachine.view.InputView;
import vendingMachine.view.OutputView;

public class VendingMachineController {
    public void operate() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Money vendingMachineMoney = new Money(inputView.settingVendingMachinePossessedMoney());
        Products products = new Products(inputView.inputProducts());
        VendingMachine vendingMachine = new VendingMachine(vendingMachineMoney, products);
        vendingMachine.inputMoney(new Money(inputView.inputMoney()));

        while (vendingMachine.possibleSellingProduct()) {
            outputView.printRemainMoney(vendingMachine.getRemainMoney());
            vendingMachine.sell(new Name(inputView.inputProductName()));
        }
        outputView.printBalance(vendingMachine.calculateBalance());
    }
}
