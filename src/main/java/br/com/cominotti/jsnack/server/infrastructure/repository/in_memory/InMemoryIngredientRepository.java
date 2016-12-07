package br.com.cominotti.jsnack.server.infrastructure.repository.in_memory;

import br.com.cominotti.jsnack.server.configuration.qualifier.IngredientCache;
import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.ingredient.IngredientId;
import br.com.cominotti.jsnack.server.infrastructure.repository.IngredientRepository;
import org.infinispan.Cache;

import javax.inject.Inject;
import java.util.Optional;

public class InMemoryIngredientRepository implements IngredientRepository {

    @Inject
    @IngredientCache
    private Cache<IngredientId, Ingredient> cache;


    @Override
    public Optional<Ingredient> findById(IngredientId ingredientId) {
        return Optional.ofNullable(cache.get(ingredientId));
    };
}
