package br.com.cominotti.jsnack.server.domain.model.ingredient;

import org.joda.money.Money;

public class MeatBurguer extends Meat {

    private MeatBurguer(IngredientId id, IngredientName name, Money price) {
        super(id, name, price);
    }


    public static MeatBurguer getInstance() {
        return new MeatBurguer(id(), IngredientName.of("Hamburguer"), Money.parse("BRL 3.00"));
    }

    public static IngredientId id() {
        return IngredientId.of(3);
    }
}
