import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.generator.optimisation;
import "definitions" from de.evoal.generator.generator;

import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from search;

module search {
	specify problem 'example-search' {
		description := "Simple search";
		'search-space' := [data 'x:0'];
		'optimisation-space' := [data 'y:0'];
		'maximise' := true;
		'optimisation-function' := 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {};    reads := [data 'x:0']; writes := [data 'y:0']; }
			];
		};
	}
		
		
	configure 'evolutionary-algorithm' for 'example-search' {
		'number-of-generations' := 5;
		'size-of-population' := 20;
		'maximum-age' := 5;
		'offspring-fraction' := 0.7;
	
		'initialisation' := 'random-population' {};
		
		'comparator' := 'numeric-comparator' {};
	
	    genotype := 'vector-genotype' {
	        chromosomes := [
				'bit-chromosome' {
	                    scale := 12;
	                    genes:= [
	                            gene {content:= data 'x:0';}
	                    ];
	            }
			];
	    };
	
	    handlers := [];
	
	    selectors := selectors {
	        offspring := 'roulette-wheel-selector' {};
	        survivor := 'elite-selector' {
	                'size-factor' := 0.3;
	                'non-elite-selector' := 'tournament-selector' {
	                        'size-factor' := 0.1;
	                };
	        };
	    };
	    
		alterers := alterers {
	        crossover := [
	                'single-point-crossover' {
	                        probability := 0.5;
	
	                }
	        ];
	        mutator := [
	                'bit-flip-mutator' {
	                        probability := 0.5;
	                        }
	        ];
	    };
	
		'optimisation-function' := 'problem-function' {};

		documenting := ['candidates-per-generation' {}];
	}
}