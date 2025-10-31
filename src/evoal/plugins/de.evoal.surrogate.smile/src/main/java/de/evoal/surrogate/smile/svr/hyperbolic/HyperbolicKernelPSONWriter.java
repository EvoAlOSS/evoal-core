package de.evoal.surrogate.smile.svr.hyperbolic;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.hyperbolic-svr-writer-pson")
@Slf4j
public class HyperbolicKernelPSONWriter extends AbstractSVRPSONWriter {
	public HyperbolicKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.hyperbolic-svr");
	}
}
