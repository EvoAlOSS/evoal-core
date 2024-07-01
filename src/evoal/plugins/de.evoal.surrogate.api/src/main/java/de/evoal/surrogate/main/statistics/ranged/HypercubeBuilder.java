package de.evoal.surrogate.main.statistics.ranged;

import de.evoal.optimisation.api.correlations.Range;

import java.util.LinkedList;
import java.util.List;

public class HypercubeBuilder {
	private final int dimensions;
	private final List<Range> intervals = new LinkedList<>();
	
	public HypercubeBuilder(int dimensions) {
		this.dimensions = dimensions; 
	}
	
	public HypercubeBuilder(final HypercubeBuilder halfbuiltCube) {
		this.dimensions = halfbuiltCube.dimensions;
		this.intervals.addAll(halfbuiltCube.intervals);
	}

	public Hypercube build() {
		if(intervals.size() == dimensions) {
			return new Hypercube(intervals.toArray(new Range [dimensions]), dimensions);
		}

		else throw new IllegalStateException("Intervallist is not yet complete.");
	}

	public void append(final double lower, final double upper) {
		intervals.add(new Range(lower, upper));
	}
}
