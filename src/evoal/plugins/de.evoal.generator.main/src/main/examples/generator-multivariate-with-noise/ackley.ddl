import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

module 'ackley' {
  data:
    @LowerBoundary { boundary := -20.0; inclusive := false; }
    @UpperBoundary { boundary := 30.0; inclusive := false; }
    quotient real data 'x.0';
    @LowerBoundary { boundary := -20.0; inclusive := false; }
    @UpperBoundary { boundary := 30.0; inclusive := false; }
    quotient real data 'x.1';
    quotient real data 'y.0';
}