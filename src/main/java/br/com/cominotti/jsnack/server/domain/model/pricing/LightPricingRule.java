package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Bacon;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Lettuce;
import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

import java.math.RoundingMode;

public class LightPricingRule extends IngredientQuantityPricingRule {

    private LightPricingRule() {
    }


    public static LightPricingRule getInstance() {
        return new LightPricingRule();
    }


    @Override
    public Money applyRule(IngredientQuantityChecker ingredientQuantityChecker, Money basePrice) {
        Validate.notNull(ingredientQuantityChecker, basePrice);

        return ingredientQuantityChecker.ingredientQuantity(Lettuce.class).isPresent() &&
                !ingredientQuantityChecker.ingredientQuantity(Bacon.class).isPresent() ?
                basePrice.multipliedBy(0.90, RoundingMode.UNNECESSARY) :
                basePrice;
    }
}
