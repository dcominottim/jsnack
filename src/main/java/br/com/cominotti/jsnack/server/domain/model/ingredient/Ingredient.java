package br.com.cominotti.jsnack.server.domain.model.ingredient;

import br.com.cominotti.jsnack.server.resource.IngredientRs;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

public class Ingredient {

    private final IngredientId id;

    private final IngredientName name;

    private final Money price;


    protected Ingredient(IngredientId id, IngredientName name, Money price) {
        Validate.notNull(id, name, price);
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public IngredientId getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (!id.equals(that.id)) return false;
        return price.equals(that.price);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }


    public static class Converter {

        public static Converter getInstance() {
            return new Converter();
        }


        public IngredientRs toIngredientRs(Ingredient ingredient) {
            return new IngredientRs(ingredient.id.getValue(), ingredient.name.getValue(), ingredient.price.getAmount());
        }
    }
}
