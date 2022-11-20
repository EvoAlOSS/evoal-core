package de.evoal.core.main.ea.gene;

import io.jenetics.util.RandomRegistry;

public class DynamicIntegerGene extends DynamicGene<Integer> {
    protected DynamicIntegerGene(final Integer data) {
        super(data);
    }

    @Override
    protected boolean isValidValue(final Integer value) {
        if(value == null) {
            return false;
        }

        return true;
    }

    /**
     * @return
     */
    @Override
    public DynamicGene newInstance() {
        int value = RandomRegistry.random().nextInt();

        while(!isValidValue(value)) {
            value = RandomRegistry.random().nextInt();
        }

        return new DynamicIntegerGene(value);
    }
}
