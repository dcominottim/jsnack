package br.com.cominotti.jsnack.server.application.command;

import br.com.cominotti.jsnack.server.domain.model.order.Order;
import br.com.cominotti.jsnack.server.domain.model.pricing.DefaultPricingStrategy;
import br.com.cominotti.jsnack.server.domain.model.snack.Snack;
import br.com.cominotti.jsnack.server.domain.model.snack.SnackId;
import br.com.cominotti.jsnack.server.infrastructure.repository.OrderRepository;
import br.com.cominotti.jsnack.server.infrastructure.repository.SnackRepository;
import br.com.cominotti.jsnack.server.resource.PlaceSnackOrderRs;
import br.com.cominotti.jsnack.server.validation.Validate;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class PlaceSnackOrderCommand {

    @Inject
    private SnackRepository snackRepository;

    @Inject
    private OrderRepository orderRepository;


    public void run(PlaceSnackOrderRs input) {
        Validate.notNull(input);

        Snack orderedSnack = snackRepository.findById(
                SnackId.of(input.getSnackId())
        ).get();

        orderRepository.add(
                Order.of(
                        UUID.randomUUID(),
                        Arrays.asList(orderedSnack),
                        DefaultPricingStrategy.getInstance(),
                        LocalDateTime.now()
                )
        );
    }
}
