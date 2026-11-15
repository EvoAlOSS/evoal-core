package de.evoal.optimisation.main.fitness;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.optimisation.core.unknown-function")
public class UnknownOptimisationFunction extends OptimisationFunctionImpl {
    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        throw new RuntimeException("The unknown function is not valid for usage during optimisation, please specify a proper optimisation function.");
    }
}
