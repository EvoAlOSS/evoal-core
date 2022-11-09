package de.evoal.core.main.statistics.rangeCorrelated;

public class Interval {
	private double lowerBound;
	private double upperBound;
	
	public boolean check(double value) {
		return (lowerBound <= value && value <= upperBound);
	}
	
	public Interval(double lowerBound, double upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
}
