package vendingMachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductsTest {

    @DisplayName("입력받은 문자열을 상품으로 바꾼다.")
    @Test
    void create_product() {
        String[] productsString = {"[콜라,20,1500]", "[사이다,10,1000]"};
        Products products = new Products(productsString);
        assertThat(products.getProductList())
                .containsExactly(new Product("콜라,20,1500"), new Product("사이다,10,1000"));
    }

}