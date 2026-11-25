# Assessing a surrogate by resampling

## What it shows

A nearest neighbour (`'knn'` with `'k' := 1`) learns

    y = x (12 − x)

from 41 points x = 1, 1.25, ..., 11. It reproduces every training point, so its goodness of
fit on the training data is perfect (RMSE 0, R² 1) and says nothing about its predictions
between or beyond the training points.

The learning task states four resampling schemes (`assessing with [...]`). Each scheme learns
on parts of the training data and assesses the rows it held out; EvoAl derives the
`resampling` use case for them, and the final model is the same as without them:

- `'k-fold-cross-validation' { 'k' := 5; }`: five folds of shuffled rows, each held out once
  (Stone 1974, https://doi.org/10.1111/j.2517-6161.1974.tb00994.x; Arlot and Celisse 2010,
  https://doi.org/10.1214/09-SS054).
- `'leave-one-out-cross-validation' {}`: each row held out once.
- `'bootstrap' { 'repetitions' := 50; }`: 50 times 41 rows drawn with replacement, assessed on
  the rows not drawn (Efron 1979, https://doi.org/10.1214/aos/1176344552).
- `'block-cross-validation' { blocks := 'grid-blocks' { intervals := 4; }; }`: the range of
  x is cut into four intervals, each held out once, so the surrogate predicts a quarter of the
  range it never saw (Roberts et al. 2017, https://doi.org/10.1111/ecog.02881).

The splits use random streams of the seed (`EVOAL_SEED`), so a run with the same seed gives
the same values.

## Files

- `surrogate.ddl`: the input `x:0`, the output `y:0` and the grid index `k`.
- `training-data.generator`: writes the training data `output/training.csv`.
- `training.mll`: the learning task with the resampling schemes and the model `'knn'`.

## Run

```sh
./01-run-generator.sh
./02-run-training.sh
```

## What to look at

`output/gof.json` holds, per measure, the value on the training data and one entry per scheme
with the mean, the standard deviation and the values of its parts, and the pooled value: the
measure on the held-out rows of all parts together, each predicted by its part's model. With
seed 42:

| Data set                         | RMSE mean | RMSE standard deviation | RMSE pooled | R² mean | R² pooled |
|----------------------------------|----------:|------------------------:|------------:|--------:|----------:|
| training                         |      0    |                         |             |    1    |           |
| k-fold cross-validation          |      1.47 |                    0.16 |        1.47 |    0.94 |      0.96 |
| leave-one-out cross-validation   |      1.28 |                    0.74 |        1.48 |         |      0.96 |
| bootstrap                        |      1.87 |                    0.54 |        1.96 |    0.94 |      0.94 |
| block cross-validation           |      6.80 |                    4.94 |        8.13 |   −1.78 |     −0.08 |

- The resampled errors estimate the error between the training points; the bootstrap error is
  larger because a bootstrap sample contains only about 63 % of the points.
- The block error is the extrapolation error: the outer blocks are predicted by the nearest
  point of the neighbouring block.
- The mean over parts and the pooled value differ when the parts are small. The R² of a block
  compares with the mean of that block, whose values vary little, so the mean R² of the blocks
  is far below 0; the pooled R² compares all predictions with the mean of all rows and is
  close to 0: the extrapolated blocks are predicted about as well as by the overall mean. The
  pooled RMSE is the root of the mean squared error of all predictions, which weights the
  large errors of the outer blocks more than the mean of the four block RMSEs does.
- Leave-one-out has no R² per part: on a single held-out row R² is undefined, and the log warns
  once. Its pooled R² (also called Q²) uses all 41 cross-validated predictions, and its pooled
  RMSE is the root of the PRESS statistic (Allen 1974,
  https://doi.org/10.1080/00401706.1974.10489157) divided by the number of rows.
- `output/model.pson` stores the same values with each output feature.
