package vendingMachine.domain;

import java.util.Objects;

public class Quantity {

    private final int quantity;

    public Quantity(String quantityString) {
        quantity = Integer.parseInt(quantityString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
