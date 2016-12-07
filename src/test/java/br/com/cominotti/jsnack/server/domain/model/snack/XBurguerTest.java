package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.pricing.*;
import org.joda.money.Money;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.assertTrue;

public class XBurguerTest {

    @Test
    public void sellingPrice() throws Exception {
        Money xBurguerSellingPrice = MeatBurguer.getInstance().getPrice().plus(
                Cheese.getInstance().getPrice()
        );

        XBurguer xBurguer = XBurguer.getInstance();

        assertTrue(
                xBurguer.sellingPrice(
                        PricingStrategy.of(
                                new LinkedHashSet<IngredientQuantityPricingRule>() {{
                                    add(MuchCheesePricingRule.getInstance());
                                    add(MuchMeatPricingRule.getInstance());
                                    add(LightPricingRule.getInstance());
                                }}
                        )
                ).equals(xBurguerSellingPrice)
        );
    }
}