# Distributions: properties of manufactured parts

## What it shows

The pipeline `'parts-pipeline'` generates 1024 parts. Each property comes from a distribution
that suits it:

| Data | Distribution | Why |
|---|---|---|
| `thickness` (mm) | `'truncated-normal-distribution'` N(2.0, 0.1²) on [1.85, 2.15] | a normal measure, parts outside the tolerance are sorted out |
| `cycle-time` (s) | `'triangular-distribution'` with a = 40, c = 45, b = 60 | an expert estimate "at least 40, most likely 45, at most 60" |
| `yield` | `'beta-distribution'` with α = 8, β = 2 on [0, 1] | a share, skewed towards 1 |
| `lifetime` (h) | `'weibull-distribution'` with k = 1.5, λ = 1000 | a lifetime with wear-out |
| `defects` | `'poisson-distribution'` with λ = 2 | a count, written to integer data |
| `variant` | `'categorical-distribution'` of 1, 2, 3 with 0.5, 0.3, 0.2 | a category, written to nominal integer data |
| `load` (%) | `'gaussian-mixture-distribution'` 0.6·N(50, 5²) + 0.4·N(80, 8²) | two operating points |
| `failures` | `'poisson-distribution'` with λ = 3 | a count that rises with the load |

`load` and `failures` are the marginals of a `'copula-distribution'` with a Gaussian copula
(correlation 0.7 of the normal scores) on a randomly shifted Sobol' sequence. The other values
are independent.

With the seed 42:

| Data | Theory | Estimate |
|---|---|---|
| `thickness` | mean 2.0, standard deviation 0.0743, within [1.85, 2.15] | 2.001, 0.0754, [1.8503, 2.1499] |
| `cycle-time` | mean 48.33, standard deviation 4.25 | 48.34, 4.31 |
| `yield` | mean 0.8, standard deviation 0.121 | 0.802, 0.116 |
| `lifetime` | mean 903, standard deviation 613 | 889, 604 |
| `defects` | mean 2 | 1.98 |
| `variant` | shares 0.5, 0.3, 0.2 | 0.46, 0.33, 0.21 |
| `load` | mean 62, standard deviation 16.0 | 61.98, 16.04 |
| `failures` | mean 3 | 3.00 |
| Spearman (`load`, `failures`) | below (6/π)·arcsin(0.35) = 0.683 | 0.669 |

The rank correlation of `load` and `failures` stays below the value for continuous marginals:
the Poisson marginal gives the same count for a range of normal scores, and these ties lower
the correlation. EvoAl does not correct for this.

## Files

- `parts.ddl`: the data. The counts are `quotient integer data`, the variant is
  `nominal integer data`, all other data is real.
- `parts.generator`: the pipeline.

## Run

```sh
./01-run-generator.sh
```

Repeat a run with its seed, for example `EVOAL_SEED=42 ./01-run-generator.sh`.

## What to look at

- `output/parts.csv`: histograms show the bounded `thickness`, the skewed `cycle-time`,
  `yield` and `lifetime`, and the two peaks of `load`.
- A scatter plot of `failures` over `load` shows more failures at the higher operating point.
- Change `data 'defects'` in `parts.ddl` to `quotient real data 'defects';`: the run stops at
  the start, because a Poisson distribution gives whole numbers. Change `data 'variant'` to
  `quotient integer data`: the run stops, because the values of a categorical distribution
  name categories and need nominal or ordinal data.
