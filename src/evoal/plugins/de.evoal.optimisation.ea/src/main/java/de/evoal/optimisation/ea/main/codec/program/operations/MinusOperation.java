package de.evoal.optimisation.ea.main.codec.program.operations;

import de.evoal.optimisation.ea.api.codec.program.Operation;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.minus")
public class MinusOperation implements Operation {
    @Override
    public String name() {
        return "minus";
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Double apply(Double [] o) {
        return o[0] - o[1];
    }

    @Override
    public String toString() {
        return "minus";
    }
}
