package de.evoal.core.main.ea.functions.correlation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Range {
    private double lower;
    private double upper;

    public boolean includes(double chromosomeValue) {
        return lower <= chromosomeValue && chromosomeValue <= upper;
    }
}
