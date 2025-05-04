package de.evoal.pipeline.api.sequence;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.languages.model.base.definitions.DataDescription;

import java.util.Map;

/**
 * A sequence to get data from.
 */
public interface Sequence extends EvoalComponent<Sequence> {

    /**
     * @return The initial value of {@link #getVariable()}.
     */
    public Object getInitialValue();

    /**
     * @return The variable to write.
     */
    public DataDescription getVariable();

    /**
     * @return The next value.
     */
    Object next();

    /**
     * Sets the symbol table to use.
     *
     * @param symbolTable The symbol table.
     */
    public void setSymbolTable(final Map<DataDescription, Object> symbolTable);
}
