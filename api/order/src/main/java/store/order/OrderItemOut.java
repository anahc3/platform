package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderItemOut(
    String id,
    Integer quantity,
    Double total
) {
}
