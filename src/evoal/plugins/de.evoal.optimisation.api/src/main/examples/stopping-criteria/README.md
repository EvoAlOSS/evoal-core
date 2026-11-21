# Stopping criteria

## What it shows

The stopping criteria decide when a search ends. A configuration can list
several criteria; the search stops as soon as one of them is met.

| Criterion | Stops |
|---|---|
| `'iteration-count'` | after `'maximum-iterations'` iterations (the initial evaluation is iteration 0) |
| `'evaluation-budget'` | when the optimisation function has been evaluated `'maximum-evaluations'` times |
| `'target-value'` | when the best candidate so far is better than `'target'` in the objective `'objective'` |
| `'stagnation'` | when a measure of the fitness (`'best-fitness'` or `'mean-fitness'`) has not improved by more than the tolerance for `'iterations'` iterations |
| `'file-check'` | when the file `'file'` (default `evoal-stop.txt`) exists in the working folder |
| `'all-of'` | when all of its `criteria` are met |
| `'any-of'` | when at least one of its `criteria` is met |

An evaluation budget makes algorithms comparable: a swarm of 20 particles uses
20 evaluations per iteration, a local search between 1 and 8. Comparing them
after the same number of iterations would be unfair; comparing them after the
same number of evaluations is not.

If the budget runs out in the middle of an iteration, `'exhaustion'` decides:

- `'budget-exhaustion.finish-iteration'` (default): the iteration is finished, so
  the run can use a few more evaluations than the budget.
- `'budget-exhaustion.cut-off'`: the run stops at once, never uses more than the
  budget, and records the partial iteration.

This example runs a particle swarm of 20 particles on the Rastrigin function
with the criteria "1000 iterations" and "310 evaluations".

## Files

- `search.ddl`: the variables `x:0`, `x:1` with their bounds and the function value `y:0`.
- `search.ol`: the problem and the swarm with the list of `'stopping-criteria'`.

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

- `output/search/metrics-per-iteration.csv`: `evaluations.real` is the number of
  evaluations so far. It is 20 after iteration 0 and grows by 20 per iteration.
  After iteration 14, it is 300, below the budget of 310. Iteration 15 needs 20
  more evaluations, and it is finished: the run ends with 320 evaluations, after
  iteration 15.
- The log shows the check of every criterion after each iteration, e.g.,
  `Check termination 320 >= 310.` of the `EvaluationBudgetCriterion`.
- `output/search/best-candidate-per-iteration.csv`: the best particle of each of
  the 16 iterations (0 to 15).

## Try next

- Set `'exhaustion' := 'budget-exhaustion.cut-off'`: the run ends with exactly 310
  evaluations; the last iteration is only partly evaluated.
- Lower `'maximum-iterations'` to 5: now the iteration count stops the run first.
- Replace the budget by
  `'stagnation' { 'iterations' := 5; 'relative-tolerance' := 0.01; 'measure' := 'best-fitness' {}; }`:
  the swarm stops when its best fitness has not improved by more than 1 % for 5
  iterations. To require a minimum number of iterations as well, combine both:
  `'all-of' { 'criteria' := ['stagnation' { … }, 'iteration-count' { 'maximum-iterations' := 20; }]; }`.
- Add `'file-check' {}` to the list, start the search with a large budget, and
  create the file `evoal-stop.txt` in the example folder while it runs.
  Since the result then depends on something outside the run, the memory model
  records a reproducibility note (`execution-information.json`).
