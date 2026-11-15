package de.evoal.optimisation.main.statistics;

import java.util.List;
import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.cdi.ConfigurationValue;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.main.statistics.internal.MultipleStatisticsWriter;

/**
 * Creates the statistics writer of a run from the {@code document [...]} lists
 *   of the OL file: the writers of the problem, followed by the writers of the
 *   algorithm.
 */
@ApplicationScoped
public class StatisticsFactory {
    @Inject
    private ComponentProducer producer;

    /**
     * @return A writer that forwards to all configured writers (none if no
     *   writer is configured).
     */
    @Produces
    @Dependent
    @Component
    public StatisticsWriter create(
            @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                access = "problem.documentation") final List<EObject> problemWriters,
            @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                access = "documentation") final List<EObject> algorithmWriters) {

        final Stream<EObject> problemConfigurations = streamOf(problemWriters);
        final Stream<EObject> algorithmConfigurations = streamOf(algorithmWriters);

        final StatisticsWriter[] writers = Stream.concat(problemConfigurations, algorithmConfigurations)
                                                 .map(this::createWriter)
                                                 .toArray(StatisticsWriter[]::new);

        return new MultipleStatisticsWriter(writers);
    }

    private StatisticsWriter createWriter(final EObject configuration) {
        return producer.create(StatisticsWriter.class, configuration);
    }

    private static Stream<EObject> streamOf(final List<EObject> configurations) {
        if(configurations == null) {
            return Stream.empty();
        }

        return configurations.stream();
    }
}
