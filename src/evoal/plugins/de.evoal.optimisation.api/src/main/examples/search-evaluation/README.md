# Evaluating a search with repeated runs

## What it shows

Heuristic searches are random: two runs of the same configuration give
different results. One run therefore says little about how good a
configuration is. The application `heuristic-search-evaluation`
(`bin/evoal-evaluate-search.sh`) runs the same configuration several times and
writes the results of all runs into the same files, with the additional column
`repetition`.

This example runs the simulated annealing search of the example
`local-search-simulated-annealing` 10 times. Each run gets its own random
numbers, derived from the seed of the evaluation and the number of the run, so
the whole evaluation can be repeated with one seed.

## Files

- `search.ddl`, `search.ol`: the same as in `local-search-simulated-annealing`.
- `01-run-evaluation.sh`: calls `evoal-evaluate-search.sh` with the number of
  runs (10) as the fourth argument.

## Run

```sh
./01-run-evaluation.sh
```

The output is written to `output/search/`. The log shows the seed of the
evaluation (`Using random seed …`). Repeat the evaluation with its seed, for
example:

```sh
EVOAL_SEED=42 ./01-run-evaluation.sh
```

## What to look at

- `output/search/candidates-per-iteration.csv` starts with the column
  `repetition` (0 to 9). The last row of every repetition is the result of that
  run. The results differ from run to run: most runs end in a local minimum
  with a small value, a few end further up. With `EVOAL_SEED=42`, the results
  of the 10 runs range from 1 to 16 with a median of 5.
- To compare configurations, compare the distribution of the results, e.g.,
  their median, not single runs.

## Try next

- Change the accepting strategy to `'hill-climber' {}` (see
  `local-search-hill-climbing`) and compare the results of the 10 runs.
- Add `'memory-model' {}` to `document [...]` in `search.ol`: every run gets its
  own folder `output/search/memory-model/repetition-<n>`.
- Give the evaluation a file of target points with
  `-Boptimisation:target-points-file=<file>` as additional argument: every
  target is then searched for 10 times, and the files get the column `target`.
