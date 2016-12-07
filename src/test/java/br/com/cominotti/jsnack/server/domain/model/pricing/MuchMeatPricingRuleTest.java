package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.Optional;

public class MuchMeatPricingRuleTest {

    @Test
    public void applyRule() throws Exception {
        MeatBurguer meatBurguer = MeatBurguer.getInstance();

        Money portionWithoutCheeseBasePrice = Money.parse("BRL 10.00");

        Assert.assertTrue(
                MuchMeatPricingRule.getInstance().applyRule(
                        targetIngredient -> Optional.empty(),
                        portionWithoutCheeseBasePrice
                ).equals(portionWithoutCheeseBasePrice)
        );

        Money portionsOf2BasePrice = meatBurguer.getPrice().multipliedBy(2, RoundingMode.UNNECESSARY);

        Assert.assertTrue(
                MuchMeatPricingRule.getInstance().applyRule(
                        targetIngredient -> Optional.of(
                                new AbstractMap.SimpleEntry<>(meatBurguer, Quantity.of(2))
                        ),
                        portionsOf2BasePrice
                ).equals(portionsOf2BasePrice)
        );

        Money portionsOf6BasePrice = meatBurguer.getPrice().multipliedBy(6, RoundingMode.UNNECESSARY);
        Money portionsOf6DiscountedPrice = meatBurguer.getPrice().multipliedBy(4, RoundingMode.UNNECESSARY);

        Assert.assertTrue(
                MuchMeatPricingRule.getInstance().applyRule(
                        targetIngredient -> Optional.of(
                                new AbstractMap.SimpleEntry<>(meatBurguer, Quantity.of(6))
                        ),
                        portionsOf6BasePrice
                ).equals(portionsOf6DiscountedPrice)
        );
    }
}