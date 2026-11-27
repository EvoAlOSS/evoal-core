package de.evoal.core.main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import de.evoal.core.api.cdi.Commandline;

/**
 * The command line parameters that the blackboard entry classes document with
 *   {@link Commandline}, grouped by the application ({@code -Bcore:main}) that reads them.
 */
final class CommandlineParameters {
    /**
     * The application name of a parameter that every application reads.
     */
    static final String GENERAL = "";

    private CommandlineParameters() {
    }

    /**
     * @param entries The blackboard entry classes.
     * @return The documented parameters by the application they name ({@link #GENERAL} for the
     *   general ones), in the order of the classes and their fields.
     */
    static Map<String, List<Commandline>> byApplication(final Collection<Class<?>> entries) {
        final Map<String, List<Commandline>> parameters = new LinkedHashMap<>();

        for(final Class<?> clazz : entries) {
            for(final Field field : clazz.getDeclaredFields()) {
                final Commandline annotation = field.getAnnotation(Commandline.class);
                if(annotation == null) {
                    continue;
                }

                for(final String application : annotation.main()) {
                    parameters.computeIfAbsent(application, name -> new ArrayList<>())
                              .add(annotation);
                }
            }
        }

        return parameters;
    }

    /**
     * @param parameters The parameters by application, see {@link #byApplication(Collection)}.
     * @param applications The names of the installed applications.
     * @return The names of the parameters by the application they name that is not installed,
     *   sorted by application; empty if every parameter names an installed application or is
     *   general.
     */
    static SortedMap<String, List<String>> unknownApplications(final Map<String, List<Commandline>> parameters,
                                                               final Set<String> applications) {
        final SortedMap<String, List<String>> unknown = new TreeMap<>();

        parameters.forEach((application, annotations) -> {
            if(!GENERAL.equals(application) && !applications.contains(application)) {
                unknown.put(application, annotations.stream().map(Commandline::name).toList());
            }
        });

        return unknown;
    }
}
