# CMA-ES: covariance matrix adaptation evolution strategy

This plugin provides the optimiser `'cma-es'` (DL module
`de.evoal.optimisation.cma_es.optimisation`). It is a (mu/mu_w, lambda)-CMA-ES with:
- cumulative step-size adaptation;
- rank-one and rank-mu update with positive recombination weights;
- a full or a diagonal covariance matrix (sep-CMA-ES);
- IPOP or BIPOP restarts.

The equations and default parameters are those of figure 6 and table 1 of the tutorial
(N. Hansen: The CMA evolution strategy: a tutorial, arXiv:1604.00772v2, 2023). They are
validated against pycma, the reference implementation (see [Validation](#validation)).

CMA-ES learns the dependencies between the variables while it runs. The memory model records
the correlations its covariance matrix implies, next to the correlations and building blocks
that the DDL declares. This makes CMA-ES the baseline for comparing learned with declared
linkage.

## Configuration

```
configure 'cma-es' for 'problem' {
    'initial-step-size' := 2.0;
    'covariance-model' := 'full-covariance' {};          // or 'diagonal-covariance' {}
    'restart-strategy' := 'bipop-restart' {};            // or 'no-restart' {}, 'ipop-restart' {}
    termination := 'cma-es-termination' {};
    'initialisation' := 'random-population' {};          // the means of the CMA-ES runs
    'comparator' := 'numeric-comparator' {};
    'optimisation-function' := 'problem-function' {};
    'stopping-criteria' := [ 'evaluation-budget' { 'maximum-evaluations' := 10000; } ];
}
```

These attributes are optional:
- `'population-size'`: default 4 + floor(3 ln n);
- `'parent-number'`: default floor(lambda / 2);
- `'learning-rates'` (`'c-sigma'`, `'d-sigma'`, `'c-c'`, `'c-1'`, `'c-mu'`, `'c-m'`): default
  table 1 of the tutorial; for the diagonal model, c_1 and c_mu are multiplied by
  (n + 2) / 3 (Ros and Hansen 2008);
- `'record-all-correlations'`.

The DL file documents every attribute with its default.

Only real search features are supported.

## Steps

| Iteration | Kind | Step |
|---|---|---|
| 0 | ParameterAdjustment | set up the distribution: the first candidate of `'initialisation'` as the mean m, sigma = `'initial-step-size'`, C = I |
| all | Selection | the mu best members of the population (from iteration 1) |
| all | ParameterAdjustment | update m, p_sigma, sigma, p_c and C (from iteration 1) |
| all | ParameterAdjustment | termination criteria of CMA-ES: restart or end the search (from iteration 1) |
| all | Adaption | sample lambda candidates from N(m, sigma^2 C), mapped into the bounds |
| all | Check | the checks of new candidates (`warn`, `resample`) |
| all | FitnessCalculation | evaluate the candidates (in parallel if the function allows it) |
| all | Acceptance | the candidates become the population (comma selection) |

If the search ends without restarting, the iteration samples nothing and the population stays.
The kernel's `'stopping-criteria'` end the whole search; the CMA-ES termination criteria end
a CMA-ES run (`'cma-es-termination'`, appendix B.3 of the tutorial: `no-effect-axis`,
`no-effect-coord`, `condition-cov`, `equal-fun-values`, `stagnation`, `tol-x-up`, `tol-fun`,
`tol-x`). The function value these criteria use is the first fitness component.

### Iteration limit

`'maximum-iterations'` of `'cma-es-termination'` (optional, no limit by default) ends a CMA-ES
run after L(n, lambda) iterations, checked before the other criteria:

| Type | L | Values of the archived BBOB entries |
|---|---|---|
| `'fixed-iteration-limit' { iterations }` | iterations | – |
| `'quadratic-iteration-limit' { 'a'; 'b' }` | a + b (n + 3)^2 / sqrt(lambda) | BIPOP-CMA-ES 2009, IPOP-CMA-ES 2010: a = 100, b = 50 (pycma's default: b = 150) |
| `'sep-iteration-limit' { 'a'; 'b' }` | a + b n sqrt(n / lambda) | IPOP-SEP-CMA-ES 2009: a = 100, b = 300 |

L is computed for every CMA-ES run with the population size of that run, as `cmaes.m` does
with `MaxIter` (version 3.61.beta: `stopMaxIter` is evaluated in every restart). pycma 4.6.0
evaluates `maxiter` once, with the real-valued default 4 + 3 ln n, and keeps it for all
restarts. A run ends when its number of updates reaches L, so the limit is ceil(L). A small
BIPOP restart ends after the smaller of L and its own limit (half the evaluations of the large
regime / lambda), as `min(maxiter0, ...)` in pycma.

### Restarts

Every CMA-ES run takes its mean from the next candidate of `'initialisation'` and starts with
C = I.

- `'ipop-restart'`: the population size is multiplied by `'population-factor'` per restart
  (Auger and Hansen 2005).
- `'bipop-restart'`: alternates between large restarts (as IPOP) and small restarts with a
  random population size and step size (Hansen 2009). The schedule follows
  `cma.fmin(..., bipop=True)` of pycma 4.6.0.

### Bounds

The distribution lives in an unbounded genotype space. A sample is mapped into the bounds of
the DDL by pycma's default boundary handling `BoundTransform`. The mapping is:
- the identity, except in a margin of max(1, |bound|) / 20 at each bound;
- quadratic within the margins;
- periodic with mirrors outside.

So no evaluation is wasted, and on BBOB ([-5, 5]) the mapping is the identity around the
optimum. The update uses the genotypes. The genotype mean can lie in a mirrored copy of the
search space. Therefore the memory model records the mean mapped into the bounds, and it turns
the sign of the correlations of coordinates that are mirrored at the mean
(`BoundTransform.orientation`).

### Candidate checks

Checks of new candidates may `warn` or `resample`; resampling draws a new sample from the
same distribution. `replace` and `repair` are rejected (`TemplateAlgorithm.reactions()`):
a candidate that is not a sample of the distribution would bias the update.

## Memory model

The sampled candidates have no predecessors; they come from the distribution of their
iteration. With a restart strategy, every candidate has the property `restart`, the number
of its CMA-ES run. A candidate that the bounds changed has its point of the distribution as
the property `genotype`.

`DistributionMetrics` records the distribution that sampled the population of every iteration
as iteration metrics:

| Metric | Meaning |
|---|---|
| `sigma` | step size |
| `axis-ratio` | sqrt of the condition number of C |
| `population-size` | lambda |
| `restart` | number of the CMA-ES run |
| `mean-<feature>` | mean, mapped into the bounds |
| `learned-correlation-<n>` | rho = C_ij / sqrt(C_ii C_jj) of the features of DDL correlation n |
| `learned-within-building-block-<n>` | mean abs(rho) of the pairs within building block n |
| `learned-between-building-block-<n>` | mean abs(rho) of the pairs of a feature of block n and one outside it |
| `correlation-<f>-<g>` | rho of every pair, with `'record-all-correlations'` |

The diagonal model records no correlations. The statistics writer `'learned-linkage'`
(`learned-linkage.csv`) compares the learned values with the declared coefficients.

## Numerics and repeatability

- **Normal samples:** `de.evoal.core.api.random.Gaussian` (Box-Muller with `EvoalMath`),
  drawn from the stream `de.evoal.optimisation.cma_es/sampling` on the run thread. Only the
  evaluations run in parallel, so the results do not depend on the number of threads.
- **Eigendecomposition:** `SymmetricEigensystem`, own code. It uses Householder
  tridiagonalisation and implicit symmetric QR steps (Golub, Van Loan). Only + - * / and
  `Math.sqrt` are used, so the result is the same on every platform. C is decomposed every
  max(1, floor(1 / (10 n (c_1 + c_mu)))) updates (appendix B.2 of the tutorial).
- **E||N(0, I)||:** the exact value sqrt(2) Gamma((n + 1) / 2) / Gamma(n / 2), as in pycma,
  computed by a recurrence. The tutorial gives an approximation.

## Validation

1. **pycma (deterministic):** `src/test/python/pycma-reference.py` runs pycma 4.6.0 on the
   sphere, the rotated ellipsoid (full model) and the ellipsoid (diagonal model) for
   n = 2, 5, 10, 40 iterations each. It writes the samples and the state after every
   update into `pycma-updates.txt`. `DistributionReferenceTest` feeds these samples into
   `Distribution.update`; m, sigma, p_sigma, p_c, h_sigma and C agree to about 1e-12
   (tolerance 1e-10). The script makes pycma the algorithm of the tutorial: no active
   update, no mirrors, a decomposition after every update. It also records two differences
   of pycma, so that the test can deal with them:
   - pycma starts with C = diag(exp(1e-4 i / n)) instead of I; the file holds that matrix.
   - pycma's squared h_sigma test and its limit on the step-size change may decide
     differently from the tutorial. A case is recorded with the first seed for which they
     never do.

   The diagonal model is compared with pycma's `GaussDiagonalSampler`, which uses the
   additive update of sep-CMA-ES. pycma's option `CMA_diagonal` uses a multiplicative update
   instead. `BoundTransformReferenceTest` compares the bound transformation with pycma.

   To regenerate the data:

   ```sh
   python3 -m venv venv && venv/bin/pip install cma==4.6.0
   venv/bin/python -I src/test/python/pycma-reference.py src/test/resources/de/evoal/optimisation/cma_es/main/distribution
   ```

2. **Unit tests:** eigendecomposition, default parameters (pycma's example values for n = 20),
   termination criteria, iteration limits, restart schedules.
3. **Regressions** (`src/test/regressions`):
   - `cma-es-rosenbrock-linkage`: memory model and `'learned-linkage'`;
   - `cma-es-bipop-restarts`: both regimes, budget cut-off;
   - `cma-es-diagonal-ipop-resample`: diagonal model, IPOP, resampling constraint check;
   - `cma-es-maximum-iterations`: IPOP with `'quadratic-iteration-limit'`; the four CMA-ES runs
     end after 21, 18, 16 and 14 iterations;
   - `cma-es-sep-iteration-limit`: diagonal model, IPOP with `'sep-iteration-limit'`; the four
     CMA-ES runs end after 16, 14, 13 and 12 iterations.
4. **COCO (statistical):** the comparison of the runtime distributions on BBOB with the archived
   CMA-ES entries is part of the COCO plugin of `evoal-benchmark-suites`.

## Example

`src/main/examples/cma-es-rosenbrock`: CMA-ES with IPOP restarts on the Rosenbrock function
of five variables. It shows the learned correlations next to the declared ones.

## References

- N. Hansen, A. Ostermeier: Completely derandomized self-adaptation in evolution strategies.
  Evolutionary Computation 9(2), 2001, pp. 159-195, doi 10.1162/106365601750190398.
- N. Hansen, S. D. Müller, P. Koumoutsakos: Reducing the time complexity of the derandomized
  evolution strategy with covariance matrix adaptation (CMA-ES). Evolutionary Computation
  11(1), 2003, pp. 1-18, doi 10.1162/106365603321828970.
- N. Hansen: The CMA evolution strategy: a tutorial. arXiv:1604.00772v2, 2023.
- A. Auger, N. Hansen: A restart CMA evolution strategy with increasing population size.
  IEEE Congress on Evolutionary Computation 2005, pp. 1769-1776, doi 10.1109/CEC.2005.1554902.
- N. Hansen: Benchmarking a BI-population CMA-ES on the BBOB-2009 function testbed. GECCO 2009
  companion, pp. 2389-2396, doi 10.1145/1570256.1570333.
- R. Ros, N. Hansen: A simple modification in CMA-ES achieving linear time and space
  complexity. PPSN X, LNCS 5199, 2008, pp. 296-305, doi 10.1007/978-3-540-87700-4_30.
- G. H. Golub, C. F. Van Loan: Matrix Computations, 4th edition. Johns Hopkins University
  Press, 2013 (algorithms 5.1.1, 5.1.3, 8.3.1-8.3.3).
