# Hill climbing

## What it shows

Hill climbing moves to a better neighbour as long as there is one. It stops in
the first local minimum it reaches, even if a better solution is only a few
steps away.

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
  - `'accepting-strategy' := 'hill-climber' {}` accepts only better neighbours.
  - `'manual-strategy'` with step size 0.5 creates the 8 neighbours of a candidate.

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

- `y:0` decreases in every row.
- After a few iterations, the candidate is an integer point, i.e., a local
  minimum. All its neighbours are worse, so the search ends. The last row
  repeats the candidate and the log says
  `No acceptable neighbour in generation … Terminating optimisation.`
- Which local minimum is reached depends on the order of the neighbours. With
  `EVOAL_SEED=42`, the search ends after 2 iterations at (5, -4) with
  `y:0` = 41, far from the global minimum 0.

Compare with the simulated annealing and threshold accepting examples, which
leave the local minimum.

## Try next

- Use a smaller step size (e.g., 0.1). The search takes more iterations, but it
  still ends in a local minimum.
- Start at another point (`'specify-candidates'`), e.g., (0.4, 0.4).
- Set `'neighbour-order' := 'neighbour-order.fixed';` in the `'manual-strategy'`.
  The neighbours are then always offered in the same order, so the search
  always takes the same path.
