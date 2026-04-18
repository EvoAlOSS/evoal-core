package de.evoal.surrogate.simple.identity;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Setter
@Named("de.evoal.surrogate.simple.ml.identity-writer-pson")
@Slf4j
@Dependent
public class IdentityFunctionPSONWriter extends AbstractPSONWriter {
    @Override
    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
    }
}
