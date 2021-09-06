package vendingMachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private final List<Product> productList;

    public Products(String[] productsString) {
        productList = Arrays.stream(productsString)
                .map(product -> new Product(product.substring(1, product.length() - 1)))
                .collect(Collectors.toList());
    }

    public List<Product> getProductList() {
        return productList;
    }
}
