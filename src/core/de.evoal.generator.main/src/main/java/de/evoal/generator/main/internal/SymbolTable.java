package de.evoal.generator.main.internal;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    /**
     * If we have an outer scope.
     */
    private final SymbolTable parent;

    /**
     * The symbols
     */
    private final Map<String, Object> symbols = new HashMap<>();

    public SymbolTable(final SymbolTable parent) {
        this.parent = parent;
    }

    public SymbolTable(final SymbolTable parent, final Map<String, Object> symbols) {
        this.parent = parent;
        this.symbols.putAll(symbols);
    }

    public void bind(final String name, final Object obj) {
        symbols.put(name, obj);
    }

    public Object get(final String name) {
        if(symbols.containsKey(name)) {
            return symbols.get(name);
        }

        if(parent != null) {
            return parent.get(name);
        }

        return null;
    }

    /**
     * @return All visible (non-hidden variable bindings.
     */
    public Map<String, Object> getVariables() {
        Map<String, Object> variables = new HashMap<>();
        
        collectVariables(variables);

        return variables;
    }

    private void collectVariables(final Map<String, Object> entries) {
        if(parent != null) {
            parent.collectVariables(entries);
        }

        entries.putAll(symbols);
    }
}
