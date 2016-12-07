package br.com.cominotti.jsnack.server.infrastructure.repository;

import br.com.cominotti.jsnack.server.domain.model.snack.Snack;
import br.com.cominotti.jsnack.server.domain.model.snack.SnackId;

import java.util.Optional;

public interface SnackRepository {

    Optional<Snack> findById(SnackId snackId);
}
