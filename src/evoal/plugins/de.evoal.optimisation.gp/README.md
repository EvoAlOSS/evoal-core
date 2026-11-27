# Genetic programming

This plugin provides tree-based genetic programming (GP) for symbolic regression as a model
search space, in the DL module `de.evoal.optimisation.gp.genetic-programming`. An expression is
a tree of DL objects, the structured search data of a problem
(`data 'f' of instance 'expression'`). The plugin adds only the primitives, an evaluator, a
fitness function and a check; the search machinery is the one of all model search spaces:

- `'random-population'` builds the trees with grow, full or ramped half-and-half
  (`de.evoal.optimisation.api`, "Model candidates");
- the operators of a `'model-chromosome'` change them (`de.evoal.optimisation.ea`, "Models"):
  `'subtree-crossover'`, `'subtree-mutation'` and the value mutations of the constants;
- `'maximum-size'` and `'maximum-depth'` limit them.

The library does not depend on the EA; random search can search the same models.

## Function set and terminal set

The primitives form the function set and the terminal set (Poli, Langdon and McPhee 2008,
sec. 3.1). The module declares the functions and the abstract terminal types; the terminals are
problem-specific, so the problem's own DL module declares them as subtypes:

| DL type | Value |
|---|---|
| `plus`, `minus`, `multiply` | `left + right`, `left - right`, `left * right` |
| `'protected-division'` | `left / right`, 1 if `right` is 0 (Poli et al. 2008, sec. 3.2.1, after Koza 1992) |
| `'protected-square-root'` | the square root of `|operand|` (EvoAl's choice; Poli et al. name protected roots without defining one) |
| `'protected-power'` | `|left|^right`, 1 if the result is not finite (EvoAl's own) |
| subtypes of `variable` | the value of the bound input data |
| subtypes of `constant` | their attribute `'value'` |

```
type x extends variable {}
type 'c' extends constant {
    @Scale { scale := 'measurement-scale.cardinal'; }
    @LowerBoundary { boundary := -50.0; }
    @UpperBoundary { boundary := 50.0; }
    'value' : real;
}
```

A variable type has no attribute. A constant type has exactly one real attribute `'value'` with
its boundaries and scale; the boundaries belong to the problem, since a DL subtype cannot change
the annotations of its super type. A constant is an ephemeral random constant: its value is drawn
when the tree is built and then changed only by mutation (`'gaussian-mutation'`,
`'random-reset-mutation'`). A fixed constant (e.g. pi) has equal boundaries. A tree may contain
every concrete subtype of `'expression'` of the loaded modules; the builder draws them uniformly.

`'expression'` and `'c'` are quoted: `expression` is a DL keyword, and `c` is the unit prefix
centi of the DSLs.

## Evaluation

`ExpressionEvaluator` (`api`) evaluates a tree with the reflective EMF API: a variable node takes
the value of its row position, a constant node its `'value'`, a function node applies the
`ExpressionFunction` of its DL type to the values of its containments, in the order of its
attributes. The functions are found by the qualified names of their DL types
(`ExpressionFunctions.standard()`), so another plugin can add functions by passing a larger
map. A tree is compiled once (`compile`) and then evaluated for every row. `problemsOf` lists why
trees of a set of types could not be evaluated: an unbound variable type, a constant type without
exactly one real `'value'`, a type that is no known function, or a function with another number
of single containments than operands.

Non-finite results other than those of the protected functions (an overflow) are kept.

## Fitness `'symbolic-regression-fitness'`

```
'optimisation-function' := 'symbolic-regression-fitness' {
    function  := data 'regression-function';
    input     := [ 'variable-binding' { variable := x {}; 'data' := data 'x0'; } ];
    output    := data 'y0';
    reference := "gp-example-function-data.csv";
    error     := data 'error';
    measure   := 'regression-error.sum-of-absolute-errors';
};
```

Every mapping is explicit: `input` binds every variable type to the data that holds its value,
`output` names the target, `error` the objective that gets the value, `measure` the error
measure (`'sum-of-absolute-errors'`, the fitness of the Field Guide's example in sec. 4.1, or
`'mean-squared-error'`). The reference table names its columns by the data, e.g. a CSV file
with the header `x0,y0`; the reader is chosen by the file extension. The input and output data
are neither searched nor optimised; `OptimisationConfigurationSetup` gives such data of a
configuration a class of its own, so the configuration can refer to them.

A variable type and a data must not have the same qualified name, e.g. a type `x0` in a DL
module `'gp-example'` and a data `'x0'` in a DDL module `'gp-example'`: the reference
`data 'x0'` then links to the type and the run fails. The example names its variable type `x`.

When the function is loaded, it checks: the `function` is structured search data of type
`'expression'`; every concrete variable type of the loaded modules has exactly one binding;
every constant type has exactly one real `'value'`; every concrete subtype of `'expression'` is a
function, a variable or a constant; the `error` is numeric optimisation data; the table has a
value of every bound data and of the `output` in every row. A non-finite prediction gives a
non-finite error, which the comparators rank worst when the error is minimised. The function is
deterministic and thread-safe.

## Check `'uses-variable'`

`'uses-variable' { model := data 'f'; count := 1; }` fails a new candidate (including the initial
candidates) whose expression uses fewer than `count` different variable types, e.g. a constant
expression. Reactions: `warn`, `replace`, `resample`.

## Example

`src/main/examples/genetic-programming` searches an expression for the table of
`y = 5 x^3 + 42` on `x = -1000, -998, ..., 1000` with the EA; see its README.

## Tests

- `ExpressionEvaluatorTest`: every function on hand-built trees, a nested tree, protected
  division by 0, roots of negative numbers, non-finite powers, a kept overflow, and the problems of
  unbound variables, unknown functions and constants without a real `'value'`.
- `SymbolicRegressionFitnessTest`: the configuration of the DL type (the order of the bindings,
  both measures on a small table, the objective, a non-finite error), the load-time checks
  (unbound and twice bound variables, unstructured `function`, `error` outside the optimisation
  space) and the rows of the table (a missing value, no rows).
- `UsesVariableCheckTest`: constant expressions, variable types counted once, check point and
  reactions.
- The example runs in CI with its reference (memory model).

## References

- J. R. Koza: Genetic Programming: On the Programming of Computers by Means of Natural
  Selection. MIT Press, 1992. ISBN 0-262-11170-5.
- R. Poli, W. B. Langdon, N. F. McPhee: A Field Guide to Genetic Programming. lulu.com, 2008.
  ISBN 978-1-4092-0073-4. Freely available at http://www.gp-field-guide.org.uk.
