package vendingMachine.domain;

public class CashExchanger {
    private static final String BALANCE = "잔돈";
    private static final String EMPTY = "";
    private static final String HYPHNE = " - ";
    private static final String CASH_UNIT = "개";

    public static String exchange(int money) {
        StringBuilder builder = new StringBuilder();
        builder.append(BALANCE).append("\n");

        for (Cash cash : Cash.values()) {
            CashCount cashCount = calculateCashCount(cash, money);
            builder.append(cashCount.cashCount);
            money = cashCount.money;
        }

        String balanceResult = builder.toString();
        return balanceResult.substring(0, balanceResult.length() - 1);
    }

    private static CashCount calculateCashCount(Cash cash, int money) {
        StringBuilder builder = new StringBuilder();
        if (money >= cash.getMoney()) {
            return new CashCount(
                    builder.append(cash.getMoneyString()).append(HYPHNE).append(money / cash.getMoney()).append(CASH_UNIT).append("\n").toString(),
                    money % cash.getMoney()
            );
        }
        return new CashCount(EMPTY,money);
    }

    private static class CashCount {
        private String cashCount;
        private int money;

        public CashCount(String cashCount, int money) {
            this.cashCount = cashCount;
            this.money = money;
        }

    }
}
