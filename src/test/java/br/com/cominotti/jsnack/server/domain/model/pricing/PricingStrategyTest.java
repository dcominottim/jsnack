package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Bacon;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.snack.XBacon;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import org.joda.money.Money;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class PricingStrategyTest {

    @Test
    public void calculateSellingPrice() throws Exception {
        Money snackBasePrice = Bacon.getInstance().getPrice().plus(
                MeatBurguer.getInstance().getPrice()
        ).plus(
                Cheese.getInstance().getPrice()
        );

        XBacon xBacon = XBacon.getInstance();

        assertTrue(
                xBacon.sellingPrice(
                        PricingStrategy.of(
                                new LinkedHashSet<>()
                        )
                ).equals(snackBasePrice)
        );

        Money customSnackBasePrice = MeatBurguer.getInstance().getPrice().multipliedBy(6).plus(
                Cheese.getInstance().getPrice().multipliedBy(6)
        );

        Money customSnackDiscountedPrice = MeatBurguer.getInstance().getPrice().multipliedBy(4).plus(
                Cheese.getInstance().getPrice().multipliedBy(4)
        );

        assertTrue(
                PricingStrategy.of(
                        new LinkedHashSet<IngredientQuantityPricingRule>() {{
                            add(MuchCheesePricingRule.getInstance());
                            add(MuchMeatPricingRule.getInstance());
                            add(LightPricingRule.getInstance());
                        }}
                ).calculateSellingPrice(
                        targetIngredient -> {
                            if (targetIngredient.equals(MeatBurguer.class)) {
                                return Optional.of(
                                        new AbstractMap.SimpleEntry<>(MeatBurguer.getInstance(), Quantity.of(6))
                                );
                            } else if (targetIngredient.equals(Cheese.class)) {
                                return Optional.of(
                                        new AbstractMap.SimpleEntry<>(Cheese.getInstance(), Quantity.of(6))
                                );
                            } else {
                                return Optional.empty();
                            }
                        },
                        customSnackBasePrice
                ).equals(customSnackDiscountedPrice)
        );
    }
}