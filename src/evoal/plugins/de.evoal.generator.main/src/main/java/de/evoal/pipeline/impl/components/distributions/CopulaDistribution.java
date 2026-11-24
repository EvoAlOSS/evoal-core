package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.Copula;
import de.evoal.pipeline.api.distribution.Distribution;
import de.evoal.pipeline.api.distribution.DistributionFactory;
import de.evoal.pipeline.api.distribution.UniformPointSet;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

/**
 * Couples univariate marginals by a copula (DL type {@code 'copula-distribution'}, Sklar's
 *   theorem). A sample takes the next point of the point set, applies the copula and maps the
 *   j-th value u_j to the quantile F_j⁻¹(u_j) of the j-th marginal.
 */
@Named(CopulaDistribution.NAME)
@Dependent
public class CopulaDistribution implements Distribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.copula-distribution";

    /**
     * The copula.
     */
    private Copula copula;

    @Inject
    private DistributionFactory factory;

    /**
     * The marginals, one per value of a sample.
     */
    private List<UnivariateDistribution> marginals;

    /**
     * The points that the copula transforms.
     */
    private UniformPointSet points;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public CopulaDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if the parts do not fit together (see
     *   {@link #configure(Copula, List, UniformPointSet)}).
     */
    CopulaDistribution(final Copula copula, final List<UnivariateDistribution> marginals, final UniformPointSet points) {
        configure(copula, marginals, points);
    }

    @Override
    public CopulaDistribution init(final EObject configuration) {
        final Copula copula = BeanFactory.createComponentForAttribute(Copula.class, configuration, "copula");
        final List<UnivariateDistribution> marginals = factory.readDistributions(configuration, "marginals")
                                                              .stream()
                                                              .map(CopulaDistribution::asUnivariate)
                                                              .toList();
        final Distribution points = BeanFactory.createComponentForAttribute(Distribution.class, configuration, "points");
        Requirements.requireTrue(points instanceof UniformPointSet,
                "The points of the copula distribution have to be a uniform point set, but are " + points.getClass().getSimpleName() + ".");

        configure(copula, marginals, (UniformPointSet)points);

        return this;
    }

    private static UnivariateDistribution asUnivariate(final Distribution distribution) {
        Requirements.requireTrue(distribution instanceof UnivariateDistribution,
                "A marginal of the copula distribution has to be a univariate distribution, but is "
                + distribution.getClass().getSimpleName() + ".");

        return (UnivariateDistribution)distribution;
    }

    /**
     * Checks and sets the parts and prepares the copula.
     *
     * @throws IllegalArgumentException if there is no marginal, the copula does not fit the
     *   number of marginals, or the point set does not lie on the unit cube of the copula's
     *   dimension.
     */
    private void configure(final @NonNull Copula copula, final @NonNull List<UnivariateDistribution> marginals, final @NonNull UniformPointSet points) {
        Requirements.requireTrue(!marginals.isEmpty(), "The copula distribution needs at least one marginal.");
        copula.prepare(marginals.size());

        final double [] lower = points.lower();
        final double [] upper = points.upper();
        Requirements.requireTrue(lower.length == copula.pointDimension(),
                "The points of the copula distribution have " + lower.length + " dimensions, but its copula needs "
                + copula.pointDimension() + ".");
        Requirements.requireTrue(Arrays.stream(lower).allMatch(b -> b == 0.0) && Arrays.stream(upper).allMatch(b -> b == 1.0),
                "The points of the copula distribution have to lie on the unit cube (every lower bound 0, every upper bound 1), "
                + "but their box is " + Arrays.toString(lower) + " to " + Arrays.toString(upper) + ".");

        this.copula = copula;
        this.marginals = List.copyOf(marginals);
        this.points = points;
    }

    /**
     * @return The number of marginals.
     */
    @Override
    public int dimension() {
        return marginals.size();
    }

    /**
     * @return If the marginal of the value is discrete.
     */
    @Override
    public boolean isDiscrete(final int index) {
        return marginals.get(index).isDiscrete(0);
    }

    /**
     * @return If the marginal of the value is categorical.
     */
    @Override
    public boolean isCategorical(final int index) {
        return marginals.get(index).isCategorical(0);
    }

    /**
     * @throws IllegalStateException if a value is not finite, e.g., because a coordinate 0 of the
     *   point maps to −∞ for a marginal without lower bound.
     */
    @Override
    public double [] sample() {
        final double [] uniforms = copula.apply(points.sample());
        final double [] sample = new double[uniforms.length];

        for(int j = 0; j < sample.length; ++j) {
            sample[j] = marginals.get(j).quantile(uniforms[j]);

            if(!Double.isFinite(sample[j])) {
                throw new IllegalStateException("Marginal " + j + " of the copula distribution gives " + sample[j]
                        + " for the copula value " + uniforms[j] + ". A coordinate 0 of the points (e.g. the first point of a "
                        + "sequence with 'no-randomisation') maps to an infinite value for a marginal without lower bound; "
                        + "use 'random-shift'.");
            }
        }

        return sample;
    }
}
