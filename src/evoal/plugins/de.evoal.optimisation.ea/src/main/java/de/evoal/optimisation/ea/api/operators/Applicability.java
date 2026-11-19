package de.evoal.optimisation.ea.api.operators;

import java.util.Set;

import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.MeasurementScale;
import de.evoal.optimisation.ea.api.genotype.Representation;

/**
 * To which chromosomes an operator applies (DL annotation {@code @Applicability} on the
 *   operator type).
 *
 * @param representations The supported representations.
 * @param minimumScale The weakest scale of measurement the features may have.
 */
public record Applicability(Set<Representation> representations, MeasurementScale minimumScale) {
    public Applicability {
        representations = Set.copyOf(representations);
    }

    /**
     * @param chromosome The chromosome.
     * @param scales The scale of every feature of the chromosome, {@code null} for a feature
     *   without declared scale.
     * @return Why the operator does not apply to the chromosome, {@code null} if it applies.
     */
    public String reasonAgainst(final Chromosome chromosome, final java.util.List<MeasurementScale> scales) {
        if(!representations.contains(chromosome.representation())) {
            return "it supports only " + representations.stream().sorted().toList() + " chromosomes";
        }

        for(int i = 0; i < scales.size(); ++i) {
            final MeasurementScale scale = scales.get(i);
            if(scale != null && !scale.isAtLeast(minimumScale)) {
                return "the feature '" + chromosome.features().get(i).getName() + "' is " + scale + ", but it needs at least "
                       + minimumScale;
            }
        }

        return null;
    }
}
