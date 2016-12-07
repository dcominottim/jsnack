package br.com.cominotti.jsnack.server.domain.model.ingredient;

import org.joda.money.Money;

public class Bacon extends Ingredient {

    private Bacon(IngredientId id, IngredientName name, Money price) {
        super(id, name, price);
    }


    public static Bacon getInstance() {
        return new Bacon(id(), IngredientName.of("Bacon"), Money.parse("BRL 2.00"));
    }

    public static IngredientId id() {
        return IngredientId.of(2);
    }
}
