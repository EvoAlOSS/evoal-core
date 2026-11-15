package de.evoal.optimisation.main.statistics.individuals;

import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;

import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.optimisation.core.candidates-per-iteration")
@Dependent
public class CandidatesPerGeneration extends AbstractCandidateStatisticsWriter {

    @Inject
    protected WriterStrategy strategy;

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    @Named("search-space")
    private Space searchSpace;

    @Inject
    @Named("optimisation-space")
    private Space optimisationSpace;

    private boolean storeOptimisationSpace;

    private boolean storeSearchSpace;

    private int rowSize;

    public CandidatesPerGeneration() {
        super(Iteration::survivedIndividuals);
    }

    @Override
    protected Writer createWriter(final EObject configuration) throws WriterException {
        final List<Column> columns = new LinkedList<>();
        final boolean prefixColumns = evaluator.attributeToBoolean(configuration, "prefix-data");
        storeSearchSpace = evaluator.attributeToBoolean(configuration, "store-search-space");
        storeOptimisationSpace = evaluator.attributeToBoolean(configuration, "store-optimisation-space");

        columns.add(new Column("individual-id", ColumnType.Integer));
        columns.add(new Column("generation", ColumnType.Integer));

        if(storeSearchSpace) {
            addVariableSpace(searchSpace, prefixColumns, "search-space-value-", columns);
        }

        if(storeOptimisationSpace) {
            addVariableSpace(optimisationSpace, prefixColumns, "optimisation-space-value-", columns);
        }

        this.rowSize = columns.size();

        return strategy.create("optimisation-by-individual", columns);
    }

    private void addVariableSpace(final Space space, final boolean prefixColumns, final String prefix, final List<Column> columns) {
        for (final EStructuralFeature feature : space) {
            String columnName = feature.getName();

            if (prefixColumns) {
                columnName = prefix + columnName;
            }

            columns.add(new Column(columnName, toColumnType(feature)));
        }
    }

    private ColumnType toColumnType(final EStructuralFeature spec) {
        final EClassifier type = spec.getEType();

        if(EClassifierHelper.isReal(type)) {
            return ColumnType.Double;
        } else if(EClassifierHelper.isLongOrShorter(type)) {
            return ColumnType.Integer;
        } else if(EClassifierHelper.isBoolean(type)) {
            return ColumnType.Boolean;
        } else if(EClassifierHelper.isString(type)) {
            return ColumnType.String;
        }

        throw new IllegalArgumentException("Unsupported EStructuralFeature " + spec.getName());
    }

    @Override
    protected Object [] toData(final int id, final int iteration, final Individual individual) {
        final Space searchSpace = individual.getInput().eSpace();
        final Space optimisationSpace = individual.getOutput().eSpace();

        final int searchSpaceSize = searchSpace.size();

        final Object [] data = new Object[rowSize];

        data[0] = id;
        data[1] = iteration;

        if(storeSearchSpace) {
            int i = 0;
            for (final EStructuralFeature feature : searchSpace) {
                data[2 + i++] = individual.getInput().eGet(feature);
            }
        }

        if(storeOptimisationSpace) {
            int searchSpaceOffset = storeSearchSpace ? searchSpaceSize : 0;

            int i = 0;
            for (final EStructuralFeature feature : optimisationSpace) {
                data[2 + searchSpaceOffset + i++] = individual.getOutput().eGet(feature);
            }
        }
        return data;
    }
}