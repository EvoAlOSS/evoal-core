package de.evoal.surrogate.main.internal;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.expressions.Factor;

/**
 * The printer writes number literals with their metric prefix, e.g. {@code 100µ} (#372).
 */
public class UseCasePrinterTest {
    @Test
    public void aLiteralWithoutPrefixHasNoSymbol() {
        Assertions.assertEquals("", UseCasePrinter.symbol(Factor.NONE));
    }

    @Test
    public void thePrefixesHaveTheSymbolsOfTheLanguages() {
        Assertions.assertEquals("µ", UseCasePrinter.symbol(Factor.MICRO));
        Assertions.assertEquals("m", UseCasePrinter.symbol(Factor.MILLI));
        Assertions.assertEquals("k", UseCasePrinter.symbol(Factor.KILO));
        Assertions.assertEquals("M", UseCasePrinter.symbol(Factor.MEGA));
        Assertions.assertEquals("da", UseCasePrinter.symbol(Factor.DEKA));
    }

    @Test
    public void everyPrefixHasItsOwnSymbol() {
        final Set<String> symbols = Arrays.stream(Factor.values())
                                          .filter(factor -> factor != Factor.NONE)
                                          .map(UseCasePrinter::symbol)
                                          .collect(Collectors.toSet());

        Assertions.assertEquals(Factor.values().length - 1, symbols.size());
        Assertions.assertFalse(symbols.contains(""));
    }
}
