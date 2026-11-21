# NSGA-II on ZDT1

## What it shows

With several goals, there is usually no single best candidate: a candidate that is
better in one goal is worse in another. A candidate is **Pareto-optimal** if no
other candidate is at least as good in every goal and better in one (it is not
*dominated*). The Pareto-optimal candidates form the **Pareto front**, the best
trade-offs between the goals.

NSGA-II (Deb et al. 2002) searches for the whole front at once:

- It sorts the candidates into **non-dominated fronts**: the first front are the
  candidates no other candidate dominates, the second front the ones only the
  first front dominates, and so on.
- Within a front, the **crowding distance** measures how much room a candidate
  has: the distance between its two neighbours in every goal. The candidates at
  the ends of the front get an infinite distance.
- Parents are chosen by binary tournaments with the **crowded comparison**: the
  lower front wins; in the same front, the larger crowding distance wins.
- Parents and children together are sorted into fronts, and the best fronts
  survive. The last front that does not fit completely keeps the candidates with
  the largest crowding distance, so the front stays spread out.

The problem is ZDT1 (Zitzler, Deb and Thiele 2000) with 30 variables in [0, 1]
and two minimised goals:

- `f:1` = x_1,
- `f:2` = g * (1 - sqrt(f_1 / g)) with g = 1 + 9 / 29 * (x_2 + ... + x_30).

Its Pareto front is `f:2` = 1 - sqrt(`f:1`) for `f:1` in [0, 1]: all variables
except x_1 are 0, and x_1 moves along the front.

## Files

- `search.ddl`: the variables `x:0`, ..., `x:29` in [0, 1] and the goals `f:1`,
  `f:2`.
- `search.ol`: the problem (`minimise data 'f:1', minimise data 'f:2'`) and the
  configuration of NSGA-II:
  - `'size-of-population' := 100`, `'number-of-offspring' := 100`.
  - `genotype`: one double chromosome with simulated binary crossover
    (probability 0.9, distribution index 20) and polynomial mutation
    (distribution index 20, every gene with probability 1/30), the settings of
    the NSGA-II paper.
  - `'parent-selection' := 'tournament-selection' { size := 2; }` with
    `'comparator' := 'crowded-comparator' {}`: binary tournaments by the crowded
    comparison.
  - `replacement := 'plus-replacement' { selection := 'nsga2-selection' {}; }`:
    parents and children are sorted into fronts, the best 100 survive.
  - `document ['best-candidate-per-iteration' { 'store-search-space' := false; }]`:
    with `'crowded-comparator'`, the best candidates of a generation are its first
    front; only the goals are written.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: the first front of every
  generation. Plot `f:2` against `f:1` for some generations together with the
  curve 1 - sqrt(`f:1`):
  - after 50 generations, the front lies clearly above the curve, and only 62 of
    the 100 candidates are in it;
  - after 250 generations, all 100 candidates are in the first front and spread
    over the whole curve from `f:1` = 0 to `f:1` = 1; on average they lie about
    0.002 above it.

## Try next

- Record the memory model (`'memory-model' {}` in `document`): every individual
  has the properties `front` and `crowding-distance`, and the ranks of an
  iteration are its fronts. With 250 generations of 200 individuals, the output
  is large; reduce `'maximum-iterations'` first.
- Combine the goals into one with `'fitness-pipeline' := [ 'weighted-sum' {
  weights := [ 'variable' { var := data 'f:1'; val := 1.0; }, 'variable' { var :=
  data 'f:2'; val := 1.0; } ]; } ]` and a single-objective configuration (see the
  example `ea-basic`): the search then finds one point of the front, not the whole
  front.
