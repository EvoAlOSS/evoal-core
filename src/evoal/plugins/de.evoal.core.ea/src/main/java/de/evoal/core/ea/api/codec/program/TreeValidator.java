package de.evoal.core.ea.api.codec.program;

import de.evoal.core.api.cdi.EvoalComponent;
import io.jenetics.prog.ProgramChromosome;

public interface TreeValidator<T> extends EvoalComponent<TreeValidator<T>> {
    public boolean validate(final ProgramChromosome<T> program);
}
