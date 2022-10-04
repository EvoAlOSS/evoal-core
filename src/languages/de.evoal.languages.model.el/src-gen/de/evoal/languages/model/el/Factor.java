/**
 */
package de.evoal.languages.model.el;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Factor</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.el.ELPackage#getFactor()
 * @model
 * @generated
 */
public enum Factor implements Enumerator {
	/**
	 * The '<em><b>Yotta</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YOTTA_VALUE
	 * @generated
	 * @ordered
	 */
	YOTTA(24, "Yotta", "Yotta"),

	/**
	 * The '<em><b>Zetta</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZETTA_VALUE
	 * @generated
	 * @ordered
	 */
	ZETTA(21, "Zetta", "Zetta"),

	/**
	 * The '<em><b>Exa</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXA_VALUE
	 * @generated
	 * @ordered
	 */
	EXA(18, "Exa", "Exa"),

	/**
	 * The '<em><b>Peta</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETA_VALUE
	 * @generated
	 * @ordered
	 */
	PETA(15, "Peta", "Peta"), /**
	 * The '<em><b>Tera</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERA_VALUE
	 * @generated
	 * @ordered
	 */
	TERA(12, "Tera", "Tera"), /**
	 * The '<em><b>Giga</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGA_VALUE
	 * @generated
	 * @ordered
	 */
	GIGA(9, "Giga", "Giga"), /**
	 * The '<em><b>Mega</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGA_VALUE
	 * @generated
	 * @ordered
	 */
	MEGA(6, "Mega", "Mega"), /**
	 * The '<em><b>Kilo</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILO_VALUE
	 * @generated
	 * @ordered
	 */
	KILO(3, "Kilo", "Kilo"), /**
	 * The '<em><b>Hecto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTO_VALUE
	 * @generated
	 * @ordered
	 */
	HECTO(2, "Hecto", "Hecto"), /**
	 * The '<em><b>Deka</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEKA_VALUE
	 * @generated
	 * @ordered
	 */
	DEKA(1, "Deka", "Deka"), /**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "None", "None"),

	/**
	 * The '<em><b>Deci</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECI_VALUE
	 * @generated
	 * @ordered
	 */
	DECI(-1, "Deci", "Deci"), /**
	 * The '<em><b>Centi</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTI_VALUE
	 * @generated
	 * @ordered
	 */
	CENTI(-2, "Centi", "Centi"), /**
	 * The '<em><b>Milli</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLI_VALUE
	 * @generated
	 * @ordered
	 */
	MILLI(-3, "Milli", "Milli"), /**
	 * The '<em><b>Micro</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO_VALUE
	 * @generated
	 * @ordered
	 */
	MICRO(-6, "Micro", "Micro"), /**
	 * The '<em><b>Nano</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO_VALUE
	 * @generated
	 * @ordered
	 */
	NANO(-9, "Nano", "Nano"), /**
	 * The '<em><b>Piko</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIKO_VALUE
	 * @generated
	 * @ordered
	 */
	PIKO(-12, "Piko", "Piko"), /**
	 * The '<em><b>Femto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTO_VALUE
	 * @generated
	 * @ordered
	 */
	FEMTO(-15, "Femto", "Femto"), /**
	 * The '<em><b>Atto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTO_VALUE
	 * @generated
	 * @ordered
	 */
	ATTO(-18, "Atto", "Atto"), /**
	 * The '<em><b>Zepto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZEPTO_VALUE
	 * @generated
	 * @ordered
	 */
	ZEPTO(-21, "Zepto", "Zepto"), /**
	 * The '<em><b>Yocto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YOCTO_VALUE
	 * @generated
	 * @ordered
	 */
	YOCTO(-24, "Yocto", "Yocto");

	/**
	 * The '<em><b>Yotta</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YOTTA
	 * @model name="Yotta"
	 * @generated
	 * @ordered
	 */
	public static final int YOTTA_VALUE = 24;

	/**
	 * The '<em><b>Zetta</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZETTA
	 * @model name="Zetta"
	 * @generated
	 * @ordered
	 */
	public static final int ZETTA_VALUE = 21;

	/**
	 * The '<em><b>Exa</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXA
	 * @model name="Exa"
	 * @generated
	 * @ordered
	 */
	public static final int EXA_VALUE = 18;

	/**
	 * The '<em><b>Peta</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETA
	 * @model name="Peta"
	 * @generated
	 * @ordered
	 */
	public static final int PETA_VALUE = 15;

	/**
	 * The '<em><b>Tera</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERA
	 * @model name="Tera"
	 * @generated
	 * @ordered
	 */
	public static final int TERA_VALUE = 12;

	/**
	 * The '<em><b>Giga</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGA
	 * @model name="Giga"
	 * @generated
	 * @ordered
	 */
	public static final int GIGA_VALUE = 9;

	/**
	 * The '<em><b>Mega</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGA
	 * @model name="Mega"
	 * @generated
	 * @ordered
	 */
	public static final int MEGA_VALUE = 6;

	/**
	 * The '<em><b>Kilo</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILO
	 * @model name="Kilo"
	 * @generated
	 * @ordered
	 */
	public static final int KILO_VALUE = 3;

	/**
	 * The '<em><b>Hecto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTO
	 * @model name="Hecto"
	 * @generated
	 * @ordered
	 */
	public static final int HECTO_VALUE = 2;

	/**
	 * The '<em><b>Deka</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEKA
	 * @model name="Deka"
	 * @generated
	 * @ordered
	 */
	public static final int DEKA_VALUE = 1;

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>Deci</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECI
	 * @model name="Deci"
	 * @generated
	 * @ordered
	 */
	public static final int DECI_VALUE = -1;

	/**
	 * The '<em><b>Centi</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTI
	 * @model name="Centi"
	 * @generated
	 * @ordered
	 */
	public static final int CENTI_VALUE = -2;

	/**
	 * The '<em><b>Milli</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLI
	 * @model name="Milli"
	 * @generated
	 * @ordered
	 */
	public static final int MILLI_VALUE = -3;

	/**
	 * The '<em><b>Micro</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO
	 * @model name="Micro"
	 * @generated
	 * @ordered
	 */
	public static final int MICRO_VALUE = -6;

	/**
	 * The '<em><b>Nano</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO
	 * @model name="Nano"
	 * @generated
	 * @ordered
	 */
	public static final int NANO_VALUE = -9;

	/**
	 * The '<em><b>Piko</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIKO
	 * @model name="Piko"
	 * @generated
	 * @ordered
	 */
	public static final int PIKO_VALUE = -12;

	/**
	 * The '<em><b>Femto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTO
	 * @model name="Femto"
	 * @generated
	 * @ordered
	 */
	public static final int FEMTO_VALUE = -15;

	/**
	 * The '<em><b>Atto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTO
	 * @model name="Atto"
	 * @generated
	 * @ordered
	 */
	public static final int ATTO_VALUE = -18;

	/**
	 * The '<em><b>Zepto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZEPTO
	 * @model name="Zepto"
	 * @generated
	 * @ordered
	 */
	public static final int ZEPTO_VALUE = -21;

	/**
	 * The '<em><b>Yocto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YOCTO
	 * @model name="Yocto"
	 * @generated
	 * @ordered
	 */
	public static final int YOCTO_VALUE = -24;

	/**
	 * An array of all the '<em><b>Factor</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Factor[] VALUES_ARRAY =
		new Factor[] {
			YOTTA,
			ZETTA,
			EXA,
			PETA,
			TERA,
			GIGA,
			MEGA,
			KILO,
			HECTO,
			DEKA,
			NONE,
			DECI,
			CENTI,
			MILLI,
			MICRO,
			NANO,
			PIKO,
			FEMTO,
			ATTO,
			ZEPTO,
			YOCTO,
		};

	/**
	 * A public read-only list of all the '<em><b>Factor</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Factor> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Factor</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Factor get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Factor result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Factor</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Factor getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Factor result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Factor</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Factor get(int value) {
		switch (value) {
			case YOTTA_VALUE: return YOTTA;
			case ZETTA_VALUE: return ZETTA;
			case EXA_VALUE: return EXA;
			case PETA_VALUE: return PETA;
			case TERA_VALUE: return TERA;
			case GIGA_VALUE: return GIGA;
			case MEGA_VALUE: return MEGA;
			case KILO_VALUE: return KILO;
			case HECTO_VALUE: return HECTO;
			case DEKA_VALUE: return DEKA;
			case NONE_VALUE: return NONE;
			case DECI_VALUE: return DECI;
			case CENTI_VALUE: return CENTI;
			case MILLI_VALUE: return MILLI;
			case MICRO_VALUE: return MICRO;
			case NANO_VALUE: return NANO;
			case PIKO_VALUE: return PIKO;
			case FEMTO_VALUE: return FEMTO;
			case ATTO_VALUE: return ATTO;
			case ZEPTO_VALUE: return ZEPTO;
			case YOCTO_VALUE: return YOCTO;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Factor(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Factor
