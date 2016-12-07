package br.com.cominotti.jsnack.server.configuration;

import br.com.cominotti.jsnack.server.configuration.qualifier.IngredientCache;
import br.com.cominotti.jsnack.server.configuration.qualifier.OrderCache;
import br.com.cominotti.jsnack.server.configuration.qualifier.SnackCache;
import br.com.cominotti.jsnack.server.domain.model.ingredient.*;
import br.com.cominotti.jsnack.server.domain.model.order.Order;
import br.com.cominotti.jsnack.server.domain.model.snack.*;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.EmbeddedCacheManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class CacheProducer {

    @Inject
    private EmbeddedCacheManager cacheManager;


    @Produces
    @ApplicationScoped
    @IngredientCache
    public Cache<IngredientId, Ingredient> ingredientCache () {
        Configuration configuration = new ConfigurationBuilder().build();
        cacheManager.defineConfiguration("ingredientCache", configuration);
        Cache<IngredientId, Ingredient> cache = cacheManager.getCache("ingredientCache");

        Lettuce lettuce = Lettuce.getInstance();
        cache.put(lettuce.getId(), lettuce);

        Bacon bacon = Bacon.getInstance();
        cache.put(bacon.getId(), bacon);

        MeatBurguer meatBurguer = MeatBurguer.getInstance();
        cache.put(meatBurguer.getId(), meatBurguer);

        Egg egg = Egg.getInstance();
        cache.put(egg.getId(), egg);

        Cheese cheese = Cheese.getInstance();
        cache.put(cheese.getId(), cheese);

        return cache;
    }

    @Produces
    @ApplicationScoped
    @SnackCache
    public Cache<SnackId, Snack> snackCache () {
        Configuration configuration = new ConfigurationBuilder().build();
        cacheManager.defineConfiguration("snackCache", configuration);
        Cache<SnackId, Snack> cache = cacheManager.getCache("snackCache");

        XBacon xBacon = XBacon.getInstance();
        cache.put(xBacon.getId(), xBacon);

        XBurguer xBurguer = XBurguer.getInstance();
        cache.put(xBurguer.getId(), xBurguer);

        XEgg xEgg = XEgg.getInstance();
        cache.put(xEgg.getId(), xEgg);

        XEggBacon xEggBacon = XEggBacon.getInstance();
        cache.put(xBacon.getId(), xEggBacon);

        return cache;
    }

    @Produces
    @ApplicationScoped
    @OrderCache
    public Cache<UUID, Order> orderCache () {
        Configuration configuration = new ConfigurationBuilder().build();
        cacheManager.defineConfiguration("orderCache", configuration);
        return cacheManager.getCache("orderCache");
    }
}