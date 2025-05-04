package de.evoal.pipeline.impl.optimisation;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.pipeline.PipelineFactory;
import de.evoal.languages.model.pipeline.Step;
import de.evoal.languages.model.base.expressions.DataReference;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.Component;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import de.evoal.pipeline.api.model.dynamic.EAnnotationHelper;
import de.evoal.pipeline.api.model.dynamic.EClassProvider;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import de.evoal.optimisation.api.model.OptimisationFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Slf4j
@Dependent
@Named("de.evoal.pipeline.optimisation.benchmark-function")
public class BenchmarkOptimisationFunction implements OptimisationFunction {

    @Inject
    private AttributeHelper helper;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpaceSpecification;

    @Inject
    private EClassProvider provider;

    @Inject
    private EAnnotationHelper annHelper;

    private PropertiesSpecification mergedSpaceSpecification;

    private Component[] functions;

    private PropertiesSpecification [] functionProperties;

    private EClass eClass;
    private Map<DataDescription, EStructuralFeature> mapping;

    @Override
    public double[] evaluate(final Properties candidate) {
        final TypedEObject temporary =  new TypedEObject(new DynamicEObjectImpl(eClass));

        // copy all input values
        for(final PropertySpecification spec : candidate.getSpecification().getProperties()) {
            temporary.eSet(mapping.get(spec.type()), candidate.get(spec));
        }

        for(int i = 0; i < functions.length; ++i) {
            final Component function = functions[i];
            final PropertiesSpecification specification = functionProperties[i];

            function.apply(temporary);
        }

        final Properties result = new Properties(optimisationSpaceSpecification);
        for(final PropertySpecification spec : optimisationSpaceSpecification.getProperties()) {
            result.put(spec, temporary.eGet(mapping.get(spec.type())));
        }

        return result.getValuesAsDouble();
    }

    @SneakyThrows
    @Override
    public OptimisationFunction init(final Instance config) {
        final List<Instance> benchmarkConfigurations = helper.lookup(config, "benchmarks");

        eClass = provider.eClassFor(searchSpaceSpecification, optimisationSpaceSpecification);
        mapping = annHelper.featuresOf(eClass);

        functions = new Component[benchmarkConfigurations.size()];
        functionProperties = new PropertiesSpecification[benchmarkConfigurations.size()];
        for(int index = 0; index < functions.length; ++index) {
            final Instance benchmarkConfiguration = benchmarkConfigurations.get(index);
            final Instance function = helper.lookup(benchmarkConfiguration, "function");

            final Step stepConfiguration = PipelineFactory.eINSTANCE.createStep();
            stepConfiguration.setInstance(EcoreUtil.copy(function));

            final List<DataDescription> readReferences = helper.lookup(benchmarkConfiguration, "reads");
            readReferences.forEach(dr -> {
                final DataReference reference = ExpressionsFactory.eINSTANCE.createDataReference();
                reference.setDefinition(dr);
                stepConfiguration.getReads().add(mapping.get(dr));
            });

            final List<DataDescription> writeReferences = (List<DataDescription>) helper.lookup(benchmarkConfiguration, "writes");
            writeReferences
                    .forEach(dr -> {
                        final DataReference reference = ExpressionsFactory.eINSTANCE.createDataReference();
                        reference.setDefinition(dr);
                        stepConfiguration.getWrites().add(mapping.get(dr));
                    });

            functions[index] = toComponent(stepConfiguration);
            functionProperties[index] = PropertiesSpecification.builder()
                    .addDescriptions(writeReferences.stream())
                    .build();
        }

        mergedSpaceSpecification = PropertiesSpecification.builder()
                .add(searchSpaceSpecification)
                .add(optimisationSpaceSpecification)
                .build();

        return this;
    }

    /**
     * Converting a step into a component, a single executable element of the pipeline.
     *
     * @param step The step to instanciate.
     * @return The instanciated component.
     */
    private Component toComponent(final de.evoal.languages.model.pipeline.Step step) {
        log.info("Instantiating component {}", step.getInstance().getDefinition().getName());
        return BeanFactory.createComponent(ComponentImpl.class, step.getInstance(), c -> c.setFeatures(step.getReads(), step.getWrites()));
    }
}


