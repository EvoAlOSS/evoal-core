package de.evoal.pipeline.impl.components.misc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.core.api.validation.constraints.ConfiguredChecker;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.constraints.ConstraintCheckers;
import de.evoal.core.api.validation.constraints.Severity;
import de.evoal.languages.model.base.definitions.Constrained;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.TypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.main.constraints.ConstraintCompiler;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineFilterImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Passes on the rows whose read data satisfy the constraints of their data description
 *   language (DDL) (DL type {@code 'constraint-validation'}):
 * <ul>
 *   <li>the annotations of the read data and of their data types that have a
 *     {@link ConstraintCheckerComponent}, e.g. {@code @LowerBoundary} and
 *     {@code @UpperBoundary};</li>
 *   <li>the declarations {@code constraint(comparison, "group")} of the DDL modules that
 *     declare the read data, compiled by the {@link ConstraintCompiler} of the optimisation:
 *     a row passes if g >= 0 (g > 0 for {@code <} and {@code >}).</li>
 * </ul>
 * A violated annotation leads to the reaction to its {@code severity}
 *   ({@code 'error-reaction'}, {@code 'warning-reaction'}); a violated declaration has no
 *   severity and leads to the reaction to errors. The reactions are
 * <ul>
 *   <li>{@code drop}: the row is dropped;</li>
 *   <li>{@code keep}: the row is passed on, and at the end of the stream the step logs how
 *     many passed rows violated the constraint;</li>
 *   <li>{@code stop}: the run stops with the row and the violated constraint.</li>
 * </ul>
 * The step stops at start-up if a constraint compares data that it does not read, if a
 *   constraint is an equality, or if a data description has a constraint that is no
 *   annotation.
 */
@Slf4j
@Dependent
@Named("de.evoal.pipeline.misc.constraint-validation")
public class ConstraintValidation extends PipelineFilterImpl {
    /**
     * The DDL function that declares a constraint.
     */
    private static final String CONSTRAINT = "constraint";

    /**
     * The reaction to a row that violates a constraint (DL enumeration {@code 'row-reaction'}).
     */
    enum RowReaction {
        /**
         * The row is dropped.
         */
        DROP,

        /**
         * The row is passed on; the violation is counted.
         */
        KEEP,

        /**
         * The run stops.
         */
        STOP;

        /**
         * @param value A literal of the DL enumeration {@code 'row-reaction'} or its name.
         * @return The corresponding reaction.
         */
        static RowReaction of(final Object value) {
            final String name = value instanceof Enumerator literal ? literal.getName() : String.valueOf(value);
            for(final RowReaction reaction : values()) {
                if(reaction.name().toLowerCase(Locale.ROOT).equals(name)) {
                    return reaction;
                }
            }

            throw new IllegalArgumentException("Unknown row reaction '" + name + "'.");
        }
    }

    /**
     * An annotation of a read data with its checker.
     *
     * @param feature The read data.
     * @param annotation The name of the annotation, e.g. {@code @LowerBoundary}.
     * @param checker The configured checker with the annotation's severity.
     */
    private record AnnotationCheck(EStructuralFeature feature, String annotation, ConfiguredChecker checker) {
        /**
         * @return The violated annotation for the messages, e.g. {@code 'a' (@UpperBoundary)}.
         */
        String label() {
            return "'" + feature.getName() + "' (" + annotation + ")";
        }
    }

    /**
     * The passed rows that violated one constraint.
     */
    private static final class KeptViolations {
        /**
         * The number of passed rows that violated the constraint.
         */
        private long rows;

        /**
         * The violation of the first such row, e.g. "has 'a' that is 1.2, but must be <= 1.0".
         */
        private String first;
    }

    /**
     * A violation of a row.
     *
     * @param label The violated constraint, e.g. {@code 'a' (@UpperBoundary)}.
     * @param message Describes the violation.
     * @param reaction The reaction to it.
     */
    private record Violation(String label, String message, RowReaction reaction) {}

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private ConstraintCheckers checkers;

    @Inject
    private ConstraintCompiler compiler;

    /**
     * The annotation checks of the read data.
     */
    private final List<AnnotationCheck> annotationChecks = new ArrayList<>();

    /**
     * The constraints of the DDL modules of the read data.
     */
    private List<Constraint> constraints = List.of();

    /**
     * The reaction to a violated annotation with severity error and to a violated declaration.
     */
    private RowReaction errorReaction = RowReaction.DROP;

    /**
     * The reaction to a violated annotation with severity warning.
     */
    private RowReaction warningReaction = RowReaction.KEEP;

    /**
     * The passed rows that violated a constraint, by the violated constraint.
     */
    private final Map<String, KeptViolations> kept = new LinkedHashMap<>();

    /**
     * Creates a filter that is configured by {@link #init(EObject)}.
     */
    public ConstraintValidation() {
    }

    /**
     * Creates a configured filter, e.g., for tests.
     *
     * @param maximumConsecutiveRejections The number of rows in a row that the filter may drop.
     * @param errorReaction The reaction to violated errors and declarations.
     * @param warningReaction The reaction to violated warnings.
     * @param checkers Creates the checkers of the annotations.
     * @param pipeline The space of the pipeline.
     * @param reads The data the step reads.
     * @throws InitializationException if a constraint cannot be checked.
     */
    ConstraintValidation(final int maximumConsecutiveRejections, final RowReaction errorReaction, final RowReaction warningReaction,
                         final ConstraintCheckers checkers, final Space pipeline, final Space reads) throws InitializationException {
        super("constraint-validation", maximumConsecutiveRejections);
        this.errorReaction = errorReaction;
        this.warningReaction = warningReaction;
        this.helper = new EAnnotationHelper();
        this.checkers = checkers;
        this.compiler = new ConstraintCompiler(helper);
        setFeatures(pipeline, reads, pipeline.subSpace(List.of()));
        configure();
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);
        errorReaction = reactionOf(configuration, "error-reaction");
        warningReaction = reactionOf(configuration, "warning-reaction");
        configure();

        return this;
    }

    private static RowReaction reactionOf(final EObject configuration, final String attribute) throws InitializationException {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(attribute);
        if(feature == null) {
            throw new InitializationException("'constraint-validation' has no attribute '" + attribute + "'.");
        }

        try {
            return RowReaction.of(configuration.eGet(feature));
        } catch(final IllegalArgumentException e) {
            throw new InitializationException("'" + attribute + "' of 'constraint-validation': " + e.getMessage(), e);
        }
    }

    private void configure() throws InitializationException {
        final Map<DataDescription, EStructuralFeature> features = readData(helper);

        for(final Map.Entry<DataDescription, EStructuralFeature> entry : features.entrySet()) {
            readAnnotations(entry.getKey(), entry.getValue());
        }

        readConstraints(features);
    }

    private void readAnnotations(final DataDescription description, final EStructuralFeature feature) throws InitializationException {
        final List<Expression> annotations = new ArrayList<>(description.getConstraints());
        if(description instanceof TypedBaseDataDescription typed && typed.getType() instanceof Constrained type) {
            annotations.addAll(type.getConstraints());
        }

        for(final Expression annotation : annotations) {
            if(!(annotation instanceof Instance instance)) {
                throw new InitializationException("The constraint '" + ExpressionText.of(annotation) + "' of the data '"
                                                  + description.getName() + "' is not supported; use an annotation "
                                                  + "(e.g. @UpperBoundary) or a constraint(...) declaration.");
            }

            final Optional<ConfiguredChecker> checker = checkers.create(instance);
            if(checker.isPresent()) {
                annotationChecks.add(new AnnotationCheck(feature, "@" + instance.getDefinition().getName(), checker.get()));
            }
        }
    }

    private void readConstraints(final Map<DataDescription, EStructuralFeature> features) throws InitializationException {
        for(final Call call : compiler.declarations(getReads())) {
            if(!CONSTRAINT.equals(call.getFunction().getName())) {
                continue;
            }

            final Set<String> unread = new TreeSet<>();
            call.eAllContents().forEachRemaining(element -> element.eCrossReferences()
                                                                   .stream()
                                                                   .filter(DataDescription.class::isInstance)
                                                                   .map(DataDescription.class::cast)
                                                                   .filter(description -> !features.containsKey(description))
                                                                   .forEach(description -> unread.add("'" + description.getName() + "'")));

            if(!unread.isEmpty()) {
                throw new InitializationException("The constraint '" + ExpressionText.of(call) + "' compares the data " + unread
                                                  + ", which the step does not read.");
            }
        }

        try {
            constraints = compiler.compile(getReads(), List.of()).all();
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage(), e);
        }

        for(final Constraint constraint : constraints) {
            if(constraint.kind() == ConstraintKind.EQUALITY) {
                throw new InitializationException("The constraint '" + constraint.text() + "' is an equality, which generated "
                                                  + "data almost never satisfies exactly; compute the dependent data in a step "
                                                  + "instead.");
            }
        }
    }

    @Override
    protected Optional<String> violation(final @NonNull TypedEObject row) {
        final List<Violation> violations = new ArrayList<>();

        for(final AnnotationCheck check : annotationChecks) {
            final ConstraintCheck result = check.checker().check(row.eGet(check.feature()));

            switch(result) {
                case ConstraintCheck.Satisfied satisfied -> {}
                case ConstraintCheck.Violated violated ->
                    violations.add(new Violation(check.label(),
                                                 "has '" + check.feature().getName() + "' that " + violated.message() + " (" + check.annotation() + ")",
                                                 check.checker().severity() == Severity.WARNING ? warningReaction : errorReaction));
                case ConstraintCheck.NotCheckable notCheckable ->
                    throw new IllegalStateException("The data '" + check.feature().getName() + "' cannot be checked against "
                                                    + check.annotation() + ": " + notCheckable.reason() + ".");
            }
        }

        for(final Constraint constraint : constraints) {
            final double g = constraint.valueOf(feature -> ((Number) row.eGet(feature)).doubleValue());
            final boolean satisfied = constraint.isStrict() ? g > 0.0 : g >= 0.0;

            if(!satisfied) {
                violations.add(new Violation("'" + constraint.text() + "'", "violates '" + constraint.text() + "'", errorReaction));
            }
        }

        return react(row, violations);
    }

    /**
     * Applies the reactions to the violations of a row: a stop stops the run, a drop drops the
     *   row, and only if neither occurs, the kept violations are counted.
     *
     * @return Why the row is dropped, or empty if it is passed on.
     */
    private Optional<String> react(final TypedEObject row, final List<Violation> violations) {
        for(final Violation violation : violations) {
            if(violation.reaction() == RowReaction.STOP) {
                throw new IllegalStateException("'constraint-validation' stops the run: the row " + describe(row) + " " + violation.message() + ".");
            }
        }

        for(final Violation violation : violations) {
            if(violation.reaction() == RowReaction.DROP) {
                return Optional.of(violation.message());
            }
        }

        for(final Violation violation : violations) {
            final KeptViolations counter = kept.computeIfAbsent(violation.label(), label -> new KeptViolations());
            if(counter.rows++ == 0) {
                counter.first = violation.message();
            }
        }

        return Optional.empty();
    }

    /**
     * @return The read data of the row, e.g. {@code {'a' = 1.2, 'b' = 0.0}}.
     */
    private String describe(final TypedEObject row) {
        final StringJoiner values = new StringJoiner(", ", "{", "}");
        for(final EStructuralFeature feature : getReads()) {
            values.add("'" + feature.getName() + "' = " + row.eGet(feature));
        }

        return values.toString();
    }

    /**
     * @return The number of passed rows that violated the given constraint, e.g.
     *   {@code 'a' (@UpperBoundary)} or the text of a declaration in quotes.
     */
    long keptViolations(final String label) {
        final KeptViolations counter = kept.get(label);
        return counter == null ? 0 : counter.rows;
    }

    @Override
    public void streamEnded() {
        super.streamEnded();

        kept.forEach((label, counter) ->
                log.warn("'constraint-validation' kept {} rows that violate {}; the first row {}.", counter.rows, label, counter.first));
    }
}
