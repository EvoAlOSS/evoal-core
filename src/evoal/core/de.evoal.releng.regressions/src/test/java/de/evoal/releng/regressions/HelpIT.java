package de.evoal.releng.regressions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Runs the help of the assembled release ({@code bin/evoal-print-help.sh}) and checks that
 *   every application lists the parameters it reads (#365), and that no documented parameter
 *   names an application that is not installed.
 *
 * <p>System properties: {@code evoal.regressions.root} (root folder of the repository) and
 *   {@code evoal.regressions.shell} (default {@code bash}), as for {@link RegressionIT}.</p>
 */
public class HelpIT {
    /**
     * The line that starts the section of an application.
     */
    private static final String APPLICATION = "  -Bcore:main=";

    /**
     * The output of the help.
     */
    private static String help;

    @BeforeAll
    static void runHelp() throws IOException, InterruptedException {
        final Path root = Path.of(System.getProperty("evoal.regressions.root", "../../../.."));
        final Path release = root.resolve("evoal").toAbsolutePath();
        final String shell = System.getProperty("evoal.regressions.shell", "bash");

        final ProcessBuilder builder = new ProcessBuilder(shell, release.resolve("bin/evoal-print-help.sh").toString());
        builder.environment().put("EVOAL_HOME", release.toString());
        builder.environment().remove("EVOAL_DEBUG");
        builder.environment().remove("EVOAL_VM");
        builder.redirectErrorStream(true);

        final Process process = builder.start();
        help = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        Assertions.assertTrue(process.waitFor(2, TimeUnit.MINUTES), "the help ends");
        Assertions.assertEquals(0, process.exitValue(), help);
    }

    /**
     * @return The parameters ({@code -B<name>=} lines) of every application section.
     */
    private static Map<String, List<String>> parametersByApplication() {
        final Map<String, List<String>> parameters = new HashMap<>();
        List<String> current = null;

        for(final String line : help.split("\\r?\\n")) {
            if(line.startsWith(APPLICATION)) {
                current = new ArrayList<>();
                parameters.put(line.substring(APPLICATION.length()).strip(), current);
            } else if(line.startsWith("-----")) {
                current = null;
            } else if(current != null && line.startsWith("    -B") && line.strip().endsWith("=")) {
                final String parameter = line.strip();
                current.add(parameter.substring(2, parameter.length() - 1));
            }
        }

        return parameters;
    }

    private static void assertParameters(final String application, final String ... expected) {
        final List<String> listed = parametersByApplication().get(application);

        Assertions.assertNotNull(listed, "the help lists the application " + application + ":\n" + help);
        Assertions.assertEquals(List.of(expected).stream().sorted().toList(), listed.stream().sorted().toList(),
                                "parameters of " + application);
    }

    @Test
    public void theSearchListsItsParameters() {
        assertParameters("heuristic-search",
                         "optimisation:optimisation-configuration-file", "optimisation:evaluation-output-folder",
                         "surrogate:pre-trained", "surrogate:training-data-file");
    }

    @Test
    public void theEvaluationListsItsParameters() {
        assertParameters("heuristic-search-evaluation",
                         "optimisation:optimisation-configuration-file", "optimisation:evaluation-output-folder",
                         "optimisation:evaluation-iterations", "optimisation:target-points-file",
                         "surrogate:pre-trained", "surrogate:training-data-file");
    }

    @Test
    public void theTrainingListsItsParameters() {
        assertParameters("surrogate-training", "surrogate:configuration-file");
    }

    @Test
    public void thePipelineRunnerListsItsParameters() {
        assertParameters("de.evoal.pipeline.pipeline-runner", "pipeline:configuration-file");
    }

    @Test
    public void theArffApplicationsListTheirParameters() {
        assertParameters("convert-arff-to-json", "arff:input", "arff:ddl-specification", "arff:output");
        assertParameters("extract-data-definition-from-arff", "arff:input", "arff:output");
    }

    @Test
    public void everyParameterNamesAnInstalledApplication() {
        Assertions.assertFalse(help.contains("which is not installed"), help);
    }
}
