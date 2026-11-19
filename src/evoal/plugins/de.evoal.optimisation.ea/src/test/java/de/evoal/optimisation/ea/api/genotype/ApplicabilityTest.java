package de.evoal.optimisation.ea.api.genotype;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.api.operators.Applicability;

public class ApplicabilityTest {
    private final DoubleChromosome chromosome = new DoubleChromosome(List.of(Candidates.real("x"), Candidates.real("y")),
                                                                     new double[] {0.0, 0.0}, new double[] {1.0, 1.0});

    private final Applicability cardinalDoubles = new Applicability(Set.of(Representation.DOUBLE), MeasurementScale.CARDINAL);

    @Test
    public void anOperatorAppliesToItsRepresentationsWithStrongEnoughScales() {
        Assertions.assertNull(cardinalDoubles.reasonAgainst(chromosome, List.of(MeasurementScale.QUOTIENT, MeasurementScale.CARDINAL)));
    }

    @Test
    public void featuresWithoutScaleAreAccepted() {
        Assertions.assertNull(cardinalDoubles.reasonAgainst(chromosome, Arrays.asList(null, null)));
    }

    @Test
    public void aWeakerScaleIsNamed() {
        Assertions.assertEquals("the feature 'y' is ordinal, but it needs at least cardinal",
                                cardinalDoubles.reasonAgainst(chromosome, List.of(MeasurementScale.QUOTIENT, MeasurementScale.ORDINAL)));
    }

    @Test
    public void anotherRepresentationIsNamed() {
        final Applicability bits = new Applicability(Set.of(Representation.BIT, Representation.GRAY), MeasurementScale.NOMINAL);

        Assertions.assertEquals("it supports only [bit, gray] chromosomes", bits.reasonAgainst(chromosome, Arrays.asList(null, null)));
    }
}
