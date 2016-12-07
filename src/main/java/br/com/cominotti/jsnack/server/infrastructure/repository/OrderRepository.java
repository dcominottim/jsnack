package br.com.cominotti.jsnack.server.infrastructure.repository;

import br.com.cominotti.jsnack.server.domain.model.order.Order;

public interface OrderRepository {

    void add(Order order);
}
