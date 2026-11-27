package de.evoal.core.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.cdi.Commandline;

public class CommandlineParametersTest {
    static final class SearchEntries {
        @Commandline(main = "search", name = "search:configuration-file", doc = "The configuration.")
        static final String CONFIGURATION_FILE = "search:configuration-file";

        @Commandline(main = {"search", "evaluation"}, name = "search:output-folder", doc = "The output.")
        static final String OUTPUT_FOLDER = "search:output-folder";

        static final String INTERNAL = "search:internal";
    }

    static final class GeneralEntries {
        @Commandline(main = "", name = "core:seed", doc = "The seed.")
        static final String SEED = "core:seed";

        @Commandline(main = "serch", name = "search:misspelt", doc = "Names an application that does not exist.")
        static final String MISSPELT = "search:misspelt";
    }

    @Test
    public void theParametersAreGroupedByTheirApplications() {
        final Map<String, List<Commandline>> parameters = CommandlineParameters.byApplication(List.of(SearchEntries.class, GeneralEntries.class));

        Assertions.assertEquals(List.of("search:configuration-file", "search:output-folder"), names(parameters.get("search")));
        Assertions.assertEquals(List.of("search:output-folder"), names(parameters.get("evaluation")));
        Assertions.assertEquals(List.of("core:seed"), names(parameters.get(CommandlineParameters.GENERAL)));
    }

    @Test
    public void aParameterOfAnApplicationThatIsNotInstalledIsReported() {
        final Map<String, List<Commandline>> parameters = CommandlineParameters.byApplication(List.of(SearchEntries.class, GeneralEntries.class));

        Assertions.assertEquals(Map.of("serch", List.of("search:misspelt")),
                                CommandlineParameters.unknownApplications(parameters, Set.of("search", "evaluation")));
        Assertions.assertEquals(Map.of("evaluation", List.of("search:output-folder"), "serch", List.of("search:misspelt")),
                                CommandlineParameters.unknownApplications(parameters, Set.of("search")));
    }

    @Test
    public void generalParametersNameNoApplication() {
        final Map<String, List<Commandline>> parameters = CommandlineParameters.byApplication(List.of(GeneralEntries.class));
        parameters.remove("serch");

        Assertions.assertTrue(CommandlineParameters.unknownApplications(parameters, Set.of()).isEmpty());
    }

    /**
     * @return The sorted names (the order of {@code getDeclaredFields} is not specified).
     */
    private static List<String> names(final List<Commandline> annotations) {
        return annotations.stream().map(Commandline::name).sorted().toList();
    }
}
