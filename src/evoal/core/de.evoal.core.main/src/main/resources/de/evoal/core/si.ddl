module de.evoal.core.si {
	types:
		/**
		 * SI-Unit for force, measure in Newton[N=kg*m/s*s].
		 */
		cardinal type newton
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for lengths, measured in metres[m].
		 */
		quotient type meter
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for time, measured in seconds[s].
		 */
		quotient type second 
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for mass, measured in kilogram[kg].
		 */
		quotient type kilogram
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for electric current, measured in ampere[A].
		 */
		quotient type ampere
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for thermodynamic temperature, measured in kelvin[K].
		 */
		quotient type kelvin
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for amount of substance, measure in mole[mol].
		 */
		quotient type mole
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for luminous intensity, measured in candela[cd].
		 */
		quotient type candela
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for frequency, measured in hertz[Hz=1/s].
		 */
		quotient type hertz
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for frequency, measured in metre per second[m/s].
		 */
		quotient type speed
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for pressure, measure in Pascal[Pa=kg/m*s*s].
		 */
		quotient type pascal
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for temperature relative to 273.15 K, measured in Celsius[°C=K]
		 */
		cardinal type celsius
			with constraints:
				value >= -273.15; 
		;
		
		/**
		 * SI-Unit for areas, measured in square meter[m*m].
		 */
		quotient type area
			with constraints:
				value >= 0.0;
		;
}	