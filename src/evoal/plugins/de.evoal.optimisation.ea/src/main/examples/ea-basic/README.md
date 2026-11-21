# Evolutionary algorithm

## What it shows

An evolutionary algorithm (EA) keeps a population of candidates. In every
generation it

1. selects parents (here by tournaments of 3: the best of 3 random candidates),
2. recombines pairs of parents into two children and mutates the children,
3. evaluates the children, and
4. forms the next population from parents and children (the replacement).

The problem is the Rastrigin function of five variables `x:0`, ..., `x:4` in
[-5.12, 5.12]. It has a local minimum at every integer point and its global
minimum 0 at the origin. A search that only moves to better neighbours gets
stuck in one of the many local minima (see the example
`local-search-hill-climbing`); the population and the recombination let the EA
jump between them.

The `genotype` puts the five real variables into one double chromosome with
simulated binary crossover (`'sbx-crossover'`, probability 0.9) and polynomial
mutation (`'polynomial-mutation'`, every gene with probability 1/5, the default
1 / n of a chromosome with n genes).

## Files

- `search.ddl`: the variables `x:0`, ..., `x:4` with their bounds and the
  function value `y:0`. The EA needs a lower and an upper bound for every
  variable that is not boolean.
- `search.ol`: the problem (`specify problem`) and the configuration of the EA
  (`configure 'evolutionary-algorithm'`):
  - `'size-of-population' := 40`, `'number-of-offspring' := 40`: 40 parents
    (mu) create 40 children (lambda) per generation.
  - `genotype := genotype { chromosomes := [ 'double-chromosome' { ... } ]; }`:
    the chromosome with its features, `recombination` and `mutation`.
  - `'parent-selection' := 'tournament-selection' { size := 3; }`.
  - `replacement := 'plus-replacement' { ... }`: the next population is chosen
    from the 80 parents and children together, (mu + lambda). The
    `'elite-selection'` keeps the best 2 for sure and chooses the other 38 by
    tournaments of 2.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The run is random, so every run is
different. The log shows the seed of the run (`Using random seed …`). Repeat a
run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

- `output/search/best-candidate-per-iteration.csv`: the best candidate of every
  generation; a generation has several rows if candidates are equally good,
  e.g. a parent and its unchanged copy. With the seed 42, `y:0` falls from about 52 to about 0.01 within
  the 100 generations, and all variables approach 0.
- `output/search/candidates-per-iteration.csv`: all 40 candidates of every
  generation. Plot `x:0` against `x:1` for some generations: first the
  candidates are spread over the whole search space, later they gather in the
  basins of a few local minima and finally around the origin.

## Try next

- Use a comma replacement, (mu, lambda): `replacement := 'comma-replacement'
  { selection := 'tournament-selection' { size := 2; }; };`. The parents do not
  survive, so the best value can get worse from one generation to the next.
- Use other operators for real values, e.g. `recombination := [
  'blx-alpha-crossover' { probability := 0.9; } ];` and `mutation := [
  'gaussian-mutation' { sigma := 0.1; } ];`.
- Make the selection weaker (`size := 2`) or stronger (`size := 5`) and compare
  how fast `y:0` falls.
- Combine different variable types in one search, see the example
  `ea-mixed-genotype`.

The README of the plugin `de.evoal.optimisation.ea` describes all operators,
selections and replacements, with references to the literature.
