package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Cheese;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Egg;
import br.com.cominotti.jsnack.server.domain.model.ingredient.MeatBurguer;
import br.com.cominotti.jsnack.server.domain.model.recipe.Recipe;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class XEgg extends Snack {

    private XEgg(SnackId id, SnackName name, Egg egg, MeatBurguer meatBurguer, Cheese cheese) {
        super(
            id,
            name,
            Recipe.of(
                Collections.unmodifiableMap(
                    Stream.of(
                        new AbstractMap.SimpleEntry<>(egg, Quantity.of(1)),
                        new AbstractMap.SimpleEntry<>(meatBurguer, Quantity.of(1)),
                        new AbstractMap.SimpleEntry<>(cheese, Quantity.of(1))
                    ).collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()))
                )
            )
        );
    }


    public static SnackId id() {
        return SnackId.of(3);
    }

    public static SnackName name() {
        return SnackName.of("X-Egg");
    }

    public static XEgg getInstance() {
        return new XEgg(id(), name(), Egg.getInstance(), MeatBurguer.getInstance(), Cheese.getInstance());
    }
}
