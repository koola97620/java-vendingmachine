package vendingMachine.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    @Test
    void test() {
        String productString = "콜라,20,1500";
        Product product = new Product(productString);
        assertThat(product.getName()).isEqualTo(new Name("콜라"));
        assertThat(product.getQuantity()).isEqualTo(new Quantity("20"));
        assertThat(product.getPrice()).isEqualTo(new Money(1500));
    }
}
