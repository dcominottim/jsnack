package br.com.cominotti.jsnack.server.resource;

import br.com.cominotti.jsnack.server.validation.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IngredientsRs {

    private final List<IngredientRs> ingredients;


    public IngredientsRs(List<IngredientRs> ingredients) {
        Validate.notNull(ingredients);
        this.ingredients = Collections.unmodifiableList(ingredients);
    }


    public List<IngredientRs> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}
