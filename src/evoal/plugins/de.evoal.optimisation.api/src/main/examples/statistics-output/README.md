# Statistics output

## What it shows

The statistics writers in the `document [...]` list of a problem decide which
files a search writes. This example uses all of them on a short particle swarm
optimisation (5 particles, 10 iterations) of the Rastrigin function, so the
files stay small enough to read.

| Writer | Output | Content |
|---|---|---|
| `'best-candidate-per-iteration'` | `best-candidate-per-iteration.csv` | the best individuals (rank 0) of every iteration |
| `'candidates-per-iteration'` | `candidates-per-iteration.csv` | all individuals of every iteration |
| `'metrics-per-iteration'` | `metrics-per-iteration.csv` | the metrics of every iteration, e.g., the number of evaluations |
| `'memory-model'` | `memory-model/*.json` | the whole run: individuals, their origin, ranks and metrics |
| `none` | nothing | disables the output |

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search.ol`: the problem with the list of writers (`document [...]`) and the
  configuration of the swarm.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The search is random, so every run
is different. The log shows the seed of the run (`Using random seed …`).
Repeat a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

All files are in `output/search/`.

- `candidates-per-iteration.csv`: one row per individual and iteration with the
  columns `individual-id`, `generation`, the search space (`x:0`, `x:1`) and the
  optimisation space (`y:0`). There are 5 rows per `generation`.
- `best-candidate-per-iteration.csv`: the same columns, but only the best
  individual of every iteration. Its `individual-id` is also in
  `candidates-per-iteration.csv`: the same individual has the same id in all files.
- `metrics-per-iteration.csv`: `evaluations.real` is the number of evaluations of
  the optimisation function so far. It grows by 5 per iteration, one per particle.
  `evaluations.surrogate` counts the evaluations of a surrogate model (none here).
- `memory-model/`: the memory model of the run, written while the run is executed.
  - `execution-information.json` (before the first iteration): the problem, the
    configuration of the algorithm, the search and optimisation space, the
    definitions of the metrics, and what is needed to repeat the run (EvoAl
    version, seed).
  - `iteration-<n>.json`: the individuals of iteration `n` with their values
    (`input`, `output`) and their origin (`relationships`), their ranks
    (`ranks`) and the metrics. A particle that moved has the relationship
    `mutation` to its individual of the previous iteration. A particle whose
    position did not change has the relationship `identity`. Following the
    relationships backwards gives the path of a particle through the search
    space.
  - `execution-finished.json` (after the last iteration): the number of
    iterations and the ids of the best individuals. Its existence shows that the
    run is complete.

The format of the JSON files is described by JSON schemas
(`https://www.evoal.de/schemas/memory-model/2027.4.0/`).

## Try next

- Add `'prefix-data' := true` to a CSV writer: the columns are then named
  `search-space-value-x:0`, …, `optimisation-space-value-y:0`.
- Run the example `search-evaluation`: with several runs, every file gets the
  column `repetition`, and the memory model gets one folder per run.
