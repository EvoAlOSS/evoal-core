# Search with a benchmark function and a repaired constraint

## What it shows

An evolutionary algorithm minimises the Ackley function of one variable `x:0`
in [-5.12, 5.12]. Its minimum 0 lies at `x:0 = 0`, but the DDL excludes it with
the constraint

```
constraint(data 'x:0' >= 1.0, "region");
```

A `'constraint-check'` tests every new candidate, the initial ones and the
children, before it is evaluated. A candidate with `x:0 < 1` is repaired by
`'saturation-repair'`: the constraint is a bound of `x:0`, so the repair sets
`x:0` to the bound 1. Every evaluated candidate is therefore feasible, and the
best candidate is the constrained minimum `x:0 = 1` with the Ackley value about
3.6254.

## Files

- `search.ddl`: the variable `x:0` with its bounds, the function value `y:0` and
  the constraint of the group `region`.
- `search.ol`: the problem and the evolutionary algorithm with the check
  (`'candidate-checks'`), its reaction `repair`, the repair strategy and the
  fallback `warn` (used if the repair fails, which saturation never does here).

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: with the seed 42, `x:0`
  reaches 1.0 and `y:0` 3.6254 within the 20 generations.
- `output/search/constraint-statistics.csv`: `infeasible-region` and
  `violation-region` are 0 in every iteration, since no infeasible candidate is
  evaluated.

## Try next

- Write the memory model (`'memory-model' {}` in `document`): repaired
  candidates have the properties `repair` and `attempts` on their relationship.
- Use the reaction `'check-reaction.resample'` without `repair`: a failed child
  is varied again, at most `'maximum-attempts'` times.
- Compare with the example `search-with-benchmark-and-target`, which keeps
  infeasible candidates and prefers feasible ones in the comparison.
