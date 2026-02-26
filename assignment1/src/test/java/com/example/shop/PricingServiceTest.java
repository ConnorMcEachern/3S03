package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PricingServiceTest {

    private final PricingService pricingService = new PricingService();

    @Test
    void shouldCalculateSubtotalCorrectly() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 2, 10.0));
        order.addItem(new OrderItem("Pen", 1, 5.0));

        assertEquals(25.0, pricingService.calculateSubtotal(order));
    }

    @Test
    void shouldReturnZeroSubtotalForEmptyOrder() {
        Order order = new Order();
        assertEquals(0.0, pricingService.calculateSubtotal(order));
    }

    @Test
    void shouldCalculateTaxCorrectly() {
        assertEquals(20.0, pricingService.calculateTax(100.0));
    }

    @Test
    void shouldReturnZeroTaxForZeroSubtotal() {
        assertEquals(0.0, pricingService.calculateTax(0.0));
    }

    @Test
    void shouldThrowExceptionForNegativeSubtotal() {
        assertThrows(IllegalArgumentException.class,
                () -> pricingService.calculateTax(-10.0));
    }
}