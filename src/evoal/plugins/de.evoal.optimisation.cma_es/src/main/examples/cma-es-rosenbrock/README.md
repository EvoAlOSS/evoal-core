# CMA-ES on the Rosenbrock function

## What it shows

CMA-ES samples its candidates from a normal distribution N(m, sigma^2 C) and adapts:
- the mean m;
- the step size sigma;
- the covariance matrix C, from the best candidates of every iteration.

C learns the dependencies between the variables: where good candidates lie along a diagonal
direction, C stretches the distribution along it.

The problem is the Rosenbrock function of five variables `x:0` … `x:4` in [-5, 5]. Its
minimum 0 lies at the end of a narrow, curved valley, at (1, 1, 1, 1, 1). Neighbouring
variables are strongly coupled. Near the minimum, the inverse Hessian implies correlations of
about 0.9 between all pairs.

The DDL declares a correlation of `x:0` and `x:1` (0.5) and a building block of `x:2`, `x:3`
and `x:4`. CMA-ES does not use this linkage. The statistics writer `'learned-linkage'`
compares it with the linkage that CMA-ES learned.

## Files

- `search.ddl`: the variables with their bounds, the function value `y:0`, and the declared
  linkage in `constraints:`.
- `search.ol`: the problem and the configuration of CMA-ES:
  - `'initial-step-size' := 3.0`: sigma_0, 0.3 times the width of the search interval as the
    tutorial suggests;
  - `'full-covariance'`: a full covariance matrix;
  - `'ipop-restart'`: a run that a termination criterion of CMA-ES ends is restarted with a
    doubled population;
  - `'cma-es-termination' {}`: the termination criteria of the tutorial with their defaults;
  - the search ends after 5000 evaluations, or when the best candidate is below 1e-10
    (`'target-value'`).

  The population size (8) and the learning rates are the defaults of the tutorial, see the
  log line `CMA-ES with lambda = 8, mu = 4, …`.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. Repeat a run with its seed, for example
`EVOAL_SEED=42 ./01-run-search.sh`.

## What to look at

All numbers are those of `EVOAL_SEED=42`.

- `best-candidate-per-iteration.csv`: `y:0` falls from about 8000 to 4.2 (iteration 100),
  0.019 (iteration 300) and 7.6e-11 in iteration 409. There, the target ends the search after
  3280 evaluations, without a restart.
- `metrics-per-iteration.csv`: the distribution of every iteration.
  - `sigma` falls while the distribution follows the valley. It grows again where the valley
    bends (iterations 200-300). At the end it is 0.0013.
  - `axis-ratio` grows to 44: C becomes a long, thin ellipsoid along the valley.
  - `mean-x:0` … `mean-x:4` approach 1.
- `learned-linkage.csv`:
  - `learned-correlation-1`, the correlation of `x:0` and `x:1` that C implies, ends near 0.87
    (declared: 0.5);
  - `within-building-block-1` approaches 0.99;
  - `between-building-block-1` approaches 0.85.

  Near the minimum, all variables of the Rosenbrock function are strongly correlated, so the
  block is not separated from the other variables: the declared linkage describes the problem
  only partly.

## Try next

- `'covariance-model' := 'diagonal-covariance' {}`: sep-CMA-ES learns only the variances. It
  needs many more evaluations on the correlated valley and records no correlations.
- `'restart-strategy' := 'bipop-restart' {}` and a multimodal function, e.g. `rastrigin {}`:
  the restarts alternate between large and small populations (metrics `population-size`,
  `restart`).
- `'record-all-correlations' := true`: the metrics contain the correlation of every pair of
  variables.
