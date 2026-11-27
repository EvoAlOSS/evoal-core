# Evolutionary algorithm on a noisy function

## What it shows

Many optimisation functions do not return the same value twice: games, simulations and
measurements are noisy. An algorithm that evaluates every candidate once believes a lucky
value. With elitism, a candidate whose single evaluation was too good survives forever and
stays the best of the run, although its true value is worse.

This example runs the same evolutionary algorithm twice on the Rastrigin function of five
variables (see the example `ea-basic`), with Gaussian noise of standard deviation 2 on every
evaluation (`'noisy-function'`):

1. `single-evaluation.ol`: every candidate is evaluated once (`'single-evaluation'`, the
   default).
2. `re-evaluation.ol`: every member of the population is evaluated once more in every
   generation, and its objective is the mean of all its samples (`'re-evaluation'`). A
   survivor is judged by more and more samples, so a lucky value does not keep it in the
   population.

Both runs have the same budget of 4000 evaluations. Re-evaluation spends 40 of the 80
evaluations of a generation on the members, so it runs fewer generations. Re-evaluation and
averaging over several samples are the usual remedies for noisy objectives (Y. Jin, J. Branke:
Evolutionary Optimization in Uncertain Environments — A Survey. IEEE Transactions on
Evolutionary Computation 9(3), 2005, pp. 303–317).

## Files

- `search.ddl`: the variables `x:0`, ..., `x:4` in [-5.12, 5.12] and the function value
  `y:0`.
- `single-evaluation.ol`, `re-evaluation.ol`: the same problem and EA; they differ only in
  `'evaluation-strategy'`. The problem writes
  - `candidates-per-iteration` with the objective the algorithm sees (the noisy value, or
    the mean of the samples), and
  - `reference-values-per-individual` with the value of the function without noise
    (`reference := 'problem-function' {}`) for the same rows.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/single-evaluation/` and `output/re-evaluation/`. The noise
depends on the seed; repeat a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

Join `candidates-per-iteration.csv` and `reference-values-per-individual.csv` of a run by
`individual-id` and `generation`, and compare the best `y:0` the algorithm sees with the value
without noise of the same individual. With the seed 42:

| Run | Generations | Best value seen | Its value without noise |
|---|---|---|---|
| single evaluation | 134 | -2.03 (from generation 67 on) | 5.33 |
| re-evaluation | 57 | 0.59 | 3.23 |

With a single evaluation, one lucky evaluation of -2.03 stays the best value from generation
67 to the end. With re-evaluation, the values
seen are still too optimistic, since the selection prefers lucky samples, but the best
candidate is better without noise, although the run had fewer generations.

## Try next

- Evaluate every new candidate several times: `'evaluation-strategy' := 're-evaluation' {
  samples := 3; };` or, for every algorithm, `'resampling' { samples := 3; }`.
- Use the median instead of the mean: `aggregation := 'sample-aggregation.median';`.
- Change the noise: `'standard-deviation' := 0.5;` or `noise := 'noise-model.multiplicative';`.
- Add `'memory-model' {}` to `document [...]`: every individual has the number of its samples
  (`samples`) and their standard deviation (`objective-standard-deviations`), and a
  re-evaluated member is related to its previous individual with the property
  `re-evaluated`.
