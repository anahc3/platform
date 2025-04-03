package store.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderResource implements OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<OrderOut> create(
        @RequestBody OrderIn orderIn,
        @RequestHeader(value = "id-account", required = true) String idAccount
    ) {
        Order created = orderService.create(OrderParser.to(orderIn, idAccount));
        return ResponseEntity.status(201).body(OrderParser.to(created));
    }

    @Override
    public ResponseEntity<List<OrderOut>> findAll(
        @RequestHeader(value = "id-account", required = true) String idAccount
    ) {
        return ResponseEntity.ok().body(
            orderService.findAll(idAccount)
                .stream()
                .map(OrderParser::to)
                .toList()
        );
    }

    @Override
    public ResponseEntity<OrderOut> findById(
        @PathVariable String idOrder,
        @RequestHeader(value = "id-account", required = true) String idAccount
    ) {
        Order order = orderService.findById(idOrder, idAccount);
        return ResponseEntity.ok().body(OrderParser.to(order));
    }
}
