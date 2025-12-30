package de.evoal.surrogate.main.statistics.surrogate;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.surrogate.api.cdi.SurrogateProducer;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.prediction-per-individual")
@Dependent
public class SurrogateStatistics extends AbstractCandidateStatisticsWriter {
    @Inject
    private EAnnotationHelper helper;

    @Inject
    private AttributeHelper attribute;

    @Inject
    private EClassProvider dynamic;

    /**
     * The predictive function used.
     */
    protected ModelFunctionData predictive;

    @Inject
    private SurrogateProducer producer;

    private Space sourceSpace;

    private Space targetSpace;

    private final Map<String, EStructuralFeature> featureMap = new HashMap<>();

    @Override
    public StatisticsWriter init(final Instance configuration) {
        final String surrogateConfiguration = attribute.lookup(configuration, "pson-file");

        final List<DataDescription> inputSpace = attribute.lookup(configuration, "input-space");
        final List<DataDescription> outputSpace = attribute.lookup(configuration, "output-space");

        final EClass dynamicEClass = dynamic.eClassFor(inputSpace, outputSpace);
        final Space dynamicSpace = new Space(dynamicEClass);
        final Space input = helper.subSpaceOf(dynamicSpace, inputSpace);
        final Space output = helper.subSpaceOf(dynamicSpace, outputSpace);


        predictive = producer.load(new File(surrogateConfiguration), input, output);

        sourceSpace = predictive.function().getInput();
        targetSpace = predictive.function().getOutput();

        super.init(configuration);

        return this;
    }

    @Override
    protected Writer createWriter(final Instance configuration) throws WriterException {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        for(final EStructuralFeature feature : sourceSpace) {
            featureMap.put(feature.getName(), feature);
        }

        for(final EStructuralFeature feature : targetSpace) {
            columns.add(new Column(feature.getName(), ColumnType.Double));
        }

        return strategy.create("prediction-by-individual", columns);
    }

    @Override
    protected Object[] toData(final int index, final int iteration, final Candidate individual) {
        final Object [] data = new Object[2 + targetSpace.size()];

        data[0] = iteration;
        data[1] = index;

        final TypedEObject input = sourceSpace.newEObject();
        final TypedEObject output = targetSpace.newEObject();

        // copy individual to input
        final Properties properties = individual.searchSpaceRepresentation();
        for(final PropertySpecification spec : properties.getSpecification().getProperties()) {
            input.eSet(featureMap.get(spec.name()), properties.get(spec));
        }

        // predict
        predictive.function()
                  .apply(input, output);

        // copy output to log
        int i = 0;
        for(final EStructuralFeature feature : targetSpace) {
            data[2 + i] = output.eGetAsDouble(feature);
        }

        return data;
    }
}
