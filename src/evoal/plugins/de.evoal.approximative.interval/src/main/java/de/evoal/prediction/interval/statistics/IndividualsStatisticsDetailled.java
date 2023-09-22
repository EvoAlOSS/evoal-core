package de.evoal.prediction.interval.statistics;

import lombok.Data;

import java.util.List;

@Data
public class IndividualsStatisticsDetailled {
    private final int nmrOfFunctions;
    private final int nmrOfIndividuals;
    private final String[] genotypes;
    private final double[] fitnessValues;
    private long generation;

    public IndividualsStatisticsDetailled(final int nmrOfFunctions, final int nmrOfIndividuals) {
        this.nmrOfFunctions = nmrOfFunctions;
        this.nmrOfIndividuals = nmrOfIndividuals;
        
        genotypes = new String[nmrOfIndividuals];
        fitnessValues = new double[nmrOfFunctions * nmrOfIndividuals];
    }

    public static String[] header(final List<String> functionNames, final int populationSize) {
        final int numberOfFunctions = functionNames.size();
        String [] header = new String[1 + populationSize + populationSize * numberOfFunctions];

        header[0] = "generation";

        for(int i = 0; i < populationSize; ++i) {
            header[1 + i] = "individual(" + i + ")";

            for(int j = 0; j < numberOfFunctions; ++j) {
                header[1 + populationSize + i * numberOfFunctions + j] = functionNames.get(j) + "(" + i + ")";
            }
        }

        return header;
    }

    public Object[] toArray() {
        final Object [] data = new Object[1 + genotypes.length + fitnessValues.length];

        data[0] = generation;
        System.arraycopy(genotypes, 0, data, 1, genotypes.length);

        for(int i = 0; i < fitnessValues.length; ++i) {
            data[1 + genotypes.length + i] = fitnessValues[i];
        }

        return data;
    }

    public void addGenoType(final int i, final String genotype) {
        genotypes[i] = genotype;
    }

    public void addFitness(final int individual, final int function, final double fitness) {
        fitnessValues[individual * nmrOfFunctions + function] = fitness;
    }
}
