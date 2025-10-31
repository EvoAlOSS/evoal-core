package de.evoal.surrogate.smile.svr.thinplatespline;

import de.evoal.surrogate.smile.svr.AbstractSVRPSONWriter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.thin-plate-spline-svr-writer-pson")
@Slf4j
public class ThinPlateSplineKernelPSONWriter extends AbstractSVRPSONWriter {
	public ThinPlateSplineKernelPSONWriter() {
		super("de.evoal.surrogate.smile.ml.thin-plate-spline-svr");
	}
}
