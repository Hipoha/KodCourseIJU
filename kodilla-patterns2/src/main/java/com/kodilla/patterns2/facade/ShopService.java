package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
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

    public boolean removeItem(Long orderId, Long productId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            int orderSize = theOrder.getItems().size();
            for (int n = 0; n < orderSize; n++) {
                if (theOrder.getItems().get(n).getProductId().equals(productId)) {
                    theOrder.getItems().remove(n);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }
}
