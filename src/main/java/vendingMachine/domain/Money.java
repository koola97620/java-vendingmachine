package vendingMachine.domain;

import java.util.Objects;

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

    public boolean lessThan(Money price) {
        return money < price.money;
    }

    public int subtract(Money price) {
        return money - price.money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
