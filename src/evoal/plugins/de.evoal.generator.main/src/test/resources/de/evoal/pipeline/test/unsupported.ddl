/**
 * Data with a constraint that is no annotation, which 'constraint-validation' rejects.
 */
module 'de.evoal.pipeline.test.unsupported' {
    data:
        quotient real data 'u' with constraints: 1.0 > 0.0; ;
}
