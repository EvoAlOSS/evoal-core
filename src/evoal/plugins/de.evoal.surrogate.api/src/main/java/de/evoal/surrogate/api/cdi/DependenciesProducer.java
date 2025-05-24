package de.evoal.surrogate.api.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.info.FeatureDependencies;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesDependencies;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;

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
    public FeatureDependencies calculateFeatureDependencies(final SurrogateFunction function) {
        return _calculate(function, 0, new FeatureDependencies(function.getInputSpecification()));
    }

    public PropertiesDependencies calculatePropertyDependencies(final SurrogateFunction function) {
        final PropertiesSpecification source = helper.specificationOf(function.getInputSpecification());

        return _calculate(helper, function, 0, new PropertiesDependencies(source));
    }

    private FeatureDependencies _calculate(final SurrogateFunction function, final int index, final FeatureDependencies dependencies) {
        if(index == function.getFunctions().size()) {
            return dependencies;
        }

        final FeatureDependencies next = new FeatureDependencies(function.getOutputSpecification());

        for(final PartialSurrogateFunction fn : function.getFunctions()){
            for(final EStructuralFeature ops : fn.getOutputProperty()) {
                next.add(ops, fn.getUsedProperties());
            }
        }

        return _calculate(function, index + 1, next);
    }

    private PropertiesDependencies _calculate(final EAnnotationHelper helper, final SurrogateFunction function, final int index, final PropertiesDependencies dependencies) {
        if(index == function.getFunctions().size()) {
            return dependencies;
        }

        final PropertiesSpecification outputSpec = helper.specificationOf(function.getOutputSpecification());

        final PropertiesDependencies next = new PropertiesDependencies(outputSpec);
        for(final PartialSurrogateFunction fn : function.getFunctions()){
            for(final PropertySpecification ops : helper.specificationOf(fn.getOutputProperty()).getProperties()) {
                next.add(ops, helper.specificationOf(fn.getUsedProperties()));
            }
        }

        return _calculate(helper, function, index + 1, next);
    }}
