package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void shouldCalculateTotalPriceCorrectly() {
        OrderItem item = new OrderItem("Book", 2, 10.0);
        assertEquals(20.0, item.getTotalPrice());
    }

    @Test
    void myTestForQuantity() {
        OrderItem item = new OrderItem("Book", 3, 10.0);
        assertEquals(3, item.getQuantity());
    }

    @Test
    void shouldThrowExceptionIfQuantityIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Book", 0, 10.0));
    }

    @Test
    void shouldThrowExceptionIfQuantityIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Book", -1, 10.0));
    }

    @Test
    void shouldThrowExceptionIfUnitPriceIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Book", 1, -5.0));
    }
}