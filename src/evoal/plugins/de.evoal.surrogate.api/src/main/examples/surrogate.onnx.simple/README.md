# Search on an ONNX model

## What it shows

A surrogate can also be a model in the ONNX format (Open Neural Network
Exchange), e.g. exported from PyTorch or scikit-learn. EvoAl evaluates it with
the ONNX Runtime. The model `in_1number-out_number_divided_by_in.onnx` has one
input tensor `Input_0` and one output tensor `output` and computes
output = 1 / input. The names of the variables in `surrogate.ddl` and
`search.ol` are the names of the tensors.

An evolutionary algorithm maximises the output for an input in [-5, 5]. The
function has a pole at 0: the closer a positive input is to 0, the larger the
output.

## Files

- `surrogate.ddl`: the input `Input_0` in [-5, 5] and the output `output`.
- `in_1number-out_number_divided_by_in.onnx`: the model.
- `search.ol`: the problem and the EA (see the example `surrogate.simple` for
  the configuration); `'optimisation-function' := 'surrogate' { 'model-file' :=
  "in_1number-out_number_divided_by_in.onnx"; ... }` loads the model.

## Run

```sh
./01-run-search.sh
```

The output is written to `output/search/`. The ONNX Runtime is a native
library, whose results can differ slightly between platforms, so a run with the
same seed can differ between platforms. The example has no reference output and
is only checked to run. The Java runtime warns that the ONNX Runtime loads a
native library (`System::load`); the warning does not affect the result.

## What to look at

- `output/search/best-candidate-per-iteration.csv`: `Input_0` approaches 0 from
  above and `output` grows by orders of magnitude.

## Try next

- Minimise the output: the search then approaches 0 from below.
- Use a model with several outputs, see the example `surrogate.onnx.multi`.
