package school.sorokin.javacore.testing.testing_exam;

import java.util.Optional;

public class OrderService {

    private final  OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processOrder(Order order){
        return orderRepository.saveOrder(order)
                != 0 ? "Order processed successfully" : "Order processing failed";
    }

    public double calculateTotal(int id){
        Optional<Order> optionalOrder = orderRepository.getOrderById(id);

        return optionalOrder.map(Order::getTotalPrice)
                .orElseThrow(() -> new NullPointerException("No order with id " + id));
    }

}
