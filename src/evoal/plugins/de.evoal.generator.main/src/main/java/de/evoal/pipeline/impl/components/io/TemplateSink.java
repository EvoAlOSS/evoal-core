package de.evoal.pipeline.impl.components.io;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import freemarker.cache.FileTemplateLoader;
import freemarker.core.TemplateClassResolver;
import freemarker.template.Configuration;
import freemarker.template.SimpleObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import de.evoal.core.api.provenance.RunRecord;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineSink;
import de.evoal.pipeline.api.values.PipelineValues;

/**
 * Renders a FreeMarker template with named {@link PipelineValues pipeline values} when the
 *   stream has ended (DL type {@code template}), e.g., a DDL module from the estimates of
 *   {@code 'correlation-estimation'}. The template sees every value under its name.
 * <p>
 * FreeMarker is configured so that the output does not depend on the platform and templates
 *   stay data-only: locale {@link Locale#ROOT}, numbers with a point, at most 16 decimals and
 *   never an exponent (e.g. {@code 0.8031}, {@code -0.0001} or {@code 1000}, valid DSL
 *   literals), a missing value is an error, only plain data is exposed
 *   ({@link SimpleObjectWrapper}), and {@code ?new} and {@code ?api} are disabled. A template
 *   can format a number differently, e.g. {@code ${c.coefficient?string("0.00")}}.
 */
@Dependent
@Named("de.evoal.pipeline.io.template")
@Slf4j
public class TemplateSink extends PipelineComponentImpl implements PipelineSink {
    /**
     * The format of numbers: no grouping, at most 16 decimals, no exponent.
     */
    private static final String NUMBER_FORMAT = "0.################";

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The file to write.
     */
    private File output;

    /**
     * The template file.
     */
    private File template;

    /**
     * The names of the values the template uses.
     */
    private List<String> values;

    /**
     * Creates a sink that is configured by {@link #init(EObject)}.
     */
    public TemplateSink() {
    }

    /**
     * Creates a sink without a DL configuration, e.g., for tests.
     *
     * @param template The template file.
     * @param output The file to write.
     * @param values The names of the values the template uses.
     */
    TemplateSink(final File template, final File output, final List<String> values) {
        this.template = template;
        this.output = output;
        this.values = List.copyOf(values);
    }

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        return object;
    }

    /**
     * @throws InitializationException if the step reads or writes data, or the template
     *   cannot be read.
     */
    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        if(!isEmpty(getReads()) || !isEmpty(getWrites())) {
            throw new InitializationException("'template' reads and writes no data; remove its 'reads' and 'writes'.");
        }

        template = new File(evaluator.attributeToString(configuration, "template"));
        output = new File(evaluator.attributeToString(configuration, "filename"));
        values = stringsOf(evaluator.attributeToJava(configuration, "values", EcorePackage.Literals.EJAVA_OBJECT));

        if(!template.isFile() || !template.canRead()) {
            throw new InitializationException("The template '" + template.getAbsolutePath() + "' cannot be read.");
        }

        return this;
    }

    @Override
    public void streamEnded() {
        final PipelineValues known = PipelineValues.of(getContext());
        final Map<String, Object> model = new LinkedHashMap<>();
        for(final String name : values) {
            model.put(name, known.get(name));
        }

        try {
            final Template parsed = configuration().getTemplate(template.getName());
            RunRecord.current().input(template.toPath());
            RunRecord.current().output(output.toPath());

            final File parent = output.getAbsoluteFile().getParentFile();
            if(parent != null) {
                Files.createDirectories(parent.toPath());
            }

            try(Writer writer = Files.newBufferedWriter(output.toPath(), StandardCharsets.UTF_8)) {
                parsed.process(model, writer);
            }
        } catch(final IOException | TemplateException e) {
            throw new IllegalStateException("Cannot render the template '" + template + "' into '" + output + "': "
                                            + e.getMessage(), e);
        }

        log.info("Rendered the template '{}' into '{}'.", template, output.getAbsolutePath());
    }

    private Configuration configuration() throws IOException {
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_34);
        configuration.setTemplateLoader(new FileTemplateLoader(template.getAbsoluteFile().getParentFile()));
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setLocale(Locale.ROOT);
        configuration.setNumberFormat(NUMBER_FORMAT);
        configuration.setBooleanFormat("c");
        configuration.setObjectWrapper(new SimpleObjectWrapper(Configuration.VERSION_2_3_34));
        configuration.setNewBuiltinClassResolver(TemplateClassResolver.ALLOWS_NOTHING_RESOLVER);
        configuration.setAPIBuiltinEnabled(false);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);

        return configuration;
    }

    /**
     * @throws InitializationException if the value is no array of strings.
     */
    private static List<String> stringsOf(final Object value) throws InitializationException {
        if(!(value instanceof List<?> list) || !list.stream().allMatch(String.class::isInstance)) {
            throw new InitializationException("'values' of 'template' must be an array of names, e.g. "
                                              + "[\"correlations\"].");
        }

        return list.stream()
                   .map(String.class::cast)
                   .toList();
    }

    private static boolean isEmpty(final Space space) {
        return space == null || space.isEmpty();
    }
}
