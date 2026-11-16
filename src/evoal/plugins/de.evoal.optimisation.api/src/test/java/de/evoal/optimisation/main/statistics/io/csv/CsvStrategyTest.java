package de.evoal.optimisation.main.statistics.io.csv;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.optimisation.main.search.HeuristicSearchUtils;

public class CsvStrategyTest {
    private static final List<Column> HEADER = List.of(new Column("generation", ColumnType.Integer),
                                                       new Column("x", ColumnType.Double));

    private static final List<Column> OTHER_HEADER = List.of(new Column("generation", ColumnType.Integer));

    private final WriterContext context = new WriterContext();

    @TempDir
    private Path outputFolder;

    private final CsvStrategy strategy = new CsvStrategy();

    private void inject(final Class<?> owner, final String name, final Object value) throws Exception {
        final Field field = owner.getDeclaredField(name);
        field.setAccessible(true);
        field.set(strategy, value);
    }

    @BeforeEach
    public void injectDependencies() throws Exception {
        final File folder = outputFolder.toFile();
        inject(CsvStrategy.class, "outputFolder", folder);
        inject(WriterStrategy.class, "context", context);
    }

    private List<String> linesOf(final String fileName) throws IOException {
        final Path file = outputFolder.resolve(fileName);
        return Files.readAllLines(file);
    }

    @Nested
    @DisplayName("given two writers with the same name and the same header")
    class SameNameAndSameHeader {
        @Test
        public void bothWritersAppendToOneCompleteFile() throws Exception {
            // given
            final Writer firstRun = strategy.create("candidates-per-iteration", HEADER);
            final Writer secondRun = strategy.create("candidates-per-iteration", HEADER);

            // when
            firstRun.addRecord(new Object[] {0, 1.5});
            secondRun.addRecord(new Object[] {0, 2.5});
            strategy.closeAll();

            // then
            final List<String> lines = linesOf("candidates-per-iteration.csv");
            Assertions.assertEquals(List.of("generation,x", "0,1.5", "0,2.5"), lines);
        }
    }

    @Nested
    @DisplayName("given an output that already exists with a different header")
    class SameNameAndDifferentHeader {
        @Test
        public void creatingTheSecondWriterFails() throws Exception {
            // given
            strategy.create("candidates-per-iteration", HEADER);

            // when / then
            Assertions.assertThrows(IllegalStateException.class,
                                    () -> strategy.create("candidates-per-iteration", OTHER_HEADER));
        }
    }

    @Nested
    @DisplayName("given writers with different names")
    class DifferentNames {
        @Test
        public void eachWriterGetsItsOwnFile() throws Exception {
            // given
            final Writer best = strategy.create("best-candidate-per-iteration", HEADER);
            final Writer all = strategy.create("candidates-per-iteration", OTHER_HEADER);

            // when
            best.addRecord(new Object[] {0, 1.5});
            all.addRecord(new Object[] {0});
            strategy.closeAll();

            // then
            Assertions.assertEquals(List.of("generation,x", "0,1.5"), linesOf("best-candidate-per-iteration.csv"));
            Assertions.assertEquals(List.of("generation", "0"), linesOf("candidates-per-iteration.csv"));
        }
    }

    @Nested
    @DisplayName("given a plain search without context columns")
    class PlainSearch {
        @Test
        public void theFileHasNoRunOrTargetColumn() throws Exception {
            // given
            final Writer writer = strategy.create("candidates-per-iteration", HEADER);

            // when
            writer.addRecord(new Object[] {0, 1.5});
            strategy.closeAll();

            // then
            final List<String> lines = linesOf("candidates-per-iteration.csv");
            Assertions.assertEquals("generation,x", lines.get(0));
        }
    }

    @Nested
    @DisplayName("given an evaluation with a repetition column in the context")
    class EvaluationRepetition {
        @BeforeEach
        public void addRepetitionColumn() {
            HeuristicSearchUtils.addColumn(context, "repetition", ColumnType.Integer, 3);
        }

        @Test
        public void theRepetitionColumnComesFirst() throws Exception {
            // given
            final Writer writer = strategy.create("candidates-per-iteration", HEADER);

            // when
            writer.addRecord(new Object[] {0, 1.5});
            strategy.closeAll();

            // then
            final List<String> lines = linesOf("candidates-per-iteration.csv");
            Assertions.assertEquals(List.of("repetition,generation,x", "3,0,1.5"), lines);
        }
    }
}
