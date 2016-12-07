package br.com.cominotti.jsnack.server.resource;

import br.com.cominotti.jsnack.server.validation.Validate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaceCustomSnackOrderRs {

    private List<Integer> ingredientIds;


    @JsonCreator
    public PlaceCustomSnackOrderRs(@JsonProperty("ingredientIds") List<Integer> ingredientIds) {
        Validate.notNull(ingredientIds);
        this.ingredientIds = Collections.unmodifiableList(ingredientIds);
    }


    public List<Integer> getIngredientIds() {
        return new ArrayList<>(ingredientIds);
    }
}
