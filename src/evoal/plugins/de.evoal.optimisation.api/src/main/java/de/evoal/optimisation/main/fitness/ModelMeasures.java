package de.evoal.optimisation.main.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.optimisation.api.builder.ModelTrees;

/**
 * The size and the depth of a model candidate as objectives (DL type {@code 'model-measures'}):
 *   the size is the number of objects of the model, the depth the depth of its deepest object
 *   (the root has depth 0). The function is deterministic, e.g. for regressions of model
 *   search spaces or as a size objective next to others.
 */
@Dependent
@Named("de.evoal.optimisation.core.model-measures")
public class ModelMeasures extends OptimisationFunctionImpl {
    @Inject
    private AttributeHelper attributes;

    /**
     * The objective with the depth, {@code null} if it is not computed.
     */
    private EStructuralFeature depth;

    /**
     * The search data with the model.
     */
    private EReference model;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * The objective with the size, {@code null} if it is not computed.
     */
    private EStructuralFeature size;

    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        final TypedEObject result = optimisationSpace.newEObject();
        final EObject root = (EObject) candidate.eGet(model);

        if(size != null) {
            result.eSet(size, NumericConversions.toType(ModelTrees.size(root), size.getEType()));
        }
        if(depth != null) {
            result.eSet(depth, NumericConversions.toType(ModelTrees.height(root), depth.getEType()));
        }

        return result;
    }

    @Override
    public OptimisationFunction init(final EObject configuration) {
        final EStructuralFeature modelData = attributes.lookup(configuration, "model");
        final EStructuralFeature found = searchSpace.find(modelData.getName()).orElse(null);
        if(!(found instanceof EReference reference)) {
            throw new IllegalArgumentException("The 'model' of 'model-measures' has to be structured search data, but '"
                                               + modelData.getName() + "' is not.");
        }
        model = reference;

        size = objective(configuration, "size");
        depth = objective(configuration, "depth");
        if(size == null && depth == null) {
            throw new IllegalArgumentException("'model-measures' needs a 'size' or a 'depth' objective.");
        }

        return this;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The function only reads the candidate.
     */
    @Override
    public boolean isThreadSafe() {
        return true;
    }

    /**
     * @return The objective of the attribute, {@code null} if the attribute is not set.
     */
    private EStructuralFeature objective(final EObject configuration, final String name) {
        final EStructuralFeature attribute = configuration.eClass().getEStructuralFeature(name);
        if(attribute == null || !configuration.eIsSet(attribute)) {
            return null;
        }

        final EStructuralFeature data = attributes.lookup(configuration, name);
        final EStructuralFeature objective = optimisationSpace.find(data.getName())
                                                              .orElseThrow(() -> new IllegalArgumentException(
                                                                      "The '" + name + "' of 'model-measures' has to be optimisation data, but '"
                                                                      + data.getName() + "' is not."));
        if(!EClassifierHelper.isNumeric(objective.getEType())) {
            throw new IllegalArgumentException("The '" + name + "' of 'model-measures' has to be numeric data, but '"
                                               + data.getName() + "' is " + objective.getEType().getName() + ".");
        }

        return objective;
    }
}
