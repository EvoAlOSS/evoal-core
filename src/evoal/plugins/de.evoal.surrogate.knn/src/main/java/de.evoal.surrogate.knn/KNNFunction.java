package de.evoal.surrogate.knn;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.surrogate.api.function.ModelFunction;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Slf4j
public class KNNFunction extends ModelFunction {

    @Getter
    private @NonNull List<Pair<double[], Double>> trainingData;

    @Getter
    private EObjectPairStreamSupplier trainingDataSupplier;

    private final @NonNull Function<TypedEObject, double[]> producer;
    private final @NonNull BiConsumer<TypedEObject, Double> consumer;

    @Getter
    private int k;

	public KNNFunction(final Space input, final Space output, final EObjectPairStreamSupplier data, final int k) {
		super("de.evoal.surrogate.knn.ml.knn", input, output);

        final EStructuralFeature feature = output.iterator().next();

        producer = eObject -> input.stream()
                                                .mapToDouble(eObject::eGetAsDouble)
                                                .toArray();

        consumer = (typedEObject, aDouble) -> typedEObject.eSet(feature, aDouble);

        trainingData = data.get()
                .map(p -> Pair.create(
                        input.stream().mapToDouble(p.getFirst()::eGetAsDouble).toArray(),
                        p.getSecond().eGetAsDouble(output.iterator().next())
                ))
                .toList();

        this.k = k;
        this.trainingDataSupplier = data;

        log.info("Calculating KNN prediction using {} elements out of {} training points.", k, trainingData.size());
	}

    @Override
    public void apply(@NonNull TypedEObject input, @NonNull TypedEObject output) {
        final EuclideanDistance euclideanDistance = new EuclideanDistance();
        final List<Pair<Double, Double>> list = new ArrayList<>();

        // Calculate distance to all training points and then sort according to distance
        trainingData.forEach(point -> {
            list.add(new Pair<>(euclideanDistance.compute(producer.apply(input), point.getKey()), point.getValue()));
        });
        list.sort(new DistanceComparator());

        // Fetch top k points and calculate average of y value
        final double average =
            list.stream()
                .limit(k)
                .mapToDouble(Pair::getValue)
                .summaryStatistics()
                .getAverage();

        // Store information
        consumer.accept(input, average);
    }
}
