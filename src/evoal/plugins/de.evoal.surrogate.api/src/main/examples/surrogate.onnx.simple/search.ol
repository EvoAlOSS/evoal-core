import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.ea.optimisation;
import "definitions" from de.evoal.surrogate.optimisation;

import "data" from surrogate;

module 'search' {
	specify problem 'example-search' {
		search for data 'Input_0'
		
		map with 'unknown-function' {}
		
		and maximise data 'output'
	}
		
		
	configure 'evolutionary-algorithm' for 'example-search' {
		'number-of-generations' := 10;
		'size-of-population' := 50;
		'maximum-age' := 10;
	    'offspring-fraction' := 0.6;

		'initialisation' := 'random-population' {};
		
		'comparator' := 'weighted-sum' {
			'weights' := [1.0];
		};
	
	    genotype := 'vector-genotype' {
	        chromosomes := [
				'double-chromosome' {
                    genes:= [
                            gene {content:= data 'Input_0';}
                    ];
	            }
			];
	    };
	
	    handlers := [];
	
	    selectors := selectors {
	        offspring := 'elite-selector' {
	                'size-factor' := 0.3;
	                'non-elite-selector' := 'tournament-selector' {
	                        'size-factor' := 0.1;
	                };
	        };
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
	                'mean-alterer' {
	                        probability := 0.5;
	                        }
	        ];
	    };
	
		'optimisation-function' := 'surrogate' {
            'model-file' := "in_1number-out_number_divided_by_in.onnx";
            'input-space' := [data 'Input_0'];
            'output-space' := [data 'output'];
		};

		'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 10; }
		];
	}
}
