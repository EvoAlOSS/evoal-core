package de.evoal.pipeline.impl.components.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.constraints.ConstraintCheckers;
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
 * The step stops at start-up if a constraint compares data that it does not read, if a
 *   constraint is an equality, or if a data description has a constraint that is no
 *   annotation.
 */
@Dependent
@Named("de.evoal.pipeline.misc.constraint-validation")
public class ConstraintValidation extends PipelineFilterImpl {
    /**
     * The DDL function that declares a constraint.
     */
    private static final String CONSTRAINT = "constraint";

    /**
     * An annotation of a read data with its checker.
     *
     * @param feature The read data.
     * @param annotation The name of the annotation, e.g. {@code @LowerBoundary}.
     * @param checker The configured checker.
     */
    private record AnnotationCheck(EStructuralFeature feature, String annotation, ConstraintCheckerComponent checker) {}

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
     * Creates a filter that is configured by {@link #init(EObject)}.
     */
    public ConstraintValidation() {
    }

    /**
     * Creates a configured filter, e.g., for tests.
     *
     * @param maximumConsecutiveRejections The number of rows in a row that the filter may drop.
     * @param checkers Creates the checkers of the annotations.
     * @param pipeline The space of the pipeline.
     * @param reads The data the step reads.
     * @throws InitializationException if a constraint cannot be checked.
     */
    ConstraintValidation(final int maximumConsecutiveRejections, final ConstraintCheckers checkers, final Space pipeline, final Space reads) throws InitializationException {
        super("constraint-validation", maximumConsecutiveRejections);
        this.helper = new EAnnotationHelper();
        this.checkers = checkers;
        this.compiler = new ConstraintCompiler(helper);
        setFeatures(pipeline, reads, pipeline.subSpace(List.of()));
        configure();
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);
        configure();

        return this;
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

            final Optional<ConstraintCheckerComponent> checker = checkers.create(instance);
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
        for(final AnnotationCheck check : annotationChecks) {
            final ConstraintCheck result = check.checker().check(row.eGet(check.feature()));

            switch(result) {
                case ConstraintCheck.Satisfied satisfied -> {}
                case ConstraintCheck.Violated violated -> {
                    return Optional.of("has '" + check.feature().getName() + "' that " + violated.message() + " (" + check.annotation() + ")");
                }
                case ConstraintCheck.NotCheckable notCheckable ->
                    throw new IllegalStateException("The data '" + check.feature().getName() + "' cannot be checked against "
                                                    + check.annotation() + ": " + notCheckable.reason() + ".");
            }
        }

        for(final Constraint constraint : constraints) {
            final double g = constraint.valueOf(feature -> ((Number) row.eGet(feature)).doubleValue());
            final boolean satisfied = constraint.isStrict() ? g > 0.0 : g >= 0.0;

            if(!satisfied) {
                return Optional.of("violates '" + constraint.text() + "'");
            }
        }

        return Optional.empty();
    }
}
