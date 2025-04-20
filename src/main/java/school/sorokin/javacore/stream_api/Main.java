package school.sorokin.javacore.stream_api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Customer> customers = CustomerFactory.makeReadyCustomerList();


        // Задание 1
        List<Product> products1 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getPrice().compareTo(BigDecimal.valueOf(100)) > 0)
                .toList();

        // Задание 2
        List<Order> orders1 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .filter(e -> e.getProducts().stream().anyMatch(p -> p.getCategory().equals("Children's products"))).toList();

        // Задание 3
        double sum = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equals("Toys"))
                .mapToDouble(e -> e.getPrice().doubleValue() * 0.9)
                .sum();

        // Задание 4
        List<Product> products3 = customers.stream()
                .filter(e -> e.getLevel() == 2)
                .flatMap(e -> e.getOrders().stream())
                .filter(e -> e.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) && e.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .flatMap(e -> e.getProducts().stream())
                .toList();

        // Задание 5
        List<Product> products4 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice)).limit(2).toList();

        // Задание 6
        List<Order> orders2 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3).toList();

        // Задание 7
        List<Product> orders3 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .filter(e -> e.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .peek(e -> System.out.println(e.getId()))
                .flatMap(e -> e.getProducts().stream()).toList();

        // Задание 8
        int sum1 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .filter(e -> e.getOrderDate().getMonth().equals(Month.FEBRUARY) && e.getOrderDate().getYear() == 2021)
                .flatMap(e -> e.getProducts().stream())
                .mapToInt(e -> e.getPrice().intValue())
                .sum();

        // Задание 9
        double sum2 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .filter(e -> e.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .flatMap(e -> e.getProducts().stream())
                .mapToDouble(e -> e.getPrice().doubleValue())
                .average().getAsDouble();

        // Задание 10
        double bookSum = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equals("Books"))
                .mapToDouble(e -> e.getPrice().doubleValue())
                .sum();

        double bookAverage = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equals("Toys"))
                .mapToDouble(e -> e.getPrice().doubleValue())
                .average().getAsDouble();

        double bookMin = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equals("Toys"))
                .mapToDouble(e -> e.getPrice().doubleValue())
                .min().getAsDouble();

        double bookMax = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equals("Toys"))
                .mapToDouble(e -> e.getPrice().doubleValue())
                .max().getAsDouble();

        // Задание 11
        Map<Long, Integer> map = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .collect(Collectors.toMap(Order::getId, v->v.getProducts().size()));

        //Задание 12
        Map<Customer, List<Order>> map1 = customers.stream()
                .collect(Collectors.toMap(k -> k, v->v.getOrders().stream().toList()));

        //Задание 13
        Map<Order, Double> map3 = customers.stream()
                .flatMap(e -> e.getOrders().stream())
                .collect(Collectors.toMap(k -> k, v->v.getProducts().stream().mapToDouble(e -> e.getPrice().doubleValue()).sum()));

        //Задание 14
        Map<String, List<String>> map4 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())
                ));

        //Задание 15
        Map<String, Product> map5 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toMap(
                        Product::getCategory,
                        Function.identity(),
                        (p1, p2) -> p1.getPrice().compareTo(p2.getPrice()) > 0 ? p1 : p2
                ));
    }

}
