package vendingMachine.domain;

import vendingMachine.domain.Money;
import vendingMachine.domain.Products;

public class VendingMachine {
    private final Money vendingMachineMoney;
    private final Products products;
    private Money inputMoney;

    public VendingMachine(Money vendingMachineMoney, Products products) {
        this.vendingMachineMoney = vendingMachineMoney;
        this.products = products;
    }

    public void inputMoney(Money inputMoney) {
        this.inputMoney = inputMoney;
    }

    public int getRemainMoney() {
        return inputMoney.getMoney();
    }
}
