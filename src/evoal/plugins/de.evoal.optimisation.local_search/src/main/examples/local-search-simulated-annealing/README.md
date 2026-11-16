# Simulated annealing

## What it shows

Simulated annealing also accepts worse neighbours, with the probability
`exp(-(y_neighbour - y_current) / T)`. At a high temperature `T`, it accepts
most worse neighbours and wanders over the hills between local minima. While
the temperature falls, it accepts fewer and fewer worse neighbours and finally
behaves like hill climbing.

Every iteration tests a single neighbour, chosen at random. If it is rejected,
the search keeps its candidate and tries again in the next iteration, at a
lower temperature. Only the stopping criterion ends the run.

Because the search also moves to worse candidates, its last candidate is not
necessarily the best one it has visited. The writer `'best-candidate-so-far'`
records the best candidate found up to every iteration.

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
  - `'geometric-decrease'` with `'decrease-rate' := 0.998`: the temperature is
    multiplied by 0.998 in every iteration, so it is about 0.1 after the 3000
    iterations. Since every iteration tests only one neighbour, the search
    needs many iterations.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The neighbours are chosen at
random, so every run is different. The log shows the seed of the run
(`Using random seed …`). Repeat a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

`output/search/candidates-per-iteration.csv` has one row per iteration with
the current candidate (`x:0`, `x:1`) and its value (`y:0`).
`output/search/best-candidate-so-far.csv` has the same columns for the best
candidate found up to every iteration:

- In the first iterations, `y:0` often increases: the search accepts worse
  neighbours and climbs over the hills between local minima.
- Later, increases become rare and `y:0` settles in a local minimum. Many rows
  repeat the candidate, because the tested neighbour was rejected.
- With `EVOAL_SEED=42`, the search accepts 170 worse neighbours, most of them in
  the first 500 iterations. It visits the global minimum (0, 0) in iteration
  353, climbs out of it again while the temperature is still high, and ends at
  (3, 1) with `y:0` = 10. `best-candidate-so-far.csv` keeps (0, 0) from
  iteration 353 on. Hill climbing from the same start ends at `y:0` = 41.
- Other seeds end between 0 and 5, and their best candidate has `y:0` = 0 in
  most runs: the result of a single run is random.

The log shows the acceptance probability of every worse neighbour
(`Acceptance probability is …`).

## Try next

- Lower the start temperature (e.g., 5.0). The search hardly accepts worse
  neighbours and behaves like hill climbing.
- Cool faster (`'decrease-rate' := 0.98`). The search freezes in a local minimum
  after a few hundred iterations.
- Use another cooling schedule, e.g., `'linear-decrease' { 'iterations' := 3000; }`,
  `'logarithmic-decrease' {}` or `'exponential-decrease' {}`.
- Compare many runs with the evaluation example `search-evaluation`.
