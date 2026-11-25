# Training gradient boosting with a prediction interval

## What it shows

A `'gradient-boosting'` model learns the one-dimensional Forrester function

    f(x) = (6x − 2)² · sin(12x − 4),  x ∈ [0, 1],

from noisy data. The noise grows with x in three steps: its standard deviation is 0.5 for
x between 0 and 0.3, 1.5 between 0.3 and 0.7, and 3.0 between 0.7 and 1. Besides the
prediction, the model predicts a prediction interval: two more models fit the 0.05 and the 0.95
quantile of y, so the interval should hold 90 % of new observations (`coverage := 0.9`) and be
narrow where the noise is small and wide where it is large.

The model file is an ONNX file. It holds the three models as one graph with the outputs `y:0`,
`y:0.lower` and `y:0.upper`, and EvoAl's model information (features, prediction pipeline,
coverage) in its metadata. Other ONNX tools can run it, e.g. ONNX Runtime in Python.

## Files

- `surrogate.ddl`: the input `x:0` in [0, 1], the output `y:0` and the grid index `k` of the
  prediction.
- `training-data.generator`: writes 150 training points per segment (`output/left.csv`,
  `output/middle.csv`, `output/right.csv`) and 200 test points of the right segment
  (`output/test.csv`).
- `training.mll`: the learning task, a z-score normalisation of `y:0` as preparation, the model
  `'gradient-boosting'` and the goodness-of-fit measures RMSE, R², PICP and MPIW.
- `prediction.generator`: predicts with the stored model for x = 0, 0.05, ..., 1.

## Run

```sh
./01-run-generator.sh
./02-run-training.sh
./03-run-prediction.sh
```

The model is written to `model/gradient-boosting.onnx`, the goodness of fit to
`output/gof.json` and the predictions of the stored model to `output/predictions.csv`.

## What to look at

- `output/gof.json`, `picp` (prediction interval coverage probability): the share of the rows
  inside their interval. On the training data it is about 0.92, close to the coverage 0.9; on
  the test data (new points of the right segment) about 0.81.
- `output/gof.json`, `mpiw` (mean prediction interval width): about 5.5 on the training data,
  the mean over all three segments, and about 9.9 on the test data of the right segment. With
  normal noise, the 90 % interval of the right segment is 2 · 1.645 · 3.0 ≈ 9.9 wide, that of the
  left segment 2 · 1.645 · 0.5 ≈ 1.6: the interval follows the noise.
- `output/predictions.csv`: the prediction of the stored model, the median of y. It follows the
  Forrester function, whose minimum is f(0.757) ≈ −6.02; on the grid, the lowest prediction is
  about −6.3 at x = 0.8, in the segment with the largest noise.

The adaption step `'prediction-interval'` uses the width of the interval to rate how reliable
a prediction is (regression `hill-climbing-prediction-interval-gradient-boosting` of the plugin
surrogate.adaption).

## Try next

- Set `coverage := 0.5` and compare `picp` and `mpiw`.
- Set `'point-prediction' := 'point-prediction.mean'`: the prediction minimises the squared
  error and may lie outside the interval; the interval stays the same.
- Set `'row-sampling' := 'row-sampling.independent'`: with `'sampling-fraction'` below 1, the
  three models draw their rows independently instead of tree t of every model seeing the same
  rows. With `'sampling-fraction' := 1.0` both give the same model.
