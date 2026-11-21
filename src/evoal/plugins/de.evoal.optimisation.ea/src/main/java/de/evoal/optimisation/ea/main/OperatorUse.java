package de.evoal.optimisation.ea.main;

/**
 * An operator of a chromosome.
 *
 * @param operator The operator.
 * @param chromosome The index of the chromosome, not negative.
 * @param stream The name of the random stream of the use.
 * @param <T> The type of the operator.
 */
public record OperatorUse<T>(T operator, int chromosome, String stream) {
    public OperatorUse {
        if(chromosome < 0) {
            throw new IllegalArgumentException("The index of a chromosome must not be negative, but it is " + chromosome + ".");
        }
    }
}
