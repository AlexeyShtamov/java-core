package school.sorokin.javacore.stream_api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomerFactory {

    public static List<Customer> makeReadyCustomerList(){
        Product product1 = new Product(1L, "Teddy bear", "Toys", BigDecimal.valueOf(500));
        Product product2 = new Product(2L, "Yula", "Toys", BigDecimal.valueOf(700));
        Product product3 = new Product(3L, "Child Milk", "Children's products", BigDecimal.valueOf(80));
        Product product4 = new Product(4L, "1984", "Books", BigDecimal.valueOf(250));
        Product product5 = new Product(5L, "The Great Gatsby", "Books", BigDecimal.valueOf(150));


        Set<Product> list1 = Set.of(product1);
        Set<Product> list2 = Set.of(product2);
        Set<Product> list3 = Set.of(product3);
        Set<Product> list4 = Set.of(product4);
        Set<Product> list5 = Set.of(product5);

        Set<Product> list6 = Set.of(product1, product2);
        Set<Product> list7 = Set.of(product2, product3);
        Set<Product> list8 = Set.of(product3, product4);
        Set<Product> list9 = Set.of(product4, product5);
        Set<Product> list10 = Set.of(product5, product1);

        Set<Product> list11 = Set.of(product1, product2, product3);
        Set<Product> list12 = Set.of(product2, product3, product4);
        Set<Product> list13 = Set.of(product3, product4, product5);
        Set<Product> list14 = Set.of(product4, product5, product1);
        Set<Product> list15 = Set.of(product5, product1, product2);

        Set<Product> list16 = Set.of(product1, product2, product3, product4);
        Set<Product> list17 = Set.of(product2, product3, product4, product5);
        Set<Product> list18 = Set.of(product3, product4, product5, product1);
        Set<Product> list19 = Set.of(product4, product5, product1, product2);
        Set<Product> list20 = Set.of(product5, product1, product2, product3);

        Set<Product> list21 = Set.of(product1, product2, product3, product4, product5);

        Set<Product> list22 = Set.of(product1, product2);
        Set<Product> list23 = Set.of(product1, product3);
        Set<Product> list24 = Set.of(product5, product1);
        Set<Product> list25 = Set.of(product2, product4, product3);


        Customer customer1 = new Customer(1L, "Alexey", 1L);
        customer1.getOrders().add(new Order(1L, LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 12), "DELIVERED", list1));
        customer1.getOrders().add(new Order(2L, LocalDate.of(2025, 2, 15), LocalDate.of(2025, 2, 18), "PROCESSING", list6));
        customer1.getOrders().add(new Order(3L, LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 22), "SHIPPED", list11));
        customer1.getOrders().add(new Order(4L, LocalDate.of(2025, 4, 5), LocalDate.of(2025, 4, 8), "CANCELLED", list16));
        customer1.getOrders().add(new Order(5L, LocalDate.of(2025, 5, 12), LocalDate.of(2025, 5, 15), "PENDING", list21));

        Customer customer2 = new Customer(2L, "Misha", 2L);
        customer2.getOrders().add(new Order(6L, LocalDate.of(2025, 6, 3), LocalDate.of(2025, 6, 6), "RETURNED", list2));
        customer2.getOrders().add(new Order(7L, LocalDate.of(2025, 7, 8), LocalDate.of(2025, 7, 11), "REFUNDED", list7));
        customer2.getOrders().add(new Order(8L, LocalDate.of(2025, 8, 14), LocalDate.of(2025, 8, 17), "COMPLETED", list12));
        customer2.getOrders().add(new Order(9L, LocalDate.of(2025, 9, 19), LocalDate.of(2025, 9, 22), "ON_HOLD", list17));
        customer2.getOrders().add(new Order(10L, LocalDate.of(2025, 10, 24), LocalDate.of(2025, 10, 27), "FAILED", list22));

        Customer customer3 = new Customer(3L, "Dima", 3L);
        customer3.getOrders().add(new Order(11L, LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 4), "AWAITING_PAYMENT", list3));
        customer3.getOrders().add(new Order(12L, LocalDate.of(2025, 12, 5), LocalDate.of(2025, 12, 8), "PARTIALLY_SHIPPED", list8));
        customer3.getOrders().add(new Order(13L, LocalDate.of(2026, 1, 9), LocalDate.of(2026, 1, 12), "IN_TRANSIT", list13));
        customer3.getOrders().add(new Order(14L, LocalDate.of(2026, 2, 13), LocalDate.of(2026, 2, 16), "OUT_FOR_DELIVERY", list18));
        customer3.getOrders().add(new Order(15L, LocalDate.of(2026, 3, 17), LocalDate.of(2026, 3, 20), "DELIVERY_ATTEMPTED", list23));

        Customer customer4 = new Customer(4L, "Masha", 4L);
        customer4.getOrders().add(new Order(16L, LocalDate.of(2026, 4, 21), LocalDate.of(2026, 4, 24), "READY_FOR_PICKUP", list4));
        customer4.getOrders().add(new Order(17L, LocalDate.of(2026, 5, 25), LocalDate.of(2026, 5, 28), "BACKORDERED", list9));
        customer4.getOrders().add(new Order(18L, LocalDate.of(2026, 6, 1), LocalDate.of(2026, 6, 4), "EXCHANGED", list14));
        customer4.getOrders().add(new Order(19L, LocalDate.of(2026, 7, 5), LocalDate.of(2026, 7, 8), "DAMAGED", list19));
        customer4.getOrders().add(new Order(20L, LocalDate.of(2026, 8, 9), LocalDate.of(2026, 8, 12), "LOST", list24));

        Customer customer5 = new Customer(5L, "Dasha", 5L);
        customer5.getOrders().add(new Order(21L, LocalDate.of(2026, 9, 13), LocalDate.of(2026, 9, 16), "ARCHIVED", list5));
        customer5.getOrders().add(new Order(22L, LocalDate.of(2026, 10, 17), LocalDate.of(2026, 10, 20), "REJECTED", list10));
        customer5.getOrders().add(new Order(23L, LocalDate.of(2026, 11, 21), LocalDate.of(2026, 11, 24), "EXPIRED", list15));
        customer5.getOrders().add(new Order(24L, LocalDate.of(2026, 12, 25), LocalDate.of(2026, 12, 28), "QUARANTINED", list20));
        customer5.getOrders().add(new Order(25L, LocalDate.of(2020, 11, 24), LocalDate.of(2021, 10, 21), "QUARANTINED", list25));

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        return customers;
    }
}
