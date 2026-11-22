package de.evoal.core.api.utils;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticNumberOperationsTest {

    @Test
    void testAddWithIntegers() {
        assertEquals(5, ArithmeticNumberOperations.add(2, 3));
    }

    @Test
    void testAddWithLongs() {
        assertEquals(10L, ArithmeticNumberOperations.add(7L, 3L));
    }

    @Test
    void testAddWithDoubles() {
        assertEquals(5.5, ArithmeticNumberOperations.add(2.2, 3.3));
    }

    @Test
    void testDivideWithIntegers() {
        assertEquals(2.0, ArithmeticNumberOperations.divide(6, 3));
    }

    @Test
    void testDivideWithIntegersIsARealDivision() {
        assertEquals(0.2, ArithmeticNumberOperations.divide(1, 5));
    }

    @Test
    void testDivideWithLongs() {
        assertEquals(2.0, ArithmeticNumberOperations.divide(8L, 4L));
        assertEquals(2.5, ArithmeticNumberOperations.divide(5L, 2L));
    }

    @Test
    void testDivideWithMixedOperands() {
        assertEquals(2.5, ArithmeticNumberOperations.divide(5, 2L));
        assertEquals(0.25, ArithmeticNumberOperations.divide(1, 4.0));
    }

    @Test
    void testDivideTwoIntegersByZeroIsInfinite() {
        assertEquals(Double.POSITIVE_INFINITY, ArithmeticNumberOperations.divide(1, 0));
    }

    @Test
    void testDivideWithDoubles() {
        assertEquals(2.5, ArithmeticNumberOperations.divide(5.0, 2.0));
    }

    @Test
    void testMinusWithIntegers() {
        assertEquals(1, ArithmeticNumberOperations.minus(4, 3));
    }

    @Test
    void testMinusWithLongs() {
        assertEquals(5L, ArithmeticNumberOperations.minus(10L, 5L));
    }

    @Test
    void testMinusWithDoubles() {
        double actual = ((Number)ArithmeticNumberOperations.minus(4.4, 3.3)).doubleValue();
        double delta = 0.000000000000001;
        assertTrue(actual -  delta < 1.1 && 1.1 < actual + delta);
    }

    @Test
    void testModuloWithIntegers() {
        assertEquals(1, ArithmeticNumberOperations.modulo(10, 3));
    }

    @Test
    void testModuloWithLongs() {
        assertEquals(2L, ArithmeticNumberOperations.modulo(14L, 3L));
    }

    @Test
    void testMultiplyWithIntegers() {
        assertEquals(12, ArithmeticNumberOperations.multiply(3, 4));
    }

    @Test
    void testMultiplyWithLongs() {
        assertEquals(20L, ArithmeticNumberOperations.multiply(4L, 5L));
    }

    @Test
    void testMultiplyWithDoubles() {
        assertEquals(9.0, ArithmeticNumberOperations.multiply(3.0, 3.0));
    }

    @Test
    void testPowWithIntegers() {
        assertEquals(8, ArithmeticNumberOperations.pow(2, 3));
    }

    @Test
    void testPowWithLongs() {
        assertEquals(27L, ArithmeticNumberOperations.pow(3L, 3L));
    }

    @Test
    void testPowWithExponentOne() {
        assertEquals(2, ArithmeticNumberOperations.pow(2, 1));
        assertEquals(2L, ArithmeticNumberOperations.pow(2L, 1L));
    }

    @Test
    void testPowWithExponentZero() {
        assertEquals(1, ArithmeticNumberOperations.pow(2, 0));
        assertEquals(1L, ArithmeticNumberOperations.pow(2L, 0L));
        assertEquals(1, ArithmeticNumberOperations.pow(0, 0));
    }

    @Test
    void testPowWithNegativeExponent() {
        assertEquals(0.5, ArithmeticNumberOperations.pow(2, -1));
        assertEquals(0.25, ArithmeticNumberOperations.pow(2L, -2L));
    }

    @Test
    void testPowWithDoubles() {
        assertEquals(16.0, ArithmeticNumberOperations.pow(4.0, 2.0));
    }

    @Test
    void testInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticNumberOperations.add(new AtomicInteger(1), new AtomicInteger(1));
        });
        assertTrue(exception.getMessage().contains("Parameters of types"));
    }
}