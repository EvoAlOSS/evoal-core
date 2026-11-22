# Sobol' sequence: evenly covering data

## What it shows

The pipeline `'sobol-pipeline'` fills `x` and `y` with the points of a two-dimensional Sobol'
sequence on [0, 1)² (`'sobol-sequence'`, Sobol' 1967, with the direction numbers of Joe and Kuo
2008). The points are randomised by a random shift (`'random-shift'`, Cranley and Patterson
1976): one uniform vector Δ is drawn per sequence, and every point x becomes frac(x + Δ). For
comparison, `'uniform-pipeline'` draws `x` and `y` independently and uniformly.

Both files hold 256 = 2⁸ points, a power of two, for which the Sobol' points are evenly balanced.
With the seed 42:

| | Sobol' | uniform |
|---|---|---|
| empty cells of a 16 × 16 grid | 16 | 92 (theory ≈ 94) |
| most points in one cell | 2 | 5 |
| occupied intervals of width 1/256 of `x` and of `y` | 256 and 256 | 160 and 156 |

Without the shift, each cell of the grid would hold exactly one point; the shift moves the
points against the grid, so a few cells hold two and their neighbours none. Every interval of
width 1/256 of each variable holds exactly one point in both cases.

Evenly covering data is the baseline of the surrogate adaption research: with a flat density, a
density-based penalty should hardly vary. Filters such as `'condition-filter'` or
`'rejection-sampling'` can then cut gaps or gradients into it.

## Files

- `points.ddl`: the variables `x` and `y`.
- `points.generator`: the pipelines with `'distribution-based-data'`, once with a Sobol' sequence
  and once with two uniform distributions.

## Run

```sh
./01-run-generator.sh
```

Repeat a run with its seed, for example `EVOAL_SEED=42 ./01-run-generator.sh`.

## What to look at

- `output/sobol.csv` and `output/uniform.csv`: a scatter plot of `y` over `x` shows clusters and
  holes in the uniform points, but not in the Sobol' points.
- Replace `'random-shift' {}` by `'no-randomisation' {}`: every run then gives the same points,
  whatever the seed, starting with the corner (0, 0).
- Do not use two one-dimensional sequences for `x` and `y`: both return the same points, so
  `x` and `y` would be (up to their shifts) the same.
