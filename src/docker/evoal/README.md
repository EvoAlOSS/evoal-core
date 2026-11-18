# EvoAl image

Runtime image of EvoAl: Java 25 (JRE), OpenBLAS (for smile) and the Linux
package of EvoAl in `/opt/evoal` (`EVOAL_HOME`, `bin/` is on the `PATH`). It runs
as user `evoal` (uid 5001, group 0) in `/home/evoal`.

| Tag | Content |
|---|---|
| `nightly` | the branch `release`, updated every night |
| `nightly-<commit>` | a single nightly build |
| `<version>`, e.g. `2026.10.0` | a release |
| `latest` | the newest release |

```
gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/evoal:nightly
```

The pipeline builds the image from the Linux package in the package registry
(job `image:evoal`, after the smoke test `evoal:package-smoke-test`), see
`.gitlab-ci.yml`.

## Running an example

```sh
docker run --rm -it gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/evoal:nightly
cp -r "$EVOAL_HOME/examples/random-search" . && cd random-search
bash 01-run-search.sh
```

## GitLab workspaces

A project uses the image as the main container of its workspaces with a
`.devfile.yaml` in its root:

```yaml
schemaVersion: 2.2.0
components:
  - name: evoal
    attributes:
      gl/inject-editor: true
    container:
      image: gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/evoal:nightly
      memoryLimit: 4Gi
      cpuLimit: "2"
```

Workspaces start the container with an arbitrary non-root user; the home
folder is writable for group 0, EvoAl is readable for everyone.
