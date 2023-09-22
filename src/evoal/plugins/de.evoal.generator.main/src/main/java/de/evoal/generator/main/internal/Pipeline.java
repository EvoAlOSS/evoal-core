package de.evoal.generator.main.internal;

import de.evoal.generator.api.GeneratorFunction;
import lombok.Getter;

import java.util.List;

public class Pipeline {
    @Getter
    private final String name;

    @Getter
    private final List<GeneratorFunction> steps;

    public Pipeline(final String name, final List<GeneratorFunction> steps) {
        this.name = name;
        this.steps = steps;
    }
}
