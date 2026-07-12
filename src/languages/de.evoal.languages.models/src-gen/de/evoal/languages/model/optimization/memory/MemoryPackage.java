/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.evoal.languages.model.optimization.memory.MemoryFactory
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
	String eNS_URI = "https://www.evoal.de/languages/memory/1.0.0";

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
	MemoryPackage eINSTANCE = de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.ExecutionImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getExecution()
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
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.StateImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getState()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.IterationImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIteration()
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
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = STATE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.IterationStepImpl <em>Iteration Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.IterationStepImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIterationStep()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.OrderedIterationStepImpl <em>Ordered Iteration Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.OrderedIterationStepImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getOrderedIterationStep()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.UnorderedIterationStepImpl <em>Unordered Iteration Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.UnorderedIterationStepImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getUnorderedIterationStep()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.RankImpl <em>Rank</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.RankImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getRank()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.IndividualImpl <em>Individual</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.IndividualImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIndividual()
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
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIVIDUAL__INPUT = 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference.
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.RelationshipImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getRelationship()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.IdentityImpl <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.IdentityImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIdentity()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.MutationImpl <em>Mutation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.MutationImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getMutation()
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
	 * The meta object id for the '{@link de.evoal.languages.model.optimization.memory.impl.RecombinationImpl <em>Recombination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.optimization.memory.impl.RecombinationImpl
	 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getRecombination()
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
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.optimization.memory.Execution#getInputSpace <em>Input Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Space</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Execution#getInputSpace()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_InputSpace();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.optimization.memory.Execution#getOutputSpace <em>Output Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Space</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Execution#getOutputSpace()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_OutputSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.Execution#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Execution#getStates()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_States();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see de.evoal.languages.model.optimization.memory.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.optimization.memory.Iteration#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Iteration#getNumber()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.Iteration#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Iteration#getSteps()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Steps();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.Iteration#getRanks <em>Ranks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ranks</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Iteration#getRanks()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Ranks();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.IterationStep <em>Iteration Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Step</em>'.
	 * @see de.evoal.languages.model.optimization.memory.IterationStep
	 * @generated
	 */
	EClass getIterationStep();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.optimization.memory.IterationStep#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.evoal.languages.model.optimization.memory.IterationStep#getDescription()
	 * @see #getIterationStep()
	 * @generated
	 */
	EAttribute getIterationStep_Description();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.OrderedIterationStep <em>Ordered Iteration Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Iteration Step</em>'.
	 * @see de.evoal.languages.model.optimization.memory.OrderedIterationStep
	 * @generated
	 */
	EClass getOrderedIterationStep();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.OrderedIterationStep#getRanks <em>Ranks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ranks</em>'.
	 * @see de.evoal.languages.model.optimization.memory.OrderedIterationStep#getRanks()
	 * @see #getOrderedIterationStep()
	 * @generated
	 */
	EReference getOrderedIterationStep_Ranks();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.UnorderedIterationStep <em>Unordered Iteration Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unordered Iteration Step</em>'.
	 * @see de.evoal.languages.model.optimization.memory.UnorderedIterationStep
	 * @generated
	 */
	EClass getUnorderedIterationStep();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.UnorderedIterationStep#getIndividuals <em>Individuals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Individuals</em>'.
	 * @see de.evoal.languages.model.optimization.memory.UnorderedIterationStep#getIndividuals()
	 * @see #getUnorderedIterationStep()
	 * @generated
	 */
	EReference getUnorderedIterationStep_Individuals();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Rank <em>Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rank</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Rank
	 * @generated
	 */
	EClass getRank();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.optimization.memory.Rank#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Rank#getNumber()
	 * @see #getRank()
	 * @generated
	 */
	EAttribute getRank_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.Rank#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Rank#getMembers()
	 * @see #getRank()
	 * @generated
	 */
	EReference getRank_Members();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Individual <em>Individual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Individual</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Individual
	 * @generated
	 */
	EClass getIndividual();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.optimization.memory.Individual#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Individual#getId()
	 * @see #getIndividual()
	 * @generated
	 */
	EAttribute getIndividual_Id();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.optimization.memory.Individual#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Individual#getInput()
	 * @see #getIndividual()
	 * @generated
	 */
	EReference getIndividual_Input();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.optimization.memory.Individual#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Individual#getOutput()
	 * @see #getIndividual()
	 * @generated
	 */
	EReference getIndividual_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.optimization.memory.Individual#getRelationships <em>Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relationships</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Individual#getRelationships()
	 * @see #getIndividual()
	 * @generated
	 */
	EReference getIndividual_Relationships();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.optimization.memory.Relationship#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Relationship#getTarget()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_Target();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Identity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Identity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Mutation <em>Mutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutation</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Mutation
	 * @generated
	 */
	EClass getMutation();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.optimization.memory.Recombination <em>Recombination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recombination</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Recombination
	 * @generated
	 */
	EClass getRecombination();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.optimization.memory.Recombination#getOther <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other</em>'.
	 * @see de.evoal.languages.model.optimization.memory.Recombination#getOther()
	 * @see #getRecombination()
	 * @generated
	 */
	EReference getRecombination_Other();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.ExecutionImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getExecution()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.StateImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.IterationImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIteration()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.IterationStepImpl <em>Iteration Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.IterationStepImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIterationStep()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.OrderedIterationStepImpl <em>Ordered Iteration Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.OrderedIterationStepImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getOrderedIterationStep()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.UnorderedIterationStepImpl <em>Unordered Iteration Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.UnorderedIterationStepImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getUnorderedIterationStep()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.RankImpl <em>Rank</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.RankImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getRank()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.IndividualImpl <em>Individual</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.IndividualImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIndividual()
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
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDIVIDUAL__INPUT = eINSTANCE.getIndividual_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDIVIDUAL__OUTPUT = eINSTANCE.getIndividual_Output();

		/**
		 * The meta object literal for the '<em><b>Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDIVIDUAL__RELATIONSHIPS = eINSTANCE.getIndividual_Relationships();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.RelationshipImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getRelationship()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.IdentityImpl <em>Identity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.IdentityImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getIdentity()
		 * @generated
		 */
		EClass IDENTITY = eINSTANCE.getIdentity();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.MutationImpl <em>Mutation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.MutationImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getMutation()
		 * @generated
		 */
		EClass MUTATION = eINSTANCE.getMutation();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.optimization.memory.impl.RecombinationImpl <em>Recombination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.optimization.memory.impl.RecombinationImpl
		 * @see de.evoal.languages.model.optimization.memory.impl.MemoryPackageImpl#getRecombination()
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

	}

} //MemoryPackage
