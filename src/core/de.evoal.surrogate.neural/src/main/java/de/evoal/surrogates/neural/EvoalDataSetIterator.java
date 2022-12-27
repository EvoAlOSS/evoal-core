package de.evoal.surrogates.neural;

import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import org.nd4j.common.primitives.Pair;

import java.util.Iterator;

public class EvoalDataSetIterator implements Iterable<Pair<double [], double []>> {
    private final PropertiesPairStreamSupplier provider;

    public EvoalDataSetIterator(final PropertiesPairStreamSupplier provider) {
        this.provider = provider;
    }

    @Override
    public Iterator<Pair<double[], double[]>> iterator() {
        return provider.get()
                       .map(p -> new Pair<>(p.getFirst().getValues(), p.getSecond().getValues()))
                       .iterator();
    }
}
