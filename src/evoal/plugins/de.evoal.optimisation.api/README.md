# Optimisation API: steps, run kernel, fitness pipeline and run events

This module holds what all optimisation algorithms share. This README describes the
six parts an algorithm, step, function or listener author works with:

- the **step model** (`de.evoal.optimisation.api.steps`): an algorithm is a template of
  steps after the unified meta-algorithm model (Berger, Plump, Drechsler:
  *Understandability and (self-)explainability in Optimisation Algorithms*, section 3.4),
- the **run kernel** (`de.evoal.optimisation.api.run`): executes a template and records
  the memory model,
- the **fitness pipeline** (`de.evoal.optimisation.api.fitness`): turns the objectives of
  a candidate into the fitness the comparator compares,
- the **constraints** (`de.evoal.optimisation.api.constraints`): how the constraints of
  the DDL are measured and handled,
- **parallel evaluation** (`de.evoal.optimisation.api.evaluation`): how the candidates of
  a batch are evaluated on several threads without changing the result,
- the **run events** (`de.evoal.optimisation.api.events`): what a run publishes to its
  listeners.

```
TemplateAlgorithm            (CDI bean of the DL type, e.g. 'random-search')
  └─ Template                (steps of the initialisation and of one iteration)
       └─ Step ... Step      (work on the SearchState)
OptimisationRun              (the kernel: loop, termination, budget, memory model)
  └─ RunEventDispatcher      (passes the run events to the listeners)
```

The random search plugin (`de.evoal.optimisation.random_search`) is the smallest
complete algorithm and the reference for the sections below. Local search and particle
swarm optimisation are written the same way.

## What the kernel does

`OptimisationRun.execute(criterion, procedure)` runs one optimisation:

1. starts the `@RunScoped` context and the run events (`RunStarted`),
2. iteration 0: `IterationStarted(0)`, `procedure.initialise(events)`, then records the
   population (`IterationFinished(0)`),
3. while the procedure did not stop, the budget is not exhausted and the termination
   criterion agrees: `IterationStarted(n)`, `procedure.iterate(n)`, record the population
   (`IterationFinished(n)`),
4. `RunFinished`, then ends the context.

Recording an iteration means: every member of the population becomes an
`IndividualRecord` with the next id, its objectives (`output`) and its fitness (`fitness`,
one value per component, canonical minimisation), its lineage becomes a relationship to the
individuals of the previous iteration, the ranks are added, and the best individual so far
(`Iteration.bestSoFar`) is updated. On an equal optimisation value, the earlier
individual stays the best.

The run keeps only what the next iteration needs. A relationship to the previous iteration
refers to an `IndividualStub` (id, values and the number of the iteration that holds the
record, but no relationships or properties), not to the record, so a record never keeps
an earlier iteration alive; `bestSoFar` is the record and keeps at most the one iteration
that contains it. Once an iteration is published, its members forget their predecessors
(`Candidate.forgetPredecessors()`, lineage `Lineage.RECORDED`). The components of the fitness are recorded once per run in
`Execution.fitnessComponents`; the applications define them from the fitness pipeline
before the run (`ExecutionRecorder.defineFitness`). The `'memory-model'` writer writes
both; CSV writers and reports show the objectives only.

An algorithm therefore does not number iterations, check the criterion, assign ids,
build the memory model or call the statistics writers.

Before a run, `SearchRunner` writes the literature of the configuration (`RunLiterature`,
`citations.bib` in the output folder) and names `<output folder>/provenance` as the folder of
the run's provenance (`RunRecord` of core, written by core's main class when the application
finished). `RunLiterature` walks the configuration with `ConfigurationLiterature` of core; a
`LiteratureContributor` (e.g. `SurrogateLiterature` for the model file of a surrogate) adds what
a configuration loads.

## Writing an algorithm

### 1. The DL type

Declare the configuration of the algorithm as a DL type that extends `'algorithm'`. The
file lives in `src/main/resources/<module path>.dl`, e.g.
`de/evoal/optimisation/random_search/optimisation.dl` for the module
`de.evoal.optimisation.random_search.optimisation`:

```
module de.evoal.optimisation.random_search.optimisation {
	type 'random-search' extends 'algorithm' {
		@LowerBoundary { boundary := 1; }
		'samples-per-iteration' : int;
	}
}
```

`'algorithm'` already brings `'initialisation'`, `'comparator'`,
`'optimisation-function'`, `'stopping-criteria'`, `'fitness-pipeline'` and
`'candidate-checks'`.

### 2. The algorithm class

Extend `TemplateAlgorithm` and name the bean `<DL module>.<type name>`:

```java
@Dependent
@Named("de.evoal.optimisation.random_search.optimisation.random-search")
public class RandomSearchAlgorithm extends TemplateAlgorithm {
    @Inject
    private Evaluator evaluator;

    @Inject
    private AttributeHelper helper;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    private int samplesPerIteration;

    @Override
    protected void configure(final EObject configuration) {
        samplesPerIteration = helper.<Integer>lookup(configuration, "samples-per-iteration");
    }

    @Override
    protected Template template() {
        final List<Step> steps = List.of(new SampleCandidates(provider, samplesPerIteration),
                                         new EvaluateCandidates(evaluator),
                                         new ReplacePopulation());

        return new Template(steps, steps);
    }
}
```

`TemplateAlgorithm` creates the termination criterion from `'stopping-criteria'` and the
candidate checks from `'candidate-checks'` (see [Candidate checks](#candidate-checks)),
then calls `configure`. Throw an `InitializationException` there if the configuration cannot
be used, e.g. because the search space has variables the algorithm cannot handle.
`template()` is called once per run and must return a new template.

### 3. Steps

A step implements one of the kinds of the meta-algorithm model. The kind is the
interface it implements; together with `description()` it describes the step in the
memory model (e.g. `Initialization: sample 20 candidates`).

| Kind | Purpose | Examples |
|---|---|---|
| `Initialization` | creates candidates | `SampleCandidates` |
| `Selection` | chooses candidates to work on | (EA, later) |
| `Adaption` | creates changed candidates | `OfferNeighbours` (local search), moving the particles (PSO) |
| `FitnessCalculation` | evaluates candidates | `EvaluateCandidates` |
| `Acceptance` | decides which candidates form the population | `ReplacePopulation`, `AcceptNeighbour` (local search) |
| `ParameterAdjustment` | changes the parameters of the strategy | `AdjustAcceptingStrategy` (local search), ARPSO direction |
| `Check` | tests candidates and reacts to failures | `CheckPopulation`, `CheckNewCandidates` |

The `Loop` and the `Generation Increment` of the meta-model are the kernel's main loop.

Reusable steps in this module:

- `SampleCandidates(provider, count)`: the next `count` candidates of the provider become
  the current candidates. All executions share one stream of the provider.
- `EvaluateCandidates(evaluator)`: evaluates the current candidates that are not evaluated
  yet, in their order.
- `EvaluateCandidates.untilAccepted(evaluator, acceptable)`: evaluates
  the offered candidates one after the other until `acceptable` accepts one. Candidates
  after it are neither created nor evaluated.
- `ReplacePopulation`: the current candidates become the population.

Always evaluate through an `Evaluator` (package `api.fitness`). It calls the
`EvaluationService`, which counts the evaluations, enforces the evaluation budget and
publishes `IndividualEvaluated`; then the fitness pipeline computes the fitness and the
comparator the optimisation value. The result is an `Evaluation` (output, fitness,
optimisation value).

### 4. The search state

The steps of a template work on one `SearchState`:

- `getPopulation()`: the evaluated candidates the algorithm holds,
- `getCandidates()`: what the current iteration works on, e.g. sampled candidates, then
  their evaluation,
- `getOffered()` / `getAccepted()`: candidates that are created only when a step consumes
  them (e.g. the neighbours of a local search) and the one that was accepted,
- `strategy(key)` / `setStrategy(key, value)`: further values of the algorithm, e.g. a
  temperature, under a typed `StateKey`,
- `stop()`: the search cannot continue (e.g. no acceptable neighbour); the kernel records
  the iteration and ends the run.

If the state of an algorithm lives in its own objects, as the particles of a swarm do, the
steps work on these objects and the template overrides `members()` to describe them as
candidates (see `ParticleSwarmAlgorithm`).

### 5. Candidates and lineage

A `Candidate` is a point of the search space with its evaluation. It is identified by
its object, not by its values: the `Lineage` of other candidates refers to it, and the
kernel maps it to its individual.

- `new Candidate(input, lineage)` creates an unevaluated candidate,
  `Candidate.evaluated(input, evaluation, lineage)` an evaluated one. The evaluation is
  set once; `output()`, `fitness()` and `value()` read its parts.
- `Lineage.NONE` for initial or sampled candidates, `Lineage.identity(c)` for an
  unchanged candidate, `Lineage.mutation(c)` for a changed one,
  `Lineage.recombination(parents)` for a combination, and `Lineage.replacement(c)` for a
  candidate that took the place of `c` (e.g. after a failed check).
- Every member of a population must be evaluated.
- After every iteration the template replaces each member by a `survivor()`: a copy with
  an identity lineage whose age is one higher. A member that no step replaces is therefore
  recorded as the same candidate in the next iteration. Steps create new candidates with a
  lineage to the members they come from; a new candidate has age 0. A member of a
  recorded iteration has forgotten its predecessors: it can be the predecessor of a new
  candidate, but it cannot be a member again (the kernel rejects it); carry it over with
  `survivor()`.
- Further details go into properties: `candidate.setProperty(name, value)` for the
  individual, `lineage.withProperty(name, value)` for the relationship. A value is a
  `Long`, `Double`, `String` or `Boolean`, or a `List` of one of these. Every name is
  defined once per run with `ExecutionRecorder.defineProperty` (name, scope, value type,
  list, description), while the algorithm is created; the kernel rejects undefined names and
  values of another type.

The population of an iteration is ranked by optimisation value (`Ranking.byValue`).

### 6. An exhausted evaluation budget

With an `'evaluation-budget'` criterion and `'exhaustion' := 'budget-exhaustion.cut-off'`,
the `EvaluationService`
throws an `EvaluationBudgetExhaustedException` when the budget runs out. Let it pass
through the steps. The kernel catches it, records the iteration with the population as it
is at that point, and ends the run. A step that changes the population or the strategy
state before the evaluation has to leave both consistent; e.g. particles that were not
evaluated undo their move.

### 7. Candidate checks

See [Candidate checks](#candidate-checks): state the check points the algorithm offers in
`checkPoints()` and place the steps of `populationChecks(evaluator)` and
`newCandidateChecks()` at them.

### 8. The plugin

- `module-info.java`: `requires de.evoal.core.main`, `de.evoal.languages.models`,
  `de.evoal.optimisation.api`, `jakarta.inject`, `jakarta.cdi`, `org.eclipse.emf.ecore`;
  `opens` the module's root package and opens the bean packages `to weld.core.impl`.
- `src/main/resources/META-INF/beans.xml` with `bean-discovery-mode="annotated"`.
- `pom.xml`: dependency on `optimisation.api` with scope `provided`.
- Register the module in `plugins/pom.xml`, in `core/de.evoal.releng.regressions/pom.xml`
  and `core/de.evoal.releng.jacoco/pom.xml`, and in `RELEASE_PLUGINS` in
  `ci/create-release.sh`.
- Regressions go to `src/test/regressions/<name>/` (`search.ol`, `search.ddl`,
  `expected/`), see the README of `de.evoal.releng.regressions`. Examples go to
  `src/main/examples/<name>/`.

## Candidate checks

A candidate check (`api.checks.CandidateCheck`, DL type `'candidate-check'`) tests
candidates and reacts to the ones that fail (`'check-reaction'`): `warn` reports the
failure, `replace` puts a new candidate in place of the failed one, `resample` redoes the
variation of a failed new candidate (algorithms with a `Resampler`), and `repair` changes
the candidate with the repair strategy of the check (`CandidateCheck.repair()`). The checks
are configured in `'candidate-checks'` of every algorithm and run in their configured
order.

Every check type defines its check point:

| Check point | Step | When | Replacement |
|---|---|---|---|
| `NEW_CANDIDATES` | `CheckNewCandidates` | after the variation, before the evaluation; a failed candidate costs no evaluation. Algorithms with an initial population also check the initial candidates | not evaluated; no predecessor, the property `reason` on the individual |
| `POPULATION` | `CheckPopulation(evaluator)` | as the last step of an iteration | evaluated by the step; `Lineage.replacement(member)` with the property `reason`, or, for a member that is new in the iteration, no predecessor and `reason` on the individual |

A replaced candidate that is not recorded in the memory model has no individual, so the
replacement cannot refer to it.

`TemplateAlgorithm` creates the checks with the `CandidateCheckProducer`. It rejects the
configuration with an `InitializationException` if a check does not support its reaction,
if the algorithm does not offer its check point (`checkPoints()`, none by default), or if
the algorithm does not support a reaction of the check, also as the fallback of a repair
(`reactions()`, all by default). An algorithm places the steps of
`populationChecks(evaluator)` and `newCandidateChecks()` at its check points; both are empty
if no check is configured, so the recorded steps do not change. Local search offers
`POPULATION`; random search and particle swarm optimisation offer none; the evolutionary
algorithm offers both and checks its initial candidates with
`sharingSources(childChecks, sample)`: the same checks with the same replacement sources,
and the `SampleCandidates` step of the initialisation as `Resampler` (`resample` of an
initial candidate takes the next candidate of the `'initialisation'`). CMA-ES
(`de.evoal.optimisation.cma_es`) offers `NEW_CANDIDATES` with the reactions `warn` and
`resample` only (a new sample of its distribution): a replaced or repaired candidate is
not a sample of the distribution and would bias its update.

`resample` and `repair` try at most `'maximum-attempts'` times. A resampled candidate has
the property `attempts` (number of variations); a repaired candidate keeps the lineage of
the failed one with the properties `repair` (strategy) and `attempts` (number of repair
attempts), or has them itself without a predecessor. If the repair fails, the fallback of
the repair (`Repair.fallback()`: `warn`, `replace` or `resample`) reacts to the original
candidate.

Replacements come from the `'replacement-source'` of the check, `'random-population' {}` by
default (#311: no fallback to the `'initialisation'` of the algorithm). Each check takes them
from one stream of its source per run, so `'random-population'` continues to draw new
candidates; the sources of given candidates (`'specify-candidates'`, `'candidates-from-file'`)
repeat their candidates, which is logged as a warning.

Checks in this module:

- `'maximum-age' { iterations; }` (`POPULATION`; `warn`, `replace`): fails a member whose
  age (`Candidate.age()`, the number of iterations it was carried over unchanged) exceeds
  `iterations`. In a local search, this is a random restart after `iterations + 1`
  iterations without an accepted neighbour.
- `'constraint-check' { group; repair; 'repair-fallback'; }` (`NEW_CANDIDATES`; all
  reactions): fails a candidate that violates a constraint of the group, see
  [Constraints](#constraints).

A new check type extends `AbstractCandidateCheck` (reads `reaction` and
`'replacement-source'`), is a `@Dependent` bean named after its DL type, and declares its
check point, its supported reactions and `test(candidate)`, which returns why the
candidate failed.

## Constraints

### Declaration

The constraints are declared in the `constraints` section of the DDL with
`constraint(comparison, "group")` (`de.evoal.optimisation.constraint`). A comparison
compares two arithmetic expressions over the search features and the objectives with
`<`, `<=`, `>`, `>=` or `=`. The `ConstraintCompiler` brings it into the normal form
g >= 0 (inequality) or g = 0 (equality) (`api.constraints.Constraint`) and keeps the
linear form if g is affine in the search features (`LinearForm`, needed by the repairs).
`'standard-deviation'(data 'x', sigma)` declares the measurement uncertainty of a feature.
The constraints are numbered from 1 in the order of the DDL.

### Measurement

The `ConstraintEvaluation` measures every constraint of an evaluated candidate with the
`'constraint-measure'` of the algorithm and stores the degrees in the
`ViolationRecord` of its `Evaluation`:

- the degree of an inequality is max(0, -g), of an equality max(0, |g| - tolerance)
  (`'equality-tolerance'`, default 1e-4); 0 means satisfied. Strict and non-strict
  inequalities are measured alike;
- `'exact-measure'` measures at the values of the candidate, `'tolerance-measure' {
  factor }` takes the smallest degree when every feature with a standard deviation sigma
  is moved by -factor * sigma, 0 or +factor * sigma;
- the violation of a group is the sum of the degrees of its constraints; a candidate is
  feasible in the group if the violation is 0.

The optimisation function is never called for a constraint, so the evaluation budget does
not change. The metric `constraint-evaluations` counts every measurement. A
`'constraint-check'` measures its group before the evaluation and keeps the degrees on the
candidate (`Candidate.measuredViolations()`); the evaluation does not measure them again
(`Evaluator.evaluateAll(inputs, known)`). The memory model records the degree of every
constraint as the individual property `violation-<n>`; `'constraint-statistics'` writes per
iteration and group the number of infeasible members and the sum of their violations.

### Handling

Every group is handled by the algorithm configuration; a configuration that names a group
the DDL does not declare is rejected, a group that nothing handles is reported as a warning
(`ConstraintGroupCheck`).

| Handling | When | What happens |
|---|---|---|
| `'constraint-check' { group; reaction; ... }` | before the evaluation | `warn`, `replace`, `resample` or `repair` a candidate that violates the group; only groups without constraints on objectives |
| `'constraint-penalty' { group; weight }` | fitness pipeline | adds weight times the violation to every fitness component (static penalty) |
| `'feasibility-comparator' { group }` | comparison | feasible before infeasible, then fitness, two infeasible by violation (Deb 2000) |
| `'epsilon-comparator' { group; epsilon }` | comparison | like the feasibility rules, but a violation up to epsilon counts as feasible (Takahama and Sakai 2006) |
| `'nsga2-selection' { group }` | non-dominated sorting | constrained domination (Deb et al. 2002, section VI-A) |

The repairs of `'constraint-check'` (`api.constraints.ConstraintRepair`) are deterministic;
every attempt starts from the previous result, rounds integer features and moves the values
into the bounds of the DDL:

- `'saturation-repair'` (`main.constraints.SaturationRepair`): constraints linear in one
  search feature are bounds; a violated bound sets the feature to it, for integer features
  the nearest integer on the feasible side, one step inside a strict bound. The name
  follows Kononova et al. (2024).
- `'projection-repair'` (`main.constraints.ProjectionRepair`): every violated linear
  constraint once per attempt, in DDL order, x + t * a with t = -g(x) / |a|^2, the
  systematic projection of Agmon (1954).

Examples: `ea-constraints` (EA plugin: repair and penalty), `search-with-benchmark`,
`search-with-benchmark-and-training` and `search-with-benchmark-and-target` (generator
plugin: saturation, replacement from training data, feasibility rules with targets).

References:

- S. Agmon: The relaxation method for linear inequalities. Canadian Journal of
  Mathematics 6, 1954, pp. 382-392.
- K. Deb: An efficient constraint handling method for genetic algorithms. Computer Methods
  in Applied Mechanics and Engineering 186(2-4), 2000, pp. 311-338.
- K. Deb, A. Pratap, S. Agarwal, T. Meyarivan: A fast and elitist multiobjective genetic
  algorithm: NSGA-II. IEEE Transactions on Evolutionary Computation 6(2), 2002, section VI-A.
- A. V. Kononova, D. Vermetten, F. Caraffini, M.-A. Mitran, D. Zaharie: The importance of
  being constrained: dealing with infeasible solutions in Differential Evolution and
  beyond. Evolutionary Computation, 2024, doi 10.1162/evco_a_00333.
- J. J. Liang et al.: Problem definitions and evaluation criteria for the CEC 2006 special
  session on constrained real-parameter optimization. Technical report, 2006 (equality
  tolerance 1e-4).
- T. Takahama, S. Sakai: Constrained optimization by the epsilon constrained differential
  evolution with gradient-based mutation and feasible elites. IEEE Congress on
  Evolutionary Computation 2006, pp. 1-8.

## The fitness pipeline

The algorithms do not compare objectives. Every evaluation goes through the same chain:

```
input ──optimisation function──▶ objectives ──FitnessPipeline──▶ fitness ──comparator──▶ optimisation value
```

- The **objectives** are the output of the optimisation function, with their declared
  types. The statistics writers show them.
- The **fitness** (`Fitness`) is a vector of `double`s in the **canonical direction:
  smaller is better**. Its `FitnessLayout` names the components; a component that belongs
  to an objective refers to its `Goal`.
- The **optimisation value** is what the steps of an algorithm compare (`FitnessValue`).

### Order of the steps

`FitnessPipeline.apply(input, objectives, violations)` runs:

1. one component per goal of the problem, the objective value as `double` (integers up to
   2^53 are exact),
2. the `DirectionStep`, derived from the goals: `minimise` keeps `v`, `maximise` gives
   `-v`, and `optimise ... towards t with d` gives the distance `d(v, t)` (DL type
   `'target-distance'`: `distance`, `'squared-distance'`, `'relative-distance'`; with
   `towards target`, `t` is the current target point of an evaluation),
3. the steps of `'fitness-pipeline'` of the algorithm, in their order, each on the result
   of the previous one.

`FitnessPipelineProducer` creates the `Goals` and the pipeline for every run. The
pipeline folds the layouts of the steps when it is built, so the components of the final
fitness are known before the first evaluation (the memory model records them). It also
rejects, when it is built:

- a `Scalarisation` that is not the last step (so there is at most one),
- a step marked `RequiresObjectiveUnits` after one marked `ChangesUnits`.

### Available steps

| DL type | Class | Kind | Effect |
|---|---|---|---|
| `scaling` | `ScalingStep` | `ChangesUnits` | divides listed components by a reference value |
| `'objective-selection'` | `ObjectiveSelectionStep` | | keeps one component |
| `'weighted-sum'` | `WeightedSumStep` | `Scalarisation` | one component `weighted-sum`; `weights` lists every component once |
| `'constraint-penalty'` | `ConstraintPenaltyStep` | `ChangesUnits` | adds weight times the violation of a constraint group to every component |
| `'prediction-interval'` | `PredictionIntervalStep` (surrogate.adaption) | `RequiresObjectiveUnits` | adapts predicted objectives by the width of their prediction interval |
| `'gaussian-density'`, `'kernel-density'` | `GaussianDensityStep`, `KernelDensityStep` (surrogate.adaption) | `RequiresObjectiveUnits` | adapts predicted objectives by the density of the training data around the candidate |

The surrogate adaptions apply formulas on objective values; they convert a component back
with `DirectionStep.toObjective` and the result with `DirectionStep.toCanonical`, so they
only accept `minimise` and `maximise` goals.

### Writing a fitness step

1. Declare a DL type that extends `'fitness-step'` (or `scalarisation`) in the module's
   DL file.
2. Implement `FitnessStep` (or one of the marker interfaces `Scalarisation`,
   `ChangesUnits`, `RequiresObjectiveUnits`), `@Dependent` and named
   `<DL module>.<type name>`; read the configuration in `init`.
3. `apply(context, current)` returns the new fitness. `context` holds the input, the
   objectives and the goals of the candidate. Do not change `current`, create a new
   `Fitness`.
4. If the step adds, removes or renames components, override `layout(input)`; the
   fitness that `apply` returns must have exactly this layout, otherwise the pipeline
   throws. New components are created with `FitnessComponent.named(name)`.

`ObjectiveSelectionStep` is a short example of a step that changes the layout.

### Scalarisation or comparator?

A **scalarising function** maps the fitness of one candidate to a single value (weighted
sum, Tchebycheff, achievement scalarising functions). It is a step, a `Scalarisation`. A
**relation** between two candidates (lexicographic order, Pareto dominance,
ε-dominance) cannot be computed per candidate. It is a comparator
(`OptimisationValueComparator`, DL type `comparator`):

| DL type | Class | Compares |
|---|---|---|
| `'numeric-comparator'` | `NumericOptimisationComparator` | the only component (one goal, or after a scalarisation or `'objective-selection'`) |
| `'hierarchical-comparator'` | `HierarchicalComparator` | the components of the objectives in `order`; the next one only if the previous ones are equal |

A comparator creates a `FitnessValue` from the objectives and the fitness. Its
`compareTo` is reversed, because `OptimisationValue` treats a greater value as better;
`distanceFrom` (used by simulated annealing and threshold accepting) is the sum of the
absolute differences of the compared components. The evolutionary algorithm does not use
the pipeline yet; it is rebuilt on it.

## Parallel evaluation

The `EvaluationService` evaluates a batch of candidates (`evaluateAll`) on the threads of
the run (`EvaluationExecutor`). The result of a run does not depend on the number of
threads: the memory model, the statistics and the references of the regressions are the
same for 1 or 64 threads.

### Number of threads

| Option | Meaning |
|---|---|
| `-Bcore:evaluation-threads=<n>` | number of threads that evaluate (default: number of processors) |
| `EVOAL_THREADS=<n>` | the same for the start scripts (`evoal-search.sh`, `evoal-evaluate-search.sh`, `evoal-search-with-surrogate.sh`) |

The number of threads is logged, but not recorded in the memory model.

### What runs in parallel

- Only the optimisation function runs on the threads. The fitness pipeline, the
  comparator, the counters and the `IndividualEvaluated` events run afterwards on the
  thread of the run, in the order of the candidates.
- Batches: random search (`EvaluateCandidates` in batch mode) and particle swarm
  optimisation (initial swarm and every iteration). The particles also move in parallel
  (ARPSO moves them one after the other). Local search evaluates one neighbour after the
  other.
- A budget with `cut-off` covers the first candidates of a batch, as in a sequential
  run (`Evaluator.evaluateAll`, `BatchEvaluation`).

### Why the result does not depend on the threads

- The `EvaluationService` gives every evaluation an index on the thread of the run, before
  the batch is submitted (`EvaluationTask`). Results, counters and events are processed in
  the order of these indices, not in the order the evaluations end.
- Random numbers drawn during an evaluation come from `RandomService.taskRandom(name)`:
  a new generator per evaluation, derived from the seed, the run, the name and the index.
  They do not depend on which thread evaluates or when.
- Parallel work of an algorithm uses one random stream per entity, e.g., one per particle
  (`de.evoal.optimisation.pso/particle-<id>`), never a shared one.

### Thread-safe optimisation functions

`OptimisationFunction.isThreadSafe()` (default `false`) declares whether `evaluate` can be
called on several threads at the same time. A function that is not thread-safe is
evaluated on the thread of the run, one candidate after the other (logged once per run);
the result is the same. Thread-safe are the benchmark functions, `'search-space-distance'`
and `'random-fitness'`; the problem function forwards the answer of the function it
delegates to. Surrogate functions are not thread-safe yet.

A function that returns `true` has to follow these rules:

- **No shared mutable state in `evaluate`.** Read only what `init` set up; create new
  objects (e.g. the output) per call.
- **No new EClasses during a run.** Create merged spaces and other classes in `init`. The
  service prepares the classes of the candidates (`ConcurrentEClassAccess`) and evaluates
  the first candidate of the first parallel batch on the thread of the run, so that the
  lazily built caches of EMF exist before several threads use them.
- **Random numbers only from `taskRandom`.** `RandomService.random(name)` returns one
  shared stream per name, whose values would depend on the order of the evaluations.

`ParallelEvaluationReproducibilityTest` (random search, memory model files) and
`ParallelSwarmReproducibilityTest` (PSO) check this with a function that needs a random
time per evaluation, for 1, 2 and 8 threads.

## Run events

A run publishes its events in this order:

```
RunStarted
  IterationStarted(0) (StepExecuted | IndividualEvaluated)* IterationFinished(0)
  IterationStarted(1) (StepExecuted | IndividualEvaluated)* IterationFinished(1)
  ...
RunFinished
```

| Event | Published by | Content |
|---|---|---|
| `RunStarted` | kernel | the `Execution`; all metric definitions are complete |
| `IterationStarted` | kernel | the number of the iteration |
| `StepExecuted` | `Template`, after every step | the iteration number and the step (`kind: description`) |
| `IndividualEvaluated` | `EvaluationService`, after every evaluation | the candidate, the output and the evaluation source |
| `IterationFinished` | kernel | the recorded `Iteration`, with its metrics |
| `RunFinished` | kernel | the `Execution` with the final execution metrics |

An interrupted iteration (exhausted budget) also ends with `IterationFinished`.

### Listeners

A `RunListener` has one method, `on(RunEvent)`; `RunEvent` is a sealed interface, so a
listener selects the events it needs with a `switch` over the event types.

- The `RunEventDispatcher` calls the listeners of the current run synchronously on the
  thread of the run, in the order they were registered. The run waits for every listener.
- Listeners observe the run. They must not change the data of an event, so that they
  cannot change the search result.
- Before the listeners receive an `IterationFinished`, the dispatcher records the
  iteration metrics. This is not a listener because the termination criteria read the
  metrics.
- Events outside a run are ignored.

The kernel registers the listeners of a run when it starts. Today that is the
`StatisticsWriterListener`, which adapts the configured statistics writers
(`document [...]` of the problem in OL): `start()` on `RunStarted`, `add(iteration)` on
`IterationFinished`, `write()` on `RunFinished`. To add output to EvoAl, write a
`StatisticsWriter`; a new kind of listener has to be registered in
`OptimisationRun.execute`.
