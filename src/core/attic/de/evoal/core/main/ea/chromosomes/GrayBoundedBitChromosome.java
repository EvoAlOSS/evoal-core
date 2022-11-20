package de.evoal.core.main.ea.chromosomes;

import static io.jenetics.internal.math.Randoms.nextDouble;

import java.util.Random;

public class GrayBoundedBitChromosome extends BoundedBitChromosome<GrayBoundedBitChromosome> { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GrayBoundedBitChromosome(byte[] bits, final double min, final double max, final int scale) {
		super(bits, min, max, scale);
	}

	@Override
	public GrayBoundedBitChromosome newInstance() {
		return GrayBoundedBitChromosome.of(min, max, scale);
	}

	/**
	 * Returns a random gray-encoded chromosome within the specified range.
	 */
	public static GrayBoundedBitChromosome of(final double min, final double max, final int scale) {
		final double value = nextDouble(min, max, new Random());

		return GrayBoundedBitChromosome.of(value, min, max, scale);
	}

	/**
	 * Returns a gray-encoded chromsome using the specified value. The value is cropped if
	 *   it is not in the specified range.
	 */
	public static GrayBoundedBitChromosome of(final double value, final double min, final double max, final int scale) {
		final double boundedValue = BoundedOperations.boundValue(value, min, max);

		final byte[] naiveBit = BitHelper.fromDouble(value, scale);
		final byte[] grayBit = GrayHelper.toGray(naiveBit);

		return new GrayBoundedBitChromosome(grayBit, min, max, scale);
	}

	/**
	 * Creates a GrayBoundedBitChromosome with the given (already gray encoded bits). The value
	 *   is cropped if ot os not in the specified range.
	 */
	public static GrayBoundedBitChromosome of(final byte [] grayBits, final double min, final double max, final int scale) {
		final double value = GrayHelper.fromGray(grayBits, scale);

		return GrayBoundedBitChromosome.of(value, min, max, scale);
	}

	@Override
	protected GrayBoundedBitChromosome newInstance(byte[] bits, double min, double max, int scale) {
		return GrayBoundedBitChromosome.of(bits, min, max, scale);
	}
}
