package br.com.cominotti.jsnack.server.domain.model.ingredient;

import br.com.cominotti.jsnack.server.validation.Validate;


public class IngredientName {

    private String name;


    private IngredientName(String name) {
        Validate.notNullNorEmpty(name);
        this.name = name;
    }


    public static IngredientName of(String name) {
        return new IngredientName(name);
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientName ingredientName = (IngredientName) o;

        return name.equals(ingredientName.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

