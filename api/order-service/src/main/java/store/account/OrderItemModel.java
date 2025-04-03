package store.order;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Embeddable
@Setter @Accessors(fluent = true)
@NoArgsConstructor
public class OrderItemModel {

    private String id;
    private Integer quantity;
    private Double total;

    public OrderItemModel(OrderItem item) {
        this.id = item.id();
        this.quantity = item.quantity();
        this.total = item.total();
    }

    public OrderItem to() {
        return OrderItem.builder()
            .id(this.id)
            .quantity(this.quantity)
            .total(this.total)
            .build();
    }
}
