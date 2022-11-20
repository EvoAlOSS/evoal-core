package de.evoal.core.main.search;

import de.evoal.core.api.statistics.Column;
import de.evoal.core.api.statistics.ColumnType;
import de.evoal.core.api.statistics.WriterContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static File calculateOutputBaseDir(final File predictiveFile, final File heuristicFile) {
        String outputDirname = predictiveFile.toString();
        outputDirname = outputDirname.split("\\.")[0];
        outputDirname = outputDirname.replace("input/", "output/");
        final File outputDir = new File(outputDirname);

        return new File(outputDir, heuristicFile.getName().split("\\.")[0]);
    }
}
