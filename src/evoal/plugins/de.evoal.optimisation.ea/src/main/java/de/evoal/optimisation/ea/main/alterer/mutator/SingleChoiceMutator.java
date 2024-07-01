/*
 * Java Genetic Algorithm Library (jenetics-7.1.0).
 * Copyright (c) 2007-2022 Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package de.evoal.optimisation.ea.main.alterer.mutator;

import de.evoal.optimisation.ea.api.operators.AltererComponent;
import io.jenetics.Alterer;
import io.jenetics.AltererResult;
import io.jenetics.Gene;
import io.jenetics.Phenotype;
import io.jenetics.util.ISeq;
import io.jenetics.util.RandomRegistry;
import io.jenetics.util.Seq;
import lombok.extern.slf4j.Slf4j;

import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * Combines several alterers to one.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 5.0
 */
@Slf4j
public final class SingleChoiceMutator<
	G extends Gene<?, G>,
	C extends Comparable<? super C>
>
	implements AltererComponent
{

	private final ISeq<Alterer<G, C>> _alterers;

	private final RandomGenerator random = RandomRegistry.random();

	/**
	 * Combine the given alterers.
	 *
	 * @param alterers the alterers to combine.
	 * @throws NullPointerException if one of the alterers is {@code null}.
	 */
	public SingleChoiceMutator(final Seq<Alterer<G, C>> alterers) {
		_alterers = ISeq.of(alterers);
	}

	@Override
	public AltererResult alter(
		final Seq population,
		final long generation
	) {
		final ISeq<Phenotype> results =
                (ISeq<Phenotype>) population.stream()
                          .map(Phenotype.class::cast)
                          .map(p -> {
							  final int aIndex = random.nextInt(0, _alterers.size());
							  final Alterer alterer = _alterers.get(aIndex);

							  log.debug("Calling alterer {}", alterer.getClass().getSimpleName());

							  return alterer.alter(ISeq.of((Phenotype)p), generation);
                          })
                        .map(r -> ((AltererResult)r).population().get(0))
                        .map(Phenotype.class::cast)
                        .collect(ISeq.toISeq());

		return new AltererResult(
			results, (int)generation
		);
	}

	@Override
	public String toString() {
		return format(
			"%s:\n%s", getClass().getSimpleName(),
			_alterers.stream()
				.map(a -> "   - " + a)
				.collect(Collectors.joining("\n"))
		);
	}
}
