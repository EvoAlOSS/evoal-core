# Genetic programming

## What it shows

Symbolic regression searches a mathematical expression that fits a table of values. Genetic
programming (GP) represents an expression as a tree: the inner nodes are functions (`plus`,
`multiply`, `'protected-division'`, ...), the leaves are terminals (the input variable and
constants). An evolutionary algorithm changes the trees by exchanging and replacing subtrees.

The table holds `y = 5 x^3 + 42` for `x = -1000, -998, ..., 1000` (1001 rows). The EA does not
know the formula; it only compares the values of its expressions with the table.

In EvoAl, an expression is a model: a tree of DL objects that is the search data of the problem
(`data 'regression-function' of instance 'expression'`). The functions come from the module
`de.evoal.optimisation.gp.genetic-programming`; the example declares its terminals itself.

## Files

- `gp-example.dl`: the terminal set, the variable type `x` and the ephemeral random constant
  `'c'` with its `'value'` in [-50, 50]. The type is not named `x0`, since a DL type and a data
  of the same qualified name clash (see the README of the plugin).
- `gp-example.ddl`: the expression `'regression-function'`, the objective `'error'` and the
  table columns `'x0'` (input) and `'y0'` (target).
- `gp-example-function-data.csv`: the table, with the header `x0,y0`.
- `gp-example.ol`: the problem and the configuration of the EA:
  - `'size-of-population' := 20`, `'number-of-offspring' := 20`, 20 generations.
  - `'random-population'` with `'ramped-half-and-half'`: trees of depth 2 to 5 with at most
    32 nodes, half of them full, half grown.
  - `'model-chromosome'` with `'subtree-crossover'` (probability 0.9; the crossover points are
    inner nodes with probability 0.9, Koza's 90/10 rule), `'subtree-mutation'` (probability
    0.2, new subtrees grown to depth 4 and 16 nodes) and `'gaussian-mutation'` of the constants
    (probability 0.3, standard deviation 0.02 of their range, i.e. 2).
  - `'plus-replacement'` keeps the best 20 of parents and children.
  - `'symbolic-regression-fitness'` binds the variable type `x` to the column `'x0'`, compares
    with the column `'y0'` and writes the sum of absolute errors into `'error'`, which the
    problem minimises.
  - `'candidate-checks'`: `'maximum-size'` draws a new candidate instead of a tree with more
    than 64 nodes, `'uses-variable'` instead of an expression without `x` (a constant).

## Run

```sh
./01-run-search.sh
```

The output is written to `output/gp-example/`. The run is random, so every run is different.
Repeat a run with its seed, for example:

```sh
EVOAL_SEED=42 ./01-run-search.sh
```

## What to look at

- `output/gp-example/memory-model/iteration-<n>.json`: the population of generation `n`, every
  candidate with its tree (`"input"`) and its error (`"output"`). With the seed 42, the
  smallest error falls from about 1.25e12 to about 1.2e11 within the 20 generations; the
  formula is not found in so few generations.
- Some initial trees divide by expressions such as `x - x`: the protected division returns 1
  there. Trees whose values overflow have the error `Infinity` and are ranked worst.

## Try next

- Search longer (`'maximum-iterations' := 200;`) with a larger population and compare the best
  trees.
- Use the mean squared error: `measure := 'regression-error.mean-squared-error';`.
- Limit the depth instead of the size: `'maximum-depth' { depth := 8; reaction :=
  'check-reaction.resample'; }`.

The README of the plugin `de.evoal.optimisation.gp` describes the functions, the fitness and
the check, with references to the literature.
