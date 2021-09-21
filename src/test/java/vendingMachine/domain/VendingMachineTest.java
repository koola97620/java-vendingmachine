package vendingMachine.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine =
                new VendingMachine(
                        new Money(450),
                        new Products(Arrays.asList(new Product("콜라,20,1500"), new Product("사이다,10,1000"))
                        ));
    }

    @DisplayName("상품이 없으면 false 를 리턴한다.")
    @Test
    void no_product() {
        Name productName = new Name("환타");
        assertThat(vendingMachine.sell(productName)).isFalse();
    }

    @DisplayName("상품이 있지만 남은금액이 상품 금액보다 작으면 false 를 리턴한다.")
    @Test
    void not_enough_money() {
        vendingMachine.inputMoney(new Money(900));
        Name productName = new Name("사이다");
        assertThat(vendingMachine.sell(productName)).isFalse();
    }

    @DisplayName("상품 판매를 하면 금액 차감 후 true 리턴한다.")
    @Test
    void success() {
        vendingMachine.inputMoney(new Money(2500));
        Name productName = new Name("콜라");
        vendingMachine.sell(productName);
        assertThat(vendingMachine.getRemainMoney()).isEqualTo(1000);
    }

    @DisplayName("자판기 보유금이 남은 금액보다 작으면 투입음액을 반환한다.")
    @Test
    void test() {
        vendingMachine.inputMoney(new Money(500));
        String returnChange = vendingMachine.calculateBalance();
        assertThat(returnChange).isEqualTo(
                "미반환금액: 50\n"
                        + "잔돈\n"
                        +"100원 - 4개\n50원 - 1개"
        );
    }

    @DisplayName("자판기 보유금이 남은 금액보다 크면 남은 금액을 반환한다.")
    @Test
    void test2() {
        vendingMachine.inputMoney(new Money(300));
        String returnChange = vendingMachine.calculateBalance();
        assertThat(returnChange).isEqualTo(
                "미반환금액: 0\n"
                        + "잔돈\n"
                        + "100원 - 3개"
        );
    }

}