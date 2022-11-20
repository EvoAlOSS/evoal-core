package de.evoal.core.main.ea.gene;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class StringUniverse {

    private final Map<String, Integer> literals = new HashMap<>();

    @Getter
    @Setter
    private boolean sealed = false;

    public int toID(final String data) {
        Integer id = literals.get(data);

        if(id == null && isSealed()) {
            throw new IllegalStateException("The string '" + data + "' is an unknown literal.");
        } else if(id == null) {
            id = literals.size();
            literals.put(data, id);
        }

        return id;
    }

    public boolean isInRange(final int value) {
        return value >= 0 && value < literals.size();
    }

    public int lastId() {
        return literals.size() - 1;
    }

    public String fetch(final int value) {
        return literals.entrySet()
                       .stream()
                       .filter(e -> e.getValue().intValue() == value)
                       .findFirst()
                       .get()
                       .getKey();
    }
}
