package br.com.cominotti.jsnack.server.domain.model.ingredient;

import org.joda.money.Money;

public class Cheese extends Ingredient {

    private Cheese(IngredientId id, IngredientName name, Money price) {
        super(id, name, price);
    }


    public static Cheese getInstance() {
        return new Cheese(id(), IngredientName.of("Queijo"), Money.parse("BRL 1.50"));
    }

    public static IngredientId id() {
        return IngredientId.of(5);
    }
}
