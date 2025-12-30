package de.evoal.surrogate.main.statistics.ranged;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import smile.tensor.DenseMatrix;
import smile.tensor.Matrix;

import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.correlations.Range;
import smile.tensor.ScalarType;

public class Hypercube {
	private final int dimensions;
	private final Range[] definition;
	private final List<Properties> data = new ArrayList<>();

	public Hypercube(final Hypercube other) {
		this.dimensions = other.dimensions;
		this.definition = other.definition;
	}
	
	public Hypercube(final Range[] definition, int dimensions) {
		if(definition.length != dimensions) {
			throw new IllegalStateException("Hypercubedefinition does not match number of dimensions.");
		}
		
		else {
			this.definition = definition;
			this.dimensions = dimensions;
		}
	}
	
	public boolean check(Properties dataPoint) {
		if(dataPoint.size()!= dimensions) {
			throw new IllegalStateException("Given dataPoint does not have the same number of dimensions as the hypercube");
		}
		
		else {
			for(int i=0; i< dataPoint.size(); i++) {
				if(!definition[i].includes(dataPoint.getAsDouble(i))){
					return false;
				}
			}
			return true;
		}
	}
	
	public void addDataPoint(final Properties dataPoint) {
		if(check(dataPoint)) {
			data.add(dataPoint);			
		}
	}
	
	public DenseMatrix computeCovarianceMatrix(){
		final int dimensions = this.dimensions;
        final int dataSize = data.size();

        if(dataSize == 0) {
			return DenseMatrix.zeros(ScalarType.Float64, dimensions, dimensions);
		}

        final double [] means = new double[dimensions];
        for(int i=0; i< dataSize; i++) {
        	for(int j=0; j< dimensions; j++) {
        		means[j] = means[j] + data.get(i).getAsDouble(j)/(double)data.size();
        	}
        }


        final DenseMatrix covarianceMatrix = DenseMatrix.zeros(ScalarType.Float64, dimensions, dimensions);
        for(int x = 0; x < dimensions; ++x) {
            for(int y = 0; y < dimensions; ++y) {
                double value = 0.0;
                for(int t = 0; t < dataSize; ++t) {
                    value += ((data.get(t).getAsDouble(x) - means[x])*(data.get(t).getAsDouble(y) - means[y]));
                }
                value = value / dataSize;
                covarianceMatrix.set(x, y, value);
            }
        }

        return covarianceMatrix;
	}
	
	public double computeSquaredDistanceToCovarianceMatrix(Hypercube other) {
		final DenseMatrix otherCovariance = other.computeCovarianceMatrix();
		final DenseMatrix thisCovariance = this.computeCovarianceMatrix();

		final DenseMatrix difference = thisCovariance.sub(otherCovariance);
		final DenseMatrix squared = difference.mm(difference);
		return squared.colSums().sum();
		
	}
	
	public boolean equals(Hypercube other) {
		return Arrays.equals(this.definition, other.definition);
	}
}
