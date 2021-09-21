package vendingMachine.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CashCounterTest {

    @Test
    void test() {
        CashCounter cashCounter = new CashCounter(new Money(5000));
        assertThat(cashCounter.calculateBalance(new Money(3000))).isEqualTo(
                "미반환금액: 0\n"
                        + "잔돈\n"
                        + "1000원 - 2개"
        );
    }

}