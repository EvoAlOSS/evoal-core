package de.evoal.optimisation.ea.api.codec.program;

import io.jenetics.prog.ProgramChromosome;

public interface TreeValidator<T> extends EvoalComponent<TreeValidator<T>> {
    public boolean validate(final ProgramChromosome<T> program);
}
