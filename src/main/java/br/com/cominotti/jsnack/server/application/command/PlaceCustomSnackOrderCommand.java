package br.com.cominotti.jsnack.server.application.command;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.ingredient.IngredientId;
import br.com.cominotti.jsnack.server.domain.model.order.Order;
import br.com.cominotti.jsnack.server.domain.model.pricing.DefaultPricingStrategy;
import br.com.cominotti.jsnack.server.domain.model.recipe.Recipe;
import br.com.cominotti.jsnack.server.domain.model.snack.Snack;
import br.com.cominotti.jsnack.server.domain.model.snack.SnackId;
import br.com.cominotti.jsnack.server.domain.model.snack.SnackName;
import br.com.cominotti.jsnack.server.domain.model.unit.Quantity;
import br.com.cominotti.jsnack.server.infrastructure.repository.IngredientRepository;
import br.com.cominotti.jsnack.server.infrastructure.repository.OrderRepository;
import br.com.cominotti.jsnack.server.resource.PlaceCustomSnackOrderRs;
import br.com.cominotti.jsnack.server.validation.Validate;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlaceCustomSnackOrderCommand {

    @Inject
    private IngredientRepository ingredientRepository;

    @Inject
    private OrderRepository orderRepository;


    public void run(PlaceCustomSnackOrderRs input) {
        Validate.notNull(input);

        Map<Ingredient, Quantity> ingredientQuantityMap = new HashMap<>();

        for (Integer ingredientId : input.getIngredientIds()) {
            Ingredient ingredient = ingredientRepository.findById(
                    IngredientId.of(ingredientId)
            ).get();

            Quantity storedIngredientQuantity = ingredientQuantityMap.get(ingredient);

            if (storedIngredientQuantity == null) {
                ingredientQuantityMap.put(ingredient, Quantity.of(1));
            } else {
                ingredientQuantityMap.put(ingredient, storedIngredientQuantity.increaseBy(1));
            }
        }

        orderRepository.add(
                Order.of(
                        UUID.randomUUID(),
                        Arrays.asList(
                                Snack.of(
                                        SnackId.of(1000),
                                        SnackName.of("Custom snack"),
                                        Recipe.of(ingredientQuantityMap)
                                )
                        ),
                        DefaultPricingStrategy.getInstance(),
                        LocalDateTime.now()
                )
        );
    }
}
