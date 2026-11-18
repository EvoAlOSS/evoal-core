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

Every regression runs with `bin/evoal-search.sh` and `EVOAL_SEED=42` in a copy
of its folder (`target/regressions/<plugin>/<name>/run-<n>`, including `run.log`).

A regression whose folder contains `targets.csv` runs as an evaluation with
`bin/evoal-evaluate-search.sh`, one repetition per target point
(`-Boptimisation:target-points-file=targets.csv`). The file has a column for
every feature of the search and the optimisation space; goals
`optimise ... towards target` take their target from it.

## Examples

The examples in `src/evoal/plugins/<plugin>/src/main/examples/<name>` are
checked as well if the property `evoal.regressions.examples` is `true` (nightly
pipeline). An example takes part if its folder contains `expected/`; all other
examples are left out. It must have exactly one run script `01-run-*.sh`, which
is run as users run it, with `EVOAL_HOME` set to the release and
`EVOAL_SEED=42`. The script writes into `output/`. Its references are named
`<plugin>/examples/<name>`.

To add an example, create an empty `expected/` folder and create the
references as described under [References](#references) (with
`-Devoal.regressions.examples=true`).
`ci/create-release.sh` does not copy `expected/` into the release.

## Running

The regressions run with the profile `regressions` (in the merge request
pipeline together with `jacoco`). The profile assembles the release with
`ci/create-release.sh` before the tests:

```sh
mvn -f src/evoal/pom.xml -Pregressions verify
```

| Property | Meaning |
|---|---|
| `-Devoal.regressions.update=true` | rewrites the references instead of comparing |
| `-Devoal.regressions.examples=true` | also runs the examples that have references |
| `-Devoal.regressions.repetitions=2` | runs every regression twice; both outputs must be identical (nightly pipeline) |
| `-Devoal.regressions.shell=zsh` | shell for the launcher (default `bash`, version 4 or newer) |

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

`ci/regressions-in-docker.sh [--update] [--examples]` does the same in the
EvoAl CI image, e.g., to reproduce a pipeline failure.

The only value that is not compared is the EvoAl version in the memory model
(`"evoalVersion"`): it is stored as `${evoal.version}` and masked in the output,
so a new project version does not change the references.

A reference changes only on purpose, in the same merge request as the code
change that justifies it.
