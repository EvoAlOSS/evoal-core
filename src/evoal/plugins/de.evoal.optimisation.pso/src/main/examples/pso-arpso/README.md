# Attractive-repulsive particle swarm optimisation (ARPSO)

## What it shows

A swarm that contracts around a local minimum stops exploring: all particles
are close together and none of them finds a better region. The
attractive-repulsive PSO (Riget and Vesterstrøm) measures the diversity of the
swarm, i.e., the mean distance of the particles to their mean position,
relative to the diagonal of the search space:

- If the diversity falls below `'diversity-low'`, the swarm switches to
  repulsion: the particles are pushed away from their personal and
  neighbourhood best positions, and the swarm spreads out again.
- If the diversity rises above `'diversity-high'`, it switches back to
  attraction and contracts again.

The problem is the Rastrigin function of two variables `x:0` and `x:1` in
[-5.12, 5.12]. It has a local minimum at every integer point and its global
minimum 0 at (0, 0).

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search.ol`: the configuration of the swarm:
  - `'arpso-swarm'` with `'diversity-low' := 0.02` and `'diversity-high' := 0.25`.
  - `'arpso-mover'`: the velocity update of the basic mover, reversed while the
    swarm repels. The inertia falls from 0.9 to 0.4 within the first 50
    iterations, so the swarm contracts early and the switches happen during
    the 200 iterations.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The initial swarm and the moves are
random, so every run is different. The log shows the seed of the run
(`Using random seed …`). Repeat a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

- The log: every switch is logged as `Repelling at iteration: …` and
  `Attracting at iteration: …`. With `EVOAL_SEED=42`, the swarm switches to
  repulsion at iterations 92, 124, 155 and 190, and back to attraction 6 to 11
  iterations later each time.
- `output/search/candidates-per-iteration.csv`: plot `x:0` against `x:1` for
  the generations around a switch. During repulsion, the particles fly apart;
  during attraction, they contract again.
- `output/search/best-candidate-per-iteration.csv`: the best particle of every
  iteration gets worse while the swarm repels and better again afterwards.

## Try next

- Raise `'diversity-low'` (e.g., 0.05): the swarm repels earlier and more often.
- Lower `'diversity-low'` to 0.000005: the swarm never repels and behaves like
  the basic PSO.
- Replace the swarm and mover with `'default-swarm' {}` and the `'basic-mover'`
  of `pso-basic` and compare.
