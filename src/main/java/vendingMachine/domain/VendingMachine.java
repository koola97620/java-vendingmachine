package vendingMachine.domain;

import java.util.Optional;

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

    public String calculateBalance() {
        StringBuilder builder = new StringBuilder();
        if (vendingMachineMoney.lessThan(inputMoney)) {
            // 투입금액만큼 잔돈 반환 vendingMachineMoney
            builder
                    .append("미반환금액: ")
                    .append(getNotReturnMoney()).append("\n")
                    .append(exchange(vendingMachineMoney.getMoney()));
            return builder.toString();
        }
        builder
                .append("미반환금액: ")
                .append(getNotReturnMoney()).append("\n")
                .append(exchange(inputMoney.getMoney()));
        return builder.toString();
    }

    private Integer getNotReturnMoney() {
        int remainBalance = inputMoney.subtract(vendingMachineMoney);
        if (remainBalance <= 0) {
            return 0;
        }
        return remainBalance;
    }

    private String exchange(int money) {
        StringBuilder builder = new StringBuilder();
        builder.append("잔돈").append("\n");
        if (money >= 10000) {
            builder.append("10000원 - ").append(money / 10000).append("개").append("\n");
            money = money % 10000;
        }

        if (money >= 5000) {
            builder.append("5000원 - ").append(money / 5000).append("개").append("\n");
            money = money % 5000;
        }

        if (money >= 1000) {
            builder.append("1000원 - ").append(money / 1000).append("개").append("\n");
            money = money % 1000;
        }

        if (money >= 500) {
            builder.append("500원 - ").append(money / 500).append("개").append("\n");
            money = money % 500;
        }

        if (money >= 100) {
            builder.append("100원 - ").append(money / 100).append("개").append("\n");
            money = money % 100;
        }

        if (money >= 50) {
            builder.append("50원 - ").append(money / 50).append("개").append("\n");
            money = money % 50;
        }

        if (money >= 10) {
            builder.append("10원 - ").append(money / 10).append("개").append("\n");
            money = money % 10;
        }

        String balanceResult = builder.toString();
        return balanceResult.substring(0, balanceResult.length() - 1);
    }

    public boolean possibleSellingProduct() {
        if (notEnoughInputMoney(products.minPrice())) {
            return false;
        }
        return true;
    }
}
