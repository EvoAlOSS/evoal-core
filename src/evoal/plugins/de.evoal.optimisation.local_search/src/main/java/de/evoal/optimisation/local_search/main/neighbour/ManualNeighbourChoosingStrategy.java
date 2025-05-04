package de.evoal.optimisation.local_search.main.neighbour;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.VariableToPropertiesHelper;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.ArithmeticNumberOperations;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import java.util.Spliterators;

/**
 * The manual neighbour choosing strategy generates neighbours in real-valued search spaces.
 * All possible permutations (addition of step size, subtraction of step size, identity) are
 * generated as neighbours of the current point.
 */
@Named("de.evoal.optimisation.local_search.optimisation.manual-strategy")
@Dependent
public class ManualNeighbourChoosingStrategy implements NeighbourChoosingStrategy {
    @Inject
    protected AttributeEvaluator evaluator;
    @Inject
    protected AttributeHelper helper;
    @Inject
    protected VariableToPropertiesHelper variableToPropertiesHelper;
	private Properties stepValues;


    private Properties createProperties(Properties currentBestCandidate) {
        final Properties props = new Properties(currentBestCandidate.getSpecification());
        props.put(currentBestCandidate.getSpecification().get(0), 0.0);
        return props;
    }

    @Override
    public Stream<Properties> neighbours(final Properties currentBestCandidate) {
        NeighbourIterator iterator = new NeighbourIterator(currentBestCandidate);
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    }

    @Override
    public ManualNeighbourChoosingStrategy init(final Instance config) {
        final  List<Instance> sv = helper.lookup(config, "step-size");
        this.stepValues = variableToPropertiesHelper.variablesToProperties(sv);
        return this;
    }

    /**
     * iterates over all possible neighbours based on
     * 3^n possible combinations of -1, 0, and 1 of length n, where
     * n is the cardinality of the search space specification.
     */
    private class NeighbourIterator implements Iterator<Properties> {

        final int[] elements = new int[]{-1, 0, 1};
        private int currentIndex = 0;
        final int length;
        final Properties baseCandidate;
        private List<Integer[]> combinations;

        public NeighbourIterator(Properties baseCandidate) {
            this.baseCandidate = baseCandidate;
            this.length = baseCandidate.size();
            this.combinations = createCombinations();
        }
        @Override
        public boolean hasNext() {
            return this.currentIndex < combinations.size();
        }

        @Override
        public Properties next() {
            Properties newCandidate = createProperties(baseCandidate);

            for(int j=0; j < baseCandidate.size(); j++) {
                final PropertySpecification ps = baseCandidate.getSpecification().get(j);

                if(this.combinations.get(currentIndex)[j] > 0){
                    //add step size
                    newCandidate.put(ps, ArithmeticNumberOperations.add(baseCandidate.get(ps), stepValues.get(ps)));
                }
                else if (this.combinations.get(currentIndex)[j] < 0) {
                    //subtract step size
                    newCandidate.put(ps, ArithmeticNumberOperations.minus(baseCandidate.get(ps), stepValues.get(ps)));
                }
                else {
                    //don't change the new candidate on this position
                    newCandidate.put(ps, baseCandidate.get(ps));
                }
            }
            this.currentIndex++;
            return newCandidate;
        }

        @Override
        public void remove() {

        }

        private List<Integer[]> createCombinations() {
            List<Integer[]> combinations = new ArrayList<>();
            createCombinationsR(new Integer[this.length], 0, combinations);
            Collections.shuffle(combinations);
            return combinations;
        }

        /*recursively create combinations matrix*/
        private void createCombinationsR(Integer[] array, int index, List<Integer[]> combinations) {
            if (index == this.length) {
                combinations.add(array.clone());
                return;
            }

            for (int el : this.elements) {
                array[index] = el;
                createCombinationsR(array, index+1, combinations);
            }
        }

    }
}
