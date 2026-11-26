# ARFF files: DDL, conversion and training

## What it shows

The three tools of the ARFF plugin on one data set, and what happens to missing values (`?`).

`data.arff` holds 11 measurements of y = 2x + 1 with noise on the grid x = 0, 0.1, ..., 1, and
the nominal attribute `source`. The row at x = 0.2 has no output, another row has no input.

1. `01-run-arff-to-ddl.sh` derives the DDL module `output/measurements.ddl` from the attributes
   of `data.arff`. The scale types are estimates: `measurements.ddl` is the reviewed copy, with
   `quotient` instead of `cardinal` for the real data.
2. `02-run-convert.sh` converts `data.arff` with `measurements.ddl` to JSON, CSV and ARFF. The
   extension of the output file selects the format. The missing values stay missing: the JSON
   rows have no entry for them, the CSV rows an empty cell, the ARFF rows `?`.
3. `03-run-training.sh` trains a linear regression directly on `data.arff`
   (`learning from [ "data.arff" ]`). The two rows with a missing value are left out with a
   warning, so the model learns from 9 of the 11 rows: RMSE 0.0192 and R² 0.9991 on these rows.

## Files

- `data.arff`: the measurements.
- `measurements.ddl`: the data of the example, reviewed from `output/measurements.ddl`.
- `training.mll`: the learning task with the model `'linear-regression'` and the
  goodness-of-fit measures RMSE and R².

## Run

```sh
./01-run-arff-to-ddl.sh
./02-run-convert.sh
./03-run-training.sh
```

The output is written to `output/`.
