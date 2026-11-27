import "definitions" from 'de.evoal.optimisation.gp.genetic-programming';

module 'gp-example' {
    data:
        /**
         * The expression to search.
         */
        data 'regression-function' of instance 'expression';

        /**
         * The error of the expression on the reference table.
         */
        quotient real data 'error';

        /**
         * The input of the reference table.
         */
        quotient real data 'x0';

        /**
         * The target of the reference table.
         */
        quotient real data 'y0';
}
