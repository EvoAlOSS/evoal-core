# Estimating correlations from data for a search

## What it shows

The DDL can declare correlations between search variables (`correlation`,
`'ranged-correlation'`), which the correlation-aware operators of the evolutionary
algorithm use. Instead of writing the coefficients by hand, this example estimates them
from tabular data with a pipeline and uses the estimates in a search:

1. `generate.generator` writes 1000 rows of `x:0`, `x:1`, `x:2` from a multivariate
   normal distribution with unit variances and the known correlations
   rho(`x:0`, `x:1`) = 0.8 and rho(`x:0`, `x:2`) = rho(`x:1`, `x:2`) = 0.
2. `estimate.generator` runs the pipeline `'estimate-correlations'` once with
   `execute("estimate-correlations");`. Its source `'reader'` reads every row of
   `output/data.csv`, and the pipeline ends with the file. Three sinks act when the stream
   has ended:
   - `'correlation-estimation'` estimates every pair of the data it reads: the Pearson
     correlation (Spearman if a feature is ordinal), the number of rows and a 95 %
     confidence interval (Fisher's z-transformation). Besides the estimate on all rows,
     it estimates `x:0` and `x:1` in the quadrant where both are positive (`ranges`).
     Estimates with an absolute coefficient below `'minimum-correlation' := 0.3` are left
     out, here the pairs with `x:2`. It publishes the estimates as the pipeline value
     `"correlations"`.
   - `'template'` renders `estimated-correlations.ddl.ftl` (FreeMarker) with the value
     into the DDL module `estimated-correlations.ddl`, strongest correlation first.
   - `'csv-writer'` writes the value as the table `output/correlations.csv`.
3. `search.ol` imports the generated module (`import "data" from
   'estimated-correlations';`). The `constraints` of every DDL module that the OL module
   of the problem imports belong to the problem, so the search uses the estimated
   correlations with `'correlation-aware-mutation'` and `'linkage-crossover'`, and
   `'correlation-statistics'` compares them with the population.

Nothing is applied implicitly: the search uses exactly the correlations of the modules it
imports, and the generated module can be inspected or edited before the search.

## Files

- `search.ddl`: the variables `x:0`, `x:1`, `x:2` with their bounds and the function
  value `y:0`.
- `generate.generator`: generates `output/data.csv`.
- `estimate.generator`: the estimation pipeline.
- `estimated-correlations.ddl.ftl`: the FreeMarker template of the generated module. It
  decides the module name, the imports, the order and the comments.
- `search.ol`: the problem (Ackley function) and the evolutionary algorithm.

## Run

```bash
./01-generate-data.sh
./02-estimate-correlations.sh
./03-run-search.sh
```

The data are random; set `EVOAL_SEED` (the references use `EVOAL_SEED=42`) to get the
same data in every run. The generated module is written next to the configuration files,
because imports of a DDL module resolve relative to the working folder.

## Result

With `EVOAL_SEED=42`, the generated module is:

```
import "definitions" from 'de.evoal.optimisation.constraint';
import "data" from 'search';

/**
 * Correlations estimated by 'correlation-estimation' from output/data.csv (example
 *   correlation-estimation), strongest first: the correlation-aware operators use the first
 *   correlation of a feature.
 */
module 'estimated-correlations' {
	constraints:
		// pearson, n = 1000, 95 % confidence interval [0.7787376650261599, 0.8230825650511868]
		correlation(data 'x:0', data 'x:1', 0.8020125121321098);
		// pearson, n = 425, 95 % confidence interval [0.5505625820922958, 0.6695943136373247]
		'ranged-correlation'(data 'x:0', range(0, 5.12), data 'x:1', range(0, 5.12), 0.6135518968472252);
}
```

The known coefficient 0.8 lies in the confidence interval of the estimate on all rows.
In the positive quadrant, the coefficient is smaller, because the range restricts the
variation of both variables.

`output/correlations.csv` holds the same estimates as a table, with the columns `first`,
`second`, `firstLower`, `firstUpper`, `secondLower`, `secondUpper`, `ranged`, `kind`,
`n`, `coefficient`, `absoluteCoefficient`, `confidenceLower`, `confidenceUpper`,
`confidenceLevel` and `intervalMethod`.
