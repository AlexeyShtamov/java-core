package school.sorokin.javacore.testing.testing_exam;

import java.util.Optional;

public interface OrderRepository {

    int saveOrder(Order order);

    Optional<Order> getOrderById(int id);
}
