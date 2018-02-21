package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private ProductService productService;

    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = orders.stream()
                    .mapToLong(o -> o.getOrderId())
                    .max().orElse(0L);
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    public void addItem(long orderId, Long productId, double qty) {
        orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .forEach(o -> o.getItems().add(new Item(productId, qty)));
    }


}
