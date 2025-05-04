package de.evoal.optimisation.main.producer;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@Slf4j
public class ConfigurationValueProducer {
    @Inject
    private AttributeHelper helper;

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Integer injectIntegerValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Double injectDoubleValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public String injectStringValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Array injectArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public List<Instance> injectInstanceListValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public List<Definition> injectDefinitionListValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Instance injectInstanceValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Boolean injectBooleanValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    public <T> T lookup(final OptimisationModule model, final String access) {
        log.info("Looking up configuration value {}", access);

        return helper.lookup(model, access);
    }
}
