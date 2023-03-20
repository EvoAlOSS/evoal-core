package de.evoal.generator.main.cdi;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.dl.AttributeDefinition;
import de.evoal.languages.model.generator.GeneratorFactory;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.InstanceFactory;
import lombok.SneakyThrows;
import org.eclipse.emf.ecore.util.EcoreUtil;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("benchmark-function")
public class BenchmarkOptimisationFunction implements OptimisationFunction {

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpaceSpecification;

    private PropertiesSpecification mergedSpaceSpecification;

    @Inject
    private de.evoal.generator.main.generators.GeneratorFactory factory;

    private GeneratorFunction function;

    @Override
    public double[] evaluate(final Properties candidate) {
        final Properties result = function.apply(candidate);
        double [] copy = new double[optimisationSpaceSpecification.getProperties().size()];

        int i = 0;
        for(final PropertySpecification spec : optimisationSpaceSpecification.getProperties()) {
            copy[i++] = result.getAsDouble(spec);
        }
        return copy;
    }

    @SneakyThrows
    @Override
    public OptimisationFunction init(final Instance config) {
        final Instance benchmarkConfiguration = (Instance)config.findAttribute("benchmark").getValue();

        final Step stepConfiguration = GeneratorFactory.eINSTANCE.createStep();
        stepConfiguration.setInstance(EcoreUtil.copy(benchmarkConfiguration));

        searchSpaceSpecification.getProperties()
                        .forEach(p -> {
                            final DataReference reference = InstanceFactory.eINSTANCE.createDataReference();
                            reference.setDefinition(p.type());
                            stepConfiguration.getReads().add(reference);
                        });
        ;

        optimisationSpaceSpecification.getProperties()
                .forEach(p -> {
                    final DataReference reference = InstanceFactory.eINSTANCE.createDataReference();
                    reference.setDefinition(p.type());
                    stepConfiguration.getWrites().add(reference);
                });
        ;

        function = factory.create(stepConfiguration);

        mergedSpaceSpecification = PropertiesSpecification.builder()
                .add(searchSpaceSpecification)
                .add(optimisationSpaceSpecification)
                .build();

        return this;
    }
}
