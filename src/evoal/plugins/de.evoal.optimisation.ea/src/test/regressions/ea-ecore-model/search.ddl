import "definitions" from 'de.evoal.core.ecore';

module search {
    data:
        /**
         * A policy of the 2048 example, a model of the metamodel in policy.ecore and
         *   conditions.ecore.
         */
        @EcoreType { files := [ "policy.ecore", "conditions.ecore" ]; root := "policy.ecore#//Policy"; }
        data 'policy' of instance 'ecore-model';

        /**
         * The number of objects of the policy.
         */
        quotient integer data 'size';
}
