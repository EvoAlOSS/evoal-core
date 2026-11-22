# Generating data that satisfies the DDL constraints

## What it shows

The pipeline draws `x` and `y` from normal distributions with mean 0.5 and standard deviation
0.5. Many samples lie outside the region that `triangle.ddl` allows:

- `@LowerBoundary { boundary := 0.0; }` and `@UpperBoundary { boundary := 1.0; }` on `x` and `y`,
- `constraint(data 'x' + data 'y' <= 1.0, "triangle");`.

The step `'constraint-validation'` is a filter: it passes on the rows that satisfy these
constraints and drops the others. `write ... with 200 samples` counts the rows after the
filter, so `output/triangle.csv` holds 200 points of the triangle x >= 0, y >= 0, x + y <= 1.
About one sample in four passes; the log line of `'constraint-validation'` says how many rows it
kept.

## Files

- `triangle.ddl`: the data `x` and `y` with their bounds and the constraint.
- `triangle.generator`: the pipeline with `'distribution-based-data'` and
  `'constraint-validation'`.

## Run

```sh
./01-run-generator.sh
```

Repeat a run with its seed, for example `EVOAL_SEED=42 ./01-run-generator.sh`.

## What to look at

- `output/triangle.csv`: every point satisfies the constraints.
- `'maximum-consecutive-rejections'` stops the run if the filter drops that many rows one after
  the other, e.g. with the constraint `data 'x' + data 'y' <= -1.0`, which no sample satisfies.
