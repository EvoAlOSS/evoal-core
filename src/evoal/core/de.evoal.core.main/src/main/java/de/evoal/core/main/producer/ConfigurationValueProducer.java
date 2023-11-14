package de.evoal.core.main.producer;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Literal;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.base.RealLiteral;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class ConfigurationValueProducer {
    @Inject
    private LanguageHelper helper;

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Integer injectIntegerValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Double injectDoubleValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public String injectStringValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Array injectArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Instance [] injectInstanceArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        final Object [] array = lookup(board.get(value.entry()), value.access());
        final Instance [] copy = new Instance[array.length];

        System.arraycopy(array, 0, copy, 0, copy.length);

        return copy;
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public DataDescription[] injectDataDescriptionArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        final Object [] array = lookup(board.get(value.entry()), value.access());
        final DataDescription[] copy = new DataDescription[array.length];

        System.arraycopy(array, 0, copy, 0, copy.length);

        return copy;
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Instance injectInstanceValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Boolean injectBooleanValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }
    
    @Produces
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public double [] injectDoubleArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return (this.<Array>lookup(board.get(value.entry()), value.access()))
                .getValues()
                .stream()
                .mapToDouble(x -> ((RealLiteral)((Literal)x)).getValue())
                .toArray();
    }

    public <T> T lookup(final OptimisationModule model, final String access) {
        log.info("Looking up configuration value {}", access);

        return helper.lookup(model, access);
    }
}
