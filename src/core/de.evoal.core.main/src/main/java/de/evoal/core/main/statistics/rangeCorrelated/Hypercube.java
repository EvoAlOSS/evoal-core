package de.evoal.core.main.statistics.rangeCorrelated;

import java.util.ArrayList;
import java.util.List;

import de.evoal.core.main.ea.functions.correlation.model.Range;
import de.evoal.core.api.properties.Properties;

import smile.math.matrix.Matrix;

public class Hypercube {
	private final int dimensions;
	private final Range[] definition;
	private final List<Properties> data = new ArrayList<>();

	public Hypercube(final Hypercube other) {
		this.dimensions = other.dimensions;
		this.definition = other.definition;
	}
	
	public Hypercube(Range[] definition) {
		this.definition = definition;
		this.dimensions = definition.length;
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
				if(!definition[i].includes(dataPoint.get(i))){
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
	
	public Matrix computeCovarianceMatrix(){
		final int dimensions = this.dimensions;
        final int dataSize = data.size();

        if(dataSize == 0) {
        	return new Matrix(dimensions, dimensions);
		}

        final double [] means = new double[dimensions];
        for(int i=0; i< dataSize; i++) {
        	for(int j=0; j< dimensions; j++) {
        		means[j] = means[j] + data.get(i).get(j)/(double)data.size();
        	}
        }


        final Matrix covarianceMatrix = new Matrix(dimensions, dimensions);
        for(int x = 0; x < dimensions; ++x) {
            for(int y = 0; y < dimensions; ++y) {
                double value = 0.0;
                for(int t = 0; t < dataSize; ++t) {
                    value += ((data.get(t).get(x) - means[x])*(data.get(t).get(y) - means[y]));
                }
                value = value / dataSize;
                covarianceMatrix.set(x, y, value);
            }
        }

        return covarianceMatrix;
	}
	
	public double computeSquaredDistanceToCovarianceMatrix(Hypercube other) {
		Matrix otherCovariance = other.computeCovarianceMatrix();
		Matrix thisCovariance = this.computeCovarianceMatrix();
		
		Matrix difference = thisCovariance.sub(otherCovariance); 
		difference.mul(difference);
		return difference.sum();
		
	}
	
	public boolean equals(Hypercube other) {
		return  this.definition.equals(other.definition);
	}
	
	public boolean contentEquals(Hypercube other) {
		return this.definition.equals(other.definition) && this.data.equals(other.data); 
	}
}
