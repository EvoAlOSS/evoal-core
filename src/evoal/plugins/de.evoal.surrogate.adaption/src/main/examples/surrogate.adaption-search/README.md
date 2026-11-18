# Surrogate adaption

## What it shows

A search on a surrogate model only sees predictions. Where the model has seen
little training data, a prediction is unreliable. The surrogate adaptions are
fitness steps that change the fitness of a prediction depending on how
reliable it is:

| Step | Measures the reliability by |
|---|---|
| `'prediction-interval'` | the width of the prediction interval of an SVR model |
| `'gaussian-density'`, `'kernel-density'` | the density of the training data around the candidate |

The steps run in the order of `'fitness-pipeline'`, each on the result of the
previous one. They need information that is calculated during training and
stored with the model (see the example `surrogate.adaption-training`, which
created `model.pson`).

The formulas are the ones of the former fitness decorators. They are not
consistent with the direction of the goals and will be redefined (see issue
#288 in the EvoAl GitLab project).

## Files

- `surrogate.ddl`: the variable `x:0` in [-5.12, 5.12] and the prediction `y:0`.
- `model.pson`: an SVR model with density and prediction-error information.
- `search.ol`: hill climbing that maximises the prediction `y:0`, starting at
  `x:0` = -4.
  - `'optimisation-function' := 'surrogate' { ... }` evaluates the candidates
    with the model.
  - `'fitness-pipeline'` adapts the prediction by the prediction interval, then
    by the Gaussian density and then by the kernel density.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The prediction interval uses native
numeric libraries, whose results can differ slightly between platforms. The log
warns about it, and the memory model records it in `setup.reproducibility` of
`output/search/memory-model/execution-information.json`.

## What to look at

- `output/search/candidates-per-iteration.csv` shows the candidates and the
  prediction `y:0`.
- `output/search/memory-model/iteration-<n>.json` shows the adapted fitness of
  every candidate (`fitness`, smaller is better; the maximised prediction
  appears negated). `execution-information.json` lists the configured steps.
- The prediction of this model is nearly constant, so the search is driven by
  the adaptions alone. With a maximised goal, the former density formula
  rewards regions with little training data: the search walks to the border
  of the data at `x:0` = -5.

## Try next

- Remove steps from `'fitness-pipeline'` and compare the fitness in the memory
  model.
- Change `kind` of a density step to `"target-based"` or `"both"`.
