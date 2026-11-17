# Optimisation API: steps, run kernel and run events

This module holds what all optimisation algorithms share. This README describes the
three parts an algorithm author or a listener author works with:

- the **step model** (`de.evoal.optimisation.api.steps`): an algorithm is a template of
  steps after the unified meta-algorithm model (Berger, Plump, Drechsler:
  *Understandability and (self-)explainability in Optimisation Algorithms*, section 3.4),
- the **run kernel** (`de.evoal.optimisation.api.run`): executes a template and records
  the memory model,
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
with the next id, its lineage becomes a relationship to the individuals of the previous
iteration, the ranks are added, and the best individual so far (`Iteration.bestSoFar`) is
updated. On an equal optimisation value, the earlier individual stays the best.

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
`'optimisation-function'` and `'stopping-criteria'`.

### 2. The algorithm class

Extend `TemplateAlgorithm` and name the bean `<DL module>.<type name>`:

```java
@Dependent
@Named("de.evoal.optimisation.random_search.optimisation.random-search")
public class RandomSearchAlgorithm extends TemplateAlgorithm {
    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    @Inject
    private EvaluationService evaluationService;

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
                                         new EvaluateCandidates(evaluationService, comparator),
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
- `EvaluateCandidates(evaluationService, comparator)`: evaluates the current candidates
  that are not evaluated yet, in their order.
- `EvaluateCandidates.untilAccepted(evaluationService, comparator, acceptable)`: evaluates
  the offered candidates one after the other until `acceptable` accepts one. Candidates
  after it are neither created nor evaluated.
- `ReplacePopulation`: the current candidates become the population.

Always evaluate through the `EvaluationService`. It counts the evaluations, enforces the
evaluation budget and publishes `IndividualEvaluated`.

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

- `new Candidate(input, lineage)` creates an unevaluated candidate, `Candidate.evaluated`
  an evaluated one. The evaluation is set once.
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
