package de.evoal.surrogate.main.statistics.ranged;


import de.evoal.core.ea.api.correlations.Range;

public class PropertyRange {
	private final int indexOfChromosome;

	private final Range range;

	public PropertyRange(final int indexOfChromosome, final Range range) {
		this.indexOfChromosome = indexOfChromosome;
		this.range = range;
	}

	public int getIndexOfChromosome() {
		return indexOfChromosome;
	}

	public double getLower() {
		return range.getLower();
	}

	public double getUpper() {
		return range.getUpper();
	}
}

