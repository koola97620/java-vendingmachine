package vendingMachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("음수가 입력되면 예외가 발생한다")
    @Test
    void test() {
        assertThatThrownBy(() -> new Money(-50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 돈이 0보다 작습니다");
    }

}