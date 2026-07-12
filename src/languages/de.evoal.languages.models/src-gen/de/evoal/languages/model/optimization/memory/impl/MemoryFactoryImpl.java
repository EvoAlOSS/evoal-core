/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory.impl;

import de.evoal.languages.model.optimization.memory.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryFactoryImpl extends EFactoryImpl implements MemoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MemoryFactory init() {
		try {
			MemoryFactory theMemoryFactory = (MemoryFactory)EPackage.Registry.INSTANCE.getEFactory(MemoryPackage.eNS_URI);
			if (theMemoryFactory != null) {
				return theMemoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MemoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MemoryPackage.EXECUTION: return createExecution();
			case MemoryPackage.ITERATION: return createIteration();
			case MemoryPackage.ORDERED_ITERATION_STEP: return createOrderedIterationStep();
			case MemoryPackage.UNORDERED_ITERATION_STEP: return createUnorderedIterationStep();
			case MemoryPackage.RANK: return createRank();
			case MemoryPackage.INDIVIDUAL: return createIndividual();
			case MemoryPackage.IDENTITY: return createIdentity();
			case MemoryPackage.MUTATION: return createMutation();
			case MemoryPackage.RECOMBINATION: return createRecombination();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution createExecution() {
		ExecutionImpl execution = new ExecutionImpl();
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iteration createIteration() {
		IterationImpl iteration = new IterationImpl();
		return iteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrderedIterationStep createOrderedIterationStep() {
		OrderedIterationStepImpl orderedIterationStep = new OrderedIterationStepImpl();
		return orderedIterationStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnorderedIterationStep createUnorderedIterationStep() {
		UnorderedIterationStepImpl unorderedIterationStep = new UnorderedIterationStepImpl();
		return unorderedIterationStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rank createRank() {
		RankImpl rank = new RankImpl();
		return rank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Individual createIndividual() {
		IndividualImpl individual = new IndividualImpl();
		return individual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Identity createIdentity() {
		IdentityImpl identity = new IdentityImpl();
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mutation createMutation() {
		MutationImpl mutation = new MutationImpl();
		return mutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Recombination createRecombination() {
		RecombinationImpl recombination = new RecombinationImpl();
		return recombination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemoryPackage getMemoryPackage() {
		return (MemoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MemoryPackage getPackage() {
		return MemoryPackage.eINSTANCE;
	}

} //MemoryFactoryImpl
