# Surrogate adaption

## What it shows

A search on a surrogate model only sees predictions. Where the model has seen
no training data, a prediction is unreliable. The surrogate adaptions are
fitness steps that change the fitness of a prediction depending on how
reliable it is:

| Step | Measures the reliability by |
|---|---|
| `'prediction-interval'` | the width of the prediction interval of an SVR model |
| `'gaussian-density'`, `'kernel-density'` | the density of the training data around the candidate |

The steps run in the order of `'fitness-pipeline'`, each on the result of the
previous one. They need information that is calculated during training and
stored with the model.

The model is an SVR trained on the Forrester function
f(x) = (6x − 2)² sin(12x − 4) on [0, 1] (Forrester, Sóbester and Keane 2008),
whose global minimum is f(0.757) = −6.02. The training data (example
`surrogate.adaption-training`, which created `model.pson`) is a grid with step
0.01 that leaves out (0.69, 0.81): the model has never seen the region around
the minimum. It fits the training data closely (R² = 0.998), but inside the gap
it predicts a shallower valley than the true one.

## Files

- `surrogate.ddl`: the variable `x:0` in [0, 1] and the prediction `y:0`.
- `model.pson`: the SVR model with density and prediction-error information.
- `search.ol`: hill climbing that minimises the prediction `y:0` from `x:0` = 0.6
  with steps of 0.02, without adaption (`'fitness-pipeline' := []`).
- `adapted-search.ol`: the same search with `'prediction-interval'`.

## Run

```sh
./01-run-search.sh
./02-run-adapted-search.sh
```

The output is written to `output/search/` and `output/adapted-search/`. The
prediction interval uses native numeric libraries, whose results can differ
slightly between platforms. The log warns about it, and the memory model records
it in `setup.reproducibility` of `execution-information.json`.

## What to look at

- `output/search/candidates-per-iteration.csv`: without adaption, the search
  walks down the valley into the gap and stops at `x:0` = 0.78, where the model
  predicts −4.86 (the true value is −5.73). It ends at a point the model has
  never seen.
- `output/adapted-search/candidates-per-iteration.csv`: an adaption is meant to
  penalise such predictions, so the search should stop at the border of the
  training data (0.68) instead of entering the gap. This is the trade-off of a
  pessimistic penalty: it keeps the search where the model is reliable, at the
  price of not exploring the gap, even though the true optimum lies there.
- With the current formula of `'prediction-interval'`, the adapted search stays
  at its start `x:0` = 0.6: the formula 2ŷ² / (upper − lower) prefers
  predictions close to 0 and wide intervals, not reliable predictions. The formulas will be redefined (see issue #288 in the EvoAl
  GitLab project).
- `output/<search>/memory-model/iteration-<n>.json` shows the fitness of every
  candidate (`fitness`, smaller is better).

The density steps are not used here: on a feature range of at most 1, the
offset `1/range` of their formula makes the density 1 everywhere, so they change
nothing (also part of #288).

## Try next

- Start both searches at another point, e.g. `x:0` = 0.9, and compare.
- Train the model with a different gap in `surrogate.adaption-training` and copy
  `output/model.pson` here. The SVR training can find a slightly different
  model on another platform (e.g. another number of support vectors), so a
  retrained model can also change the search results.
