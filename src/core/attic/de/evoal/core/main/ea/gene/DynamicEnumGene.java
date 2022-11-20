package de.evoal.core.main.ea.gene;

import io.jenetics.util.RandomRegistry;

public class DynamicEnumGene extends DynamicGene<Integer> {
    private StringUniverse literalManager;

    protected DynamicEnumGene(final String data, final StringUniverse manager) {
        super(manager.toID(data));
        this.literalManager = manager;
    }

    @Override
    protected boolean isValidValue(final Integer value) {
        if(value == null) {
            return false;
        }

        return literalManager.isInRange(value);
    }

    /**
     * @return
     */
    @Override
    public DynamicGene newInstance() {
        int value = RandomRegistry.random().nextInt(0, literalManager.lastId() + 1);

        while(!isValidValue(value)) {
            value = RandomRegistry.random().nextInt();
        }

        return new DynamicEnumGene(literalManager.fetch(value), literalManager);
    }
}
