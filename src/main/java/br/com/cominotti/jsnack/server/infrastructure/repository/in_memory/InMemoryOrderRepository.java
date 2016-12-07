package br.com.cominotti.jsnack.server.infrastructure.repository.in_memory;

import br.com.cominotti.jsnack.server.configuration.qualifier.OrderCache;
import br.com.cominotti.jsnack.server.domain.model.order.Order;
import br.com.cominotti.jsnack.server.infrastructure.repository.OrderRepository;
import org.infinispan.Cache;

import javax.inject.Inject;
import java.util.UUID;

public class InMemoryOrderRepository implements OrderRepository {

    @Inject
    @OrderCache
    private Cache<UUID, Order> cache;


    @Override
    public void add(Order order) {
        cache.put(order.getId(), order);
    }
}
