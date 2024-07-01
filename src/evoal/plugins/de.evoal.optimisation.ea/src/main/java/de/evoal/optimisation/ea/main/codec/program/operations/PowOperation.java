package de.evoal.optimisation.ea.main.codec.program.operations;

import de.evoal.optimisation.ea.api.codec.program.Operation;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.pow")
public class PowOperation implements Operation {
    @Override
    public String name() {
        return "pow";
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Double apply(Double [] o) {
        return Math.pow(o[0], o[1]);
    }

    @Override
    public String toString() {
        return "pow";
    }
}
