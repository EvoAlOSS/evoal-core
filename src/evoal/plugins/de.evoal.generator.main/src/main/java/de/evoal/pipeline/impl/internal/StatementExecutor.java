package de.evoal.pipeline.impl.internal;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.pipeline.*;
import de.evoal.languages.model.pipeline.util.PipelineSwitch;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.model.Composite;
import de.evoal.pipeline.impl.executor.StreamExecutor;
import de.evoal.pipeline.api.model.TypedEObject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class StatementExecutor extends PipelineSwitch<Object> {

    public static final ExpressionsFactory EXPR_FACTORY = ExpressionsFactory.eINSTANCE;
    /**
     * Regular expression for matching variable expressions in strings.
     */
    private final Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    private final EClass space;

    /**
     * The symbol table used
     */
    private SymbolTable symbols;

    private final DefinitionModuleLoader loader;

    public StatementExecutor(final DefinitionModuleLoader loader, final Map<String, PipelineDefinition> pipelineTable, final EClass space) {
        this.symbols = new SymbolTable(null, pipelineTable);
        this.loader = loader;
        this.space = space;
    }

    public void execute(final List<Statement> statements) {
        log.info("Interpreting statements.");
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
        final int start = (int)new LiteralSwitch(symbols).doSwitch(range.getStart());
        final int end = (int)new LiteralSwitch(symbols).doSwitch(range.getEnd());

        final boolean reverse = start > end;
        final int min = Math.min(start, end);
        final int max = Math.max(start, end);
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
    public Object caseLiteralRange(final LiteralRange range) {
        final LiteralSwitch helper = new LiteralSwitch(symbols);

        return range.getElements()
                .stream()
                .map(helper::doSwitch);
    }

    @Override
    public Object caseApplyStatement(final ApplyStatement stmt) {
        final PipelineDefinition writer = generateWriterPipeline(stmt);
        final LiteralSwitch lSwitch = new LiteralSwitch(symbols);

        final EObject countObject = stmt.getCount();
        final Object countValue = lSwitch.doSwitch(countObject);
        final int count = ((Number)countValue).intValue();
        log.info("Writing {} data points.", count);

        log.info("There are {} pipelines.", stmt.getPipelines().size());
        final List<PipelineDefinition> pipelines =
                stmt.getPipelines()
                     .stream()
                     .filter(Objects::nonNull)
                     .filter(PipelineDefinitionReference.class::isInstance)
                     .map(PipelineDefinitionReference.class::cast)
                     .map(this::casePipelineDefinitionReference)
                        .peek(System.out::println)
                     .collect(Collectors.toList());

        pipelines.add(writer);

        final PipelineInstantiator converter = new PipelineInstantiator(space);
        final Composite pipeline = converter.convert(pipelines);
        final PipelineExecutor executor = new StreamExecutor();
        final Optional<Function<Stream<TypedEObject>, Stream<TypedEObject>>> countLimit = Optional.of(stream -> stream.limit(count));

        executor.setSpace(space);
        executor.execute(pipeline, countLimit);

        pipeline.close();

        return null;
    }


    private PipelineDefinition generateWriterPipeline(final ApplyStatement stmt) {
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
            } else if(value instanceof NamedPipeline) {
                replacement = ((NamedPipeline)value).name();
            }

            if(replacement == null) {
                log.warn("Unable to replace ${{}}", var);
                continue;
            }

            filename = filename.replace("${" + var + "}", replacement);
        }

        log.info("Writing results to {}.", filename);
        new File(filename)
                .getAbsoluteFile()
                .getParentFile()
                .mkdirs();

        log.info("Generating writer");
        final DefinitionModule module = loader.load("classpath:/de/evoal/pipeline/io.dl");
        final TypeDefinition writerDefinition = module.getTypes()
                .stream()
                .filter(t ->"writer".equals(t.getName()))
                .findFirst()
                .get();

        final AttributeDefinition filenameDefinition = writerDefinition.getAttributes()
                .stream()
                .filter(a -> "filename".equals(a.getName()))
                .findFirst()
                .get();

        final StringLiteral filenameLiteral = EXPR_FACTORY.createStringLiteral();
        filenameLiteral.setValue(filename);

        final UnaryAddOrSubtractExpression unaryAddOrSubtractExpression = EXPR_FACTORY.createUnaryAddOrSubtractExpression();
        unaryAddOrSubtractExpression.setSubExpression(filenameLiteral);

        final PowerOfExpression powerOfExpression = EXPR_FACTORY.createPowerOfExpression();
        powerOfExpression.setLeftOperand(unaryAddOrSubtractExpression);

        final MultiplyDivideModuloExpression mdmExpression = EXPR_FACTORY.createMultiplyDivideModuloExpression();
        mdmExpression.setLeftOperand(powerOfExpression);

        final AddOrSubtractExpression addOrSubtractExpression = EXPR_FACTORY.createAddOrSubtractExpression();
        addOrSubtractExpression.setLeftOperand(mdmExpression);

        final ComparisonExpression comparisonExpression = EXPR_FACTORY.createComparisonExpression();
        comparisonExpression.setLeftOperand(addOrSubtractExpression);

        final NotExpression notExpression = EXPR_FACTORY.createNotExpression();
        notExpression.setNegated(false);
        notExpression.setOperand(comparisonExpression);

        final AndExpression andExpression = EXPR_FACTORY.createAndExpression();
        andExpression.getSubExpressions().add(notExpression);

        final XorExpression xorExpression = EXPR_FACTORY.createXorExpression();
        xorExpression.getSubExpressions().add(andExpression);

        final OrExpression orExpression = EXPR_FACTORY.createOrExpression();
        orExpression.getSubExpressions().add(xorExpression);

        final Attribute filenameAttribute = EXPR_FACTORY.createAttribute();
        filenameAttribute.setDefinition(filenameDefinition);
        filenameAttribute.setValue(orExpression);

        final Instance writerInstance = EXPR_FACTORY.createInstance();
        writerInstance.getAttributes().add(filenameAttribute);
        writerInstance.setDefinition(writerDefinition);

        final Step writerStep = PipelineFactory.eINSTANCE.createStep();
        writerStep.getReads().addAll(space.getEAttributes());
        writerStep.setInstance(writerInstance);

        final PipelineDefinition definition = PipelineFactory.eINSTANCE.createPipelineDefinition();
        definition.setName("artificial");
        definition.getSteps().add(writerStep);

        return definition;
    }

    @Override
    public PipelineDefinition casePipelineDefinitionReference(final PipelineDefinitionReference obj) {
        return obj.getPipeline();
    }
}
