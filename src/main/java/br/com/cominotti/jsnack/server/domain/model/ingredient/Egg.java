package br.com.cominotti.jsnack.server.domain.model.ingredient;

import org.joda.money.Money;

public class Egg extends Ingredient {

    private Egg(IngredientId id, IngredientName name, Money price) {
        super(id, name, price);
    }


    public static Egg getInstance() {
        return new Egg(id(), IngredientName.of("Ovo"), Money.parse("BRL 0.80"));
    }

    public static IngredientId id() {
        return IngredientId.of(4);
    }
}
