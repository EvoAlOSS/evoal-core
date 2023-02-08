package de.evoal.core.main.ea.constraints.el;

import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.el.Call;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.slf4j.Logger;

public final class LogHelper {
    private LogHelper() {}

    public static void parameterMismatch(final Logger log, final String name, final Call call, final int expectedParameters) {
        final Serializer serializer = new DataDescriptionLanguageStandaloneSetup()
                .createInjector()
                .getInstance(Serializer.class);

        final String representation = serializer.serialize(call).strip();

        log.error("Call to {} has not the correct number of parameters. Expected {} parameters. Skipping call '{}'.", name, expectedParameters, representation);
    }
}
