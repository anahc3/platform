package store.order;

import store.product.ProductController;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductController productController;

    public Order create(Order order) {
        if (order.items() == null || order.items().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order must contain items");
        }

        double total = 0.0;
        for (OrderItem item : order.items()) {
            final ProductOut product = productController.findById(item.id()).getBody();
            if (product == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product id: " + item.id());
            }
            item.name(product.name());
            item.unit(product.unit());
            item.price(product.price());
            item.total(product.price() * item.quantity());
            total += item.total();
        }

        order.id(UUID.randomUUID().toString());
        order.date(new Date());
        order.total(total);

        return orderRepository.save(new OrderModel(order)).to();
    }

    public List<Order> findAll(String idAccount) {
        return StreamSupport
            .stream(orderRepository.findByIdAccount(idAccount).spliterator(), false)
            .map(OrderModel::to)
            .toList();
    }

    public Order findById(String idOrder, String idAccount) {
        OrderModel model = orderRepository.findById(idOrder)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        if (!model.idAccount().equals(idAccount)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found for current user");
        }

        return model.to();
    }
}
