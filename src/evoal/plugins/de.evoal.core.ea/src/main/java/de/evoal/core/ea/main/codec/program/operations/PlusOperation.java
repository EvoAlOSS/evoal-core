package de.evoal.core.ea.main.codec.program.operations;

import de.evoal.core.ea.api.codec.program.Operation;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.core.ea.genetic-programming.plus")
public class PlusOperation implements Operation {
    @Override
    public String name() {
        return "plus";
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Double apply(Double [] o) {
        return o[0] + o[1];
    }

    @Override
    public String toString() {
        return "plus";
    }
}
