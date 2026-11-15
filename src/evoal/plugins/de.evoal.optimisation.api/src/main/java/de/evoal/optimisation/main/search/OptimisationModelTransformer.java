package de.evoal.optimisation.main.search;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.Direction;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.core.CorePackage;
import de.evoal.models.v202704.optimisation.execution.ExecutionPackage;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.models.v202704.optimisation.model.TargetGoal;
import de.evoal.models.v202704.optimisation.model.Problem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class OptimisationModelTransformer extends ModelTransformer {

    @Inject
    private EAnnotationHelper eAnnotationHelper;

    /**
     * Dependency for generating dynamic ecore classes.
     */
    @Inject
    private EClassProvider eClassProvider;

    /**
     * Factory for creating the ecore-based model.
     */
    private final static ModelFactory factory = ModelFactory.eINSTANCE;

    @Override
    protected Collection<EPackage> mappedPackages() {
        return List.of(CorePackage.eINSTANCE, ExecutionPackage.eINSTANCE);
    }

    public OptimisationModule transform(de.evoal.languages.model.ol.OptimisationModule model, final Space space) {
        this.space = space;

        OptimisationModule result = factory.createOptimisationModule();
        
        result.setProblem(transform(model.getAlgorithm().getProblem()));
        result.setAlgorithm(transform(model.getAlgorithm()));

        return checkConfiguredBy(result);
    }

    private Configuration transform(final AlgorithmInstance algorithm) {
        return createDynamic(algorithm);
    }

    private Problem transform(final ProblemInstance problem) {
        final Problem result = factory.createProblem();
        result.setName(problem.getName());

        final Pair<EClass, EClass> spaceClasses = eClassProvider.eClassFor(problem);

        result.setSearchSpace(spaceClasses.getFirst());
        result.setOptimisationSpace(spaceClasses.getSecond());

        for(final OptimisationGoal goal : problem.getOptimisationSpace()) {
            result.getGoals().add(transform(goal, spaceClasses.getSecond()));
        }

        final Configuration configuration = createDynamic(problem.getOptimisationFunction());
        result.setOptimisationFunction(configuration);

        if(problem.getDocumentation() != null) {
            for(final Expression writer : problem.getDocumentation().getValues()) {
                if(!(writer instanceof Instance instance)) {
                    throw new IllegalArgumentException("The documentation of problem '" + problem.getName() + "' may only contain instances, but contains '" + writer + "'.");
                }

                result.getDocumentation().add(createDynamic(instance));
            }
        }

        return result;
    }

    private de.evoal.models.v202704.optimisation.model.OptimisationGoal transform(final OptimisationGoal goal, final EClass classifier) {
        final de.evoal.models.v202704.optimisation.model.OptimisationGoal result;

        if(goal.getDirection().equals(Direction.MAXIMISE)) {
            result = factory.createMaximiseGoal();
        } else if(goal.getDirection().equals(Direction.MINIMISE)) {
            result = factory.createMinimiseGoal();
        } else if(goal.getDirection().equals(Direction.TARGET)) {
            result = factory.createTargetGoal();
            de.evoal.languages.model.ol.TargetGoal targetGoal = (de.evoal.languages.model.ol.TargetGoal) goal;


            ((TargetGoal)result).setValue(targetGoal.getValue().getValue());
        } else {
            throw new InternalError();
        }

        final EStructuralFeature feature = eAnnotationHelper.featureOf(classifier, (DataDescription) goal.getData().getDefinition());
        result.setData(feature);

        return result;
    }
}
