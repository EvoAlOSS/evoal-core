# Search on a linear regression model

## What it shows

A search does not need the real function: `'optimisation-function' :=
'surrogate' { ... }` evaluates the candidates with a trained model (a
surrogate) instead. Here the model is a linear regression of one variable,
y = -0.154 * x + 11.71, stored in `simple.pson`. The example
`training.simple` shows how such a model is trained.

The search is an evolutionary algorithm that maximises the prediction `y:0` for
`x:0` in [-5, 5]. Since the slope is negative, the maximum lies at the lower
bound, x = -5, with y = 12.48.

## Files

- `surrogate.ddl`: the variable `x:0` with its bounds and the prediction `y:0`.
- `simple.pson`: the trained model.
- `search.ol`: the problem with `map with 'unknown-function' {}` (the real
  function is unknown) and the configuration of the EA:
  - 50 parents create 30 children per generation, parents are chosen by
    tournaments of 2.
  - `'arithmetic-crossover'`: a child is the mean of its parents (with
    probability 0.5); the mutation is the default of real values,
    `'polynomial-mutation'`.
  - `'survivor-replacement'`: the best 5 parents and 15 more chosen by
    tournaments survive, the 30 children replace the others.
  - `'candidate-checks' := ['maximum-age' { ... }]`: a candidate that has
    survived 10 generations is replaced by a random one.
  - `'optimisation-function' := 'surrogate' { ... }`: the model file and which
    variables are its inputs and outputs.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for
example `EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: `x:0` approaches -5 and
  `y:0` approaches 12.48 within the 10 generations.

## Try next

- Use another model of the same variables, e.g. the SVR model of the example
  `surrogate.svr`.
- Search with another algorithm on the same model, e.g. hill climbing (see the
  example `surrogate.adaption-search`).
