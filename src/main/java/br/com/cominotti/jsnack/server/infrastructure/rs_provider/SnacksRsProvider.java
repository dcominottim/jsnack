package br.com.cominotti.jsnack.server.infrastructure.rs_provider;

import br.com.cominotti.jsnack.server.domain.model.pricing.PricingStrategy;
import br.com.cominotti.jsnack.server.resource.SnacksRs;

public interface SnacksRsProvider {

    SnacksRs findAll(PricingStrategy pricingStrategy);
}
