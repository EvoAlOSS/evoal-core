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
| `-Devoal.regressions.repetitions=2` | runs every regression twice; both outputs must be identical (nightly pipeline) |
| `-Devoal.regressions.shell=zsh` | shell for the launcher (default `bash`, version 4 or newer) |

## References

References are compared exactly, and floating-point results can differ between
platforms. Therefore the references are created in the EvoAl CI image:

```sh
ci/regressions-in-docker.sh --update
```

The only value that is not compared is the EvoAl version in the memory model
(`"evoalVersion"`): it is stored as `${evoal.version}` and masked in the output,
so a new project version does not change the references.

A reference changes only on purpose, in the same merge request as the code
change that justifies it.
