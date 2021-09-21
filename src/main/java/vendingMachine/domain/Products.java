package vendingMachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Products {

    private List<Product> productList;

    public Products(String[] productsString) {
        productList = Arrays.stream(productsString)
                .map(product -> new Product(product.substring(1, product.length() - 1)))
                .collect(Collectors.toList());
    }

    public Products(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Optional<Product> containProduct(Name productName) {
        return productList.stream()
                .filter(product -> productName.equals(product.getName()))
                .findAny();
    }

    public Money minPrice() {
        return productList.stream()
                .map(Product::getPrice)
                .min(Comparator.comparingInt(Money::getMoney)).get();
    }
}
