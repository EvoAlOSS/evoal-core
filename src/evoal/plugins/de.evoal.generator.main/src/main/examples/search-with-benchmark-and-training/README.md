# Search with a benchmark function and replacements from training data

## What it shows

The same problem as `search-with-benchmark`: the Ackley function of `x:0` with
the constraint `x:0 >= 1` (group `region`). Here, a new candidate that violates
the constraint is not repaired but replaced: the `'constraint-check'` has the
reaction `replace`, and its `'replacement-source'` is a
`'training-population'`, which draws random points of the training data
`training.json` (with repetition).

The training data has three points, `x:0` = -4.82, 5.08 and 2.90. The first one
violates the constraint. A replacement is not tested again by the check, so a
replacement with `x:0 = -4.82` enters the search as an infeasible candidate. It
is evaluated and recorded with its degree of violation, and the selection soon
drops it, since its Ackley value is high.

## Files

- `search.ddl`: the variable `x:0`, the function value `y:0` and the constraint.
- `search.ol`: the evolutionary algorithm with the check and its replacement
  source.
- `training.json`: the training data (`x:0`, `y:0`).

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/constraint-statistics.csv`: with the seed 42, the initial
  population has two infeasible candidates (both replacements with
  `x:0 = -4.82`, violation 5.82 each); from the first generation on, there are
  none.
- `output/search/best-candidate-per-iteration.csv`: the best candidate
  approaches the constrained minimum `x:0 = 1` (`x:0` = 1.0039, `y:0` = 3.639
  with the seed 42).

## Try next

- Remove the infeasible point from `training.json`: then every replacement is
  feasible.
- Use `'training-population'` also as `'initialisation'`.
