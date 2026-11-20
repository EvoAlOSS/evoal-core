package de.evoal.core.main.credits;

import java.util.List;

/**
 * The credits of an installation, collected from the jars of {@code modules/} and
 *   {@code plugins/} by {@link CreditsCollector}.
 *
 * @param modules The EvoAl modules, core first, then the plugins by name.
 * @param evoalComponents EvoAl's own shipped libraries that are no module, e.g. the language
 *   modules in {@code modules/}.
 * @param libraries The third-party libraries, sorted by artifact id.
 */
public record InstalledCredits(List<InstalledModule> modules,
                               List<SbomComponent> evoalComponents,
                               List<InstalledLibrary> libraries) {
    public InstalledCredits {
        modules = CreditsFiles.copyOrEmpty(modules);
        evoalComponents = CreditsFiles.copyOrEmpty(evoalComponents);
        libraries = CreditsFiles.copyOrEmpty(libraries);
    }
}
