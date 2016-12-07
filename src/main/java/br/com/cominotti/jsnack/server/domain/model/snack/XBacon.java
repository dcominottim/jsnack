package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Bacon;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.recipe.Recipe;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class XBacon extends Snack {

    private XBacon(SnackId id, SnackName name, Bacon bacon, MeatBurguer meatBurguer, Cheese cheese) {
        super(
            id,
            name,
            Recipe.of(
                Collections.unmodifiableMap(
                    Stream.of(
                        new AbstractMap.SimpleEntry<>(bacon, Quantity.of(1)),
                        new AbstractMap.SimpleEntry<>(meatBurguer, Quantity.of(1)),
                        new AbstractMap.SimpleEntry<>(cheese, Quantity.of(1))
                    ).collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()))
                )
            )
        );
    }


    public static SnackId id() {
        return SnackId.of(1);
    }

    public static SnackName name() {
        return SnackName.of("X-Bacon");
    }

    public static XBacon getInstance() {
        return new XBacon(id(), name(), Bacon.getInstance(), MeatBurguer.getInstance(), Cheese.getInstance());
    }
}
