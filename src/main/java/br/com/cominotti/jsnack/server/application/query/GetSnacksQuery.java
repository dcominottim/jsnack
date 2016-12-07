package br.com.cominotti.jsnack.server.application.query;

import br.com.cominotti.jsnack.server.domain.model.pricing.DefaultPricingStrategy;
import br.com.cominotti.jsnack.server.infrastructure.rs_provider.SnacksRsProvider;
import br.com.cominotti.jsnack.server.resource.SnacksRs;

import javax.inject.Inject;

public class GetSnacksQuery {

    @Inject
    private SnacksRsProvider snacksRsProvider;


    public SnacksRs run() {
        return snacksRsProvider.findAll(DefaultPricingStrategy.getInstance());
    }
}
