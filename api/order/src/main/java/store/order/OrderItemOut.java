package store.order;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true)
public record OrderOut(
    String id, // id do product
    int quantity,
    Double total
) {
}
