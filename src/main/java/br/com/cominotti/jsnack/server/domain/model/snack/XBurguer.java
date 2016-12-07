package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.recipe.Recipe;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class XBurguer extends Snack {

    private XBurguer(SnackId id, SnackName name, MeatBurguer meatBurguer, Cheese cheese) {
        super(
            id,
            name,
            Recipe.of(
                Collections.unmodifiableMap(
                    Stream.of(
                        new AbstractMap.SimpleEntry<>(meatBurguer, Quantity.of(1)),
                        new AbstractMap.SimpleEntry<>(cheese, Quantity.of(1))
                    ).collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()))
                )
            )
        );
    }


    public static SnackId id() {
        return SnackId.of(2);
    }

    public static SnackName name() {
        return SnackName.of("X-Meat");
    }

    public static XBurguer getInstance() {
        return new XBurguer(id(), name(), MeatBurguer.getInstance(), Cheese.getInstance());
    }
}
