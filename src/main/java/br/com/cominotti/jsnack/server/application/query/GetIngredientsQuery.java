package br.com.cominotti.jsnack.server.application.query;

import br.com.cominotti.jsnack.server.infrastructure.rs_provider.IngredientsRsProvider;
import br.com.cominotti.jsnack.server.resource.IngredientsRs;

import javax.inject.Inject;

public class GetIngredientsQuery {

    @Inject
    private IngredientsRsProvider ingredientsRsProvider;


    public IngredientsRs run() {
        return ingredientsRsProvider.findAll();
    }
}
