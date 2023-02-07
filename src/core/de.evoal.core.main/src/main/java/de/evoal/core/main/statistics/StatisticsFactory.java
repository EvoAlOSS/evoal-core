package de.evoal.core.main.statistics;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.statistics.StatisticsWriter;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.main.statistics.internal.MultipleStatisticsWriter;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import org.apache.commons.math3.util.Pair;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.inject.Named;

@ApplicationScoped
public class StatisticsFactory {
    @Produces
    @Dependent
    @Named("statistics")
    public StatisticsWriter create(final @ConfigurationValue(entry = BlackboardEntry.OPTIMISATION_CONFIGURATION, access = "statistics") Instance instance) {
        Requirements.requireSize(instance.getAttributes(), 1);
        final Array array = (Array)instance.getAttributes().get(0).getValue();

        final StatisticsWriter [] writers = array.getValues()
                                                 .stream()
                                                 .map(Instance.class::cast)
                                                 .map(i -> new Pair<>(BeanProvider.getContextualReference(i.getName().getName(), false, StatisticsWriter.class), i))
                                                 .map(p -> p.getFirst().init(p.getSecond()))
                                                 .toArray(i -> new StatisticsWriter[i]);

        return new MultipleStatisticsWriter(writers);
    }
}
