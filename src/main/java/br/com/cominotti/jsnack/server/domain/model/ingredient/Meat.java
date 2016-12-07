package br.com.cominotti.jsnack.server.domain.model.ingredient;

import org.joda.money.Money;

public abstract class Meat extends Ingredient {

    protected Meat(IngredientId id, IngredientName name, Money price) {
        super(id, name, price);
    }
}
