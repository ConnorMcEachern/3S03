package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    void shouldReturnSubtotalWhenCodeIsNull() {
        assertEquals(100.0, discountService.applyDiscount(100.0, null));
    }

    @Test
    void shouldReturnSubtotalWhenCodeIsBlank() {
        assertEquals(100.0, discountService.applyDiscount(100.0, "   "));
    }

    @Test
    void shouldApplyStudentDiscount() {
        assertEquals(90.0, discountService.applyDiscount(100.0, "STUDENT10"));
    }

    @Test
    void shouldApplyStudentDiscountCaseInsensitive() {
        assertEquals(90.0, discountService.applyDiscount(100.0, "student10"));
    }

    @Test
    void shouldApplyBlackFridayDiscount() {
        assertEquals(70.0, discountService.applyDiscount(100.0, "BLACKFRIDAY"));
    }

    @Test
    void shouldThrowExceptionForInvalidCode() {
        assertThrows(IllegalArgumentException.class,
                () -> discountService.applyDiscount(100.0, "INVALID"));
    }

    @Test
    void shouldReturnSubtotalForUnknownCode() {
        assertEquals(100.0, discountService.applyDiscount(100.0, "SOMETHINGELSE"));
    }
}
