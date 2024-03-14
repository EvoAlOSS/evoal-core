package de.evoal.core.ea.main.codec.program.operations;

import de.evoal.core.ea.api.codec.program.Operation;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.core.ea.genetic-programming.sqrt")
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
