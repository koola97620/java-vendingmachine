package vendingMachine.domain;

public class CashCounter {
    private Money vendingMachineMoney;

    public CashCounter(Money vendingMachineMoney) {
        this.vendingMachineMoney = vendingMachineMoney;
    }

    public String calculateBalance(Money inputMoney) {
        StringBuilder builder = new StringBuilder();
        if (vendingMachineMoney.lessThan(inputMoney)) {
            builder
                    .append("미반환금액: ")
                    .append(getNotReturnMoney(inputMoney)).append("\n")
                    .append(CashExchanger.exchange(vendingMachineMoney.getMoney()));
            return builder.toString();
        }
        builder
                .append("미반환금액: ")
                .append(getNotReturnMoney(inputMoney)).append("\n")
                .append(CashExchanger.exchange(vendingMachineMoney.subtract(inputMoney)));
        return builder.toString();
    }

    private Integer getNotReturnMoney(Money inputMoney) {
        int remainBalance = inputMoney.subtract(vendingMachineMoney);
        if (remainBalance <= 0) {
            return 0;
        }
        return remainBalance;
    }
}
