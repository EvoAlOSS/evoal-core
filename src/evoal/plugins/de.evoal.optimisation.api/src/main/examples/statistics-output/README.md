# Statistics output

## What it shows

The statistics writers in the `document [...]` list of a problem decide which
files a search writes. This example uses all of them on a short particle swarm
optimisation (5 particles, 10 iterations) of the Rastrigin function, so the
files stay small enough to read.

| Writer | Output | Content |
|---|---|---|
| `'best-candidate-per-iteration'` | `best-candidate-per-iteration.csv` | the best individuals (rank 0) of every iteration |
| `'best-candidate-so-far'` | `best-candidate-so-far.csv` | the best individual found up to every iteration |
| `'candidates-per-iteration'` | `candidates-per-iteration.csv` | all individuals of every iteration |
| `'metrics-per-iteration'` | `metrics-per-iteration.csv` | the metrics of every iteration, e.g., the number of evaluations |
| `'memory-model'` | `memory-model/*.json` | the whole run: individuals with objectives and fitness, their origin, ranks and metrics |
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
- `best-candidate-so-far.csv`: the same columns, but the best individual found up
  to and including every iteration. If the swarm gets worse, the row keeps the
  earlier individual (with its earlier `individual-id`), so the values never get
  worse.
- `metrics-per-iteration.csv`: `evaluations.real` is the number of evaluations of
  the optimisation function so far. It grows by 5 per iteration, one per particle.
  `evaluations.surrogate` counts the evaluations of a surrogate model (none here).
- `memory-model/`: the memory model of the run, written while the run is executed.
  - `execution-information.json` (before the first iteration): the problem with
    the configuration of its optimisation function, the configuration of the
    algorithm and of the statistics writers (`documentation`) with all
    attributes, the search and optimisation space, the components of the fitness
    (`fitness`), the definitions of the metrics, and what is needed to repeat the
    run (EvoAl version, seed).
  - `iteration-<n>.json`: the individuals of iteration `n` with their values
    (`input`, `output`), their fitness (`fitness`, one value per component of
    `execution-information.json`; smaller is better, so a maximised objective
    appears negated) and their origin (`relationships`), their ranks
    (`ranks`) and the metrics. A particle that moved has the relationship
    `mutation` to its individual of the previous iteration. A particle whose
    position did not change has the relationship `identity`. Following the
    relationships backwards gives the path of a particle through the search
    space. `bestSoFar` is the id of the best individual found so far; it can
    belong to an earlier iteration.
  - `execution-finished.json` (after the last iteration): the number of
    iterations and the ids of the best individuals. Its existence shows that the
    run is complete.

  This is the final version of the memory model (`'memory-model' {}`): an
  iteration holds its ranked members, related to the previous iteration, and its
  `steps` are empty. With `'memory-model' { 'steps' := true; }`, the steps version
  is written: every executed step (e.g. `Adaption: move the particles`) is listed
  with the ids of its outputs, the `individuals` of an iteration also contain
  these outputs, and every individual is related to its direct predecessor, which
  may belong to the same iteration. Both versions use the same ids. The particles
  of a swarm stay in the swarm, so the steps of this example have no outputs;
  in the steps version of an evolutionary algorithm, the selection lists the
  selected parents, the recombination the recombined children (`recombination`
  of the parents) and the mutation the mutated children (`mutation` of the
  recombined child).

The format of the JSON files is described by JSON schemas
(`https://www.evoal.de/schemas/memory-model/2027.4.0/`).

## Try next

- Write the steps version (`'memory-model' { 'steps' := true; }`) and compare
  `iteration-1.json` with the final version; for the outputs of the steps, add the
  writer to the example `ea-basic`.

- Add `'prefix-data' := true` to a CSV writer: the columns are then named
  `search-space-value-x:0`, …, `optimisation-space-value-y:0`.
- Run the example `search-evaluation`: with several runs, every file gets the
  column `repetition`, and the memory model gets one folder per run.
