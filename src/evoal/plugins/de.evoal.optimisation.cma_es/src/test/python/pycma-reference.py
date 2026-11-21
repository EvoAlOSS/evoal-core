"""Writes the reference data of the CMA-ES tests from pycma, the reference implementation.

Usage (pycma 4.6.0 in a virtual environment):

    python3 -m venv venv && venv/bin/pip install cma==4.6.0
    venv/bin/python -I pycma-reference.py ../resources/de/evoal/optimisation/cma_es/main/distribution

The update test (DistributionReferenceTest) feeds the samples that pycma drew into the
update of EvoAl's Distribution and compares the state after every iteration. pycma runs
with the options that make it the algorithm of the tutorial (N. Hansen: The CMA evolution
strategy: a tutorial, arXiv:1604.00772v2): no active update, no mirrored samples, the
eigendecomposition after every update, no bounds. The learning rates are pycma's and are
written into the files, so the test compares the update equations, not the defaults.

pycma differs from the tutorial in two details of the update: it computes h_sigma from the
squared length of p_sigma, and it limits the change of log(sigma) to [-1, 1]. A case is
recorded with the first seed from 4711 on for which neither difference occurs in its
iterations; the seed is written into the file.

The diagonal model (sep-CMA-ES) uses pycma's GaussDiagonalSampler, the additive update of
the diagonal, with the learning rates of Ros and Hansen 2008 (c_1 and c_mu times
(n + 2) / 3); pycma's option CMA_diagonal uses another, multiplicative, update.

pycma's full model starts with C = diag(exp(1e-4 i / n)) instead of the identity to avoid
equal eigenvalues in numpy; the initial matrix is written into the file, and the test starts
from it.

The boundary transformation test (BoundTransformReferenceTest) compares with
cma.transformations.BoxConstraintsLinQuadTransformation.
"""
import math
import sys
from pathlib import Path

import cma
import numpy as np
from cma.sampler import GaussDiagonalSampler
from cma.utilities.math import Mh

ITERATIONS = 40


def sphere(x):
    return float(np.sum(x ** 2))


def ellipsoid(x):
    n = len(x)
    scales = 1e6 ** (np.arange(n) / max(1, n - 1))
    return float(np.sum(scales * x ** 2))


def rotation(n, seed):
    matrix = np.random.default_rng(seed).standard_normal((n, n))
    q, _ = np.linalg.qr(matrix)
    return q


def rotated_ellipsoid(n):
    q = rotation(n, 17)
    return lambda x: ellipsoid(q @ x)


def separable_parameters(n, mueff, lam):
    c1 = min(1.0, 2.0 / ((n + 1.3) ** 2 + mueff) * (n + 2.0) / 3.0)
    cmu = 2.0 * (0.25 + mueff + 1.0 / mueff - 2.0) / ((n + 2.0) ** 2 + 2.0 * mueff / 2.0)
    return dict(c1=c1, cmu=min(1.0 - c1, cmu * (n + 2.0) / 3.0))


class SeparableSampler(GaussDiagonalSampler):
    """The additive diagonal update with the learning rates of sep-CMA-ES."""

    def parameters(self, mueff=None, lam=None):
        if mueff is not None:
            self._separable = separable_parameters(self.dimension, mueff, lam)
        return self._separable


def vector(name, values):
    return name + " " + " ".join(repr(float(v)) for v in values)


def chi(n):
    """E||N(0, I)||, exact for n <= 100 as EvoAl computes it."""
    return Mh.chiN(n)


class VariantDifference(Exception):
    """pycma and the tutorial would update differently in an iteration."""


def write_case(out, name, function, n, diagonal):
    for seed in range(4711, 4811):
        case = []
        try:
            record_case(case, name, function, n, diagonal, seed)
        except VariantDifference:
            continue
        out.extend(case)
        return
    raise SystemExit("no seed without a difference between pycma and the tutorial for " + name)


def record_case(out, name, function, n, diagonal, seed):
    options = {
        'CMA_active': False,
        'CMA_mirrors': 0,
        'updatecovwait': 0,
        'seed': seed,
        'verbose': -9,
        'tolfun': 0, 'tolx': 0, 'tolfunhist': 0, 'tolstagnation': 10 ** 9,
        'tolflatfitness': 10 ** 9, 'tolconditioncov': 1e300, 'tolfacupx': 1e300, 'tolupsigma': 1e300,
        'tolfunrel': 0, 'maxiter': 10 ** 9,
    }
    if diagonal:
        options['CMA_sampler'] = SeparableSampler
    mean0 = np.linspace(1.0, 2.0, n)
    sigma0 = 0.5
    es = cma.CMAEvolutionStrategy(mean0, sigma0, options)

    sp = es.sp
    weights = [w for w in sp.weights if w > 0]
    parameters = es.sm.parameters(mueff=sp.weights.mueff, lam=sp.weights.lambda_)
    cs, damps = es.adapt_sigma.cs, es.adapt_sigma.damps

    out.append("case " + name)
    out.append("seed %d" % seed)
    out.append("dimension %d" % n)
    out.append("diagonal %s" % ("true" if diagonal else "false"))
    out.append("lambda %d" % sp.popsize)
    out.append(vector("weights", weights))
    out.append(vector("mueff", [sp.weights.mueff]))
    out.append(vector("rates", [cs, damps, sp.cc, parameters['c1'], parameters['cmu'], sp.cmean]))
    out.append(vector("mean", mean0))
    out.append(vector("sigma", [sigma0]))
    # pycma does not start with C = I, see GaussFullSampler ("prevent equal eigenvals")
    if not diagonal:
        for row in es.sm.C:
            out.append(vector("C0", row))

    for iteration in range(1, ITERATIONS + 1):
        candidates = es.ask()
        values = [function(np.asarray(x)) for x in candidates]
        order = np.argsort(values)
        es.tell(candidates, values)

        ps = es.adapt_sigma.ps
        squared = np.sum(ps ** 2) / (1 - (1 - cs) ** (2 * es.countiter))
        pycma_h = squared / n - 1 < 1 + 4.0 / (n + 1)
        tutorial_h = math.sqrt(squared) < (1.4 + 2.0 / (n + 1)) * chi(n)
        change = cs / damps * (np.linalg.norm(ps) / chi(n) - 1)
        if pycma_h != tutorial_h or abs(change) >= 1:
            raise VariantDifference()

        out.append("iteration %d" % iteration)
        for index in order:
            out.append(vector("x", candidates[index]))
        out.append(vector("mean", es.mean))
        out.append(vector("sigma", [es.sigma]))
        out.append(vector("ps", ps))
        out.append(vector("pc", es.pc))
        out.append("h %d" % (1 if tutorial_h else 0))
        covariance = es.sm.C
        if diagonal:
            out.append(vector("variances", covariance))
        else:
            for row in covariance:
                out.append(vector("C", row))
    out.append("end")


def write_updates(folder):
    out = ["# generated by pycma-reference.py with pycma " + cma.__version__ + " and numpy " + np.__version__]
    for n in (2, 5, 10):
        write_case(out, "sphere-full-%d" % n, sphere, n, False)
        write_case(out, "rotated-ellipsoid-full-%d" % n, rotated_ellipsoid(n), n, False)
        write_case(out, "ellipsoid-diagonal-%d" % n, ellipsoid, n, True)
    (folder / "pycma-updates.txt").write_text("\n".join(out) + "\n")


def write_bounds(folder):
    from cma.transformations import BoxConstraintsLinQuadTransformation
    out = ["# generated by pycma-reference.py with pycma " + cma.__version__]
    rng = np.random.default_rng(99)
    cases = [(-5.0, 5.0), (0.0, 1.0), (-100.0, -90.0), (2.0, 2.05), (-1.0, None), (None, 3.0)]
    for lower, upper in cases:
        transformation = BoxConstraintsLinQuadTransformation([[lower, upper]])
        lb = -math.inf if lower is None else lower
        ub = math.inf if upper is None else upper
        centre = (lb if math.isfinite(lb) else ub) if not (math.isfinite(lb) and math.isfinite(ub)) else (lb + ub) / 2
        width = 10.0 if not (math.isfinite(lb) and math.isfinite(ub)) else ub - lb
        values = list(rng.uniform(centre - 3 * width, centre + 3 * width, 60))
        out.append(vector("bounds", [lb, ub]))
        for value in values:
            transformed = transformation([value])[0]
            out.append(vector("transform", [value, transformed]))
        inside = [lb + (ub - lb) * u for u in rng.uniform(0, 1, 20)] if math.isfinite(lb) and math.isfinite(ub) else []
        for value in inside:
            out.append(vector("inverse", [value, transformation.inverse([value])[0]]))
    (folder / "pycma-bounds.txt").write_text("\n".join(out) + "\n")


def main():
    folder = Path(sys.argv[1])
    folder.mkdir(parents=True, exist_ok=True)
    write_updates(folder)
    write_bounds(folder)


if __name__ == "__main__":
    main()
