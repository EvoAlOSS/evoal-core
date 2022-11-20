package de.evoal.core.main.ea.codecs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.main.ea.chromosomes.BitHelper;
import de.evoal.core.main.ea.chromosomes.NaiveBoundedBitChromosome;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import org.apache.commons.math3.util.Pair;

public class BitGenotypeToPropertiesCodec implements CustomCodec<BitGene> {
	
	private final int dimensions;
	private final PropertiesSpecification specification;
	private final List<Pair<Double, Double>> limits;
	private final Random random;
	private final int scale;
	
	public BitGenotypeToPropertiesCodec(final PropertiesSpecification specification, final List<Pair<Double, Double>> limits, int scale) {
		this.dimensions = specification.getProperties().size();
		this.specification = specification;
		this.limits = limits;
		this.random = new Random();
		this.scale= scale;
	}

	@Override
	public Factory<Genotype<BitGene>> encoding() {
		final List<BitChromosome> listOfChromosomes = new ArrayList<>(dimensions);
		for (int i=0; i< dimensions; i++) {
			final Pair<Double, Double> limit = limits.get(i);
			listOfChromosomes.add(NaiveBoundedBitChromosome.of(limit.getFirst(), limit.getSecond(), scale));
		}

		return Genotype.of(listOfChromosomes);
	}

	@Override
	public Function<Genotype<BitGene>, Properties> decoder() {
		return this::fromChromosome;
	}
	
	private Properties fromChromosome(final Genotype<BitGene> genotype) {
		double[] vector = new double[genotype.length()];
		
		for(int i = 0; i< genotype.length(); i++) {
			final BitChromosome chr = (BitChromosome)genotype.get(i); // nasty girl
			final byte [] bytes = chr.toByteArray();

			vector[i] = BitHelper.toDouble(bytes, scale);
		}

		return new Properties(specification, vector);
	}

	@Override
	public Genotype<BitGene> encode(final Properties individuum) {
		final List<BitChromosome> listOfChromosomes = new ArrayList<>(dimensions);

		for (int i = 0; i < dimensions; i++) {
			final Pair<Double, Double> limit = limits.get(i);
			listOfChromosomes.add(NaiveBoundedBitChromosome.of(individuum.getValues()[i], limit.getFirst(), limit.getSecond(), scale));
		}

		return Genotype.of(listOfChromosomes);
	}
}



