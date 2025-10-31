package de.evoal.surrogate.simple.identity;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdentityFunctionPSONWriter extends AbstractPSONWriter {
    @Override
    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
    }
}
