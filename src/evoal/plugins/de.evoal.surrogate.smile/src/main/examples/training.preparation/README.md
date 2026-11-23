# Training a surrogate on prepared data

## What it shows

An SVR learns a quantity of about 20000 that depends on a temperature between 250 K and
350 K:

    y = 20000 + 30 (x − 250) − 0.4 (x − 250)²

The SVR learns on prepared data. The `preparation` pipeline maps the temperature to [0, 1]
(`'min-max-normalisation'`) and the output to mean 0 and standard deviation 1
(`'z-score-normalisation'`, both Han, Kamber and Pei 2012,
https://doi.org/10.1016/B978-0-12-381479-1.00003-4). Their parameters are fitted on the
training data while learning. The settings of the SVR refer to the prepared data: `'ε' := 0.05`
is 0.05 standard deviations of the output, the Gaussian kernel's `'σ' := 0.2` is a fifth of the
temperature range.

The model file stores the prediction pipeline with the fitted parameters: it prepares the
temperature, predicts and undoes the z-score normalisation of the output. Every prediction runs
it, so the goodness of fit, the generator step `'trained-model'` and a search predict in the
original unit of `y:0`.

## Files

- `surrogate.ddl`: the input `x:0` (kelvin), the output `y:0` and the grid index `k`.
- `training-data.generator`: writes the training data `output/training.csv`
  (x = 250, 260, ..., 350) and the test data `output/test.csv` (x = 255, 265, ..., 345).
- `training.mll`: the learning task with test data, the preparation steps and the model
  `'epsilon-svr'`.
- `prediction.generator`: predicts `y:0` with the trained model for x = 250, 275, ..., 350.

## Run

```sh
./01-run-generator.sh
./02-run-training.sh
./03-run-prediction.sh
```

## What to look at

- `output/model.pson`: `predictionPipeline` contains `'min-max-normalisation'` with the fitted
  `minimum` 250 and `maximum` 350, `'model-prediction'`, and `'z-score-normalisation'` twice:
  in `preparation` with the fitted `μ` and `σ` of `y:0`, and at the end with `inverse` true.
- `output/gof.json`: RMSE and R² on the training and the test data, in the unit of `y:0`.
- `output/predictions.csv`: the predictions in the unit of `y:0`, close to the function above.
