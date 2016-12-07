package br.com.cominotti.jsnack.server.infrastructure.repository.in_memory;

import br.com.cominotti.jsnack.server.configuration.qualifier.SnackCache;
import br.com.cominotti.jsnack.server.domain.model.snack.Snack;
import br.com.cominotti.jsnack.server.domain.model.snack.SnackId;
import br.com.cominotti.jsnack.server.infrastructure.repository.SnackRepository;
import org.infinispan.Cache;

import javax.inject.Inject;
import java.util.Optional;

public class InMemorySnackRepository implements SnackRepository {

    @Inject
    @SnackCache
    private Cache<SnackId, Snack> cache;


    @Override
    public Optional<Snack> findById(SnackId snackId) {
        return Optional.ofNullable(cache.get(snackId));
    }
}
