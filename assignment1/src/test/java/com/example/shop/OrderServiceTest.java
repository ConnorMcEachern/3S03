package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    void shouldCancelOrderIfPaymentInvalid() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        double result = orderService.processOrder(order, null, "crypto");

        assertEquals(0.0, result);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void shouldProcessOrderSuccessfullyWithoutDiscount() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        double result = orderService.processOrder(order, null, "card");

        // 100 + 20% tax = 120
        assertEquals(120.0, result);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void shouldProcessOrderWithDiscount() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        double result = orderService.processOrder(order, "STUDENT10", "card");

        // 100 -> 90 -> + 18 tax = 108
        assertEquals(108.0, result);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void shouldThrowIfPaymentMethodUnsupported() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        assertThrows(UnsupportedOperationException.class,
                () -> orderService.processOrder(order, null, "banktransfer"));
    }
}