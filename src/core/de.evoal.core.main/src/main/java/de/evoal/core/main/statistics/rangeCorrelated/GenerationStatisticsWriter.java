package de.evoal.core.main.statistics.rangeCorrelated;

import de.evoal.core.api.statistics.*;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.main.ea.functions.correlation.model.Correlation;
import de.evoal.core.main.ea.functions.correlation.model.Correlations;
import de.evoal.core.main.ea.functions.correlation.model.RangedCorrelation;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.Genotype;
import io.jenetics.engine.EvolutionResult;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Pair;


/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("range-correlated")
@Dependent
public class GenerationStatisticsWriter implements StatisticsWriter {
    /**
     * Encoding for converting between ea and domain.
     */
    @Inject
    private CustomCodec encoding;

    @Inject @Named("genotype-limits")
    private List<Pair<Double, Double>> limits;

    @Inject
    private Correlations correlations;

    private List<Hypercube> hypercubeDefinitions;

    private List<Hypercube> initialGenerationCubes;

    @Inject
    private WriterStrategy strategy;

    private Writer writer;

    /**
     * Creates a new GenerationStatistics instance.
     */
    @PostConstruct
    @SneakyThrows(WriterException.class)
    public void init() {
        final List<PropertyRange> rangesOfProperties = extractPropertyRangesFromCorrelations();
        
        hypercubeDefinitions = generateHypercubesFromRanges(rangesOfProperties, limits.size());

        createWriter();
    }

    private void createWriter() throws WriterException {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));

        for(int i = 0; i < hypercubeDefinitions.size(); ++i) {
            columns.add(new Column("hypercube-" + (i+1), ColumnType.Double));
        }

        writer = strategy.create("hypercube-correlation-distances", columns);
    }

    private List<PropertyRange> extractPropertyRangesFromCorrelations() {
        final List<PropertyRange> result = new ArrayList<>();

        final List<Correlation> allTheCorrelations = correlations.getCorrelations();

        allTheCorrelations
                .stream()
                .filter(RangedCorrelation.class::isInstance)
                .map(RangedCorrelation.class::cast)
                .forEach(rc -> {
                    result.add(new PropertyRange(rc.getChromosomeOne(), rc.getChromosomeOneRange()));
                    result.add(new PropertyRange(rc.getChromosomeTwo(), rc.getChromosomeTwoRange()));
                });

        return result;
    }

    @Override
    public void add(final EvolutionResult<?, FitnessType> evolutionResult) {
        if(evolutionResult.generation() == 1) {
            initialGenerationCubes = fillHypercubes(evolutionResult);
        }

        final List<Hypercube> currentCubes = fillHypercubes(evolutionResult);
    	double[] arrayOfDistances = new double[initialGenerationCubes.size()];
    	for(int i=0; i< arrayOfDistances.length; i++) {
   			arrayOfDistances[i] = currentCubes.get(i).computeSquaredDistanceToCovarianceMatrix(initialGenerationCubes.get(i));
    	}

    	Object[] data = new Object[1+ arrayOfDistances.length + 1];
    	data[0] = evolutionResult.generation();
    	double sum = 0.0;
    	for(int i = 0; i < arrayOfDistances.length; i++) {
    		data[i+1] = arrayOfDistances[i];
    		sum += arrayOfDistances[i];
    	}
    	data[arrayOfDistances.length + 1] = sum;
    	try {
			writer.addRecord(data);
		} catch (Exception e) {
			log.error("The csv printing didn't work in generation {}", evolutionResult.generation(), e);
		}
    }
    
    private List<Hypercube> fillHypercubes(final EvolutionResult<?, FitnessType> evolutionResult){
    	List<Hypercube> currentGeneration = new ArrayList<>();
    	for(int j = 0; j < hypercubeDefinitions.size(); j++) {
    		Hypercube hypercube = new Hypercube(hypercubeDefinitions.get(j));
    		for(int i= 0; i < evolutionResult.population().asList().size(); i++) {
                final Genotype<?> genotype = evolutionResult.population().asList().get(i).genotype();
                final Properties domainValues = (Properties) encoding.decode(genotype);

                hypercube.addDataPoint(domainValues);
        	}
    		currentGeneration.add(hypercube); 
    	}
    	return currentGeneration;
    }

    public void write() {
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
    
    /**
     * This methods builds all hypercubes resulting from the given ranges of the dvl. It need only be performed once., 
     * @param listOfRanges
     * @return
     */
    public List<Hypercube> generateHypercubesFromRanges(final List<PropertyRange> listOfRanges, final int dimensions){

    	List<SortedSet<Double>> listOfBoundaries = new ArrayList<>(dimensions);
    	for(int i=0; i<dimensions; i++) {
    		final SortedSet<Double> boundaries = new TreeSet<>();
            boundaries.add(limits.get(i).getFirst());
            boundaries.add(limits.get(i).getSecond());

            listOfBoundaries.add(boundaries);
    	}

    	//sorts every range into the correct dimension and sorts the interval values afterwards. 
    	for(int j = 0; j < listOfRanges.size(); j++) {
    		PropertyRange currentRange = listOfRanges.get(j);
    		listOfBoundaries.get(currentRange.getIndexOfChromosome()).add(currentRange.getLower());
    		listOfBoundaries.get(currentRange.getIndexOfChromosome()).add(currentRange.getUpper());
    	}
    	
    	//we should have a list of sorted double values for each dimension now, containing all values existing in the dvl ranges
        final List<Hypercube> hypercubes = new ArrayList<>();
    	addVariationsOfNextDimension(dimensions, 0, new HypercubeBuilder(dimensions), listOfBoundaries, hypercubes);

        return hypercubes;
    }
    
    private void addVariationsOfNextDimension(int dimensions, int indexOfNextDimension, HypercubeBuilder builder, List<SortedSet<Double>> listOfBoundaries, final List<Hypercube> result){
        if(indexOfNextDimension == dimensions) {
            result.add(builder.build());
            return;
        }

        final List<Double> boundaries = new ArrayList<>(listOfBoundaries.get(indexOfNextDimension));

        for(int i = 0; i < boundaries.size() - 1; ++i) {
            final HypercubeBuilder next = new HypercubeBuilder(builder);
            next.append(boundaries.get(i), boundaries.get(i + 1));

            addVariationsOfNextDimension(dimensions, indexOfNextDimension +  1, next, listOfBoundaries, result);
        }
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }
}
