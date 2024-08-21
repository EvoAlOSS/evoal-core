package de.evoal.generator.main.cdi;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.generator.GeneratorFactory;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.instance.InstanceFactory;
import lombok.SneakyThrows;
import org.eclipse.emf.ecore.util.EcoreUtil;
import de.evoal.optimisation.api.model.OptimisationFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Dependent
@Named("de.evoal.generator.optimisation.benchmark-function")
public class BenchmarkOptimisationFunction implements OptimisationFunction {

    @Inject
    private AttributeHelper helper;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpaceSpecification;

    private PropertiesSpecification mergedSpaceSpecification;

    @Inject
    private de.evoal.generator.main.generators.GeneratorFactory factory;

    private GeneratorFunction [] functions;

    private PropertiesSpecification [] functionProperties;

    @Override
    public double[] evaluate(final Properties candidate) {
        final Properties result = new Properties(optimisationSpaceSpecification);

        for(int i = 0; i < functions.length; ++i) {
            final GeneratorFunction function = functions[i];
            final PropertiesSpecification specification = functionProperties[i];

            final Properties calculated = function.apply(candidate);

            for(PropertySpecification spec : specification.getProperties()) {
                result.put(spec, calculated.get(spec));
            }
        }

        return result.getValuesAsDouble();
    }

    @SneakyThrows
    @Override
    public OptimisationFunction init(final Instance config) {
        final List<Instance> benchmarkConfigurations = helper.lookup(config, "benchmarks");

        functions = new GeneratorFunction[benchmarkConfigurations.size()];
        functionProperties = new PropertiesSpecification[benchmarkConfigurations.size()];
        for(int index = 0; index < functions.length; ++index) {
            final Instance benchmarkConfiguration = benchmarkConfigurations.get(index);
            final Instance function = helper.lookup(benchmarkConfiguration, "function");

            final Step stepConfiguration = GeneratorFactory.eINSTANCE.createStep();
            stepConfiguration.setInstance(EcoreUtil.copy(function));

            final List<DataDescription> readReferences = helper.lookup(benchmarkConfiguration, "reads");
            readReferences.forEach(dr -> {
                final DataReference reference = InstanceFactory.eINSTANCE.createDataReference();
                reference.setDefinition(dr);
                stepConfiguration.getReads().add(reference);
            });

            final List<DataDescription> writeReferences = (List<DataDescription>) helper.lookup(benchmarkConfiguration, "writes");
            writeReferences
                    .forEach(dr -> {
                        final DataReference reference = InstanceFactory.eINSTANCE.createDataReference();
                        reference.setDefinition(dr);
                        stepConfiguration.getWrites().add(reference);
                    });

            functions[index] = factory.create(stepConfiguration);
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
}
