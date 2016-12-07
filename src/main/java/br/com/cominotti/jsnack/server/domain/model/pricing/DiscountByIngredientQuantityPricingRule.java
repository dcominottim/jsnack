package br.com.cominotti.jsnack.server.domain.model.pricing;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

import java.util.Map;
import java.util.Optional;

public class DiscountByIngredientQuantityPricingRule extends IngredientQuantityPricingRule {

    private final Class<? extends Ingredient> targetIngredient;

    private final Quantity ingredientQuantityForPortion;


    protected DiscountByIngredientQuantityPricingRule(Class<? extends Ingredient> targetIngredient,
                                                      Quantity ingredientQuantityForPortion) {
        Validate.notNull(targetIngredient, ingredientQuantityForPortion);
        this.targetIngredient = targetIngredient;
        this.ingredientQuantityForPortion = ingredientQuantityForPortion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountByIngredientQuantityPricingRule that = (DiscountByIngredientQuantityPricingRule) o;

        if (!targetIngredient.equals(that.targetIngredient)) return false;
        return ingredientQuantityForPortion.equals(that.ingredientQuantityForPortion);

    }

    @Override
    public int hashCode() {
        int result = targetIngredient.hashCode();
        result = 31 * result + ingredientQuantityForPortion.hashCode();
        return result;
    }

    @Override
    public Money applyRule(IngredientQuantityChecker ingredientQuantityChecker, Money basePrice) {
        Validate.notNull(ingredientQuantityChecker, basePrice);

        Optional<Map.Entry<Ingredient, Quantity>> ingredientQuantity =
                ingredientQuantityChecker.ingredientQuantity(targetIngredient);

        if (!ingredientQuantity.isPresent()) {
            return basePrice;
        }

        int portions = Integer.divideUnsigned(
                ingredientQuantity.get().getValue().getValue(), ingredientQuantityForPortion.getValue()
        );

        if (portions < 1) {
            return basePrice;
        }

        return basePrice.minus(
                ingredientQuantity.get().getKey().getPrice().multipliedBy(portions)
        );
    }
}
