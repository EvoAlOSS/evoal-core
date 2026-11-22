# Gaussian copula: correlated data with a skewed marginal

## What it shows

The pipeline `'copula-pipeline'` generates a standard normal `x` and a log-normal `y` (ln y has
μ = 0 and σ = 0.5) whose dependence is a Gaussian copula with the correlation R = 0.8 of the
normal scores (`'copula-distribution'`, Sklar 1959; Nelsen 2006). The copula transforms the
points of a randomly shifted two-dimensional Sobol' sequence on the unit square, so the data also
covers its distribution evenly. A multivariate normal distribution cannot generate such data,
because its marginals are always normal.

Afterwards, `'estimate-pipeline'` reads the 1024 rows and estimates Pearson's correlation
(`'correlation-estimation'`, written to `output/correlations.csv`).

R is not the Pearson correlation of the data: the log-normal marginal bends the relation, so
Pearson's coefficient is smaller. The rank correlations do not depend on the marginals and follow
from R. With the seed 42:

| Measure | Theory | Estimate |
|---|---|---|
| Pearson (x, y) | ρσ / √(e^{σ²} − 1) ≈ 0.751 | 0.754 (`output/correlations.csv`) |
| Spearman (x, y) | (6/π)·arcsin(ρ/2) ≈ 0.786 | 0.789 |
| Pearson (x, ln y), the normal scores | ρ = 0.8 | 0.803 |

The median of `y` is 0.995 (theory e⁰ = 1), the mean of `x` is −0.004 (theory 0).

Data like this shows whether a correlation-based method, e.g. the linkage learning of the
optimisation, depends on the marginals of the data or only on its ranks.

## Files

- `points.ddl`: the variables `x` and `y`.
- `points.generator`: the pipeline with the copula distribution and the pipeline that estimates
  the correlation.

## Run

```sh
./01-run-generator.sh
```

Repeat a run with its seed, for example `EVOAL_SEED=42 ./01-run-generator.sh`.

## What to look at

- `output/points.csv`: a scatter plot of `y` over `x` shows a band that bends upwards, with a
  long tail to large `y`.
- `output/correlations.csv`: Pearson's coefficient with its confidence interval.
- Replace the log-normal marginal by `'normal-distribution' { 'μ' := 1.0; 'σ' := 0.5; }`:
  the data is then bivariate normal and Pearson's coefficient is about 0.8.
- Replace `'random-shift' {}` by `'no-randomisation' {}`: the run stops at once, because the
  first Sobol' point (0, 0) maps to −∞ for the normal marginal.
