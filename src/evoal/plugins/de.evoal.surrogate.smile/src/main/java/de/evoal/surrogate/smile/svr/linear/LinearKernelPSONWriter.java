package de.evoal.surrogate.smile.svr.linear;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.linear-svr-writer-pson")
@Slf4j
public class LinearKernelPSONWriter extends AbstractSVRPSONWriter {
	public LinearKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.linear-svr");
	}
}
