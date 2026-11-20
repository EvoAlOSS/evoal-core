# Random search

## What it shows

Random search samples candidates uniformly from the search space, independently
of each other, and keeps the best one found so far. It uses no information
about the problem. That makes it the baseline for every other algorithm: an
algorithm that is not better than random search with the same number of
evaluations does not exploit the structure of the problem.

Here, every iteration samples 20 candidates, in the iterations 0 to 100. These
are 2020 evaluations, as many as the particle swarm of the example `pso-basic`
may use on the same problem. Both stop earlier if their best candidate so far
is below 0.01.

The problem is the Ackley function of two variables `x:0` and `x:1` in
[-32.768, 32.768]. It is almost flat far from the origin, has many small local
minima, and its global minimum 0 at (0, 0).

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search.ol`: the problem (`specify problem`) and the configuration of the
  random search (`configure 'random-search'`):
  - `'samples-per-iteration' := 20`: the number of candidates per iteration.
  - `'initialisation' := 'random-population' {}`: where the candidates come
    from; here, uniformly random points of the search space.
  - `'stopping-criteria'`: the run stops after 100 iterations (`'iteration-count'`)
    or as soon as the best candidate so far is below 0.01 (`'target-value'`), i.e.,
    close to the global minimum 0. `pso-basic` uses the same criteria.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The samples are random, so every run
is different. The log shows the seed of the run (`Using random seed …`). Repeat
a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

- `output/search/best-candidate-so-far.csv`: the best candidate found up to
  every iteration. With `EVOAL_SEED=42`, it improves only four times (in the
  iterations 0, 7, 36 and 58) and ends with `y:0` ≈ 4.2 after all 2020
  evaluations: it does not reach the target 0.01. The particle swarm of
  `pso-basic` falls below the target in iteration 80, after 1620 evaluations.
- `output/search/best-candidate-per-iteration.csv`: the best of the 20 samples
  of every iteration. It does not improve over time: every iteration starts
  from scratch.

## Try next

- Sample more per iteration (`'samples-per-iteration' := 100`) and compare the
  best value with the number of evaluations.
- Add `'memory-model' { 'steps' := true; }` to `document [...]`: the memory
  model (see the example `statistics-output`) then also lists the steps of every
  iteration (sample, evaluate, accept).
