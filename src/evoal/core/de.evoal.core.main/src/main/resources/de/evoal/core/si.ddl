module de.evoal.core.si {
	types:
		/**
		 * SI-Unit for force, measure in Newton[N=kg*m/s*s].
		 */
		cardinal type Newton
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for lengths, measured in metres[m].
		 */
		quotient type Meter
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for time, measured in seconds[s].
		 */
		quotient type Second 
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for mass, measured in kilogram[kg].
		 */
		quotient type Kilogram
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for eletric current, measured in ampere[A].
		 */
		quotient type Ampere
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for thermodynamic temperature, measured in kelvin[K].
		 */
		quotient type Kelvin
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for amount of substance, measure in mole[mol].
		 */
		quotient type Mole
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for luminous intensity, measured in candela[cd].
		 */
		quotient type Candela
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for frequency, measured in hertz[Hz=1/s].
		 */
		quotient type Hertz
			with constraints: 
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for frequency, measured in metre per second[m/s].
		 */
		quotient type Speed
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for pressure, measure in Pascal[Pa=kg/m*s*s].
		 */
		quotient type Pascal
			with constraints:
				value >= 0.0;
		;
		
		/**
		 * SI-Unit for temperature relative to 273.15 K, measured in Celsius[°C=K]
		 */
		cardinal type Celsius
			with constraints:
				value >= -273.15; 
		;
		
		/**
		 * SI-Unit for areas, measured in square meter[m*m].
		 */
		quotient type Area
			with constraints:
				value >= 0.0;
		;
}	