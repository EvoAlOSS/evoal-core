# Simulated annealing

## What it shows

Simulated annealing also accepts worse neighbours, with the probability
`exp(-(y_neighbour - y_current) / T)`. At a high temperature `T`, it accepts
most worse neighbours and wanders over the hills between local minima. While
the temperature falls, it accepts fewer and fewer worse neighbours and finally
behaves like hill climbing.

If all neighbours of an iteration are rejected, the search keeps its candidate
and tries again in the next iteration, at a lower temperature. Only the
stopping criterion ends the run.

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
  - `'initial-temperature' := 40.0`: the start temperature. A neighbour that is
    worse by 20 (about the height of a hill) is first accepted with probability
    `exp(-20 / 40)` ≈ 0.6.
  - `'geometric-decrease'` with `'decrease-rate' := 0.98`: the temperature is
    multiplied by 0.98 in every iteration.

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

- In the first iterations, `y:0` often increases: the search accepts worse
  neighbours and climbs over the hills between local minima.
- Later, increases become rare and `y:0` settles in a local minimum.
- The run uses all 300 iterations. At the end, it repeats a candidate in many
  rows, because all neighbours were rejected.
- With `EVOAL_SEED=42`, the search accepts 40 worse neighbours and ends at
  (3, -1) with `y:0` = 10. Hill climbing from the same start ends at
  `y:0` = 41. Other seeds end between 1 and 17 in most runs, and sometimes in
  a worse local minimum: the result of a single run is random.

The log shows the acceptance probability of every worse neighbour
(`Acceptance probability is …`).

## Try next

- Lower the start temperature (e.g., 5.0). The search hardly accepts worse
  neighbours and behaves like hill climbing.
- Cool faster (`'decrease-rate' := 0.9`). The search freezes in a local minimum
  after a few iterations.
- Use another cooling schedule, e.g., `'linear-decrease' { 'iterations' := 300; }`,
  `'logarithmic-decrease' {}` or `'exponential-decrease' {}`.
- Compare many runs with the evaluation example `search-evaluation`.
