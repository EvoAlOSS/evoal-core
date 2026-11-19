package de.evoal.optimisation.ea;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.ea.main.comparator.CrowdedComparator;

/**
 * Candidates and search spaces for the tests.
 */
public final class Candidates {
    private static final FitnessLayout LAYOUT = new FitnessLayout(List.of(FitnessComponent.named("f")));

    private Candidates() {
    }

    /**
     * @return An evaluated candidate with the fitness {@code f}; smaller is better.
     */
    public static Candidate withFitness(final double f) {
        final Evaluation evaluation = new Evaluation(Mockito.mock(TypedEObject.class),
                                                     new Fitness(LAYOUT, new double[] {f}),
                                                     new Value(f));

        return Candidate.evaluated(Mockito.mock(TypedEObject.class), evaluation, Lineage.NONE);
    }

    private static final FitnessLayout TWO_COMPONENTS = new FitnessLayout(List.of(FitnessComponent.named("f1"),
                                                                                  FitnessComponent.named("f2")));

    /**
     * @return An evaluated candidate with the two fitness components {@code f1} and
     *   {@code f2} and the value of {@code 'crowded-comparator'} (Pareto dominance).
     */
    public static Candidate withTwoComponents(final double f1, final double f2) {
        final Fitness fitness = new Fitness(TWO_COMPONENTS, new double[] {f1, f2});
        final TypedEObject objectives = Mockito.mock(TypedEObject.class);
        final Evaluation evaluation = new Evaluation(objectives, fitness, new CrowdedComparator().toValue(objectives, fitness));

        return Candidate.evaluated(Mockito.mock(TypedEObject.class), evaluation, Lineage.NONE);
    }

    /**
     * @return Evaluated candidates with the given fitness values.
     */
    public static List<Candidate> withFitness(final double... values) {
        final List<Candidate> candidates = new ArrayList<>();
        for(final double value : values) {
            candidates.add(withFitness(value));
        }

        return candidates;
    }

    /**
     * @return An attribute of the given type.
     */
    public static EAttribute feature(final String name, final EDataType type) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(name);
        feature.setEType(type);

        return feature;
    }

    /**
     * @return A search space with the features.
     */
    public static Space space(final EAttribute... features) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Space");
        eClass.getEStructuralFeatures().addAll(List.of(features));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    /**
     * @return A real attribute.
     */
    public static EAttribute real(final String name) {
        return feature(name, EcorePackage.Literals.EDOUBLE);
    }

    /**
     * @return An integer attribute.
     */
    public static EAttribute integer(final String name) {
        return feature(name, EcorePackage.Literals.EINT);
    }

    /**
     * @return A boolean attribute.
     */
    public static EAttribute bool(final String name) {
        return feature(name, EcorePackage.Literals.EBOOLEAN);
    }

    /**
     * An optimisation value of the canonical minimisation: a smaller fitness is better.
     */
    public static final class Value extends MinimalEObjectImpl.Container implements OptimisationValue {
        private final double fitness;

        public Value(final double fitness) {
            this.fitness = fitness;
        }

        @Override
        public int compareTo(final OptimisationValue other) {
            return Double.compare(((Value) other).fitness, fitness);
        }

        @Override
        public boolean isBetter(final OptimisationValue other) {
            return compareTo(other) > 0;
        }

        @Override
        public boolean isEqual(final OptimisationValue other) {
            return compareTo(other) == 0;
        }

        @Override
        public boolean isWorse(final OptimisationValue other) {
            return compareTo(other) < 0;
        }

        @Override
        public TypedEObject toOptmisationSpace() {
            return null;
        }

        @Override
        public List<Object> toStatistics() {
            return List.of(fitness);
        }

        @Override
        public String toString() {
            return Double.toString(fitness);
        }
    }
}
