package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldAddItemWhenStatusIsCreated() {
        Order order = new Order();
        OrderItem item = new OrderItem("Pen", 1, 2.0);

        order.addItem(item);

        assertEquals(1, order.getItems().size());
    }

    @Test
    void shouldThrowWhenAddingItemAfterProcessed() {
        Order order = new Order();
        order.setStatus(OrderStatus.PAID);

        OrderItem item = new OrderItem("Pen", 1, 2.0);

        assertThrows(IllegalStateException.class,
                () -> order.addItem(item));
    }

    @Test
    void shouldHaveCreatedStatusInitially() {
        Order order = new Order();
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }
}