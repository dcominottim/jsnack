package br.com.cominotti.jsnack.server.infrastructure.repository;

import br.com.cominotti.jsnack.server.domain.model.ingredient.Ingredient;
import br.com.cominotti.jsnack.server.domain.model.ingredient.IngredientId;

import java.util.Optional;

public interface IngredientRepository {

    Optional<Ingredient> findById(IngredientId snackId);
}
