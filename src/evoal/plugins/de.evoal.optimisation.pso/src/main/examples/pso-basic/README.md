# Particle swarm optimisation

## What it shows

A particle swarm searches with a set of particles (here 20). Every particle has
a position and a velocity. In every iteration, the velocity of a particle is
pulled towards two positions:

- the best position the particle itself has found (personal best), and
- the best position its neighbours have found (neighbourhood best).

The inertia `w` keeps a part of the old velocity. A large inertia lets the
particles fly over the search space (exploration), a small one lets the swarm
contract around the best position found (exploitation). Here, the inertia falls
from 0.9 to 0.4 during the run.

The problem is the Ackley function of two variables `x:0` and `x:1` in
[-32.768, 32.768]. It is almost flat far from the origin, has many small local
minima, and its global minimum 0 at (0, 0).

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search.ol`: the problem (`specify problem`) and the configuration of the
  swarm (`configure 'particle-swarm-optimisation'`):
  - `'size-of-population' := 20`: the number of particles.
  - `'basic-mover'`: the velocity update with `'inertia-start'`, `'inertia-end'`,
    `'inertia-iterations'` and the weights `'c1'` (personal best) and `'c2'`
    (neighbourhood best).
  - `'boundary-type' := 'boundary-handling.bounce'`: a particle that leaves the
    search space is reflected at the boundary.
  - `'topology' := 'topology.global'`: the neighbourhood of every particle is
    the whole swarm.
  - `'stopping-criteria'`: the run stops after 100 iterations (`'iteration-count'`)
    or as soon as the best particle so far is below 0.01 (`'target-value'`), i.e.,
    close to the global minimum 0. The example `random-search` uses the same
    criteria.

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

- `output/search/best-candidate-per-iteration.csv`: the best particle of every
  iteration. `y:0` falls from about 8, and `x:0`, `x:1` approach 0. With
  `EVOAL_SEED=42`, the best particle so far is below the target 0.01 in iteration 80
  (`y:0` ≈ 0.0074), so `'target-value'` ends the run after 1620 evaluations.
  Random search (example `random-search`) does not get below 4.2 with 2020
  evaluations.
- `output/search/candidates-per-iteration.csv`: all 20 particles of every
  iteration (`generation`). Plot `x:0` against `x:1` for some generations:
  first the particles are spread over the whole search space, at the end they
  are close together around (0, 0). Every particle keeps its `individual-id`
  only for one iteration; the memory model (see the example `statistics-output`)
  relates the positions of a particle.

## Try next

- Keep the inertia high (`'inertia-end' := 0.9`). The swarm does not contract and
  does not get close to the optimum.
- Lower the target (e.g., `'target' := 0.001`) and compare how many more
  iterations the swarm needs.
- Use other boundary handling: `'boundary-handling.stick'` (the particle stops
  at the boundary) or `'boundary-handling.wrap'` (it reenters on the other side).
- Use another mover: `'constriction-factor-mover' { 'c1' := 2.05; 'c2' := 2.05; }`
  (no inertia, the velocity is damped by a constriction factor) or
  `'fips-mover' { phi := 4.1; }` (every particle is informed by all its neighbours).
- Change the neighbourhood, see the example `pso-topologies`.
