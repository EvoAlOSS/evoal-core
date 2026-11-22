# Rejection sampling: data with a density gradient

## What it shows

The pipeline draws `x` uniformly from [0, 1) and keeps it with the probability p = x
(`'rejection-sampling'`, von Neumann 1951; Devroye 1986). For every row, a uniform random number
u is drawn, and the row is kept if u < p. The kept points therefore have the density 2x: few
points near 0, many near 1. `write ... with 1000 samples` counts the kept rows.

In theory, a quarter of the points lie below 0.5 and their mean is 2/3. With the seed 42, 1000
of 1936 samples were kept, 261 points (26.1 %) lie below 0.5, and their mean is 0.659.

Data with such gradients shows whether a surrogate's uncertainty, e.g. the density-based
penalty of the surrogate adaption, grows where the training data is sparse.

## Files

- `points.ddl`: the variable `x`.
- `points.generator`: the pipeline with `'distribution-based-data'` and `'rejection-sampling'`.

## Run

```sh
./01-run-generator.sh
```

Repeat a run with its seed, for example `EVOAL_SEED=42 ./01-run-generator.sh`.

## What to look at

- `output/points.csv`: a histogram of `x` rises linearly from 0 to 1.
- Change the acceptance probability, e.g. to `1.0 - data 'x'` (density 2(1 − x), more points
  near 0) or to `data 'x' * data 'x'` (density 3x²). The value has to be in [0, 1] for every
  row; otherwise the run stops.
