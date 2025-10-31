import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.ea.optimisation;
import "definitions" from  de.evoal.surrogate.optimisation;

import "definitions" from de.evoal.surrogate.adaption.density.optimisation;
import "definitions" from de.evoal.surrogate.adaption.interval.optimisation;

import "data" from surrogate;

module 'search' {
	specify problem 'example-search' {
		search for data 'x:0'
		
		map with 'unknown-function' {}
		
		and maximise data 'y:0'
	}
		
		
	configure 'evolutionary-algorithm' for 'example-search' {
		'number-of-generations' := 100;
		'size-of-population' := 50;
		'maximum-age' := 100;
	
		'initialisation' := 'random-population' {};
		
		'comparator' := 'numeric-comparator' {};
	
	    genotype := 'vector-genotype' {
	        chromosomes := [
				'double-chromosome' {
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
	                'uniform-crossover' {
	                        'crossover-probability' := 0.5;
	                        'swap-probability' := 0.5;
	
	                }
	        ];
	        mutator := [
	                'mean-alterer' {
	                        probability := 0.5;
	                        }
	        ];
	    };
	
		'optimisation-function' := 'kernel-density' {
			kind            := "source-based";
			exponent        := 1.0;
			'root-exponent' := 1.0;

			function := 'gaussian-density' {
				kind            := "source-based";
				exponent        := 1.0;
				'root-exponent' := 1.0;
				
				function := 'adjusted-predicted-fitness' {
					function := 'adjusted-modified-fitness' {
						function := 'surrogate' {
            'model-file' := "model.pson";
            'input-space' := [data 'x:0'];
            'output-space' := [data 'y:0'];
						};
					};
				};
			};
		};

		'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 10; }
		];

		document := [
            'correlated' {
                'input-space' := [data 'x:0'];
                'output-space' := [data 'y:0'];
            }
            //,
//            'range-correlated' {}
		];
	}
}