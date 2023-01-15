package de.evoal.core.main.ea.constraints.correlation;

import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.core.main.ea.constraints.correlation.el.AstHelper;
import de.evoal.core.main.ea.constraints.el.ElHelper;
import de.evoal.core.api.ea.correlations.Correlation;
import de.evoal.core.api.ea.correlations.Correlations;
import de.evoal.core.api.ea.correlations.RangedCorrelation;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.el.Call;
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

    private CustomCodec codec;

    private PropertiesSpecification specification;

    @Produces
    @ApplicationScoped
    public Correlations createCorrelations(final DataConstraints constraints,
                                           final @Named("genotype-specification") PropertiesSpecification specification,
                                           final CustomCodec codec) {
        this.codec = codec;
        this.specification = specification;
        final Correlations correlations = new Correlations(codec);

        constraints.stream()
                        .forEach(p -> {
                            final DataDescription context = p.getFirst();

                            p.getSecond()
                             .stream()
                             .map(ElHelper::findCall)
                             .filter(Objects::nonNull)
                             .map(Call.class::cast)
                             .filter(c -> "connection".equals(((de.evoal.languages.model.ddl.FunctionName)c.getFunction()).getDefinition().getName()))
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
            result.setCorrelationFactor(ElHelper.findNumber(constraint.getParameters().get(2)).doubleValue());
            result.setCodec(codec);

            return Optional.of(result);
        } else if(constraint.getParameters().size() == 5) {
            final RangedCorrelation result = new RangedCorrelation();
            result.setChromosomeOne(AstHelper.findChromosomeIndex(specification, constraint.getParameters().get(0)));
            result.setChromosomeTwo(AstHelper.findChromosomeIndex(specification, constraint.getParameters().get(2)));
            result.setCorrelationFactor(ElHelper.findNumber(constraint.getParameters().get(4)).doubleValue());
            result.setCodec(codec);

            result.setChromosomeOneRange(AstHelper.findRange(constraint.getParameters().get(1)));
            result.setChromosomeTwoRange(AstHelper.findRange(constraint.getParameters().get(3)));

            return Optional.of(result);
        } else {
            log.error("connection constraint has wrong number of parameters: {}", constraint.getParameters().size());
            return Optional.empty();
        }
    }
}
