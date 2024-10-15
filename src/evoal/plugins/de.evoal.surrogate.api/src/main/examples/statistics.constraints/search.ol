import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.generator.optimisation;
import "definitions" from de.evoal.generator.generator;
import "definitions" from de.evoal.surrogate.optimisation;

import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from search;

module search {
	specify problem 'example-search-with-constraints' {
		description := "Simple search with constraints";
		'search-space' := [data 'x:0', data 'x:1', data 'x:2'];
		'optimisation-space' := [data 'y:0'];
		'maximise' := false;
		'optimisation-function' := 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {};    reads := [data 'x:0', data 'x:1', data 'x:2']; writes := [data 'y:0']; }
			];
		};
	}
		
		
	configure 'evolutionary-algorithm' for 'example-search-with-constraints' {
		'number-of-generations' := 20;
		'size-of-population' := 50;
		'maximum-age' := 20;
	    'offspring-fraction' := 0.6;

		'initialisation' := 'random-population' {};
		
		'comparator' := 'numeric-comparator' {};
	
	    genotype := 'vector-genotype' {
	        chromosomes := [
				'bit-chromosome' {
	                    scale := 12;
	                    genes:= [
	                            gene {content:= data 'x:0';}
	                    ];
	            },
				'bit-chromosome' {
	                    scale := 12;
	                    genes:= [
	                            gene {content:= data 'x:1';}
	                    ];
	            },
				'bit-chromosome' {
	                    scale := 12;
	                    genes:= [
	                            gene {content:= data 'x:2';}
	                    ];
	            }
			];
	    };
	
	    handlers := [
	        'constraint-handler' {
                category := "strict";
                calculation := 'normal-calculation' {};
                'constraint-handling' := 'kill-at-birth' {
                    'repair-strategy' := 'repair-with-random' {};
                };
	        },
            'constraint-handler' {
                category := "vague";
                calculation := 'normal-calculation' {};
                'constraint-handling' := 'malus-for-fitness' {
                    'smoothing' := 0.5;
                };
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
		
		documenting:= ['constraint-statistics'{}];
	}
}