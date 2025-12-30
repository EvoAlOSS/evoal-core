package de.evoal.surrogate.smile.svr.hellinger;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.hellinger-svr-writer-pson")
@Slf4j
public class HellingerKernelPSONWriter extends AbstractSVRPSONWriter {
	public HellingerKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.hellinger-svr");
	}
}
