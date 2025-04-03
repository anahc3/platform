package store.order;

public class OrderItemParser {
    
    public static OrderItem to(OrderItemModel model) {
        return model == null ? null :
            OrderItem.builder()
                .id(model.id())
                .quantity(model.quantity())
                .total(model.total())
                .build();
    }

    public static OrderItemModel to(OrderItem item) {
        return item == null ? null :
            new OrderItemModel(item);
    }
}
