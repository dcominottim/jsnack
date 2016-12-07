package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.Optional;

public class MuchCheesePricingRuleTest {

    @Test
    public void applyRule() throws Exception {
        Cheese cheese = Cheese.getInstance();

        Money portionWithoutCheeseBasePrice = Money.parse("BRL 10.00");

        Assert.assertTrue(
                MuchCheesePricingRule.getInstance().applyRule(
                        targetIngredient -> Optional.empty(),
                        portionWithoutCheeseBasePrice
                ).equals(portionWithoutCheeseBasePrice)
        );

        Money portionsOf2BasePrice = cheese.getPrice().multipliedBy(2, RoundingMode.UNNECESSARY);

        Assert.assertTrue(
                MuchCheesePricingRule.getInstance().applyRule(
                        targetIngredient -> Optional.of(
                                new AbstractMap.SimpleEntry<>(cheese, Quantity.of(2))
                        ),
                        portionsOf2BasePrice
                ).equals(portionsOf2BasePrice)
        );

        Money portionsOf6BasePrice = cheese.getPrice().multipliedBy(6, RoundingMode.UNNECESSARY);
        Money portionsOf6DiscountedPrice = cheese.getPrice().multipliedBy(4, RoundingMode.UNNECESSARY);

        Assert.assertTrue(
                MuchCheesePricingRule.getInstance().applyRule(
                        targetIngredient -> Optional.of(
                                new AbstractMap.SimpleEntry<>(cheese, Quantity.of(6))
                        ),
                        portionsOf6BasePrice
                ).equals(portionsOf6DiscountedPrice)
        );
    }
}