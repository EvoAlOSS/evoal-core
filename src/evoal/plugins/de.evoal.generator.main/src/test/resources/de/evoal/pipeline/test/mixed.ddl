/**
 * Real and integer data for the tests of 'distribution-based-data'.
 */
module 'de.evoal.pipeline.test.mixed' {
    types:
        /**
         * Numbers of design variants.
         */
        nominal type 'variant-number';

        /**
         * Temperatures in degrees Celsius.
         */
        cardinal type 'celsius';

    data:
        /**
         * A real value.
         */
        quotient real data 'x';

        /**
         * A count.
         */
        quotient integer data 'n';

        /**
         * Another real value.
         */
        quotient real data 'y';

        /**
         * A category.
         */
        nominal integer data 'variant';

        /**
         * A category of a nominal type.
         */
        integer data 'typed-variant' of type 'variant-number';

        /**
         * A whole number without a scale, nominal by default.
         */
        integer data 'unscaled';

        /**
         * A temperature of a cardinal type.
         */
        real data 'temperature' of type 'celsius';
}
