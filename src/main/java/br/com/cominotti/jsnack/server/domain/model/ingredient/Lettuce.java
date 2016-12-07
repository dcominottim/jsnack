package br.com.cominotti.jsnack.server.domain.model.ingredient;

import org.joda.money.Money;

public class Lettuce extends Ingredient {

    private Lettuce(IngredientId id, IngredientName name, Money price) {
        super(id, name, price);
    }


    public static Lettuce getInstance() {
        return new Lettuce(id(), IngredientName.of("Alface"), Money.parse("BRL 0.40"));
    }

    public static IngredientId id() {
        return IngredientId.of(1);
    }
}
