package de.evoal.optimisation.main.constraints.correlation;

import de.evoal.optimisation.api.constraints.model.DataConstraints;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.api.correlations.RangedCorrelation;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.optimisation.main.constraints.correlation.el.AstHelper;
import de.evoal.core.api.languages.base.BaseLanguageHelper;
import de.evoal.core.api.languages.base.LogHelper;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Call;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;

import java.util.Objects;
import java.util.Optional;

/**
 * Extracts all correlations from the DVL AST.
 */
@ApplicationScoped
@Slf4j
public class CorrelationsProducer {

    private PropertiesSpecification specification;

    @Produces
    @ApplicationScoped
    public Correlations createCorrelations(final DataConstraints constraints,
                                           final @Named("genotype-specification") PropertiesSpecification specification) {
        this.specification = specification;
        final Correlations correlations = new Correlations();

        constraints.stream()
                        .forEach(p -> {
                            final DataDescription context = p.getFirst();

                            p.getSecond()
                             .stream()
                             .map(BaseLanguageHelper::findCall)
                             .filter(Objects::nonNull)
                             .map(Call.class::cast)
                             .filter(c -> "connection".equals(((de.evoal.languages.model.base.DefinedFunctionName)c.getFunction()).getDefinition().getName()))
                             .map(c -> convert(c, context))
                             .filter(Optional::isPresent)
                             .map(Optional::get)
                             .forEach(correlations.getCorrelations()::add);
                        });

        log.info("Loaded {} correlations.", correlations.getCorrelations().size());

        return correlations;
    }

    private Optional<Correlation> convert(final Call constraint, DataDescription context) {
        if(constraint.getParameters().size() == 3) {
            final Correlation result = new Correlation();
            result.setChromosomeOne(AstHelper.findChromosomeIndex(specification, constraint.getParameters().get(0)));
            result.setChromosomeTwo(AstHelper.findChromosomeIndex(specification, constraint.getParameters().get(1)));
            result.setCorrelationFactor(BaseLanguageHelper.findNumber(constraint.getParameters().get(2)).doubleValue());

            return Optional.of(result);
        } else if(constraint.getParameters().size() == 5) {
            final RangedCorrelation result = new RangedCorrelation();
            result.setChromosomeOne(AstHelper.findChromosomeIndex(specification, constraint.getParameters().get(0)));
            result.setChromosomeTwo(AstHelper.findChromosomeIndex(specification, constraint.getParameters().get(2)));
            result.setCorrelationFactor(BaseLanguageHelper.findNumber(constraint.getParameters().get(4)).doubleValue());

            result.setChromosomeOneRange(AstHelper.findRange(constraint.getParameters().get(1)));
            result.setChromosomeTwoRange(AstHelper.findRange(constraint.getParameters().get(3)));

            return Optional.of(result);
        } else {
            LogHelper.parameterMismatch(log, "connection", constraint, 3);
            return Optional.empty();
        }
    }
}
