package de.evoal.surrogate.knn;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.ListBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.training.AbstractModelLearner;
import de.evoal.surrogate.api.training.ModelLearner;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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
    public ModelLearner init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        k = helper.lookup(configuration, KNNLerner.PARAMETER_K);

        return this;
    }

    @Override
    public void learn() {
    }

    @Override
	public @NonNull ModelFunction toFunction() {
        final EObjectStreamSupplier objectStream = new ListBasedEObjectStreamSupplier(trainingData);
        final EObjectPairStreamSupplier pairStream = EObjectPairStreamFactory.createFromList(inputFeatures, outputFeatures, objectStream);

		return new KNNFunction(inputFeatures, outputFeatures, pairStream, k);
	}
}