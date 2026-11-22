# Training a Gaussian process

## What it shows

A Gaussian process regression (kriging) model learns the one-dimensional Forrester function

    f(x) = (6x − 2)² · sin(12x − 4),  x ∈ [0, 1],

from nine points, as in the kriging example of Forrester, Sóbester and Keane (2008,
https://doi.org/10.1002/9780470770801). The training points are x = 0, 0.1, ..., 0.6, 0.9
and 1.0, so the data has a gap (0.6, 0.9) around the global minimum f(0.757) ≈ −6.02. The
model is tested on the gap.

The model uses a Gaussian kernel. Its length scale σ and the noise in the MLL file are
starting values: with `'iterations' := 100` both are fitted by maximising the log marginal
likelihood of the training data. The model file stores the fitted values, so a search on the
model (example `surrogate.gaussianprocess`) uses the same model as the goodness of fit here.

## Files

- `surrogate.ddl`: the input `x:0` in [0, 1], the output `y:0` and the grid index `k` of the
  generator.
- `training-data.generator`: writes the training data `output/left.csv` (x = 0, ..., 0.6)
  and `output/right.csv` (x = 0.9, 1.0) and the test data `output/test.csv`
  (x = 0.61, 0.62, ..., 0.89).
- `training.mll`: the learning task with `testing with [ "output/test.csv" ]`, the model
  `'gaussian-process'` and the goodness-of-fit measures RMSE and R².

## Run

```sh
./01-run-generator.sh
./02-run-training.sh
```

The model is written to `output/gaussian-process.pson`, the goodness of fit to
`output/gof.json`.

## What to look at

- The log of `02-run-training.sh` names the fitted kernel and noise: the length scale is
  about 0.15, the noise is at its lower bound 1e-10, because the data has no noise.
- `output/gof.json`: on the training data the model is exact (the noise is tiny, so the model
  interpolates its training points); in the gap the RMSE is about 1.7 and R² about 0.63. The
  model has not seen the minimum and predicts it too shallow.
- `output/gaussian-process.pson`, `state` → `model` → `regression`: the fitted
  `hyperparameters` (the length scale), the `noise` and the `log-marginal-likelihood`.

A Gaussian process also gives the predictive standard deviation σ of its prediction: about 0
at the training points and large in the gap. The adaption step `'prediction-interval'` uses it
(regression `hill-climbing-prediction-interval-gaussian-process` of the plugin
surrogate.adaption).

## Try next

- Close the gap: add the points 0.7 and 0.8 to the pipeline `'right'` (`initial := 7.0` and
  `0.7`, 4 samples) and compare the RMSE on the gap.
- Keep the starting values with `'iterations' := 0` and compare the goodness of fit.
- Use a Matérn kernel, e.g. `'kernel' := 'matérn' { 'σ' := 0.2; 'ν' := 2.5; };`.
