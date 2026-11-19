package de.evoal.optimisation.ea.main.jenetics;

import org.decimal4j.api.ImmutableDecimal;
import org.decimal4j.factory.Factories;

public final class BitHelper {
    private BitHelper() {
    }

    public static byte [] fromDouble(final double value, final int scale) {
        final ImmutableDecimal<?> decimal = DecimalFactory.create(scale, value);
        final long unscaled = decimal.unscaledValue();
        final byte [] result = new byte[8];

        for(int by = 0; by < 8; ++ by) {
            for(int bi = 0; bi < 8; ++bi) {
                byte mask = (byte)((unscaled >>> (by * 8 + bi)  & 1) << bi);
                result[by] |= mask;
            }
        }

        return result;
    }

    private static void printBits(long value) {
        System.err.print("      unscaled ");

        for(int i = 0; i < 64; ++i) {
            System.err.print(((value >>> i) & 1) == 1 ? "1" : "0");
        }
        System.err.println();
    }

    public static double toDouble(final byte[] value, final int scale) {
        long unscaled = 0;

        for(int by = 0; by < 8; ++ by) {
            for(int bi = 0; bi < 8; ++bi) {
                long mask = (((long)(value[by] >>> bi))  & 1) << (by * 8 + bi);
                unscaled |= mask;
            }
        }

        return Factories.getDecimalFactory(scale).valueOfUnscaled(unscaled).doubleValue();
    }
}
