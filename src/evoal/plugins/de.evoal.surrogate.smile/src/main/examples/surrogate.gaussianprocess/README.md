# Search on a Gaussian process model

## What it shows

An evolutionary algorithm minimises the prediction of a Gaussian process regression model
instead of a real function. The model `gaussian-process.pson` is the one of the example
`training.gaussianprocess`: it learned the Forrester function
f(x) = (6x − 2)² · sin(12x − 4) on [0, 1] from nine points with a gap (0.6, 0.9) around the
global minimum f(0.757) ≈ −6.02.

The configuration of the EA is the same as in the example `surrogate.simple`; only the model
and the goal differ.

## Files

- `surrogate.ddl`: the variable `x:0` in [0, 1] and the prediction `y:0`.
- `gaussian-process.pson`: the trained model (output of `training.gaussianprocess`).
- `search.ol`: the problem and the EA (see the example `surrogate.simple` for the
  configuration); `'optimisation-function' := 'surrogate' { 'model-file' :=
  "gaussian-process.pson"; ... }` loads the model. The statistics writer
  `'reference-values-per-individual'` evaluates the Forrester function (`'benchmark-function'`
  with `forrester`) on the candidates of the search; it does not change the search.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for example
`EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: the EA finds the minimum of the model,
  about x = 0.744 with a prediction of −3.70. The true function is −5.93 there (the last row
  of `reference-values-per-individual.csv` for that individual). The search
  finds the region of the true minimum, because the model bends down into the gap, but the
  model predicts it too shallow: it has no data in the gap. The search is only as good as the
  model where the model is uncertain.
- `output/search/candidates-per-iteration.csv`: how the population gathers around the minimum
  of the model.
- `output/search/reference-values-per-individual.csv`: the Forrester function at the same
  candidates, one row per row of `candidates-per-iteration.csv` and in the same order. Join both
  files by `individual-id` and `generation`; prediction minus true value is the error of the
  model where the search goes. The mean absolute error of the population grows from 0.40 in
  generation 0 to 1.91 in generation 10 (at most 2.5): the search leaves the regions with
  training data and gathers in the gap, where the model is worst. The reference
  evaluations are no evaluations of the run; with the writer `'memory-model'`, their number is
  the execution metric `evaluations.reference`.

## Try next

- Train the model with the gap closed (see "Try next" of `training.gaussianprocess`), copy
  `output/gaussian-process.pson` here and compare the found minimum.
- Use the model as reference of a search on the Forrester function: swap the
  `'optimisation-function'` and the `reference`.
- Adapt the prediction by the model's uncertainty with the fitness step
  `'prediction-interval'` (plugin surrogate.adaption), which uses the predictive standard
  deviation of the Gaussian process.
