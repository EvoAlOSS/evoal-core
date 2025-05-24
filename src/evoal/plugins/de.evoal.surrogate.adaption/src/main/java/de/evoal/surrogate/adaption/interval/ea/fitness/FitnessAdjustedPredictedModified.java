package de.evoal.surrogate.adaption.interval.ea.fitness;

import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import org.apache.commons.math3.util.Pair;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Dependent
@Named("de.evoal.surrogate.adaption.interval.optimisation.adjusted-modified-fitness")
public class FitnessAdjustedPredictedModified extends AbstractFitnessAdjustedPredicted {
}
