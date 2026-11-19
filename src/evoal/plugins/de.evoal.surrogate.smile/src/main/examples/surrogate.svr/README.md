# Search on an SVR model

## What it shows

An evolutionary algorithm maximises the prediction of a support vector
regression (SVR) model instead of a real function. The model `svr.pson` has
one input `x:0` and one output `y:0`; the example `training.svr` shows how such
a model is trained. The search variable `x:0` lies in [-5, 5].

The configuration of the EA is the same as in the example `surrogate.simple`;
only the model differs.

## Files

- `surrogate.ddl`: the variable `x:0` in [-5, 5] and the prediction `y:0`.
- `svr.pson`: the trained model.
- `search.ol`: the problem and the EA (see the example `surrogate.simple` for
  the configuration); `'optimisation-function' := 'surrogate' { 'model-file' :=
  "svr.pson"; ... }` loads the model.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: `x:0` approaches -5 and
  `y:0` about 11.54.
- `output/search/candidates-per-iteration.csv`: plot `y:0` against `x:0` over
  all generations to see the shape of the prediction in the part of the range
  the EA explored.

## Try next

- Change the goal to `minimise data 'y:0'`.
- Train your own model with the example `training.svr` and use its
  `output/svr.pson`.
