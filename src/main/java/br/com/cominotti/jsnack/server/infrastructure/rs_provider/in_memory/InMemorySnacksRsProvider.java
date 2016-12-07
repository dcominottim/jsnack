package br.com.cominotti.jsnack.server.infrastructure.rs_provider.in_memory;

import br.com.cominotti.jsnack.server.configuration.qualifier.SnackCache;
import br.com.cominotti.jsnack.server.domain.model.pricing.PricingStrategy;
import br.com.cominotti.jsnack.server.domain.model.snack.Snack;
import br.com.cominotti.jsnack.server.domain.model.snack.SnackId;
import br.com.cominotti.jsnack.server.infrastructure.rs_provider.SnacksRsProvider;
import br.com.cominotti.jsnack.server.resource.SnacksRs;
import org.infinispan.Cache;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class InMemorySnacksRsProvider implements SnacksRsProvider {

    @Inject
    @SnackCache
    private Cache<SnackId, Snack> cache;


    @Override
    public SnacksRs findAll(PricingStrategy pricingStrategy) {
        Snack.Converter converter = Snack.Converter.getInstance();

        return new SnacksRs(
                cache.values().stream().map(
                        snack -> converter.toSnackRs(snack, pricingStrategy)
                ).collect(Collectors.toList())
        );
    }
}
