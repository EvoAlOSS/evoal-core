package de.evoal.optimisation.main.producer;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.Definition;
//import de.evoal.languages.model.base.expressions.*;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import jakarta.enterprise.inject.Typed;
import jakarta.enterprise.inject.spi.InjectionPoint;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

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
/*
    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Array injectArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }
    */

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public List<EObject> injectEObjectListValue(final InjectionPoint ip, final Blackboard board) {
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
    public EObject injectEObjectValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @Typed(Configuration.class)
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Configuration injectConfigurationValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Boolean injectBooleanValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @Typed(EEnumLiteral.class)
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public EEnumLiteral injectEnumLiteralValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    public <T> T lookup(final OptimisationModule model, final String access) {
        log.info("Looking up configuration value {}", access);

        return helper.lookup(model, access);
    }
}
