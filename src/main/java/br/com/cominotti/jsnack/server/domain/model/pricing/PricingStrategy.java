package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

import java.util.LinkedHashSet;

public class PricingStrategy {

    private final LinkedHashSet<IngredientQuantityPricingRule> ingredientQuantityPricingRules;


    protected PricingStrategy(LinkedHashSet<IngredientQuantityPricingRule> ingredientQuantityPricingRules) {
        Validate.notNull(ingredientQuantityPricingRules);
        this.ingredientQuantityPricingRules = new LinkedHashSet<>(ingredientQuantityPricingRules);
    }


    public static PricingStrategy of(LinkedHashSet<IngredientQuantityPricingRule> ingredientQuantityPricingRules) {
        return new PricingStrategy(ingredientQuantityPricingRules);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricingStrategy that = (PricingStrategy) o;

        return ingredientQuantityPricingRules.equals(that.ingredientQuantityPricingRules);
    }

    @Override
    public int hashCode() {
        return ingredientQuantityPricingRules.hashCode();
    }

    public Money calculateSellingPrice(IngredientQuantityChecker ingredientQuantityChecker, Money basePrice) {
        Validate.notNull(ingredientQuantityChecker, basePrice);

        Money adjustedPrice = basePrice;

        for (IngredientQuantityPricingRule ingredientQuantityPricingRule : ingredientQuantityPricingRules) {
            adjustedPrice = ingredientQuantityPricingRule.applyRule(ingredientQuantityChecker, adjustedPrice);
        }

        return adjustedPrice;
    }
}
