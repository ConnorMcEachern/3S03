package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorTest{

    private final PaymentValidator validator = new PaymentValidator();

    @Test
    void shouldReturnFalseWhenPaymentMethodIsNull() {
        assertFalse(validator.isPaymentMethodValid(null));
    }

    @Test
    void shouldAcceptCard() {
        assertTrue(validator.isPaymentMethodValid("card"));
    }

    @Test
    void shouldAcceptPaypal() {
        assertTrue(validator.isPaymentMethodValid("paypal"));
    }

    @Test
    void shouldRejectCrypto() {
        assertFalse(validator.isPaymentMethodValid("crypto"));
    }

    @Test
    void shouldBeCaseInsensitive() {
        assertTrue(validator.isPaymentMethodValid("CARD"));
    }

    @Test
    void shouldThrowForUnknownPaymentMethod() {
        assertThrows(UnsupportedOperationException.class,
                () -> validator.isPaymentMethodValid("banktransfer"));
    }
}