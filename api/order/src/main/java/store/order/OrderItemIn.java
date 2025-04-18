package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderItemIn(
    String id, // id do product
    int quantity
) {
}