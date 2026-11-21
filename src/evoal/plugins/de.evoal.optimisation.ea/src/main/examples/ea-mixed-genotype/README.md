# Evolutionary algorithm with a mixed genotype

## What it shows

The genotype is how the EA represents a candidate: a list of chromosomes, each
holding the genes of some variables. Every chromosome has a representation and
lists its own operators; an operator must support the representation of its
chromosome. This example combines two representations:

| Chromosome | Variables | Genes | Operators |
|---|---|---|---|
| `'gray-chromosome'` | `x:0`, `x:1` (real) | 12 bits per variable in Gray code | two-point crossover and bit-flip mutation |
| `'integer-chromosome'` | `n:0`, `n:1` (integer) | one integer per variable | uniform crossover and creep mutation |

A Gray code divides the range of a variable into 2^12 steps and codes
neighbouring steps by bit strings that differ in one bit, so flipping one bit
can always move a value by one step.

The parents are chosen by roulette wheel selection: the chance of a candidate
grows with how much better it is than the worst candidate of the population.

The problem is the Rastrigin function of the four variables. Its global minimum
0 is at the origin.

## Files

- `search.ddl`: the real variables `x:0`, `x:1` in [-5.12, 5.12], the integer
  variables `n:0`, `n:1` in [-5, 5] and the function value `y:0`.
- `search.ol`: the problem and the configuration of the EA:
  - `genotype := genotype { chromosomes := [...] }`: the two chromosomes, each
    with its `recombination` and `mutation`. The Gray chromosome uses
    `'multi-point-crossover' { points := 2; ... }` and `'bit-flip-mutation'`; the
    bit-flip mutation applies only to bit and Gray chromosomes, so the integer
    chromosome uses `'creep-mutation'` instead.
  - `'parent-selection' := 'roulette-wheel-selection' {}`.
  - `replacement := 'survivor-replacement' { ... }`: the 20 children replace 20
    of the 30 parents. Of the parents, the best 2 survive for sure, the other 8
    are chosen by stochastic universal sampling.
  - `document [..., 'memory-model' {}]`: writes the lineage of every candidate.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: the best candidates of
  every generation. With the seed 42, the integer variables reach 0 after 15
  generations, and the real variables stay near (2, 1), a local minimum with the
  value 5: roulette wheel selection hardly prefers a slightly
  better candidate once the population is close together.
- `output/search/memory-model/iteration-<n>.json`: every child refers to its
  parents (`Recombination`, `Mutation` or `Identity`). The property `operators`
  names the operators that changed the child, `changed-features` the variables
  whose genes changed.

## Try next

- Use tournament selection (`'parent-selection' := 'tournament-selection'
  { size := 3; };`) and compare the best values.
- Replace `'gray-chromosome'` by `'bit-chromosome'` (standard binary code):
  neighbouring values can then differ in many bits.
- Put `x:0` and `x:1` into a `'double-chromosome'`. The two-point crossover still
  applies to it, the bit-flip mutation does not: the configuration is rejected
  until the chromosome gets a mutation for real values, e.g.
  `'polynomial-mutation' {}` (see the example `ea-basic`).
