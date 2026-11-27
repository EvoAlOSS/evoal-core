# EvoAl's merged Xtext jar

The official jars `org.eclipse.xtext` and `org.eclipse.xtext.util` both contain classes of the
package `org.eclipse.xtext.util`. The Java module system rejects such a split package, so EvoAl
cannot put both jars on the module path. EvoAl therefore uses its own merged jar:
`org.eclipse.xtext` with the classes of `org.eclipse.xtext.util` added.

- `core.main/pom.xml` depends on the merged jar and does not copy the util jar into the release
  (`excludeArtifactIds`); `credits.json` names the util jar under `contains` of the library.
- The merged jar is served by the package registry `custom-xtext` of the project (repository
  `evoal-common-artifacts` in `src/evoal/pom.xml`). The languages build and `core.junit` use the
  official jars from Maven Central.
- **Version scheme:** the merged jar of the official version `a.b.c` has the version
  `a.b.(c+1)`, e.g. 2.41.1 for 2.41.0.

## Building

```sh
./merge.sh 2.41.0
```

downloads both official jars of the version from Maven Central (checked against Central's
SHA-1) and writes `target/org.eclipse.xtext-2.41.1.jar` and `target/org.eclipse.xtext-2.41.1.pom`:

- the classes and resources of both jars; on a conflict the file of `org.eclipse.xtext` wins
  (`plugin.properties`);
- without the signatures (`META-INF/ECLIPSE_.SF`, `ECLIPSE_.RSA`), which do not fit the merged
  content, and without the `META-INF` of the util jar;
- a new manifest with `Automatic-Module-Name: org.eclipse.xtext`, so the module name does not
  depend on the file name; the OSGi headers are left out (EvoAl does not run in OSGi);
- the pom of `org.eclipse.xtext` with the merged version, and the dependency versions
  `${project.parent.version}`, so the Xtext dependencies keep the official version; the
  embedded `pom.xml` and `pom.properties` are changed the same way;
- every entry with the same date, so that a second run gives the same jar.

`./merge.sh 2.41.0 --compare <jar>` also lists the entries that differ from another jar, e.g. the
one in the registry. Against the uploaded 2.41.1 (built by hand), only `META-INF/MANIFEST.MF`
differs: it has no `Automatic-Module-Name` and another `Created-By`.

## Upgrading Xtext

1. `./merge.sh <new official version>` and check the result (`--compare` with the previous
   merged jar lists what changed).
2. `./upload.sh <merged version>` installs it locally and deploys it to `custom-xtext` (needs the
   credentials of the server `evoal-artifacts` in Maven's settings).
3. Set the version in `src/evoal/core/de.evoal.core.main/pom.xml` and `xtext.version` in
   `src/languages/pom.xml` and `src/evoal/pom.xml`, then build the languages and the runtime.
