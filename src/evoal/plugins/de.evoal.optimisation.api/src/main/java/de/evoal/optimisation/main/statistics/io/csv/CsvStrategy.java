package de.evoal.optimisation.main.statistics.io.csv;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Named("csv")
public class CsvStrategy extends WriterStrategy {
    @Inject @BlackboardValue(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER)
    private File outputFolder;

    private final Map<String, CsvWriter> writerMap = new HashMap<>();

    @Override
    public void close(final Writer writer) {
        writer.flush();
    }

    @Override
    public Writer create(final String name, final List<Column> header) throws WriterException {
        if(writerMap.containsKey(name)) {
            return writerMap.get(name);
        }

        final File csvFile = new File(outputFolder, name + ".csv");
        csvFile.getParentFile().mkdirs();

        final CsvWriter writer = new CsvWriter(csvFile, context, header);
        writerMap.put(name, writer);

        return writer;
    }

    protected void finalize() {
        writerMap.values().forEach(Writer::close);
    }
}

