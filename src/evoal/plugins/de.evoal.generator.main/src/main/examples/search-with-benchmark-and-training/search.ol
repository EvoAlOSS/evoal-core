import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;

import "definitions" from de.evoal.optimisation.ea.optimisation;
import "definitions" from de.evoal.surrogate.optimisation;

import "data" from search;

module search {
	specify problem 'example-search' {
		description := "Simple search";
		'search-space' := [data 'x:0'];
		'optimisation-space' := [data 'y:0'];
		'maximise' := false;
		'optimisation-function' := 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {};    reads := [data 'x:0']; writes := [data 'y:0']; }
			];
		};
	}
		
		
	configure 'evolutionary-algorithm' for 'example-search' {
		'number-of-generations' := 20;
		'size-of-population' := 50;
		'maximum-age' := 20;
	    'offspring-fraction' := 0.6;

		'initialisation' := 'training' { 'training-file' := "training.json"; };
		
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
	
	    handlers := [
	        'kill-at-birth' {
	            'repair-strategy' := 'repair-with-random' {};
	        }
        ];
	
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

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 10; }
        ];
	}
}