use "LanguageHelperTest.dl";

parent {
	child := A {
		'boolean-field' := true;	
		'float-field' := 1.3;
		'integer-field' := 4;
		'string-field' := "FOOBAR";
		'array-1D-float' := [4.2, 3.1, 1.0];
		'array-2D-int' := [
			[ 1, 2, 3, 4, 5],
			[ 3, 2, 1],
			[42]
		];
	};
}