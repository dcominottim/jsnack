package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import org.joda.money.Money;

public abstract class IngredientQuantityPricingRule {

    public abstract Money applyRule(IngredientQuantityChecker ingredientQuantityChecker, Money basePrice);
}
