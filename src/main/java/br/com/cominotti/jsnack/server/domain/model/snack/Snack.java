package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.pricing.PricingStrategy;
import br.com.cominotti.jsnack.server.domain.model.recipe.IngredientQuantityChecker;
import br.com.cominotti.jsnack.server.domain.model.recipe.Recipe;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import br.com.cominotti.jsnack.server.resource.SnackRs;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

import java.util.Map;
import java.util.Optional;

public class Snack implements IngredientQuantityChecker {

    private final SnackId id;

    private final SnackName snackName;

    private final Recipe recipe;


    protected Snack(SnackId id, SnackName snackName, Recipe recipe) {
        Validate.notNull(id, snackName, recipe);
        this.id = id;
        this.snackName = snackName;
        this.recipe = recipe;
    }


    public static Snack of(SnackId id, SnackName snackName, Recipe recipe) {
        return new Snack(id, snackName, recipe);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snack snack = (Snack) o;

        return id.equals(snack.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public SnackId getId() {
        return id;
    }

    @Override
    public Optional<Map.Entry<Ingredient, Quantity>> ingredientQuantity(Class<? extends Ingredient> targetIngredient) {
        return recipe.ingredientQuantity(targetIngredient);
    }

    public Money sellingPrice(PricingStrategy pricingStrategy) {
        return pricingStrategy.calculateSellingPrice(
                this, recipe.totalPrice()
        );
    }


    public static class Converter {

        public static Converter getInstance() {
            return new Converter();
        }


        public SnackRs toSnackRs(Snack snack, PricingStrategy pricingStrategy) {
            return new SnackRs(
                    snack.id.getValue(), snack.snackName.getValue(), snack.sellingPrice(pricingStrategy).getAmount()
            );
        }
    }
}
