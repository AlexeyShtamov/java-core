package school.sorokin.javacore.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.sorokin.javacore.testing.testing_exam.Order;
import school.sorokin.javacore.testing.testing_exam.OrderRepository;
import school.sorokin.javacore.testing.testing_exam.OrderService;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private Order order;
    private OrderRepository mockOrderRepository;

    @BeforeEach
    void init(){
        order = new Order(1,"RedBull", 3, 100.0);
        mockOrderRepository = mock(OrderRepository.class);
    }

    @Test
    void shouldSuccessfullyProcessOrder(){
        when(mockOrderRepository.saveOrder(order)).thenReturn(1);

        OrderService orderService = new OrderService(mockOrderRepository);

        String result = orderService.processOrder(order);

        assertEquals("Order processed successfully", result);
        verify(mockOrderRepository, times(1)).saveOrder(order);
    }

    @Test
    void shouldUnsuccessfullyProcessOrder(){
        when(mockOrderRepository.saveOrder(order)).thenReturn(0);

        OrderService orderService = new OrderService(mockOrderRepository);

        String result = orderService.processOrder(order);

        assertEquals("Order processing failed", result);
        verify(mockOrderRepository, times(1)).saveOrder(order);
    }

    @Test
    void shouldSuccessfullyCalculateTotal(){
        when(mockOrderRepository.getOrderById(1)).thenReturn(Optional.of(order));

        OrderService orderService = new OrderService(mockOrderRepository);

        double result = orderService.calculateTotal(order.getId());

        assertEquals(300.0, result);
        verify(mockOrderRepository, times(1)).getOrderById(1);
    }

    @Test
    void shouldThrowExceptionWhenOrderIsNull(){
        when(mockOrderRepository.getOrderById(1)).thenReturn(Optional.empty());

        OrderService orderService = new OrderService(mockOrderRepository);

        Exception exception = assertThrows(NullPointerException.class, () -> {
           orderService.calculateTotal(1);
        });

        assertEquals("No order with id 1", exception.getMessage());
        verify(mockOrderRepository, times(1)).getOrderById(1);
    }

    @Test
    void shouldSuccessfullyCalculateZeroWhenPriceIsNull(){

        Order order = new Order(1,"RedBull", 3, 0);

        when(mockOrderRepository.getOrderById(1)).thenReturn(Optional.of(order));

        OrderService orderService = new OrderService(mockOrderRepository);

        double result = orderService.calculateTotal(order.getId());

        assertEquals(0.0, result);
        verify(mockOrderRepository, times(1)).getOrderById(1);
    }

    @Test
    void shouldSuccessfullyCalculateZeroWhenCountIsNull(){

        Order order = new Order(1,"RedBull", 0, 100.0);

        when(mockOrderRepository.getOrderById(1)).thenReturn(Optional.of(order));

        OrderService orderService = new OrderService(mockOrderRepository);

        double result = orderService.calculateTotal(order.getId());

        assertEquals(0.0, result);
        verify(mockOrderRepository, times(1)).getOrderById(1);
    }
}
