package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Bacon;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Egg;
import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.pricing.*;
import org.joda.money.Money;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.assertTrue;

public class XEggBaconTest {

    @Test
    public void sellingPrice() throws Exception {
        Money xEggBaconSellingPrice = MeatBurguer.getInstance().getPrice().plus(
                Cheese.getInstance().getPrice()
        ).plus(
                Egg.getInstance().getPrice()
        ).plus(
                Bacon.getInstance().getPrice()
        );

        XEggBacon xEggBacon = XEggBacon.getInstance();

        assertTrue(
                xEggBacon.sellingPrice(
                        PricingStrategy.of(
                                new LinkedHashSet<IngredientQuantityPricingRule>() {{
                                    add(MuchCheesePricingRule.getInstance());
                                    add(MuchMeatPricingRule.getInstance());
                                    add(LightPricingRule.getInstance());
                                }}
                        )
                ).equals(xEggBaconSellingPrice)
        );
    }
}