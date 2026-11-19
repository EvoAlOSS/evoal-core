# Evolutionary algorithm

This plugin provides the evolutionary algorithm (EA) `'evolutionary-algorithm'` of the DL
module `de.evoal.optimisation.ea.optimisation`. It runs on the step model of
`de.evoal.optimisation.api` (see the README there), like random search, local search and
particle swarm optimisation. It replaces the Jenetics-based EA, whose code is kept in
`de.evoal.optimisation.ea.jenetics` until it is deleted.

## A generation

N is `'size-of-population'`, lambda is `'number-of-offspring'`.

| Step | Kind | What happens |
|---|---|---|
| parent selection | `Selection` | `'parent-selection'` selects 2 * ceil(lambda / 2) parents; consecutive parents form a pair |
| recombination | `Adaption` | every pair becomes two children; the first lambda children are kept |
| mutation | `Adaption` | every child is mutated |
| checks of new candidates | `Check` | only if `'candidate-checks'` has such checks; `resample` varies a failed child again (`GenerationSteps.resampler`): its parents are recombined again, the child in the place of the same parent is mutated |
| evaluation | `FitnessCalculation` | in parallel if the optimisation function allows it; unchanged children keep the evaluation of their parent |
| replacement | `Acceptance` | `replacement` forms the next population of N candidates |
| population checks | `Check` | only if `'candidate-checks'` has such checks, e.g. `'maximum-age'` |

The initialisation samples N candidates from `'initialisation'` and evaluates them.

## Representation

A `Genotype` maps every search variable to exactly one chromosome
(`api.genotype`):

| Chromosome | Genes | Features |
|---|---|---|
| `'double-chromosome'` | `RealGenes`, one per feature | real |
| `'integer-chromosome'` | `IntegerGenes`, one per feature | integer |
| `'bit-chromosome'` | `BitGenes`: 1 bit per boolean, `precision` bits per real or integer, standard binary code | boolean, integer, real |
| `'gray-chromosome'` | like `'bit-chromosome'`, real and integer features in Gray code | boolean, integer, real |

Without `genotype`, the default mapping creates one chromosome per representation (real
features a double chromosome, integer features an integer chromosome, boolean features a
bit chromosome). Every search variable that is not boolean needs a lower and an upper
boundary. After every operator, `'boundary-handling'` (`stick`, `bounce`, `wrap`) brings
values outside the boundaries back.

## Operators and probabilities

Which chromosomes an operator changes is stated once, in the DL: the annotation
`@Applicability { representations; 'minimum-scale'; }` on the operator type. The
`ApplicabilityReader` reads it from the operator's DL type (also for the default
operators). The `OperatorPlan` decides per chromosome:

1. a chromosome with its own `recombination` or `mutation` list uses it; every operator in it
   must apply to the chromosome;
2. otherwise, it uses the operators of the algorithm that apply to it (skips are logged);
3. if none applies, it uses the default of its representation: double chromosomes
   `'sbx-crossover'` (probability 0.9) and `'polynomial-mutation'`, integer chromosomes
   `'uniform-crossover'` and `'random-reset-mutation'`, bit and Gray chromosomes
   `'single-point-crossover'` and `'bit-flip-mutation'`. A double chromosome with features
   below the cardinal scale gets `'uniform-crossover'` and `'random-reset-mutation'`.

Every probability has one unit (`Variation`):

- `probability` of a recombination: one draw per pair; the recombination then changes every
  chromosome it applies to. A pair that is not recombined passes on two copies.
- `probability` of a mutation: one draw per child; `'gene-probability'`: one draw per gene,
  default 1 / n with n the number of genes the mutation covers.
- Draws are `nextDouble() < p`. Operators are applied in list order.
- `'single-choice-mutation'`: if it fires, exactly one of its `children` is chosen by
  `weights` (`MutationOperator.choose`) and applied with its own gene probability; the
  property `operators` names the chosen one. It applies to the chromosomes that all its
  children apply to (`ApplicabilityReader` combines them).

Every configured operator and selection draws from its own named stream of the
`RandomService` (`de.evoal.optimisation.ea/<slot>[<index>]`), so a run gives the same
result with any number of evaluation threads.

| Operator | Representations | Minimum scale |
|---|---|---|
| `'single-point-crossover'`, `'multi-point-crossover'`, `'uniform-crossover'` | all | nominal |
| `'sbx-crossover'`, `'line-crossover'`, `'arithmetic-crossover'`, `'blx-alpha-crossover'` | double | cardinal |
| `'random-reset-mutation'` | double, integer | nominal |
| `'gaussian-mutation'`, `'polynomial-mutation'` | double | cardinal |
| `'bit-flip-mutation'` | bit, Gray | nominal |
| `'creep-mutation'` | integer | ordinal |
| `'single-choice-mutation'` | all its children have in common | the strongest of its children |

## Selections and replacements

All selections choose with replacement. Ranking and comparison use the `'comparator'` of the
algorithm; `'roulette-wheel-selection'`, `'stochastic-universal-sampling'` and
`'boltzmann-selection'` use the fitness itself and need a fitness with one component (the
configuration is rejected otherwise). The fitness is canonical (smaller is better), so the
fitness-proportional selections use the windowed weights f_max - f.

| Replacement | Next population |
|---|---|
| `'survivor-replacement'` | N - lambda parents chosen by `selection`, then all lambda children (lambda <= N) |
| `'plus-replacement'` | N of parents and children, (mu + lambda) |
| `'comma-replacement'` | N of the children, (mu, lambda) (lambda >= N) |

## Memory model

A child that was recombined refers to both parents (`Recombination`) and, if the sibling is
recorded too, to its sibling (`partner`); a child that was only mutated refers to its parent
(`Mutation`); an unchanged child is an `Identity` of its parent. The relationships have the
properties `operators` (the operators that changed the child) and `changed-features` (the
features whose genes differ from the parent whose place the child takes).

## Examples

In `src/main/examples`, each with a README:

- `ea-basic`: a real-valued benchmark with the default mapping and the default operators,
  tournament selection and a (mu + lambda) replacement.
- `ea-mixed-genotype`: a Gray chromosome and an integer chromosome with its own operators,
  roulette wheel selection and the memory model.

The surrogate plugins have examples that search on a trained model with the EA
(`surrogate.simple`, `surrogate.svr`, `surrogate.gaussianprocess`, `surrogate.onnx.simple`,
`surrogate.onnx.multi`).

## Tests

- `OperatorStatisticsTest` and `SelectionStatisticsTest`: with a fixed seed and many trials,
  the observed frequencies lie within +-4 standard deviations of the binomial expectation.
- `RealAndIntegerOperatorsTest`: line, arithmetic and BLX-alpha crossover, creep and
  single-choice mutation.
- Regressions in `src/test/regressions`: the three replacements, a mixed genotype,
  `'maximum-age'` and the real-valued operators, each with the memory model.

## References

- J. E. Baker: Adaptive selection methods for genetic algorithms. Proc. 1st International
  Conference on Genetic Algorithms, 1985, pp. 101-111.
- J. E. Baker: Reducing bias and inefficiency in the selection algorithm. Proc. 2nd
  International Conference on Genetic Algorithms, 1987, pp. 14-21.
- T. Blickle, L. Thiele: A comparison of selection schemes used in genetic algorithms.
  TIK-Report 11, ETH Zurich, 1995.
- G. E. P. Box, M. E. Muller: A note on the generation of random normal deviates. Annals of
  Mathematical Statistics 29(2), 1958, pp. 610-611.
- K. Deb, R. B. Agrawal: Simulated binary crossover for continuous search space. Complex
  Systems 9, 1995, pp. 115-148.
- K. Deb, A. Pratap, S. Agarwal, T. Meyarivan: A fast and elitist multiobjective genetic
  algorithm: NSGA-II. IEEE Transactions on Evolutionary Computation 6(2), 2002, pp. 182-197;
  reference implementation revision 1.1.6 (bounded SBX and polynomial mutation).
- L. J. Eshelman, J. D. Schaffer: Real-coded genetic algorithms and interval-schemata.
  Foundations of Genetic Algorithms 2, 1993, pp. 187-202.
- D. E. Goldberg, K. Deb: A comparative analysis of selection schemes used in genetic
  algorithms. Foundations of Genetic Algorithms 1, 1991, pp. 69-93.
- F. Gray: Pulse code communication. US patent 2,632,058, 1953.
- H. Muehlenbein, D. Schlierkamp-Voosen: Predictive models for the breeder genetic algorithm
  I. Evolutionary Computation 1(1), 1993, pp. 25-49.
- H.-P. Schwefel: Numerische Optimierung von Computer-Modellen mittels der
  Evolutionsstrategie. Birkhaeuser, 1977.
- G. Syswerda: Uniform crossover in genetic algorithms. Proc. 3rd International Conference
  on Genetic Algorithms, 1989, pp. 2-9.
