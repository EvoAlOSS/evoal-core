# Pipelines (generator)

This plugin runs the pipelines of a generator file (`.generator`, application
`de.evoal.pipeline.pipeline-runner`, script `bin/evoal-pipeline.sh`) and provides their
components. A pipeline is a sequence of steps; every step is a component with a configuration and
the data it `reads` and `writes`. The wiki page *Generator Language* describes the language.

## Running pipelines

The `begin`/`end` block of a generator file runs pipelines with two statements:

| Statement | What happens |
|---|---|
| `write "file" with n samples from executing ['p', …];` | an endless source of empty rows, the pipelines, a limit of n rows and a writer of all data to the file (format by its extension); the limit counts the rows that passed the filters |
| `execute("p");` | the pipeline `p` once: its first step is the source (e.g. `'reader'`), the pipeline ends when the source has no more data; no limit, no writer |

`execute` names the pipeline by a string, because a bare name in a generator expression links to
a DL value, not to a pipeline. `ExecutionDSLConverter` turns the string into a reference to the
converted pipeline, so an unknown name is rejected before the program runs.

## Sources, processors, filters and sinks

`StreamExecutor` passes every row through the steps in order. A **source** (`PipelineSource`, DL
type `Source`, e.g. `reader`) starts the stream of `execute`. A **processor** (DL type `Processor`,
e.g. `'distribution-based-data'`, `'sequence-generator'` or a benchmark) fills or computes data of
the row. A **filter** (`PipelineFilter`, DL type `Filter`) passes on the rows that satisfy its
condition and drops the others; the executor applies it with `stream.filter`. A **sink**
(`PipelineSink`, DL type `Sink`) passes the rows on unchanged and acts when the stream has ended:
the executor calls `streamEnded()` on every filter and sink in pipeline order after the last row
and before `close()`.

### Filters

Every filter has `'maximum-consecutive-rejections'` (no default): if it drops that many rows one
after the other, the run stops with an error that names the filter and the last violation, so a
filter that the data never passes cannot run forever on the endless source of `write`. At the end
of the stream, every filter logs how many rows it kept (`PipelineFilterImpl`).

- `'condition-filter'` keeps the rows for which its `'condition'` is true, e.g.
  `data 'x' < 0.7 OR data 'x' > 0.8`. The condition may only use data the step reads.
- `'constraint-validation'` keeps the rows whose read data satisfy their data description:
  the annotations of the data and of their data types that have a checker (`@LowerBoundary`,
  `@UpperBoundary`; the checkers of the configuration checks, `ConstraintCheckers` in core), and
  the declarations `constraint(comparison, "group")` of the DDL modules that declare the read
  data (compiled by `ConstraintCompiler` of `de.evoal.optimisation.api`; a row passes if g >= 0,
  g > 0 for `<` and `>`). The run stops at start-up if a constraint compares data the step does
  not read, if a constraint is an equality (generated data almost never satisfies g = 0 exactly;
  compute the dependent data in a step instead), or if a data description has a constraint that
  is no annotation (`with constraints: ...`), which nothing evaluates.
- `'rejection-sampling'` keeps a row with the probability p that its `'acceptance-probability'`
  computes from the read data (acceptance-rejection method, von Neumann 1951; Devroye 1986). It
  draws a uniform u in [0, 1) for every row from its own random stream (`RandomStreams`) and keeps
  the row if u < p, so the same seed keeps the same rows. The DL bounds the attribute to [0, 1]:
  a constant outside is rejected when the configuration is loaded, an expression of data is
  checked for every row and stops the run with an error.

`'condition-filter'` and `'rejection-sampling'` evaluate their expression with
`ReadDataExpression`, which also rejects expressions on data the step does not read.

The generator never checks the DDL on its own; only a `'constraint-validation'` step does.

Sinks share results as **pipeline values** (`PipelineValues`): one map per program, bound to the
variable `pipeline-values` of the outermost interpreter state, so values outlive loop bodies. A
value is plain data (lists, maps with camelCase keys, strings, numbers, booleans). A name may be
set once per execution (`write` or `execute`); a later execution replaces it.

## Components

| DL module | Components |
|---|---|
| `de.evoal.pipeline.distributions` | `'distribution-based-data'` (processor), `'noise-data'`; distributions `'normal-distribution'`, `'uniform-distribution'`, `'multivariate-normal-distribution'`, `'sobol-sequence'`; randomisations `'no-randomisation'`, `'random-shift'` |
| `de.evoal.pipeline.benchmarks` | `ackley`, `forrester`, `rastrigin`, `rosenbrock`, `'weighted-sphere'`, `zdt1` |
| `de.evoal.pipeline.sequences` | `'sequence-generator'` (processor) with `'expression-based-sequence'` |
| `de.evoal.pipeline.io` | `reader` (source), `writer`, `empty`, sinks `template` and `'csv-writer'` |
| `de.evoal.pipeline.statistics` | sink `'correlation-estimation'` |
| `de.evoal.pipeline.misc` | `constants`, `limit`, filters `'condition-filter'`, `'constraint-validation'` and `'rejection-sampling'` |
| `de.evoal.pipeline.optimisation` | `'benchmark-function'`: the benchmarks as optimisation function of a search |

### Low-discrepancy sequences

A `'low-discrepancy-sequence'` is a distribution whose samples are the points of a sequence that
covers the box [`lower`, `upper`) more evenly than independent uniform samples; the i-th row gets
the i-th point. `LowDiscrepancySequence` checks the bounds (one pair per dimension), takes the
next point of [0, 1)^d from the subclass, randomises it and scales it to the box.

- `'sobol-sequence'` (`SobolSequence`): Sobol' (1967) with the direction numbers of Joe and Kuo
  (2008) from Commons Math (`SobolSequenceGenerator`), up to 1000 dimensions. The first point,
  the corner `lower`, is kept (Owen 2022, doi:10.1007/978-3-030-98319-2_4). The points are evenly
  balanced for sample counts that are powers of two; a filter after the sequence breaks this.
- `'randomisation'` (no default) maps the points of [0, 1)^d before scaling (`Randomisation`):
  `'no-randomisation'` keeps them, so the seed is ignored; `'random-shift'` (Cranley and
  Patterson 1976) adds one uniform vector Δ per sequence modulo 1. A sequence rejects
  randomisations it does not support (`supports`); a randomisation that needs the structure of a
  sequence, such as Owen's scrambling of digital sequences, would only be supported there.
- Every sequence takes its own random stream (`RandomStreams`), also without randomisation.
- One sequence has to fill all data that should cover the box together: separate sequences
  return the same points (up to their shifts), so their data would be strongly correlated.

### `'correlation-estimation'`

Estimates the correlation of every pair of the data in `reads` and publishes the estimates as the
pipeline value `result`, a list with one map per estimate. It uses `CorrelationEstimator` of
`de.evoal.optimisation.api`, like the statistics writer `'correlation-statistics'`, so both give
the same values for the same data.

- Kind by the DDL scales (`CorrelationKind.of`): Pearson for cardinal and quotient data, Spearman
  (average ranks for ties) if one feature is ordinal; pairs with nominal data are skipped, other
  non-numeric data (e.g. an ordinal enum) is rejected.
- A row without a finite value of one feature is left out for that pair only.
- Confidence interval by Fisher's z-transformation (R. A. Fisher, Metron 1, 1921, pp. 3-32):
  variance 1/(n−3) for Pearson; for Spearman `'confidence-interval'` selects
  `'bonett-wright'` (1 + r²/2)/(n−3) (D. G. Bonett, T. A. Wright, Psychometrika 65(1), 2000,
  pp. 23-28; the default) or `'fieller-hartley-pearson'` 1.06/(n−3) (E. C. Fieller,
  H. O. Hartley, E. S. Pearson, Biometrika 44(3/4), 1957, pp. 470-481).
- One estimate on all rows per pair and, with `ranges` for both features, one per combination of
  their ranges. `'minimum-correlation'` leaves out weaker estimates; estimates without a
  coefficient are left out with a warning.
- Keys: `first`, `second`, `firstLower`, `firstUpper`, `secondLower`, `secondUpper`, `ranged`,
  `kind`, `n`, `coefficient`, `absoluteCoefficient`, `confidenceLower`, `confidenceUpper`,
  `confidenceLevel`, `intervalMethod`.

### `template`

Renders an Apache FreeMarker template (`template`) with the pipeline values in `values` into
`filename`. Locale `ROOT`; numbers with a point, at most 16 decimals and no exponent (valid
literals of the languages); a missing value is an error; only plain data is exposed
(`SimpleObjectWrapper`), `?new` and `?api` are disabled. FreeMarker is shipped with this plugin
(`META-INF/evoal/credits.json`).

### `'csv-writer'`

Writes the pipeline value `name`, a list of maps, to `filename`: one row per map, one column per
key in the key order of the first map, the keys as column names. Rows with different keys and
nested values are rejected; an empty list writes an empty file.

## Examples

| Example | Shows |
|---|---|
| `generator` | sampling the Ackley function |
| `generator-multivariate-with-noise` | a multivariate normal distribution and noise |
| `generator-pipeline` | reading and recalculating data |
| `generator-timeseries` | sequences |
| `generator-constraints` | keeping the samples that satisfy the DDL constraints (`'constraint-validation'`) |
| `generator-rejection-sampling` | data with the density 2x by rejection sampling (`'rejection-sampling'`) |
| `generator-sobol-sequence` | evenly covering data from a randomly shifted Sobol' sequence, compared with uniform data |
| `correlation-estimation` | estimating correlations from data, rendering them into a DDL module and using them in a search |
| `search-with-benchmark`, `search-with-benchmark-and-target`, `search-with-benchmark-and-training` | the benchmarks as optimisation function |
