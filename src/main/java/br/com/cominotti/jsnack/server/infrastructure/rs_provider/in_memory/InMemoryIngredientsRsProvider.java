package br.com.cominotti.jsnack.server.infrastructure.rs_provider.in_memory;

import br.com.cominotti.jsnack.server.configuration.qualifier.IngredientCache;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.ingredient.IngredientId;
import br.com.cominotti.jsnack.server.infrastructure.rs_provider.IngredientsRsProvider;
import br.com.cominotti.jsnack.server.resource.IngredientsRs;
import org.infinispan.Cache;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class InMemoryIngredientsRsProvider implements IngredientsRsProvider {

    @Inject
    @IngredientCache
    private Cache<IngredientId, Ingredient> cache;


    @Override
    public IngredientsRs findAll() {
        Ingredient.Converter converter = Ingredient.Converter.getInstance();

        return new IngredientsRs(
                cache.values().stream().map(
                        converter::toIngredientRs
                ).collect(Collectors.toList())
        );
    }
}
