package de.evoal.optimisation.api.statistics.writer;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

/**
 * Writer context for injecting columns into a writer.
 */
@ApplicationScoped
public class WriterContext {
    /**
     * List of columns to prepend to a newly created writer.
     */
    protected final List<Column> columns = new LinkedList<>();

    /**
     * Bindings of columns to their values.
     */
    protected final Map<Column, Object> values = new HashMap<>();

    /**
     * Adds a new column to the context.
     *
     * @param column The column to add.
     */
    public void addColumn(final Column column) {
        if(!columns.contains(column)) {
            columns.add(column);
        }
    }

    /**
     * Binds a column to a value.
     *
     * @param column The column to bind.
     * @param value The value to bind.
     */
    public void bindColumn(final Column column, final Object value) {
        values.put(column, value);
    }

    public int size() {
        return columns.size();
    }

    /**
     * @return A unmodifiable list of columns.
     */
    public List<Column> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    /**
     * @param column The column to lookup.
     * @return Returns the value for the column.
     */
    public Object get(final Column column) {
        return values.get(column);
    }
}
