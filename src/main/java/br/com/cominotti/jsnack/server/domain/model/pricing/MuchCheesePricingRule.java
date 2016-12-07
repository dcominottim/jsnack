package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import org.joda.money.Money;

public class MuchCheesePricingRule extends DiscountByIngredientQuantityPricingRule {

    private MuchCheesePricingRule() {
        super(Cheese.class, Quantity.of(3));
    }


    public static MuchCheesePricingRule getInstance() {
        return new MuchCheesePricingRule();
    }


    @Override
    public Money applyRule(IngredientQuantityChecker ingredientQuantityChecker, Money basePrice) {
        return super.applyRule(ingredientQuantityChecker, basePrice);
    }
}
