package de.evoal.core.api.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Specification of a statistics column
 */
@AllArgsConstructor
@Data
public class Column {
    /**
     * Name of the column.
     */
    @Getter
    private String name;

    /**
     * Type of the column.
     */
    @Getter
    private ColumnType type;
}
