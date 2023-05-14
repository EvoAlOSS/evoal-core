package de.evoal.core.main.statistics;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.main.statistics.internal.MultipleStatisticsWriter;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import de.evoal.languages.model.base.Value;
import de.evoal.languages.model.interpreter.ConstantExpressionEvaluator;
import org.apache.commons.math3.util.Pair;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class StatisticsFactory {
    @Inject
    private ExpressionEvaluator evaluator;

    @Produces
    @Dependent
    @Named("statistics")
    public StatisticsWriter create(
            final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.documentation") Array problemWriter,
            final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.documentation") Array algorithmWriter) {

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
                                                  .map(i -> new Pair<>(BeanFactory.create(i.getDefinition().getName(), StatisticsWriter.class), i))
                                                  .map(p -> p.getFirst().init(p.getSecond()))
                                                  .toArray(i -> new StatisticsWriter[i]);

        return new MultipleStatisticsWriter(writers);
    }
}
