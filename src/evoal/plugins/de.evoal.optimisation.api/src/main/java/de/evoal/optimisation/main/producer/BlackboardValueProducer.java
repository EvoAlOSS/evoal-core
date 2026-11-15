package de.evoal.optimisation.main.producer;

import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.board.Blackboard;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

import java.io.File;
import java.util.Map;

@ApplicationScoped
public class BlackboardValueProducer {
    @Produces
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION)
    public Integer injectIntegerValue(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);
        final Object result = board.get(value.value());

        if(result instanceof Number) {
            return ((Number)result).intValue();
        } else if(result instanceof String) {
            return Integer.parseInt((String)result);
        }

        throw new IllegalArgumentException("Unable to handle type " + result.getClass());
    }

    @Produces
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION)
    public String injectStringValue(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);
        final Object result = board.get(value.value());

        return castValue(result);
    }

    @Produces
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION)
    public File injectFileValue(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);
        final Object result = board.get(value.value());
        return new File(result.toString());
    }

    @Produces
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION)
    public Map<String, Object> injectMapValue(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);

        return castValue(board.get(value.value()));
    }

    @Produces
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION)
    public Space injectSpace(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);

        return castValue(board.get(value.value()));
    }

    @Produces
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION)
    public TypedEObject injectEObject(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);

        return castValue(board.get(value.value()));
    }

    private <T> T castValue(final Object object) {
        return (T) object;
    }
}
