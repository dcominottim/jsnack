package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Bacon;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Lettuce;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.Optional;

public class LightPricingRuleTest {

    @Test
    public void applyRule() throws Exception {
        Money basePrice = Money.parse("BRL 10.00");
        Money discountedPrice = basePrice.multipliedBy(0.90, RoundingMode.UNNECESSARY);

        Assert.assertTrue(
                LightPricingRule.getInstance().applyRule(
                        targetIngredient -> {
                            if (Lettuce.class.equals(targetIngredient)) {
                                return Optional.of(
                                        new AbstractMap.SimpleEntry<>(Lettuce.getInstance(), Quantity.of(1))
                                );
                            } else if (Bacon.class.equals(targetIngredient)) {
                                return Optional.of(
                                        new AbstractMap.SimpleEntry<>(Bacon.getInstance(), Quantity.of(1))
                                );
                            } else {
                                return Optional.empty();
                            }
                        },
                        basePrice
                ).equals(basePrice)
        );

        Assert.assertTrue(
                LightPricingRule.getInstance().applyRule(
                        targetIngredient -> {
                            if (Lettuce.class.equals(targetIngredient)) {
                                return Optional.of(
                                        new AbstractMap.SimpleEntry<>(Lettuce.getInstance(), Quantity.of(1))
                                );
                            } else {
                                return Optional.empty();
                            }
                        },
                        basePrice
                ).equals(discountedPrice)
        );
    }
}