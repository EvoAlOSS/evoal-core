package de.evoal.surrogate.api.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import de.evoal.surrogate.api.function.ModelFunction;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.info.FeatureDependencies;

@ApplicationScoped
public class DependenciesProducer {

    @Inject
    private EAnnotationHelper helper;

    /**
     * Calculates the dependencies of all output features.
     *
     * @param function The function to use for calculation.
     * @return The output dependencies.
     */
    public FeatureDependencies calculateFeatureDependencies(final ModelFunction function) {
        return new FeatureDependencies(function.getInput());
    }
}
