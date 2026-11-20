# Threshold accepting

## What it shows

Threshold accepting accepts a worse neighbour if it is worse by less than a
threshold (and, of course, better and equal neighbours). Unlike simulated
annealing, the decision is not random. The
threshold falls over the iterations, so the search accepts smaller and smaller
steps up and finally behaves like hill climbing.

If all neighbours of an iteration are rejected, the search ends: the threshold
only falls, so the neighbours would be rejected in every later iteration, too.

The problem is the Rastrigin function of two variables `x:0` and `x:1` in
[-5.12, 5.12]. It has a local minimum at every integer point and its global
minimum 0 at (0, 0). The search starts at (4.5, -4.5). A neighbour changes each
variable by -0.5, 0 or +0.5, so a neighbour of an integer point lies on a hill
between two local minima.

The three local search examples solve the same problem from the same start and
differ only in the accepting strategy:

| Example | Accepts a worse neighbour |
|---|---|
| `local-search-hill-climbing` | never |
| `local-search-simulated-annealing` | with a probability that falls with the temperature |
| `local-search-threshold-accepting` | if it is worse by less than a falling threshold |

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search.ol`: the problem (`specify problem`) and the configuration of the
  local search (`configure 'local-search'`).
  - `'initial-threshold' := 25.0`: a neighbour may first be worse by up to 25,
    a little more than the height of a hill.
  - `'linear-decrease'` with `'iterations' := 300`: the threshold falls linearly
    to 0 within 300 iterations.
  - `'stopping-criteria'`: the run stops after 300 iterations (`'iteration-count'`)
    or as soon as the best candidate so far is below 0.01 (`'target-value'`), i.e.,
    close to the global minimum 0. The three local search examples use the same
    target, so they show how many iterations and evaluations each strategy needs.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The neighbours are offered in a
random order, so every run is different. The log shows the seed of the run
(`Using random seed …`). Repeat a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

`output/search/candidates-per-iteration.csv` has one row per iteration with
the current candidate (`x:0`, `x:1`) and its value (`y:0`):

- In the first iterations, `y:0` goes up and down: the search moves over the
  hills between local minima.
- While the threshold falls, the search only moves downhill. If it does not
  reach the target, it ends in a local minimum: the last row repeats the
  candidate and the log says
  `No acceptable neighbour in generation … Terminating optimisation.`
- With `EVOAL_SEED=42`, the search reaches the global minimum (0, 0) with
  `y:0` = 0 in iteration 85, so `'target-value'` ends the run after 134
  evaluations. Hill climbing from the same start ends at `y:0` = 41. Other seeds
  end between 0 and 9, most of them at 0 or 1.

The three local search examples with `EVOAL_SEED=42`:

| Example | Best `y:0` | Iterations | Evaluations |
|---|---|---|---|
| `local-search-hill-climbing` | 41, stuck in a local minimum | 2 | 7 |
| `local-search-simulated-annealing` | 0, target reached | 353 | 354 |
| `local-search-threshold-accepting` | 0, target reached | 85 | 134 |

## Try next

- Lower the threshold (e.g., 5.0). The search cannot climb a hill and ends in
  the nearest local minimum, like hill climbing.
- Use the `'geometric-decrease'` instead of the linear one.
- Compare with the simulated annealing example: which one gets closer to the
  global minimum in most runs? The evaluation example `search-evaluation`
  shows how to run a search many times.
- Add `'metrics-per-iteration' {}` to `document [...]`: its column
  `evaluations.real` counts the evaluations up to every iteration.
