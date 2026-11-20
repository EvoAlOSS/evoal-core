# Evolutionary algorithm with correlation-aware operators

## What it shows

The DDL can declare correlations between search variables. This example
minimises the Ackley function of three variables with three ranged correlations:

```
'ranged-correlation'(data 'x:1', range(-1.12, 3.00), data 'x:2', range(-2.00, 0.00), 0.9);
'ranged-correlation'(data 'x:0', range(1.00, 4.00), data 'x:1', range(-5.12, -3.00), 0.9);
'ranged-correlation'(data 'x:0', range(-5.12, -3.00), data 'x:2', range(2.00, 5.12), 0.9);
```

A ranged correlation only applies while both variables lie in their ranges. Two
operators of the evolutionary algorithm use the correlations, independent of the
chromosome and representation of the variables (here `x:0` and `x:2` are real
genes, `x:1` is Gray-coded):

- `'correlation-aware-mutation'` wraps a mutation. The wrapped mutation makes the
  primary change; the change of a variable f is then propagated to every variable
  g correlated with it: change(g) = rho * change(f) / range(f) * range(g), where
  the range is given by the bounds of the DDL.
- `'linkage-crossover'` wraps a crossover that exchanges genes. Afterwards, a
  child takes correlated variables from the same parent.

Both use only correlations whose absolute coefficient is at least
`'minimum-correlation'`. `'propagation-depth' := 1` propagates only to the
variables correlated with a changed one; a larger depth follows chains of
correlations.

## Files

- `search.ddl`: the variables `x:0`, `x:1`, `x:2` with their bounds, the function
  value `y:0` and the correlations.
- `search.ol`: the problem and the evolutionary algorithm. Each chromosome wraps
  its mutation in `'correlation-aware-mutation'`; the double chromosome also wraps
  its uniform crossover in `'linkage-crossover'`.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/correlation-statistics.csv`: per iteration and correlation n,
  `n-<n>` (the members of the population inside the ranges of the correlation),
  `correlation-<n>` (their empirical Pearson correlation), `deviation-<n>`
  (empirical minus declared coefficient) and `covariance-difference-<n>` (the
  covariance of the two variables minus the one in the initial population). A
  value is empty if fewer than two members lie in the ranges; the ranges of this
  example are narrow, so with the seed 42 most values are empty. Without ranges
  (see below), every row has values.
- `output/search/memory-model/iteration-*.json`: the relationships of the children
  record `primary-features` (what the wrapped mutation changed),
  `propagated-features` (e.g. `x:2 from x:1 (0.9)`) and `linked-features` (e.g.
  `x:2 with x:0`).

## Try next

- Use `correlation(data 'x:0', data 'x:1', 0.9);` without ranges: then every
  mutation of `x:0` moves `x:1` as well.
- Set `'propagation-depth' := 2` and add a correlation of `x:1` and `x:2`: a
  change of `x:0` then reaches `x:2` through `x:1`.

The README of the plugin `de.evoal.optimisation.ea` describes both operators,
with references to the literature.
