package school.sorokin.javacore.stream_api;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private final Long id;
    private final String name;
    private final Long level;
    private final Set<Order> orders;

    public Customer(Long id, String name, Long level) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.orders = new HashSet<>();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getLevel() {
        return level;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
