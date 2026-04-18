package de.evoal.surrogate.simple.identity;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import lombok.extern.slf4j.Slf4j;


import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;


@Named("de.evoal.surrogate.simple.ml.identity-reader-pson")
@Slf4j
@Dependent
public class IdentityFunctionPSONReader extends AbstractPSONReader {
	@Override
	public ModelFunction load() {
		storage.load();

        return new IdentityFunction(getInput(), getOutput());
	}
}
