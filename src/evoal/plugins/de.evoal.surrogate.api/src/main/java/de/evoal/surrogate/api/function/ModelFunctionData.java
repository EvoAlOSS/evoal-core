package de.evoal.surrogate.api.function;

import de.evoal.surrogate.api.function.ModelFunction;

import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelWriter;

import java.util.Optional;

public record ModelFunctionData(ModelFunction function, Optional<ModelReader> reader, Optional<ModelWriter> writer) {
}
