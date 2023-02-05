package de.evoal.core.main.producer;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.ol.OptimisationModel;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
@Slf4j
public class ConfigurationValueProducer {
    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public Integer injectIntegerValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public Double injectDoubleValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public String injectStringValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public final Array injectArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public final Instance injectInstanceValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }

    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public Boolean injectBooleanValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return lookup(board.get(value.entry()), value.access());
    }
    
    @Produces
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "")
    public double [] injectDoubleArrayValue(final InjectionPoint ip, final Blackboard board) {
        final ConfigurationValue value = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return (ConfigurationValueProducer.<Array>lookup(board.get(value.entry()), value.access()))
                .getValues()
                .stream()
                .mapToDouble(x -> ((DoubleLiteral)(((LiteralValue)x).getLiteral())).getValue())
                .toArray();
    }

    private static <T> T lookup(final OptimisationModel model, final String access) {
        return LanguageHelper.lookup(model.getInstance(), access);
    }
}
