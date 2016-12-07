package br.com.cominotti.jsnack.server.domain.model.recipe;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Recipe implements IngredientQuantityChecker {

    private final Map<Ingredient, Quantity> ingredients;


    private Recipe(Map<Ingredient, Quantity> ingredients) {
        Validate.notNullNorEmpty(ingredients);
        Validate.nonNullKeysAndValues(ingredients);
        this.ingredients = Collections.unmodifiableMap(new HashMap<>(ingredients));
    }


    public static Recipe of(Map<Ingredient, Quantity> ingredients) {
        return new Recipe(ingredients);
    }


    @Override
    public Optional<Map.Entry<Ingredient, Quantity>> ingredientQuantity(Class<? extends Ingredient> targetIngredient) {
        for (Map.Entry<Ingredient, Quantity> ingredient : ingredients.entrySet()) {
            if (targetIngredient.isInstance(ingredient.getKey())) {
                return Optional.of(ingredient);
            }
        }

        return Optional.empty();
    }

    public Money totalPrice() {
        Money totalPrice = Money.of(ingredients.keySet().iterator().next().getPrice().getCurrencyUnit(), 0);

        for (Map.Entry<Ingredient, Quantity> ingredient : ingredients.entrySet()) {
            totalPrice = totalPrice.plus(
                    ingredient.getKey().getPrice().multipliedBy(
                            ingredient.getValue().getValue()
                    )
            );
        }

        return totalPrice;
    }
}
