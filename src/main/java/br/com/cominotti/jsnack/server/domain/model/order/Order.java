package br.com.cominotti.jsnack.server.domain.model.order;

import br.com.cominotti.jsnack.server.domain.model.pricing.PricingStrategy;
import br.com.cominotti.jsnack.server.domain.model.snack.Snack;
import br.com.cominotti.jsnack.server.validation.Validate;
import org.joda.money.Money;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;

    private final List<Snack> snacks;

    private final Money totalPrice;

    private final LocalDateTime createdAt;


    protected Order(UUID id, List<Snack> snacks, PricingStrategy pricingStrategy, LocalDateTime createdAt) {
        Validate.notNull(id, pricingStrategy, createdAt);
        Validate.notNullNorEmpty(snacks);
        this.id = id;
        this.snacks = Collections.unmodifiableList(snacks);

        Money totalPrice = Money.parse("BRL 0.00");

        for (Snack snack : this.snacks) {
            totalPrice = totalPrice.plus(
                    snack.sellingPrice(pricingStrategy)
            );
        }

        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }


    public static Order of(UUID id, List<Snack> snacks, PricingStrategy pricingStrategy, LocalDateTime createdAt) {
        return new Order(id, snacks, pricingStrategy, createdAt);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (!snacks.equals(order.snacks)) return false;
        if (!totalPrice.equals(order.totalPrice)) return false;
        return createdAt.equals(order.createdAt);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + snacks.hashCode();
        result = 31 * result + totalPrice.hashCode();
        result = 31 * result + createdAt.hashCode();
        return result;
    }

    public UUID getId() {
        return id;
    }
}
