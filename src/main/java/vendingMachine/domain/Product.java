package vendingMachine.domain;

import java.util.Objects;

public class Product {
    private Name name;
    private Quantity quantity;
    private Price price;

    public Product(String productString) {
        String[] splittedProductString = productString.split(",");
        name = new Name(splittedProductString[0]);
        quantity = new Quantity(splittedProductString[1]);
        price = new Price(splittedProductString[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, price);
    }

    public Name getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }
}
