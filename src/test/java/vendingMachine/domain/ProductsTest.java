package vendingMachine.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProductsTest {

    private Products products;

    @BeforeEach
    void setUp() {
        products = new Products(new String[]{"[콜라,20,1500]", "[사이다,10,1000]"});
    }

    @DisplayName("입력받은 문자열을 상품으로 바꾼다.")
    @Test
    void create_product() {
        assertThat(products.getProduct("콜라")).isEqualTo(new Product("콜라,20,1500"));
        assertThat(products.getProduct("사이다")).isEqualTo(new Product("사이다,10,1000"));
    }

    @DisplayName("상품 최소 금액 구하기")
    @Test
    void min_product_price() {
        assertThat(products.minPrice()).isEqualTo(new Money(1000));
    }

}