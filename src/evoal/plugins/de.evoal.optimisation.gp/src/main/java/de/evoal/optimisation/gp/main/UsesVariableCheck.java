package de.evoal.optimisation.gp.main;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.checks.AbstractCandidateCheck;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.run.Candidate;

import de.evoal.optimisation.gp.api.ExpressionTypes;

/**
 * Fails a new candidate whose expression uses fewer than the configured number of different
 *   variable types (DL type {@code 'uses-variable'}), e.g. a constant expression.
 */
@Dependent
@Named("de.evoal.optimisation.gp.genetic-programming.uses-variable")
public class UsesVariableCheck extends AbstractCandidateCheck {
    /**
     * The smallest number of different variable types.
     */
    private int count;

    @Inject
    private AttributeHelper helper;

    /**
     * The search data with the expression.
     */
    private EReference model;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    public UsesVariableCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param reaction The reaction to a failed candidate.
     * @param model The search data with the expression.
     * @param count The smallest number of different variable types.
     */
    public UsesVariableCheck(final CheckReaction reaction, final EReference model, final int count) {
        super(reaction);
        this.model = model;
        this.count = count;
    }

    private static void addIfVariable(final EObject node, final Set<EClass> types) {
        final EClass type = node.eClass();
        if(ExpressionTypes.isVariable(type)) {
            types.add(type);
        }
    }

    @Override
    public CheckPoint checkPoint() {
        return CheckPoint.NEW_CANDIDATES;
    }

    @Override
    protected void configure(final EObject configuration) throws InitializationException {
        final EStructuralFeature data = helper.lookup(configuration, "model");
        final EStructuralFeature found = searchSpace.find(data.getName()).orElse(null);
        if(!(found instanceof EReference reference)) {
            throw new InitializationException("The 'model' of 'uses-variable' has to be structured search data, but '"
                                              + data.getName() + "' is not.");
        }

        model = reference;
        count = helper.<Integer>lookup(configuration, "count");
    }

    @Override
    public String name() {
        return "uses-variable";
    }

    /**
     * @return The number of different variable types in the tree.
     */
    static int numberOfVariableTypes(final EObject root) {
        final Set<EClass> types = new HashSet<>();
        addIfVariable(root, types);
        root.eAllContents()
            .forEachRemaining(node -> addIfVariable(node, types));

        return types.size();
    }

    @Override
    public Set<CheckReaction> supportedReactions() {
        return EnumSet.of(CheckReaction.WARN, CheckReaction.REPLACE, CheckReaction.RESAMPLE);
    }

    @Override
    public Optional<String> test(final Candidate candidate) {
        final EObject root = (EObject) candidate.input().eGet(model);
        final int used = root == null ? 0 : numberOfVariableTypes(root);
        if(used >= count) {
            return Optional.empty();
        }

        return Optional.of("the expression '" + model.getName() + "' uses " + used + " different variables, at least "
                           + count + " are required");
    }
}
