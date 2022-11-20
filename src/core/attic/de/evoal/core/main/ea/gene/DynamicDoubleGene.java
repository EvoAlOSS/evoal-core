package de.evoal.core.main.ea.gene;

import io.jenetics.util.RandomRegistry;

public class DynamicDoubleGene extends DynamicGene<Double> {
    protected DynamicDoubleGene(final Double data) {
        super(data);
    }

    /**
     * @param value The value to check.
     * @return
     */
    @Override
    protected boolean isValidValue(final Double value) {
        if(value == null) {
            return false;
        }

        return true; // TODO
    }

    /**
     * @return
     */
    @Override
    public DynamicGene newInstance() {
        double value = RandomRegistry.random().nextDouble();

        while(!isValidValue(value)) {
            value = RandomRegistry.random().nextDouble();
        }

        return new DynamicDoubleGene(value);
    }
}
