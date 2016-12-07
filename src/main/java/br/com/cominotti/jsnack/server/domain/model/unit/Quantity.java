package br.com.cominotti.jsnack.server.domain.model.unit;

import br.com.cominotti.jsnack.server.validation.Validate;

public class Quantity {

    private final Integer quantity;


    private Quantity(Integer quantity) {
        Validate.positiveNumber(quantity);
        this.quantity = quantity;
    }


    public static Quantity of(Integer quantity) {
        return new Quantity(quantity);
    }


    public Quantity increaseBy(Integer quantity) {
        Validate.positiveNumber(quantity);
        Integer newQuantity = this.quantity + quantity;
        Validate.positiveNumber(newQuantity);
        return Quantity.of(newQuantity);
    }

    public Quantity decreaseBy(Integer quantity) {
        Validate.positiveNumber(quantity);
        Integer newQuantity = this.quantity - quantity;
        Validate.positiveNumber(newQuantity);
        return Quantity.of(newQuantity);
    }

    public Integer getValue() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quantity)) return false;

        Quantity that = (Quantity) o;

        return quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return quantity.hashCode();
    }

    @Override
    public String toString() {
        return quantity.toString();
    }
}
