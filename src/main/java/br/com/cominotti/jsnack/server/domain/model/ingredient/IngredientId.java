package br.com.cominotti.jsnack.server.domain.model.ingredient;

import br.com.cominotti.jsnack.server.validation.Validate;

public class IngredientId {

    private Integer id;


    private IngredientId(Integer id) {
        Validate.positiveNumber(id);
        this.id = id;
    }


    public static IngredientId of(Integer id) {
        return new IngredientId(id);
    }


    public Integer getValue() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientId that = (IngredientId) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
