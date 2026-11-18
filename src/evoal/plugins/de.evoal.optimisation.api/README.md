# Optimisation API: steps, run kernel, fitness pipeline and run events

This module holds what all optimisation algorithms share. This README describes the
five parts an algorithm, step, function or listener author works with:

- the **step model** (`de.evoal.optimisation.api.steps`): an algorithm is a template of
  steps after the unified meta-algorithm model (Berger, Plump, Drechsler:
  *Understandability and (self-)explainability in Optimisation Algorithms*, section 3.4),
- the **run kernel** (`de.evoal.optimisation.api.run`): executes a template and records
  the memory model,
- the **fitness pipeline** (`de.evoal.optimisation.api.fitness`): turns the objectives of
  a candidate into the fitness the comparator compares,
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

Recording an iteration means: every member of the population becomes an `Individual`
with the next id, its objectives (`output`) and its fitness (`fitness`, one value per
component, canonical minimisation), its lineage becomes a relationship to the individuals
of the previous iteration, the ranks are added, and the best individual so far
(`Iteration.bestSoFar`) is updated. On an equal optimisation value, the earlier
individual stays the best. The components of the fitness are recorded once per run in
`Execution.fitnessComponents`; the applications define them from the fitness pipeline
before the run (`ExecutionRecorder.defineFitness`). The `'memory-model'` writer writes
both; CSV writers and reports show the objectives only.

An algorithm therefore does not number iterations, check the criterion, assign ids,
build the memory model or call the statistics writers.

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
`'optimisation-function'`, `'stopping-criteria'` and `'fitness-pipeline'`.

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

`TemplateAlgorithm` creates the termination criterion from `'stopping-criteria'`, then
calls `configure`. Throw an `InitializationException` there if the configuration cannot
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
  unchanged candidate, `Lineage.mutation(c)` for a changed one, and
  `Lineage.recombination(parents)` for a combination.
- Every member of a population must be evaluated.
- After every iteration the template replaces each member by a `copy()` with an identity
  lineage. A member that no step replaces is therefore recorded as the same candidate in
  the next iteration. Steps create new candidates with a lineage to the members they come
  from.

The population of an iteration is ranked by optimisation value (`Ranking.byValue`).

### 6. An exhausted evaluation budget

With an `'evaluation-budget'` criterion and `'exhaustion' := 'budget-exhaustion.cut-off'`,
the `EvaluationService`
throws an `EvaluationBudgetExhaustedException` when the budget runs out. Let it pass
through the steps. The kernel catches it, records the iteration with the population as it
is at that point, and ends the run. A step that changes the population or the strategy
state before the evaluation has to leave both consistent; e.g. particles that were not
evaluated undo their move.

### 7. The plugin

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

`FitnessPipeline.apply(input, objectives)` runs:

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
| `'weighted-sum'` | `WeightedSumStep` | `Scalarisation` | one component `weighted-sum` |
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
