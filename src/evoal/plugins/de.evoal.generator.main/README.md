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

The generator never checks the DDL on its own; only a `'constraint-validation'` step does.

Sinks share results as **pipeline values** (`PipelineValues`): one map per program, bound to the
variable `pipeline-values` of the outermost interpreter state, so values outlive loop bodies. A
value is plain data (lists, maps with camelCase keys, strings, numbers, booleans). A name may be
set once per execution (`write` or `execute`); a later execution replaces it.

## Components

| DL module | Components |
|---|---|
| `de.evoal.pipeline.distributions` | `'distribution-based-data'` (processor), `'noise-data'`; distributions `'normal-distribution'`, `'uniform-distribution'`, `'multivariate-normal-distribution'` |
| `de.evoal.pipeline.benchmarks` | `ackley`, `forrester`, `rastrigin`, `rosenbrock`, `'weighted-sphere'`, `zdt1` |
| `de.evoal.pipeline.sequences` | `'sequence-generator'` (processor) with `'expression-based-sequence'` |
| `de.evoal.pipeline.io` | `reader` (source), `writer`, `empty`, sinks `template` and `'csv-writer'` |
| `de.evoal.pipeline.statistics` | sink `'correlation-estimation'` |
| `de.evoal.pipeline.misc` | `constants`, `limit`, filters `'condition-filter'` and `'constraint-validation'` |
| `de.evoal.pipeline.optimisation` | `'benchmark-function'`: the benchmarks as optimisation function of a search |

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
| `correlation-estimation` | estimating correlations from data, rendering them into a DDL module and using them in a search |
| `search-with-benchmark`, `search-with-benchmark-and-target`, `search-with-benchmark-and-training` | the benchmarks as optimisation function |
