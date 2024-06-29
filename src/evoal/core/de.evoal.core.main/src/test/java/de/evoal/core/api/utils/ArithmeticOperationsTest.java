package de.evoal.core.api.utils;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    void testAddWithIntegers() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    void testAddWithLongs() {
        assertEquals(10L, ArithmeticOperations.add(7L, 3L));
    }

    @Test
    void testAddWithDoubles() {
        assertEquals(5.5, ArithmeticOperations.add(2.2, 3.3));
    }

    @Test
    void testDivideWithIntegers() {
        assertEquals(2, ArithmeticOperations.divide(6, 3));
    }

    @Test
    void testDivideWithLongs() {
        assertEquals(2L, ArithmeticOperations.divide(8L, 4L));
    }

    @Test
    void testDivideWithDoubles() {
        assertEquals(2.5, ArithmeticOperations.divide(5.0, 2.0));
    }

    @Test
    void testMinusWithIntegers() {
        assertEquals(1, ArithmeticOperations.minus(4, 3));
    }

    @Test
    void testMinusWithLongs() {
        assertEquals(5L, ArithmeticOperations.minus(10L, 5L));
    }

    @Test
    void testMinusWithDoubles() {
        double actual = ((Number)ArithmeticOperations.minus(4.4, 3.3)).doubleValue();
        double delta = 0.000000000000001;
        assertTrue(actual -  delta < 1.1 && 1.1 < actual + delta);
    }

    @Test
    void testModuloWithIntegers() {
        assertEquals(1, ArithmeticOperations.modulo(10, 3));
    }

    @Test
    void testModuloWithLongs() {
        assertEquals(2L, ArithmeticOperations.modulo(14L, 3L));
    }

    @Test
    void testMultiplyWithIntegers() {
        assertEquals(12, ArithmeticOperations.multiply(3, 4));
    }

    @Test
    void testMultiplyWithLongs() {
        assertEquals(20L, ArithmeticOperations.multiply(4L, 5L));
    }

    @Test
    void testMultiplyWithDoubles() {
        assertEquals(9.0, ArithmeticOperations.multiply(3.0, 3.0));
    }

    @Test
    void testPowWithIntegers() {
        assertEquals(8, ArithmeticOperations.pow(2, 3));
    }

    @Test
    void testPowWithLongs() {
        assertEquals(27L, ArithmeticOperations.pow(3L, 3L));
    }

    @Test
    void testPowWithDoubles() {
        assertEquals(16.0, ArithmeticOperations.pow(4.0, 2.0));
    }

    @Test
    void testInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticOperations.add(new AtomicInteger(1), new AtomicInteger(1));
        });
        assertTrue(exception.getMessage().contains("Parameters of types"));
    }
}