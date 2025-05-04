package de.evoal.surrogate.main.statistics.ranged;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.model.Iteration;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.api.correlations.RangedCorrelation;
import de.evoal.languages.model.base.expressions.Instance;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.range-correlated")
@Dependent
public class GenerationStatisticsWriter implements StatisticsWriter {
    @Inject
    private PropertiesBoundaries limits;

    @Inject @Named("genotype-specification")
    private PropertiesSpecification specification;

    @Inject
    private Correlations correlations;

    private List<Hypercube> hypercubeDefinitions = new ArrayList<>();

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
        
        generateHypercubesFromRanges(rangesOfProperties, specification.size());

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
    public void add(final Iteration result) {
        if(initialGenerationCubes == null) {
            initialGenerationCubes = fillHypercubes(result);
        }

        final List<Hypercube> currentCubes = fillHypercubes(result);
    	double[] arrayOfDistances = new double[initialGenerationCubes.size()];
    	for(int i=0; i< arrayOfDistances.length; i++) {
   			arrayOfDistances[i] = currentCubes.get(i).computeSquaredDistanceToCovarianceMatrix(initialGenerationCubes.get(i));
    	}

    	Object[] data = new Object[1+ arrayOfDistances.length + 1];
    	data[0] = result.iteration();
    	double sum = 0.0;
    	for(int i = 0; i < arrayOfDistances.length; i++) {
    		data[i+1] = arrayOfDistances[i];
    		sum += arrayOfDistances[i];
    	}
    	data[arrayOfDistances.length + 1] = sum;
    	try {
			writer.addRecord(data);
		} catch (Exception e) {
			log.error("The csv printing didn't work in generation {}", result.iteration(), e);
		}
    }
    
    private List<Hypercube> fillHypercubes(final Iteration result){
    	final List<Hypercube> currentCandidates = new ArrayList<>();

    	for(int j = 0; j < hypercubeDefinitions.size(); j++) {
    		final Hypercube hypercube = new Hypercube(hypercubeDefinitions.get(j));

            result.candidates()
                    .map(Candidate::searchSpaceRepresentation)
                    .forEach(hypercube::addDataPoint);

    		currentCandidates.add(hypercube);
    	}
    	return currentCandidates;
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
    public void generateHypercubesFromRanges(final List<PropertyRange> listOfRanges, final int dimensions) {
    	final List<SortedSet<Double>> listOfBoundaries = new ArrayList<>(dimensions);

    	for(final PropertySpecification spec : specification.getProperties()) {
    		final SortedSet<Double> boundaries = new TreeSet<>();
            boundaries.add(limits.get(spec).lower().doubleValue());
            boundaries.add(limits.get(spec).upper().doubleValue());

            listOfBoundaries.add(boundaries);
    	}

    	//sorts every range into the correct dimension and sorts the interval values afterwards. 
    	for(int j = 0; j < listOfRanges.size(); j++) {
    		final PropertyRange currentRange = listOfRanges.get(j);
    		listOfBoundaries.get(currentRange.getIndexOfChromosome()).add(currentRange.getLower());
    		listOfBoundaries.get(currentRange.getIndexOfChromosome()).add(currentRange.getUpper());
    	}
    	
    	//we should have a list of sorted double values for each dimension now, containing all values existing in the dvl ranges
        //TODO changed because it was throwing error when null/ empty
        if (hypercubeDefinitions == null) hypercubeDefinitions = new ArrayList<>();
        else hypercubeDefinitions.clear();
    	addVariationsOfNextDimension(dimensions, 0, new HypercubeBuilder(dimensions), listOfBoundaries, hypercubeDefinitions);
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
