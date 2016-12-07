package br.com.cominotti.jsnack.server.domain.model.recipe;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;

import java.util.Map;
import java.util.Optional;

public interface IngredientQuantityChecker {
    Optional<Map.Entry<Ingredient, Quantity>> ingredientQuantity(Class<? extends Ingredient> targetIngredient);
}
