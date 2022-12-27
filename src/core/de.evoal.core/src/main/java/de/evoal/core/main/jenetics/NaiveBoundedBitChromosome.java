package de.evoal.core.main.jenetics;

import io.jenetics.util.RandomRegistry;


public class NaiveBoundedBitChromosome extends BoundedBitChromosome<NaiveBoundedBitChromosome> {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private NaiveBoundedBitChromosome(byte[] bits, final double min, final double max, final int scale) {
		super(bits, min, max, scale);
	}

	public static NaiveBoundedBitChromosome of(final double min, final double max, final int scale) {
		double value = RandomRegistry.random().nextDouble(min, max);

		return NaiveBoundedBitChromosome.of(value, min, max, scale);
	}
	
	public static NaiveBoundedBitChromosome of(final double value, final double min, final double max, final int scale) {
		final double boundedValue = BoundedOperations.boundValue(value, min, max);
		final byte [] bits = BitHelper.fromDouble(boundedValue, scale);

		return new NaiveBoundedBitChromosome(bits, min, max, scale);
	}

	public static NaiveBoundedBitChromosome of(final byte [] bits, final double min, final double max, final int scale) {
		final double value = BitHelper.toDouble(bits, scale);

		return NaiveBoundedBitChromosome.of(value, min, max, scale);
	}

	@Override
	public NaiveBoundedBitChromosome newInstance() {
		return NaiveBoundedBitChromosome.of(min, max, scale);
	}

	@Override
	protected NaiveBoundedBitChromosome newInstance(byte[] bits, double min, double max, int scale) {
		return NaiveBoundedBitChromosome.of(bits, min, max, scale);
	}
}
