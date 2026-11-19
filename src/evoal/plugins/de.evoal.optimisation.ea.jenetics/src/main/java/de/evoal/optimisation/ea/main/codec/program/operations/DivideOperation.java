package de.evoal.optimisation.ea.main.codec.program.operations;

import de.evoal.optimisation.ea.api.codec.program.Operation;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.divide")
public class DivideOperation implements Operation {
    @Override
    public String name() {
        return "divide";
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Double apply(Double [] o) {
        return o[0] / o[1];
    }

    @Override
    public String toString() {
        return "divide";
    }

}
