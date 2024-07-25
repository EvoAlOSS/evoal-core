package de.evoal.generator.main.internal;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesIOFactory;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.generator.*;
import de.evoal.languages.model.generator.util.GeneratorSwitch;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class StatementExecutor extends GeneratorSwitch<Object> {

    /**
     * Variable pattern
     */
    private final Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    private final Map<String, Pipeline> pipelineTable;

    private SymbolTable symbols;

    public StatementExecutor(final Map<String, Pipeline> pipelineTable) {
        this.pipelineTable = pipelineTable;

        this.symbols = new SymbolTable(null, (Map<String, Object>)(Map<String, ?>)pipelineTable);
    }

    public void execute(final List<Statement> statements) {
        statements.forEach(this::doSwitch);
    }

    @Override
    public Object caseForStatement(final ForStatement forLoop) {
        final String varName = forLoop.getName();

        final SymbolTable currentSymbols = this.symbols;

        final Stream<?> loopElements = (Stream<?>)doSwitch(forLoop.getRange());
        loopElements.forEach(e -> {
            this.symbols = new SymbolTable(currentSymbols);
            this.symbols.bind(varName, e);

            execute(forLoop.getStatements());

            this.symbols = currentSymbols;
        });

        return null;
    }

    @Override
    public Object caseCounterRange(final CounterRange range) {
        final boolean reverse = range.getStart() > range.getEnd();
        final int min = Math.min(range.getStart(), range.getEnd());
        final int max = Math.max(range.getStart(), range.getEnd());
        final int count = max - min;

        Stream<Integer> values = IntStream.rangeClosed(0, count)
                                          .boxed();

        if(reverse) {
            values = values.map(i -> max - i);
        } else {
            values = values.map(i -> min + i);
        }

        return values;
    }

    @Override
    public Object casePipelineArray(final PipelineArray range) {
        if(range.getReferences().isEmpty()) {
            return new ArrayList<>(pipelineTable.values()).stream();
        }

        return range.getReferences()
                    .stream()
                    .map(this::doSwitch)
                    .filter(Objects::nonNull);
    }

    @Override
    public Object casePipelineDefinitionReference(final PipelineDefinitionReference reference) {
        final String name = reference.getPipeline().getName();

        return symbols.get(name);
    }

    @Override
    public Object caseVariableReference(final VariableReference reference) {
        final String name = reference.getLoop().getName();

        return symbols.get(name);
    }

    @Override
    public Object caseApplyStatement(final ApplyStatement stmt) {
        final int count = stmt.getCount();
        final List<Pipeline> pipelines =
                stmt.getPipelines()
                     .stream()
                     .map(this::doSwitch)
                     .filter(Objects::nonNull)
                     .filter(Pipeline.class::isInstance)
                     .map(Pipeline.class::cast)
                     .toList();

        String filename = stmt.getFile();

        final Matcher matcher = varPattern.matcher(filename);

        final Set<String> vars = new HashSet<>();
        while(matcher.find()) {
            vars.add(filename.substring(matcher.start() + 2, matcher.end() - 1));
        }

        for(final String var : vars) {
            String replacement = null;

            Object value = symbols.get(var);
            if(value instanceof Integer) {
                replacement = value.toString();
            } else if(value instanceof Pipeline) {
                replacement = ((Pipeline)value).getName();
            }

            if(replacement == null) {
                log.warn("Unable to replace ${{}}", var);
                continue;
            }

            filename = filename.replace("${" + var + "}", replacement);
        }

        log.info("Writing {} with {} data points.", filename, count);
        new File(filename).getAbsoluteFile().getParentFile().mkdirs();

        // we start with an empty specification (and empty properties)
        final PropertiesSpecification emptySpecification = PropertiesSpecification.builder()
                                                                             .build();
        final Properties emptyProperties = new Properties(emptySpecification);


        Stream<Properties> stream = Stream.generate(() -> emptyProperties);
        PropertiesSpecification specification = emptySpecification;

        for(final Pipeline pipe : pipelines) {
            for(final GeneratorFunction function : pipe.getSteps()) {
                stream = stream.map(function::apply);
                specification = PropertiesSpecification.builder()
                                                       .add(specification)
                                                       .add(function.getWriteSpecification())
                                                       .build();
            }
        }

        log.info("Writing properties stream with specification {} to {}.", specification, filename);
        try(final PropertiesWriter writer = PropertiesIOFactory.writer(new File(filename), specification)) {
            stream.limit(count)
                  .forEach(p -> {
                      try {
                          writer.add(p);
                      } catch (final EvoalIOException e) {
                          log.error("Failed to writer properties.", e);
                      }
                  });
        } catch (final Exception e) {
            log.error("Failed to write properties to file '{}'.", filename, e);
        }

        return null;
    }
}
