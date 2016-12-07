package br.com.cominotti.jsnack.server.domain.model.pricing;

import java.util.LinkedHashSet;

public final class DefaultPricingStrategy extends PricingStrategy {

    private DefaultPricingStrategy(LinkedHashSet<IngredientQuantityPricingRule> ingredientQuantityPricingRules) {
        super(ingredientQuantityPricingRules);
    }


    public static DefaultPricingStrategy getInstance() {
        LinkedHashSet<IngredientQuantityPricingRule> pricingRules = new LinkedHashSet<>();
        pricingRules.add(MuchCheesePricingRule.getInstance());
        pricingRules.add(MuchMeatPricingRule.getInstance());
        pricingRules.add(LightPricingRule.getInstance());

        return new DefaultPricingStrategy(pricingRules);
    }
}
