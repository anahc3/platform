package store.order;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Setter @Accessors(fluent = true)
@NoArgsConstructor
public class OrderModel {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "dt_order")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "id_account")
    private String accountId;

    @Column(name = "double_total")
    private Double total;

    @ElementCollection
    @CollectionTable(
        name = "order_item",
        joinColumns = @JoinColumn(name = "id_order")
    )
    private List<OrderItemModel> items;

    public OrderModel(Order o) {
        this.id = o.id();
        this.date = o.date();
        this.accountId = o.accountId();
        this.total = o.total();
    }

    public Order to() {
        return Order.builder()
            .id(this.id)
            .date(this.date)
            .accountId(this.accountId)
            .total(this.total)
            .build();
    }
}
