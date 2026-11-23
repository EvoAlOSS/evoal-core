# Regression tests

Runs every regression configuration of the plugins against the assembled
release and compares the output exactly with the stored references.

## Regression configurations

A regression is a folder `src/evoal/plugins/<plugin>/src/test/regressions/<name>`
with

- `search.ol`, the configuration that is run, and the files it imports
  (e.g. `search.ddl`),
- `expected/`, the expected content of the output folder.

Regressions are small (about 10 iterations, 5–10 individuals) and cover
combinations and edge cases. They are not part of the release. User examples
belong in `src/main/examples`.

Every regression runs with `bin/evoal-search.sh`, `EVOAL_SEED=42` and
`EVOAL_THREADS=1` (see `-Devoal.regressions.threads`) in a copy of its folder
(`target/regressions/<plugin>/<name>/run-<n>`, including `run.log`).

A regression whose folder contains `targets.csv` runs as an evaluation with
`bin/evoal-evaluate-search.sh`, one repetition per target point
(`-Boptimisation:target-points-file=targets.csv`). The file has a column for
every feature of the search and the optimisation space; goals
`optimise ... towards target` take their target from it.

## Tolerance

The comparison is exact. A regression or example whose results depend on the platform,
e.g. because it uses native numeric libraries, can set a relative tolerance for numbers in
the optional file `regression.properties` in its folder, with the reason as a comment:

```properties
# The prediction interval multiplies matrices with native BLAS (OpenBLAS), whose
# results differ in the last digit between platforms.
tolerance = 1e-12
```

Two different lines then still match if they differ only in numbers and every pair of
numbers `a`, `b` satisfies `|a - b| <= tolerance * max(|a|, |b|)`. Without the file the
tolerance is 0. The repeated runs of `-Devoal.regressions.repetitions` are always compared
exactly, since they run on the same platform. `ci/create-release.sh` does not copy the file
into the release.

## Examples

The examples in `src/evoal/plugins/<plugin>/src/main/examples/<name>` run as
well if the property `evoal.regressions.examples` is `true`. An example has
numbered scripts (`01-run-*.sh`, `02-*.sh`, ...), which run in this order as
users run them, with `EVOAL_HOME` set to the release, `EVOAL_SEED=42`,
`EVOAL_THREADS` and `EVOAL_LOGGING=WARN`. The scripts write their results into
`output/`. The log of all scripts is `run.log`.

- An example with `expected/` is compared with its references, named
  `<plugin>/examples/<name>`.
- An example without `expected/` is a smoke test: all scripts must finish with
  exit code 0; the output is not compared and the example runs only once.

To add references to an example, create an empty `expected/` folder and create
the references as described under [References](#references) (with
`-Devoal.regressions.examples=true`). Only deterministic examples get
references. `ci/create-release.sh` does not copy `expected/` into the release.

## Running

The regressions run with the profile `regressions`. Together with the profile
`jacoco`, every run (also the examples) records its coverage in
`target/jacoco-regressions.exec`. The profile assembles the release with
`ci/create-release.sh` before the tests:

```sh
mvn -f src/evoal/pom.xml -Pregressions verify
```

| Property | Meaning |
|---|---|
| `-Devoal.regressions.update=true` | rewrites the references instead of comparing |
| `-Devoal.regressions.examples=true` | also runs the examples (see [Examples](#examples)) |
| `-Devoal.regressions.repetitions=2` | runs every regression twice; both outputs must be identical |
| `-Devoal.regressions.parallelism=2` | number of regressions that run at the same time (default 1) |
| `-Devoal.regressions.shell=zsh` | shell for the launcher (default `bash`, version 4 or newer) |
| `-Devoal.regressions.threads=4` | number of threads that evaluate the candidates (`EVOAL_THREADS`, default 1) |
| `-Devoal.regressions.vm-options=-XX:ActiveProcessorCount=2` | further JVM options of every run (`EVOAL_VM`, after the coverage agent) |

The runner prints the duration of every run (`Regression <name> (run-<n>) took <s> s.`).

In the pipeline (see `REGRESSION_OPTS` in `.gitlab-ci.yml`), 2 runs start at the same
time with 4 evaluation threads each, and every JVM is limited to 4 CPUs
(`-XX:ActiveProcessorCount=4`): the jobs have a quota of 8 CPUs, and a JVM that sees more
CPUs starts more garbage collection and compiler threads than the quota allows.

| Pipeline | Runs |
|---|---|
| merge request into `develop` (the gate) | regressions and examples, with coverage |
| `develop` after a merge | none (the project merges fast-forward only, so the gate tested the same tree) |
| merge request `develop` → `release` | regressions and examples, 2 repetitions |

## References

References are compared exactly. The output is the same on every platform,
because the plugins use `de.evoal.core.api.math.EvoalMath` instead of the
platform-dependent `java.lang.Math` functions (`exp`, `log`, `pow`, `cos`, ...);
the build fails if such a function is called (`forbiddenapis` in
`src/evoal/pom.xml`).
Therefore the references can be created and checked locally:

```sh
mvn -f src/evoal/pom.xml -Pregressions -Devoal.regressions.update=true verify
mvn -f src/evoal/pom.xml -Pregressions -Devoal.regressions.update=true -Devoal.regressions.examples=true verify
```

The libraries the plugins call (e.g. Smile, ONNX Runtime, native BLAS/LAPACK)
do not use `EvoalMath`, so their results can differ between platforms. Examples
that train or evaluate such models either compare with a tolerance (e.g.
`training.gaussianprocess`, see [Tolerance](#tolerance)) or are smoke tests without
`expected/` if their results differ by more (e.g. `surrogate.adaption-training`, whose SVR
keeps a different number of support vectors on another platform).

`ci/regressions-in-docker.sh [--update] [--examples]` does the same in the
EvoAl CI image, e.g., to reproduce a pipeline failure.

The references do not depend on the number of threads either (see "Parallel evaluation"
in the README of `de.evoal.optimisation.api`). They are created with one thread; the pipeline checks them
with 4 threads (`-Devoal.regressions.threads=4`).

The only value that is not compared is the EvoAl version in the memory model
(`"evoalVersion"`): it is stored as `${evoal.version}` and masked in the output,
so a new project version does not change the references.

A reference changes only on purpose, in the same merge request as the code
change that justifies it.
