# Search on an ONNX model with three outputs

## What it shows

The ONNX model `in_3Num-out-3_x+y_x+y-z_z.onnx` has three inputs `x0`, `x1`,
`x2` and three outputs:

- `y0` = x0 + x1,
- `y1` = x0 + x1 - x2,
- `y2` = x2.

The problem maximises all three outputs. The evolutionary algorithm needs one
fitness value, so `'fitness-pipeline' := [ 'weighted-sum' { weights := [...]; } ]`
combines the three goals into their sum with the weight 1 each (normalised to 1/3
each). In this
sum, x2 cancels out: the fitness is (2 * x0 + 2 * x1) / 3. The search therefore
drives `x0` and `x1` to their upper bound 5 and leaves `x2` free.

## Files

- `surrogate.ddl`: the inputs in [-5, 5] and the outputs.
- `in_3Num-out-3_x+y_x+y-z_z.onnx`: the model.
- `search.ol`: the problem and the EA (see the example `surrogate.simple` for
  the configuration), with
  - `genotype`: one double chromosome per input, each with arithmetic crossover
    and polynomial mutation,
  - `'fitness-pipeline' := [ 'weighted-sum' { weights := [...]; } ]`: the
    scalarisation of the three goals; it needs a weight for every goal.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The ONNX Runtime is a native
library, so a run with the same seed can differ between platforms (see the
example `surrogate.onnx.simple`). The example has no reference output and is
only checked to run.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: `x0` and `x1` approach 5
  and `y0` approaches 10. `x2`, and with it `y1` and `y2`, stays wherever the
  population happens to be.

## Try next

- Weight the goals differently, e.g. `val := 2.0` for `y2`: `x2` then counts and
  goes to 5 as well.
