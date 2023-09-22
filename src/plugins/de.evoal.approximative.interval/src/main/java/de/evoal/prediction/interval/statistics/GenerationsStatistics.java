package de.evoal.prediction.interval.statistics;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class GenerationsStatistics {
    public static String[] header(final List<String> functionNames) {
        final int numberOfFunctions = functionNames.size();
        String [] header = new String[1 + 5 * numberOfFunctions];

        header[0] = "generation";

        for(int i = 0; i < numberOfFunctions; ++i) {
            header[1 + 0 + i] = "mean(" + functionNames.get(i) + ")";
            header[1 + numberOfFunctions + i] = "std(" + functionNames.get(i) + ")";
            header[1 + 2 * numberOfFunctions + i] = "best(" + functionNames.get(i) + ")";
            header[1 + 3 * numberOfFunctions + i] = "worst(" + functionNames.get(i) + ")";
            header[1 + 4 * numberOfFunctions + i] = "size(" + functionNames.get(i) + ")";
        }

        return header;
    }

    private long generation;

    private final double [] mean;

    private final double [] std;

    private final double [] bestFitness;

    private final double [] worstFitness;

    private final int size;

    private final int [] fitnessCount;

    public GenerationsStatistics(final int size) {
        this.mean = new double[size];
        this.std = new double[size];
        this.bestFitness = new double[size];
        this.worstFitness = new double[size];
        this.size = size;
        this.fitnessCount = new int[size];

        for(int i = 0; i < size; ++i) {
            bestFitness[i] = Double.NEGATIVE_INFINITY;
            worstFitness[i] = Double.POSITIVE_INFINITY;
        }
    }

    public void addFitness(final int index, final Double fitness) {
        //log.info("Adding fitness value {} to function {}.", fitness, index);
        if (!fitness.isInfinite() && !fitness.isNaN()) {
            mean[index] += fitness;
            std[index] += fitness * fitness;
            fitnessCount[index] += 1;
        }

        if(fitness > bestFitness[index]) {
            bestFitness[index] = fitness;
        }

        if(fitness < worstFitness[index]) {
            worstFitness[index] = fitness;
        }
    }

    public Object[] toArray() {
        final int numberOfFunctions = mean.length;
        Object [] data = new Object[1 + 5 * numberOfFunctions];

        data[0] = generation;

        for(int i = 0; i < numberOfFunctions; ++i) {
            final double m = mean[i] / fitnessCount[i];

            data[1 + 0 + i] = m;
            data[1 + numberOfFunctions + i] = Math.sqrt(std[i] / fitnessCount[i] - Math.pow(m, 2));
            data[1 + 2 * numberOfFunctions + i] = bestFitness[i];
            data[1 + 3 * numberOfFunctions + i] = worstFitness[i];
            data[1 + 4 * numberOfFunctions + i] = fitnessCount[i];
        }

        return data;
    }
}
