package vendingMachine.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Products {

    private Map<Name, Product> map;

    public Products(String[] productsString) {
        map = Arrays.stream(productsString)
                .map(product -> new Product(product.substring(1, product.length() - 1)))
                .collect(Collectors.toMap(product -> product.getName(), product -> product));
    }

    public Products(List<Product> productList) {
        map = productList.stream()
                .collect(Collectors.toMap(product -> product.getName(), product -> product));
    }

    public Product getProduct(String name) {
        return map.get(new Name(name));
    }

    public Optional<Product> containProduct(Name productName) {
        return map.entrySet().stream()
                .filter(entry -> entry.getKey().equals(productName))
                .findAny()
                .map(entry -> entry.getValue());
    }

    public Money minPrice() {
        return map.values().stream()
                .map(Product::getPrice)
                .min(Comparator.comparingInt(Money::getMoney)).get();
    }

    public void sellProduct(Product product) {

    }
}
