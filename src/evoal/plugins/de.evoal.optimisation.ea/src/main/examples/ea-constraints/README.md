# Evolutionary algorithm with two constraint groups

## What it shows

The constraints of the DDL belong to groups, and every group is handled by the
algorithm configuration. This example minimises the Ackley function of three
variables with two groups:

```
constraint(data 'x:0' < data 'x:1', "strict");
constraint(data 'x:0' + data 'x:1' < data 'x:2', "vague");
```

- `strict` is handled before the evaluation: a `'constraint-check'` repairs
  every new candidate (also the initial ones) that violates it with
  `'projection-repair'`, which moves the candidate onto the line `x:0 = x:1`.
  If the candidate still fails after 3 attempts, the fallback `replace` takes
  a random candidate instead.
- `vague` is handled after the evaluation: `'constraint-penalty'` adds 10 times
  its violation to the fitness, so infeasible candidates are evaluated but
  rarely selected.

The writer `'constraint-statistics'` shows per iteration and group the number of
infeasible candidates of the population and the sum of their violations; the
memory model records the degree of violation of every constraint
(`violation-1`, `violation-2`) and the repairs.

## Files

- `search.ddl`: the variables `x:0`, `x:1`, `x:2`, the function value `y:0` and
  the two constraints.
- `search.ol`: the evolutionary algorithm with the check of the group `strict`
  (`'candidate-checks'`) and the penalty of the group `vague`
  (`'fitness-pipeline'`).

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/constraint-statistics.csv`: `infeasible-strict` is 0 in every
  iteration. With the seed 42, the initial population has 6 candidates that
  violate `vague` (sum 30.9); afterwards at most 3 with small violations
  remain, since the penalty makes infeasible candidates worse.
- `output/search/memory-model/iteration-*.json`: repaired individuals have the
  properties `repair` (`projection-repair`) and `attempts` on their
  relationship; repaired initial individuals, which have no relationship, have
  them on themselves. With the seed 42, every repair succeeds in one attempt. The metric
  `constraint-evaluations` counts every measurement of a constraint.

## Try next

- Handle `vague` with `'feasibility-comparator' { group := "vague"; }` instead
  of the penalty and `'numeric-comparator'`.
- Set `'repair-fallback' := 'check-reaction.warn'` and `'maximum-attempts' :=
  1`: candidates that the projection cannot repair (e.g., because of the bounds)
  stay infeasible.

The README of the plugin `de.evoal.optimisation.api` describes the constraint
handling, with references to the literature.
