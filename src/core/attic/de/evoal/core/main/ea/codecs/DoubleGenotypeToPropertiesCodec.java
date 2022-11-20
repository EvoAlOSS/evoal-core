package de.evoal.core.main.ea.codecs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.main.jenetics.BoundedDoubleChromosome;
import de.evoal.core.main.jenetics.BoundedDoubleGene;
import io.jenetics.DoubleGene;
import io.jenetics.Genotype;
import io.jenetics.util.DoubleRange;
import io.jenetics.util.Factory;
import org.apache.commons.math3.util.Pair;

public class DoubleGenotypeToPropertiesCodec implements CustomCodec<DoubleGene> {
	
	private final int dimensions;
	private final PropertiesSpecification specification;
	private final List<Pair<Double, Double>> limits;

	public DoubleGenotypeToPropertiesCodec(final PropertiesSpecification specification, final List<Pair<Double, Double>> limits) {
		this.dimensions = specification.getProperties().size();
		this.specification = specification;
		this.limits = limits;
	}

	@Override
	public Factory<Genotype<DoubleGene>> encoding() {
		final List<DoubleGene> listOfChromosomes = new ArrayList<>(dimensions);
		for (int i = 0; i < dimensions; i++) {
			final Pair<Double, Double> limit = limits.get(i);
			listOfChromosomes.add(DoubleGene.of(DoubleRange.of(limit.getFirst(), limit.getSecond())));
		}
		return Genotype.of(listOfChromosomes);
	}

	@Override
	public Function<Genotype<DoubleGene>, Properties> decoder() {
		return this::fromChromosome;
	}
	
	private Properties fromChromosome(final Genotype<DoubleGene> genotype) {
		final double [] vector = genotype.stream().mapToDouble(c -> c.gene().doubleValue()).toArray();

		return new Properties(specification, vector);
	}

	@Override
	public Genotype<DoubleGene> encode(final Properties individuum) {
		final double[] values = individuum.getValues();
		final List<DoubleGene> listOfChromosomes = new ArrayList<>(dimensions);

		for (int i=0; i< dimensions; i++) {
			final Pair<Double, Double> limit = limits.get(i);
			listOfChromosomes.add(DoubleGene.of(DoubleGene.of(values[i], limit.getFirst(), limit.getSecond())));
		}

		return Genotype.of(listOfChromosomes);
	}
}



