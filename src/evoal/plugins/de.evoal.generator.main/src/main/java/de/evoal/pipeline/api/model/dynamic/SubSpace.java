package de.evoal.pipeline.api.model.dynamic;

import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.LinkedHashSet;

public class SubSpace extends LinkedHashSet<EStructuralFeature> {
    public SubSpace() {
    }

    public SubSpace(final Collection<EStructuralFeature> features) {
        super(features);
    }
}
