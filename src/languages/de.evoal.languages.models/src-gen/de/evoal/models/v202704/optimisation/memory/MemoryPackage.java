/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * The memory model of the optimization.
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.models.v202704.optimisation.memory.MemoryFactory
 * @model kind="package"
 * @generated
 */
public interface MemoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "memory";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://evoal.de/v202704/models/optimisation/memory";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MemoryPackage eINSTANCE = de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 0;

	/**
	 * The feature id for the '<em><b>Input Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__INPUT_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Output Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__OUTPUT_SPACE = 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__STATES = 2;

	/**
	 * The feature id for the '<em><b>Metric Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__METRIC_DEFINITIONS = 3;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__METRICS = 4;

	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.StateImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.IterationImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__NUMBER = STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__STEPS = STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ranks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__RANKS = STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__METRICS = STATE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = STATE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IterationStepImpl <em>Iteration Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.IterationStepImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIterationStep()
	 * @generated
	 */
	int ITERATION_STEP = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_STEP__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Iteration Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_STEP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.OrderedIterationStepImpl <em>Ordered Iteration Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.OrderedIterationStepImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getOrderedIterationStep()
	 * @generated
	 */
	int ORDERED_ITERATION_STEP = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_ITERATION_STEP__DESCRIPTION = ITERATION_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Ranks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_ITERATION_STEP__RANKS = ITERATION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Iteration Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_ITERATION_STEP_FEATURE_COUNT = ITERATION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.UnorderedIterationStepImpl <em>Unordered Iteration Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.UnorderedIterationStepImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getUnorderedIterationStep()
	 * @generated
	 */
	int UNORDERED_ITERATION_STEP = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNORDERED_ITERATION_STEP__DESCRIPTION = ITERATION_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Individuals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNORDERED_ITERATION_STEP__INDIVIDUALS = ITERATION_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unordered Iteration Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNORDERED_ITERATION_STEP_FEATURE_COUNT = ITERATION_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.RankImpl <em>Rank</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.RankImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getRank()
	 * @generated
	 */
	int RANK = 6;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANK__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANK__MEMBERS = 1;

	/**
	 * The number of structural features of the '<em>Rank</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IndividualImpl <em>Individual</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.IndividualImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIndividual()
	 * @generated
	 */
	int INDIVIDUAL = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDUAL__ID = 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDUAL__INPUT = 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDUAL__OUTPUT = 2;

	/**
	 * The feature id for the '<em><b>Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDUAL__RELATIONSHIPS = 3;

	/**
	 * The number of structural features of the '<em>Individual</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDUAL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.RelationshipImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 8;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__TARGET = 0;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IdentityImpl <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.IdentityImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIdentity()
	 * @generated
	 */
	int IDENTITY = 9;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY__TARGET = RELATIONSHIP__TARGET;

	/**
	 * The number of structural features of the '<em>Identity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.MutationImpl <em>Mutation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MutationImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMutation()
	 * @generated
	 */
	int MUTATION = 10;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATION__TARGET = RELATIONSHIP__TARGET;

	/**
	 * The number of structural features of the '<em>Mutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATION_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.RecombinationImpl <em>Recombination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.RecombinationImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getRecombination()
	 * @generated
	 */
	int RECOMBINATION = 11;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMBINATION__TARGET = RELATIONSHIP__TARGET;

	/**
	 * The feature id for the '<em><b>Other</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMBINATION__OTHER = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recombination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMBINATION_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.MetricEntryImpl <em>Metric Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MetricEntryImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricEntry()
	 * @generated
	 */
	int METRIC_ENTRY = 12;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Metric Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.impl.MetricDefinitionImpl <em>Metric Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MetricDefinitionImpl
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricDefinition()
	 * @generated
	 */
	int METRIC_DEFINITION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DEFINITION__KIND = 1;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DEFINITION__VALUE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DEFINITION__SCOPE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DEFINITION__DESCRIPTION = 4;

	/**
	 * The number of structural features of the '<em>Metric Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.MetricKind <em>Metric Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.MetricKind
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricKind()
	 * @generated
	 */
	int METRIC_KIND = 14;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.MetricValueType <em>Metric Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.MetricValueType
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricValueType()
	 * @generated
	 */
	int METRIC_VALUE_TYPE = 15;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.optimisation.memory.MetricScope <em>Metric Scope</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.optimisation.memory.MetricScope
	 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricScope()
	 * @generated
	 */
	int METRIC_SCOPE = 16;


	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.optimisation.memory.Execution#getInputSpace <em>Input Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Space</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Execution#getInputSpace()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_InputSpace();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.optimisation.memory.Execution#getOutputSpace <em>Output Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Space</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Execution#getOutputSpace()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_OutputSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.Execution#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Execution#getStates()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_States();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.Execution#getMetricDefinitions <em>Metric Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Definitions</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Execution#getMetricDefinitions()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_MetricDefinitions();

	/**
	 * Returns the meta object for the map '{@link de.evoal.models.v202704.optimisation.memory.Execution#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Metrics</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Execution#getMetrics()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Metrics();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.Iteration#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Iteration#getNumber()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.Iteration#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Iteration#getSteps()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Steps();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.Iteration#getRanks <em>Ranks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ranks</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Iteration#getRanks()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Ranks();

	/**
	 * Returns the meta object for the map '{@link de.evoal.models.v202704.optimisation.memory.Iteration#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Metrics</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Iteration#getMetrics()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Metrics();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.IterationStep <em>Iteration Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Step</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.IterationStep
	 * @generated
	 */
	EClass getIterationStep();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.IterationStep#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.IterationStep#getDescription()
	 * @see #getIterationStep()
	 * @generated
	 */
	EAttribute getIterationStep_Description();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.OrderedIterationStep <em>Ordered Iteration Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Iteration Step</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.OrderedIterationStep
	 * @generated
	 */
	EClass getOrderedIterationStep();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.OrderedIterationStep#getRanks <em>Ranks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ranks</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.OrderedIterationStep#getRanks()
	 * @see #getOrderedIterationStep()
	 * @generated
	 */
	EReference getOrderedIterationStep_Ranks();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep <em>Unordered Iteration Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unordered Iteration Step</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep
	 * @generated
	 */
	EClass getUnorderedIterationStep();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep#getIndividuals <em>Individuals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Individuals</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep#getIndividuals()
	 * @see #getUnorderedIterationStep()
	 * @generated
	 */
	EReference getUnorderedIterationStep_Individuals();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Rank <em>Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rank</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Rank
	 * @generated
	 */
	EClass getRank();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.Rank#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Rank#getNumber()
	 * @see #getRank()
	 * @generated
	 */
	EAttribute getRank_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.Rank#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Rank#getMembers()
	 * @see #getRank()
	 * @generated
	 */
	EReference getRank_Members();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Individual <em>Individual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Individual</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Individual
	 * @generated
	 */
	EClass getIndividual();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.Individual#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Individual#getId()
	 * @see #getIndividual()
	 * @generated
	 */
	EAttribute getIndividual_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.Individual#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Individual#getInput()
	 * @see #getIndividual()
	 * @generated
	 */
	EAttribute getIndividual_Input();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.Individual#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Individual#getOutput()
	 * @see #getIndividual()
	 * @generated
	 */
	EAttribute getIndividual_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.optimisation.memory.Individual#getRelationships <em>Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relationships</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Individual#getRelationships()
	 * @see #getIndividual()
	 * @generated
	 */
	EReference getIndividual_Relationships();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.models.v202704.optimisation.memory.Relationship#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Relationship#getTarget()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_Target();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Identity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Identity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Mutation <em>Mutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutation</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Mutation
	 * @generated
	 */
	EClass getMutation();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.Recombination <em>Recombination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recombination</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Recombination
	 * @generated
	 */
	EClass getRecombination();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.optimisation.memory.Recombination#getOther <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.Recombination#getOther()
	 * @see #getRecombination()
	 * @generated
	 */
	EReference getRecombination_Other();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Metric Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="de.evoal.models.v202704.optimisation.Number" valueRequired="true"
	 * @generated
	 */
	EClass getMetricEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getMetricEntry()
	 * @generated
	 */
	EAttribute getMetricEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getMetricEntry()
	 * @generated
	 */
	EAttribute getMetricEntry_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition <em>Metric Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Definition</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricDefinition
	 * @generated
	 */
	EClass getMetricDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricDefinition#getName()
	 * @see #getMetricDefinition()
	 * @generated
	 */
	EAttribute getMetricDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricDefinition#getKind()
	 * @see #getMetricDefinition()
	 * @generated
	 */
	EAttribute getMetricDefinition_Kind();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricDefinition#getValueType()
	 * @see #getMetricDefinition()
	 * @generated
	 */
	EAttribute getMetricDefinition_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricDefinition#getScope()
	 * @see #getMetricDefinition()
	 * @generated
	 */
	EAttribute getMetricDefinition_Scope();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricDefinition#getDescription()
	 * @see #getMetricDefinition()
	 * @generated
	 */
	EAttribute getMetricDefinition_Description();

	/**
	 * Returns the meta object for enum '{@link de.evoal.models.v202704.optimisation.memory.MetricKind <em>Metric Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric Kind</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricKind
	 * @generated
	 */
	EEnum getMetricKind();

	/**
	 * Returns the meta object for enum '{@link de.evoal.models.v202704.optimisation.memory.MetricValueType <em>Metric Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric Value Type</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricValueType
	 * @generated
	 */
	EEnum getMetricValueType();

	/**
	 * Returns the meta object for enum '{@link de.evoal.models.v202704.optimisation.memory.MetricScope <em>Metric Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric Scope</em>'.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricScope
	 * @generated
	 */
	EEnum getMetricScope();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MemoryFactory getMemoryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getExecution()
		 * @generated
		 */
		EClass EXECUTION = eINSTANCE.getExecution();

		/**
		 * The meta object literal for the '<em><b>Input Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__INPUT_SPACE = eINSTANCE.getExecution_InputSpace();

		/**
		 * The meta object literal for the '<em><b>Output Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__OUTPUT_SPACE = eINSTANCE.getExecution_OutputSpace();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__STATES = eINSTANCE.getExecution_States();

		/**
		 * The meta object literal for the '<em><b>Metric Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__METRIC_DEFINITIONS = eINSTANCE.getExecution_MetricDefinitions();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__METRICS = eINSTANCE.getExecution_Metrics();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.StateImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.IterationImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__NUMBER = eINSTANCE.getIteration_Number();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__STEPS = eINSTANCE.getIteration_Steps();

		/**
		 * The meta object literal for the '<em><b>Ranks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__RANKS = eINSTANCE.getIteration_Ranks();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__METRICS = eINSTANCE.getIteration_Metrics();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IterationStepImpl <em>Iteration Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.IterationStepImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIterationStep()
		 * @generated
		 */
		EClass ITERATION_STEP = eINSTANCE.getIterationStep();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION_STEP__DESCRIPTION = eINSTANCE.getIterationStep_Description();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.OrderedIterationStepImpl <em>Ordered Iteration Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.OrderedIterationStepImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getOrderedIterationStep()
		 * @generated
		 */
		EClass ORDERED_ITERATION_STEP = eINSTANCE.getOrderedIterationStep();

		/**
		 * The meta object literal for the '<em><b>Ranks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_ITERATION_STEP__RANKS = eINSTANCE.getOrderedIterationStep_Ranks();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.UnorderedIterationStepImpl <em>Unordered Iteration Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.UnorderedIterationStepImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getUnorderedIterationStep()
		 * @generated
		 */
		EClass UNORDERED_ITERATION_STEP = eINSTANCE.getUnorderedIterationStep();

		/**
		 * The meta object literal for the '<em><b>Individuals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNORDERED_ITERATION_STEP__INDIVIDUALS = eINSTANCE.getUnorderedIterationStep_Individuals();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.RankImpl <em>Rank</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.RankImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getRank()
		 * @generated
		 */
		EClass RANK = eINSTANCE.getRank();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANK__NUMBER = eINSTANCE.getRank_Number();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANK__MEMBERS = eINSTANCE.getRank_Members();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IndividualImpl <em>Individual</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.IndividualImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIndividual()
		 * @generated
		 */
		EClass INDIVIDUAL = eINSTANCE.getIndividual();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDIVIDUAL__ID = eINSTANCE.getIndividual_Id();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDIVIDUAL__INPUT = eINSTANCE.getIndividual_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDIVIDUAL__OUTPUT = eINSTANCE.getIndividual_Output();

		/**
		 * The meta object literal for the '<em><b>Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDIVIDUAL__RELATIONSHIPS = eINSTANCE.getIndividual_Relationships();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.RelationshipImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__TARGET = eINSTANCE.getRelationship_Target();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.IdentityImpl <em>Identity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.IdentityImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getIdentity()
		 * @generated
		 */
		EClass IDENTITY = eINSTANCE.getIdentity();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.MutationImpl <em>Mutation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MutationImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMutation()
		 * @generated
		 */
		EClass MUTATION = eINSTANCE.getMutation();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.RecombinationImpl <em>Recombination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.RecombinationImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getRecombination()
		 * @generated
		 */
		EClass RECOMBINATION = eINSTANCE.getRecombination();

		/**
		 * The meta object literal for the '<em><b>Other</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMBINATION__OTHER = eINSTANCE.getRecombination_Other();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.MetricEntryImpl <em>Metric Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MetricEntryImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricEntry()
		 * @generated
		 */
		EClass METRIC_ENTRY = eINSTANCE.getMetricEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_ENTRY__KEY = eINSTANCE.getMetricEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_ENTRY__VALUE = eINSTANCE.getMetricEntry_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.impl.MetricDefinitionImpl <em>Metric Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MetricDefinitionImpl
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricDefinition()
		 * @generated
		 */
		EClass METRIC_DEFINITION = eINSTANCE.getMetricDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_DEFINITION__NAME = eINSTANCE.getMetricDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_DEFINITION__KIND = eINSTANCE.getMetricDefinition_Kind();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_DEFINITION__VALUE_TYPE = eINSTANCE.getMetricDefinition_ValueType();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_DEFINITION__SCOPE = eINSTANCE.getMetricDefinition_Scope();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_DEFINITION__DESCRIPTION = eINSTANCE.getMetricDefinition_Description();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.MetricKind <em>Metric Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.MetricKind
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricKind()
		 * @generated
		 */
		EEnum METRIC_KIND = eINSTANCE.getMetricKind();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.MetricValueType <em>Metric Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.MetricValueType
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricValueType()
		 * @generated
		 */
		EEnum METRIC_VALUE_TYPE = eINSTANCE.getMetricValueType();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.optimisation.memory.MetricScope <em>Metric Scope</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.optimisation.memory.MetricScope
		 * @see de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl#getMetricScope()
		 * @generated
		 */
		EEnum METRIC_SCOPE = eINSTANCE.getMetricScope();

	}

} //MemoryPackage
