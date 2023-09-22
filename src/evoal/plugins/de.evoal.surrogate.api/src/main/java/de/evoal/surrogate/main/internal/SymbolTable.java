package de.evoal.surrogate.main.internal;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final SymbolTable parentTable;
    private final Map<String, Object> bindings = new HashMap<>();

    public SymbolTable(final SymbolTable symbolTable) {
        this.parentTable = symbolTable;
    }

    public void put(final String name, final Object value) {
        this.bindings.put(name, value);
    }

    public Object get(final String name) {
        if(bindings.containsKey(name)) {
            return bindings.get(name);
        }

        if(parentTable != null) {
            return parentTable.get(name);
        }

        return null;
    }
}
