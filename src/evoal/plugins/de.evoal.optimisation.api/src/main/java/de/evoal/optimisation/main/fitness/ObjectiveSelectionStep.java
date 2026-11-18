package de.evoal.optimisation.main.fitness;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessContext;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.FitnessStep;

/**
 * Keeps the fitness component of one objective and drops all others (DL type
 *   {@code 'objective-selection'}). The kept component still refers to its goal.
 */
@Dependent
@Named("de.evoal.optimisation.core.objective-selection")
public class ObjectiveSelectionStep implements FitnessStep {
    @Inject
    private AttributeHelper attributes;

    /**
     * The name of the selected component.
     */
    private String objective;

    /**
     * The position of the selected component in {@link #resolvedLayout}.
     */
    private int index;

    /**
     * The layout the step returns: the selected component only.
     */
    private FitnessLayout outputLayout;

    /**
     * The layout {@link #index} was resolved for; all candidates of a run share it.
     */
    private FitnessLayout resolvedLayout;

    /**
     * Creates the step without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public ObjectiveSelectionStep() {
    }

    /**
     * @param objective The name of the selected component.
     */
    public ObjectiveSelectionStep(final String objective) {
        this.objective = objective;
    }

    @Override
    public Fitness apply(final FitnessContext context, final Fitness current) {
        resolve(current.layout());

        final double value = current.value(index);

        return new Fitness(outputLayout, new double[] {value});
    }

    @Override
    public ObjectiveSelectionStep init(final EObject configuration) {
        final EStructuralFeature selected = attributes.lookup(configuration, "objective");
        this.objective = selected.getName();

        return this;
    }

    /**
     * @throws IllegalArgumentException if the selected component is not part of the layout.
     */
    @Override
    public FitnessLayout layout(final FitnessLayout input) {
        resolve(input);

        return outputLayout;
    }

    private void resolve(final FitnessLayout layout) {
        if(layout == resolvedLayout) {
            return;
        }

        index = layout.indexOf(objective);
        final FitnessComponent component = layout.component(index);
        outputLayout = new FitnessLayout(List.of(component));
        resolvedLayout = layout;
    }

    @Override
    public String toString() {
        return "objective-selection " + objective;
    }
}
