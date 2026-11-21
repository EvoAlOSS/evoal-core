# Pipelines (generator)

This plugin runs the pipelines of a generator file (`.generator`, application
`de.evoal.pipeline.pipeline-runner`, script `bin/evoal-pipeline.sh`) and provides their
components. A pipeline is a sequence of steps; every step is a component with a configuration and
the data it `reads` and `writes`. The wiki page *Generator Language* describes the language.

## Running pipelines

The `begin`/`end` block of a generator file runs pipelines with two statements:

| Statement | What happens |
|---|---|
| `write "file" with n samples from executing ['p', …];` | an endless source of empty rows, the pipelines, a limit of n rows and a writer of all data to the file (format by its extension) |
| `execute("p");` | the pipeline `p` once: its first step is the source (e.g. `'reader'`), the pipeline ends when the source has no more data; no limit, no writer |

`execute` names the pipeline by a string, because a bare name in a generator expression links to
a DL value, not to a pipeline. `ExecutionDSLConverter` turns the string into a reference to the
converted pipeline, so an unknown name is rejected before the program runs.

## Sources, processors and sinks

`StreamExecutor` maps every row through the steps in order. A **sink** (`PipelineSink`, DL type
`Sink`) passes the rows on unchanged and acts when the stream has ended: the executor calls
`streamEnded()` on every sink in pipeline order after the last row and before `close()`.

Sinks share results as **pipeline values** (`PipelineValues`): one map per program, bound to the
variable `pipeline-values` of the outermost interpreter state, so values outlive loop bodies. A
value is plain data (lists, maps with camelCase keys, strings, numbers, booleans). A name may be
set once per execution (`write` or `execute`); a later execution replaces it.

## Components

| DL module | Components |
|---|---|
| `de.evoal.pipeline.distributions` | `'distribution-based-data'` (source), `'noise-data'`; distributions `'normal-distribution'`, `'uniform-distribution'`, `'multivariate-normal-distribution'` |
| `de.evoal.pipeline.benchmarks` | `ackley`, `rastrigin`, `rosenbrock`, `'weighted-sphere'`, `zdt1` |
| `de.evoal.pipeline.sequences` | `'sequence-generator'` (source) with `'expression-based-sequence'` |
| `de.evoal.pipeline.io` | `reader` (source), `writer`, `empty`, sinks `template` and `'csv-writer'` |
| `de.evoal.pipeline.statistics` | sink `'correlation-estimation'` |
| `de.evoal.pipeline.misc` | `constants`, `limit` |
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
| `correlation-estimation` | estimating correlations from data, rendering them into a DDL module and using them in a search |
| `search-with-benchmark`, `search-with-benchmark-and-target`, `search-with-benchmark-and-training` | the benchmarks as optimisation function |
