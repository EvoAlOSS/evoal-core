package de.evoal.optimisation.main.fitness;

import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.board.Blackboard;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.utils.VariableToEObjectHelper;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.languages.model.base.expressions.*;

@Dependent
@Named("de.evoal.optimisation.core.optimisation-distance")
@Slf4j
public class OptimisationDistanceFitness extends OptimisationFunctionDecorator {

    @Inject
    private Blackboard board;

    @Inject
    private VariableToEObjectHelper instanceConverter;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    /**
     * The target to search for.
     */
    private TypedEObject target;

    @Override
    public TypedEObject evaluate(final TypedEObject input) {
        final TypedEObject current = decoratedFunction.evaluate(input);
        final TypedEObject result = optimisationSpace.newEObject();

        for(final EStructuralFeature feature : optimisationSpace) {
            // TODO We have to use a proper function to measure the distance based on the type.
            result.eSet(feature, distance(target.eGetAsDouble(feature), current.eGetAsDouble(feature)));
        }

        return result;
    }

    private double distance(final Object o, final double v) {
        return Math.abs(((Number)o).doubleValue() - v);
    }

    @Override
    public OptimisationFunction init(final EObject config) {
        super.init(config);

        final List<EObject> target = helper.lookup(config, "target");

        if(target == null) {
            this.target = board.get(OptimisationBlackboardEntries.TARGET_PROPERTIES);
        } else {
            this.target = instanceConverter.fromVariables(target, optimisationSpace);
            log.info("Binding target properties based on information found in MLL to {}.", this.target);
            board.bind(OptimisationBlackboardEntries.TARGET_PROPERTIES, this.target);
        }

        return this;
    }
}
