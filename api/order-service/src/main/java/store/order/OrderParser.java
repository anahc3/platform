package store.order;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderParser {

    public static Order to(OrderIn in, String idAccount) {
        if (in == null) return null;

        List<OrderItem> items = in.items().stream()
            .map(i -> OrderItem.builder()
                .id(i.id())
                .quantity(i.quantity())
                .build())
            .collect(Collectors.toList());

        return Order.builder()
            .id(UUID.randomUUID().toString())
            .accountId(idAccount)
            .items(items)
            .build();
    }

    public static OrderOut to(Order o) {
        if (o == null) return null;

        List<OrderItemOut> items = o.items().stream()
            .map(i -> OrderItemOut.builder()
                .id(i.id())
                .quantity(i.quantity())
                .total(i.total())
                .build())
            .collect(Collectors.toList());

        return OrderOut.builder()
            .id(o.id())
            .date(o.date())
            .total(o.total())
            .items(items)
            .build();
    }

    public static Order to(OrderModel model) {
    if (model == null) return null;

    List<OrderItem> items = model.items().stream()
        .map(OrderItemModel::to) 
        .toList();

    return Order.builder()
        .id(model.id())
        .accountId(model.accountId())
        .date(model.date())
        .total(model.total())
        .items(items)
        .build();
    }

}


