package de.evoal.optimisation.ea.main.jenetics;

/**
 * Helper class for the gray encoding
 */
public final class GrayHelper {
    private GrayHelper() {
    }

    public static byte[] toGray(byte[] naiveBit) {
        byte[] gray = new byte[naiveBit.length];

        boolean last = false;
        for(int i = 0; i < naiveBit.length; ++i) {
            for(int j = 0; j < 8; ++j) {
                boolean current = (((naiveBit[i] >>> j) & 1) == 1);
                boolean value = current ^ last;
                last = current;

                if(value) {
                    gray[i] |= (1 << j);
                }
            }
        }

        return gray;
    }

    public static double fromGray(final byte[] origin, final int scale) {
        final byte [] converted = new byte [origin.length];

        boolean last = false;
        for(int i = 0; i < origin.length; ++i) {
            for(int j = 0; j < 8; ++j) {
                boolean current = (((origin[i] >>> j) & 1) == 1);
                boolean value = current ^ last;
                last = value;

                if(value) {
                    converted[i] |= (1 << j);
                }

            }
        }

        return BitHelper.toDouble(converted, scale);
    }
}
