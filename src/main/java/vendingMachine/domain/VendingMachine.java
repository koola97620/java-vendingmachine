package vendingMachine.domain;

import java.util.Optional;

public class VendingMachine {
    private final CashCounter cashCounter;
    private final Products products;
    private Money inputMoney;

    public VendingMachine(Money vendingMachineMoney, Products products) {
        this.cashCounter = new CashCounter(vendingMachineMoney);
        this.products = products;
    }

    public void inputMoney(Money inputMoney) {
        this.inputMoney = inputMoney;
    }

    public int getRemainMoney() {
        return inputMoney.getMoney();
    }

    public boolean sell(Name productName) {
        Optional<Product> hasProduct = hasProduct(productName);
        if (!hasProduct.isPresent()) {
            return false;
        }

        Product product = hasProduct.get();
        if (notEnoughInputMoney(product.getPrice())) {
            return false;
        }

        inputMoney = new Money(inputMoney.subtract(product.getPrice()));
        return true;
    }

    private boolean notEnoughInputMoney(Money price) {
        return inputMoney.lessThan(price);
    }

    private Optional<Product> hasProduct(Name productName) {
        return products.containProduct(productName);
    }

    public boolean possibleSellingProduct() {
        if (notEnoughInputMoney(products.minPrice())) {
            return false;
        }
        return true;
    }

    public String calculateBalance() {
        return cashCounter.calculateBalance(inputMoney);
    }
}
