package vendingMachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CashExchangerTest {

    @DisplayName("잔돈 450원")
    @Test
    void hundred_fifty() {
        assertThat(CashExchanger.exchange(450))
                .isEqualTo(
                        "잔돈\n"
                        + "100원 - 4개\n"
                        + "50원 - 1개"
                );
    }

    @DisplayName("잔돈 1500원")
    @Test
    void thousand_hundred() {
        assertThat(CashExchanger.exchange(1500))
                .isEqualTo(
                        "잔돈\n"
                                + "1000원 - 1개\n"
                                + "500원 - 1개"
                );
    }

    @DisplayName("잔돈 3770원")
    @Test
    void thousand_hundred_fifty_ten() {
        assertThat(CashExchanger.exchange(3770))
                .isEqualTo(
                        "잔돈\n"
                                + "1000원 - 3개\n"
                                + "500원 - 1개\n"
                                + "100원 - 2개\n"
                                + "50원 - 1개\n"
                                + "10원 - 2개"
                );
    }

}