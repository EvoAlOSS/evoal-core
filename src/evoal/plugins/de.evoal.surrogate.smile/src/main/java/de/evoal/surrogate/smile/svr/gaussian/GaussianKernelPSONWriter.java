package de.evoal.surrogate.smile.svr.gaussian;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.gaussian-svr-writer-pson")
@Slf4j
public class GaussianKernelPSONWriter extends AbstractSVRPSONWriter {
	public GaussianKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.gaussian-svr");
	}
}
