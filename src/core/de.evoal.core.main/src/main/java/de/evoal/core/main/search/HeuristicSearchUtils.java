package de.evoal.core.main.search;

import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.WriterContext;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * Helper functions for loading stuff for heuristic search.
 */
@Slf4j
public final class HeuristicSearchUtils {
    private HeuristicSearchUtils(){
    }

    public static Column addColumn(final WriterContext context, final String name, final ColumnType type, final Object value) {
        final Column col = new Column(name, type);
        context.addColumn(col);
        context.bindColumn(col, value);

        return col;
    }

    public static File calculateOutputBaseDir(final File outputFolder, final File heuristicFile) {
        return new File(outputFolder, heuristicFile.getName().split("\\.")[0]);
    }
}
