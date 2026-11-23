package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/**
 * The switches {@code --credits}, {@code --praise} and {@code --licenses} of EvoAl, which run
 *   without the CDI container:
 * <ul>
 *   <li>{@code --credits}: lists the libraries of the installation ({@link CreditsPrinter});</li>
 *   <li>{@code --credits bibtex}: prints the citations as BibTeX;</li>
 *   <li>{@code --credits release-files <folder>}: writes the licence files of a release
 *     ({@link ReleaseFiles}).</li>
 * </ul>
 * The installation consists of the jars of the module path ({@code modules/} and the folders
 *   in {@code plugins/}), so the libraries of installed external plugins are included.
 */
public final class CreditsCommand {
    /**
     * The argument that prints the citations as BibTeX.
     */
    public static final String BIBTEX = "bibtex";

    /**
     * The argument that writes the licence files of a release.
     */
    public static final String RELEASE_FILES = "release-files";

    /**
     * The switches that run this command; they are aliases.
     */
    public static final Set<String> SWITCHES = Set.of("--credits", "--praise", "--licenses");

    private CreditsCommand() {
    }

    /**
     * @return Whether the argument is one of the {@link #SWITCHES}.
     */
    public static boolean isCreditsSwitch(final String argument) {
        return SWITCHES.contains(argument);
    }

    /**
     * Runs the command.
     *
     * @param arguments The command line: a switch of {@link #SWITCHES}, optionally followed by
     *   {@value #BIBTEX} or by {@value #RELEASE_FILES} and a folder.
     * @param out Receives the output.
     * @return The exit code: 0 on success, 1 for wrong arguments or a failure.
     */
    public static int run(final List<String> arguments, final PrintStream out) {
        final List<String> options = arguments.subList(1, arguments.size());
        final boolean listsCredits = options.isEmpty();
        final boolean printsBibTeX = options.equals(List.of(BIBTEX));
        final boolean writesReleaseFiles = options.size() == 2 && options.get(0).equals(RELEASE_FILES);

        if(!listsCredits && !printsBibTeX && !writesReleaseFiles) {
            out.println("Usage: " + arguments.get(0) + " [" + BIBTEX + " | " + RELEASE_FILES + " <folder>]");
            return 1;
        }

        try {
            final List<Path> jars = InstalledJars.moduleJars();
            final Path coreFolder = InstalledJars.coreFolder();
            final InstalledCredits credits = CreditsCollector.collect(jars, coreFolder);

            if(printsBibTeX) {
                CreditsPrinter.printBibTeX(out, credits);
            } else if(writesReleaseFiles) {
                final Path folder = Path.of(options.get(1));
                ReleaseFiles.write(credits, folder);
            } else {
                CreditsPrinter.printCredits(out, credits);
            }

            return 0;
        } catch(final IOException e) {
            out.println("Cannot collect the credits: " + e.getMessage());
            return 1;
        }
    }
}
