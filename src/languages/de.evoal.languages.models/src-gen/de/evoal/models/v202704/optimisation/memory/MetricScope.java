/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Metric Scope</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Where the values of a metric are recorded.
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricScope()
 * @model
 * @generated
 */
public enum MetricScope implements Enumerator {
	/**
	 * The '<em><b>Execution</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Once for the whole execution ({@link Execution#getMetrics()}), e.g., a limit.
	 * 
	 * <!-- end-model-doc -->
	 * @see #EXECUTION_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTION(0, "Execution", "Execution"),

	/**
	 * The '<em><b>Iteration</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * In every iteration ({@link Iteration#getMetrics()}), e.g., the number of evaluations so far.
	 * 
	 * <!-- end-model-doc -->
	 * @see #ITERATION_VALUE
	 * @generated
	 * @ordered
	 */
	ITERATION(1, "Iteration", "Iteration");

	/**
	 * The '<em><b>Execution</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Once for the whole execution ({@link Execution#getMetrics()}), e.g., a limit.
	 * 
	 * <!-- end-model-doc -->
	 * @see #EXECUTION
	 * @model name="Execution"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTION_VALUE = 0;

	/**
	 * The '<em><b>Iteration</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * In every iteration ({@link Iteration#getMetrics()}), e.g., the number of evaluations so far.
	 * 
	 * <!-- end-model-doc -->
	 * @see #ITERATION
	 * @model name="Iteration"
	 * @generated
	 * @ordered
	 */
	public static final int ITERATION_VALUE = 1;

	/**
	 * An array of all the '<em><b>Metric Scope</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MetricScope[] VALUES_ARRAY =
		new MetricScope[] {
			EXECUTION,
			ITERATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Metric Scope</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MetricScope> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Metric Scope</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetricScope get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MetricScope result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Metric Scope</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetricScope getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MetricScope result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Metric Scope</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MetricScope get(int value) {
		switch (value) {
			case EXECUTION_VALUE: return EXECUTION;
			case ITERATION_VALUE: return ITERATION;
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
	private MetricScope(int value, String name, String literal) {
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
	
} //MetricScope
