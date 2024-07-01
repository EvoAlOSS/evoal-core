package de.evoal.optimisation.ea.main.codec.program.operations;

import de.evoal.optimisation.ea.api.codec.program.Operation;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.sqrt")
public class SqrtOperation implements Operation {
    @Override
    public String name() {
        return "sqrt";
    }

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Double apply(Double [] o) {
        return Math.sqrt(o[0]);
    }

    @Override
    public String toString() {
        return "sqrt";
    }

}
