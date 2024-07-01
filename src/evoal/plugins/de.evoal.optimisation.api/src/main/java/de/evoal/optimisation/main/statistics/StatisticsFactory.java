package de.evoal.optimisation.main.statistics;

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.main.statistics.internal.MultipleStatisticsWriter;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import de.evoal.languages.model.base.Value;

import javax.inject.Inject;
import java.util.stream.Stream;

@ApplicationScoped
public class StatisticsFactory {
    @Inject
    private ExpressionEvaluator evaluator;

    @Inject
    private ComponentProducer producer;

    @Produces
    @Dependent
    @Component
    public StatisticsWriter create(
            final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.documentation") Array problemWriter,
            final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.documentation") Array algorithmWriter) {

        Stream<Value> problemStream = Stream.empty();
        Stream<Value> algorithmStream = Stream.empty();

        if(problemWriter != null) {
            problemStream = problemWriter.getValues().stream();
        }

        if(algorithmWriter != null) {
            algorithmStream = algorithmWriter.getValues().stream();
        }

        final StatisticsWriter [] writers = Stream.concat(problemStream, algorithmStream)
                                                  .map(evaluator::evaluate)
                                                  .map(Instance.class::cast)
                                                  .map(i -> producer.create(StatisticsWriter.class, i))
                                                  .toArray(i -> new StatisticsWriter[i]);

        return new MultipleStatisticsWriter(writers);
    }
}
