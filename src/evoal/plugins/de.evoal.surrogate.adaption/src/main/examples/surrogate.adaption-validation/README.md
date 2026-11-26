# Training on validated data

## What it shows

The `validation` pipeline of an MLL file decides which rows of the training data the model
learns from. The goodness of fit on the training data and the estimates of the surrogate
adaption (here the density of the inputs) describe exactly these rows, not the rows of the
training files.

`data.json` holds y = 2x + 1 with a noise of ±0.1 on the grid x = 0.05, 0.1, ..., 1, and two
outliers (y = 10 at x = 0.72 and 0.76). The validation pipeline cuts the gap
0.7 ≤ x ≤ 0.8 out of the data with a `'condition-filter'`, so it drops the outliers and the
grid points 0.7, 0.75 and 0.8. The linear regression learns from the 17 rows that are left.

The learning use case records the rows after `validation` with
`'assessment-data' { 'data-set' := "training"; }`; the derived use case does this by itself.
The goodness of fit on the training data and the density estimation use these rows:

| Value | On the 17 rows after `validation` | On all 22 rows of `data.json` |
|---|---:|---:|
| RMSE of the trained model | 0.0997 | 2.27 |
| mean of x (`density-mu`) | 0.4853 | 0.5445 |
| standard deviation of x (`density-sigma`) | 0.3040 | 0.2885 |

The model file and the goodness-of-fit file hold the values of the left column.

## Files

- `surrogate.ddl`: the input `x:0` in [0, 1] and the output `y:0`.
- `data.json`: the training data, written by `generator.py`.
- `training.mll`: the learning task, the `'condition-filter'` in `validation`, the model
  `'linear-regression'`, the goodness-of-fit measures RMSE and R², and the Gaussian density
  estimation of the density adaption.

## Run

```sh
./01-run-training.sh
```

The model is written to `output/model.pson`, the goodness of fit to `output/gof.json`.
