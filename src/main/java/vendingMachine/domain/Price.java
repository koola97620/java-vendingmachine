package vendingMachine.domain;

import java.util.Objects;

public class Price {

    private final int price;

    public Price(String priceString) {
        price = Integer.parseInt(priceString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
