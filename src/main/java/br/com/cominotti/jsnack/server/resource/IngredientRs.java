package br.com.cominotti.jsnack.server.resource;

import br.com.cominotti.jsnack.server.validation.Validate;

import java.math.BigDecimal;

public class IngredientRs {

    private final Integer id;

    private final String name;

    private final BigDecimal price;


    public IngredientRs(Integer id, String name, BigDecimal price) {
        Validate.positiveNumber(id, price);
        Validate.notNullNorEmpty(name);
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
