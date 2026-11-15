package de.evoal.optimisation.pso.main.impl;

import java.util.List;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

/**
 * An optimisation value with a single number, greater values are better.
 */
final class TestFitness extends MinimalEObjectImpl.Container implements OptimisationValue {
    private final double value;

    TestFitness(final double value) {
        this.value = value;
    }

    @Override
    public int compareTo(final OptimisationValue other) {
        final TestFitness otherFitness = (TestFitness) other;

        return Double.compare(value, otherFitness.value);
    }

    @Override
    public boolean isBetter(final OptimisationValue other) {
        return compareTo(other) > 0;
    }

    @Override
    public boolean isEqual(final OptimisationValue other) {
        return compareTo(other) == 0;
    }

    @Override
    public boolean isWorse(final OptimisationValue other) {
        return compareTo(other) < 0;
    }

    @Override
    public TypedEObject toOptmisationSpace() {
        return null;
    }

    @Override
    public List<Object> toStatistics() {
        return List.of(value);
    }
}
