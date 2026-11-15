package de.evoal.optimisation.main.statistics;

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.main.statistics.internal.MultipleStatisticsWriter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class StatisticsFactory {
    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private ComponentProducer producer;

    @Produces
    @Dependent
    @Component
    public StatisticsWriter create(
            @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.documentation") List<EObject> problemWriter
//            @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.documentation") List<EObject> algorithmWriter
            ) {

        if(problemWriter == null) {
            problemWriter = Collections.emptyList();
        }
/*
        if(algorithmWriter == null) {
            algorithmWriter = Collections.emptyList();
        }
*/
        final StatisticsWriter [] writers = problemWriter.stream()//Stream.concat(problemWriter.stream(), algorithmWriter.stream())
                                                  .map(i -> producer.create(StatisticsWriter.class, i))
                                                  .toArray(StatisticsWriter[]::new);

        return new MultipleStatisticsWriter(writers);
    }
}
