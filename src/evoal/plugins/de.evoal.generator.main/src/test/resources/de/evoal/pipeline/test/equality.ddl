import "definitions" from 'de.evoal.optimisation.constraint';

/**
 * Data with an equality constraint, which 'constraint-validation' rejects.
 */
module 'de.evoal.pipeline.test.equality' {
    data:
        quotient real data 'p';

        quotient real data 'q';

    constraints:
        constraint(data 'p' = data 'q', "same");
}
