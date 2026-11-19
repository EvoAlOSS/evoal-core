# Search towards targets with the feasibility rules

## What it shows

An evaluation of a search: the evolutionary algorithm runs 3 times for each of
the three targets in `data.json` (the Ackley values 13.59, 13.06 and 9.26 of the
points `x:0` = -4.82, 5.08 and 2.90). The goal

```
and optimise data 'y:0' towards target with distance {}
```

takes its target from the evaluation, so every run searches an `x:0` whose
Ackley value is as close as possible to its target. The DDL adds the constraint
`x:0 >= 1` (group `region`).

The constraint is not checked before the evaluation. Infeasible candidates are
evaluated and compared by the `'feasibility-comparator'` (K. Deb, 2000): a
feasible candidate is better than an infeasible one, two feasible ones are
compared by their distance to the target and two infeasible ones by their
violation. The search therefore leaves the infeasible region and finds, for
the first target, a point near `x:0 = 4.82` instead of the excluded -4.82.

## Files

- `search.ddl`: the variable `x:0`, the function value `y:0` and the constraint.
- `search.ol`: the problem with the target goal and the evolutionary algorithm
  with the feasibility comparator.
- `data.json`: the target points.

## Run

```sh
./01-run-search.sh
```

The script runs `evoal-evaluate-search.sh` with 3 repetitions and the target
points (`-Boptimisation:target-points-file=data.json`). The output is written
to `output/search/`; the files start with the columns `repetition` and
`target`.

## What to look at

- `output/search/constraint-statistics.csv`: the number of infeasible
  candidates falls to 0 within a few generations in every run.
- `output/search/best-candidate-per-iteration.csv`: the best `y:0` of every run
  approaches its target with a feasible `x:0`.

## Try next

- Replace the comparator by `'epsilon-comparator' { group := "region"; epsilon
  := 0.5; }`: a violation up to 0.5 counts as feasible.
- Add a penalty instead: `'fitness-pipeline' := [ 'constraint-penalty' { group
  := "region"; weight := 10.0; } ];` with `'numeric-comparator' {}`.
