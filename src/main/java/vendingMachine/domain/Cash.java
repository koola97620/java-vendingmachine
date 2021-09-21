package vendingMachine.domain;

public enum Cash {
    TEN_THOUSAND(10000, "10000원"),
    FIVE_THOUSAND(5000, "5000원"),
    THOUSAND(1000, "1000원"),
    FIVE_HUNDRED(500, "500원"),
    HUNDRED(100, "100원"),
    FIFTY(50, "50원"),
    TEN(10, "10원");

    private Integer money;
    private String moneyString;

    Cash(Integer money, String moneyString) {
        this.money = money;
        this.moneyString = moneyString;
    }

    public Integer getMoney() {
        return money;
    }

    public String getMoneyString() {
        return moneyString;
    }
}
