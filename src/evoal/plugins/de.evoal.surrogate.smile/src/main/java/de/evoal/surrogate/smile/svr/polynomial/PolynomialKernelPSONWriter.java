package de.evoal.surrogate.smile.svr.polynomial;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.polynomial-svr-writer-pson")
@Slf4j
public class PolynomialKernelPSONWriter extends AbstractSVRPSONWriter {
	public PolynomialKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.polynomial-svr");
	}
}
