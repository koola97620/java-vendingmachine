package vendingMachine.domain;

public class Money {
    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("입력한 돈이 0보다 작습니다");
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
