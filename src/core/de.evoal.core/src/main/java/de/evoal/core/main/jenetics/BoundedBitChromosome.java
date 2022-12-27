package de.evoal.core.main.jenetics;

import io.jenetics.BitGene;
import io.jenetics.util.ISeq;

/**
 * A bit chromosome that represents a buonded fixed-point double value.
 */
public abstract class BoundedBitChromosome<T extends BoundedBitChromosome<T>> extends BitChromosome {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Minimal valid value
	 */
	protected final double min;

	/**
	 * Maximal valid value
	 */
	protected final double max;

	/**
	 * Scale of the decimal.
	 */
	protected final int scale;

	protected BoundedBitChromosome(byte[] bits, final double min, final double max, final int scale) {
			super(bits);
		
		this.min = min;
		this.max = max;
		this.scale = scale;
	}

	protected abstract T newInstance(final byte [] bits, final double min, final double max, final int scale);

	@Override
	public T newInstance(final ISeq<BitGene> genes) {
		final BitChromosome result = super.newInstance(genes);
		
		return newInstance(result.toByteArray(), min, max, scale);
	}

	@Override
	public BitChromosome invert() {
		final BitChromosome result = super.invert();
		
		return newInstance(result.toByteArray(), min, max, scale);
	}

}
