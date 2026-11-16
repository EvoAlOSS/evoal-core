# Topologies of a particle swarm

## What it shows

The topology decides which particles inform each other, i.e., which
neighbourhood best attracts a particle:

| Topology | Neighbourhood of a particle |
|---|---|
| `topology.global` | the whole swarm |
| `topology.ring` | the `'neighborhood-size'` particles next to it on a ring of all particles |
| `topology.star` | one central particle informs all others |
| `topology.square` | its neighbours on a grid |

With the global topology, a good position found by one particle attracts the
whole swarm at once: the swarm contracts fast. In a ring, a good position
spreads slowly from neighbour to neighbour: the swarm stays spread out longer
and explores more, but improves more slowly.

The example runs the same swarm twice, once with each topology. Both use a
constant inertia, so the topology alone decides how fast the swarm contracts.

The problem is the Rastrigin function of two variables `x:0` and `x:1` in
[-5.12, 5.12]. It has a local minimum at every integer point and its global
minimum 0 at (0, 0).

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search-global.ol`: 20 particles with `'topology' := 'topology.global'`.
- `search-ring.ol`: the same with `'topology' := 'topology.ring'` and
  `'neighborhood-size' := 2`: every particle sees its two neighbours on the ring.
- The `'basic-mover'` of both uses the constant inertia 0.7298 and
  `'c1'` = `'c2'` = 1.49618 (constants of Clerc and Kennedy).

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search-global/` and `output/search-ring/`.
The initial swarm and the moves are random, so every run is different. The log
shows the seed of each search (`Using random seed …`). Repeat a run with a seed,
for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

Compare `candidates-per-iteration.csv` of both folders. It contains all 20
particles of every iteration (`generation`):

- Spread of the swarm: plot `x:0` against `x:1` for the generations 10, 25 and
  50, or compute the mean distance of the particles to their mean position. The
  ring stays clearly more spread out. Over many seeds, the mean distance after 50
  iterations is about 0.3–1.0 with the global topology and about 1.2–1.8 in the
  ring.
- Progress: `best-candidate-per-iteration.csv` falls faster with the global
  topology. After 50 iterations, the best particle has a value of about 0.03
  (global) and 0.2 (ring) in a typical run.

On this small, two-dimensional problem, both topologies find the global minimum
in most runs, and the global one is faster. The slower contraction of the ring
pays off on harder problems with many variables and local minima, where a
fast-contracting swarm gets stuck.

## Try next

- Change `'neighborhood-size'` in `search-ring.ol` (e.g., 4 or 10) and see how
  fast the swarm contracts.
- Try `'topology.star'` and `'topology.square'`.
- Use a falling inertia as in `pso-basic`. The inertia then dominates the
  contraction and the topologies hardly differ.
