package de.evoal.core.main.statistics.rangeCorrelated;

import de.evoal.core.main.ea.functions.correlation.model.Range;

public class PropertyRange {
	// TODO FIXME AND SO ON


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

