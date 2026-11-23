package de.evoal.surrogate.knn;

import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.ListBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.training.AbstractModelLearner;
import de.evoal.surrogate.api.training.ModelLearner;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dependent
@Named("de.evoal.surrogate.knn.ml.knn-learner")
@Slf4j
public class KNNLerner extends AbstractModelLearner {
    public static final String PARAMETER_K = "k";

    @Inject
    private AttributeHelper helper;

    private int k;

    private final List<TypedEObject> trainingData = new ArrayList<>();

    @Override
    public void add(final TypedEObject features) {
        trainingData.add(features);
    }

    @Override
    public ModelLearner init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        k = helper.lookup(configuration, KNNLerner.PARAMETER_K);

        return this;
    }

    /**
     * kNN has no training; it only warns if k exceeds the number of training rows.
     */
    @Override
    public void learn() {
        constantModelWarning(k, trainingData.size()).ifPresent(log::warn);
    }

    /**
     * @param k The number of neighbours.
     * @param rows The number of training rows.
     * @return A warning if k exceeds the number of training rows: every prediction then
     *   averages all rows, so the model is constant.
     */
    static Optional<String> constantModelWarning(final int k, final int rows) {
        if(k <= rows) {
            return Optional.empty();
        }

        return Optional.of("k = " + k + " exceeds the number of training rows (" + rows + "); every prediction averages all rows, "
                           + "so the kNN model is constant.");
    }

    @Override
	public @NonNull ModelFunction toFunction() {
        final EObjectStreamSupplier objectStream = new ListBasedEObjectStreamSupplier(trainingData);
        final EObjectPairStreamSupplier pairStream = EObjectPairStreamFactory.createFromList(inputFeatures, outputFeatures, objectStream);

		return new KNNFunction(inputFeatures, outputFeatures, pairStream, k);
	}
}