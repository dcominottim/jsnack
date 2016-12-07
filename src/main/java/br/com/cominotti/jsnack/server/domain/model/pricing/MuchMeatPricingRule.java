package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import org.joda.money.Money;

public class MuchMeatPricingRule extends DiscountByIngredientQuantityPricingRule {

    private MuchMeatPricingRule() {
        super(MeatBurguer.class, Quantity.of(3));
    }


    public static MuchMeatPricingRule getInstance() {
        return new MuchMeatPricingRule();
    }


    @Override
    public Money applyRule(IngredientQuantityChecker ingredientQuantityChecker, Money basePrice) {
        return super.applyRule(ingredientQuantityChecker, basePrice);
    }
}
