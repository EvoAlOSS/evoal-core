# Search on a Gaussian process model

## What it shows

An evolutionary algorithm maximises the prediction of a Gaussian process
regression model with six inputs `x:0`, ..., `x:5` and one output `y:0`
(`gaussian-process.pson`). The example `training.gaussianprocess` shows how
such a model is trained; its training data lies roughly in [-18, 18] for every
input. The search space is [-15, 15] for every input.

The configuration of the EA is the same as in the example `surrogate.simple`:
the six real variables form one double chromosome.

## Files

- `surrogate.ddl`: the six inputs with their bounds and the prediction `y:0`.
  The EA needs a lower and an upper bound for every variable that is not
  boolean.
- `gaussian-process.pson`: the trained model.
- `search.ol`: the problem and the EA (see the example `surrogate.simple` for
  the configuration); `'optimisation-function' := 'surrogate' { ... }` loads the
  model.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The model uses native numeric
libraries, whose results can differ slightly between platforms; such a
difference can change which candidates the EA selects, so a run with the same
seed can differ between platforms. The example has no reference output and is
only checked to run.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: the best prediction rises
  only a little (about 14.3 to 14.4 within the 10 generations); the prediction
  is flat in large parts of the search space.
- `output/search/candidates-per-iteration.csv`: which values of the six inputs
  the population keeps.

## Try next

- Run more generations (`'maximum-iterations' := 50`).
- Restrict the search space to the region with most training data, e.g.
  [-5, 5], in `surrogate.ddl`.
