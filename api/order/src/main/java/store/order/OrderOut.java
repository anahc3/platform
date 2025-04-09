package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderOut(
    String id, // id da order
    Date date,
    List<OrderItemOut> items,
    Double total
) {
}
