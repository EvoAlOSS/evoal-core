/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution.impl;

import de.evoal.models.v202704.core.CorePackage;

import de.evoal.models.v202704.optimisation.OptimisationPackage;

import de.evoal.models.v202704.optimisation.execution.ExecutionFactory;
import de.evoal.models.v202704.optimisation.execution.ExecutionPackage;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance;
import de.evoal.models.v202704.optimisation.execution.Selection;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.models.v202704.optimisation.impl.OptimisationPackageImpl;

import de.evoal.models.v202704.optimisation.memory.MemoryPackage;

import de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl;

import de.evoal.models.v202704.optimisation.model.ModelPackage;

import de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionPackageImpl extends EPackageImpl implements ExecutionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optimisationFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminationCriterionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optimisationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optimisationValueWithDistanceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.evoal.models.v202704.optimisation.execution.ExecutionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionPackageImpl() {
		super(eNS_URI, ExecutionFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ExecutionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExecutionPackage init() {
		if (isInited) return (ExecutionPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredExecutionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ExecutionPackageImpl theExecutionPackage = registeredExecutionPackage instanceof ExecutionPackageImpl ? (ExecutionPackageImpl)registeredExecutionPackage : new ExecutionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(OptimisationPackage.eNS_URI);
		OptimisationPackageImpl theOptimisationPackage = (OptimisationPackageImpl)(registeredPackage instanceof OptimisationPackageImpl ? registeredPackage : OptimisationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MemoryPackage.eNS_URI);
		MemoryPackageImpl theMemoryPackage = (MemoryPackageImpl)(registeredPackage instanceof MemoryPackageImpl ? registeredPackage : MemoryPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(registeredPackage instanceof ModelPackageImpl ? registeredPackage : ModelPackage.eINSTANCE);

		// Create package meta-data objects
		theExecutionPackage.createPackageContents();
		theOptimisationPackage.createPackageContents();
		theMemoryPackage.createPackageContents();
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theExecutionPackage.initializePackageContents();
		theOptimisationPackage.initializePackageContents();
		theMemoryPackage.initializePackageContents();
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExecutionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExecutionPackage.eNS_URI, theExecutionPackage);
		return theExecutionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptimisationFunction() {
		return optimisationFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTerminationCriterion() {
		return terminationCriterionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSelection() {
		return selectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptimisationValue() {
		return optimisationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptimisationValueWithDistance() {
		return optimisationValueWithDistanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionFactory getExecutionFactory() {
		return (ExecutionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		optimisationFunctionEClass = createEClass(OPTIMISATION_FUNCTION);

		terminationCriterionEClass = createEClass(TERMINATION_CRITERION);

		selectionEClass = createEClass(SELECTION);

		optimisationValueEClass = createEClass(OPTIMISATION_VALUE);

		optimisationValueWithDistanceEClass = createEClass(OPTIMISATION_VALUE_WITH_DISTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		OptimisationPackage theOptimisationPackage = (OptimisationPackage)EPackage.Registry.INSTANCE.getEPackage(OptimisationPackage.eNS_URI);
		MemoryPackage theMemoryPackage = (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage(MemoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theCorePackage.getEvoalComponent());
		EGenericType g2 = createEGenericType(this.getOptimisationFunction());
		g1.getETypeArguments().add(g2);
		optimisationFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCorePackage.getEvoalComponent());
		g2 = createEGenericType(this.getTerminationCriterion());
		g1.getETypeArguments().add(g2);
		terminationCriterionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theOptimisationPackage.getComparable());
		g2 = createEGenericType(this.getOptimisationValue());
		g1.getETypeArguments().add(g2);
		optimisationValueEClass.getEGenericSuperTypes().add(g1);
		optimisationValueWithDistanceEClass.getESuperTypes().add(this.getOptimisationValue());

		// Initialize classes and features; add operations and parameters
		initEClass(optimisationFunctionEClass, OptimisationFunction.class, "OptimisationFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(optimisationFunctionEClass, theOptimisationPackage.getTypedEObject(), "evaluate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOptimisationPackage.getTypedEObject(), "input", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(optimisationFunctionEClass, ecorePackage.getEBoolean(), "isThreadSafe", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(terminationCriterionEClass, TerminationCriterion.class, "TerminationCriterion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(terminationCriterionEClass, ecorePackage.getEBoolean(), "shouldTerminate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMemoryPackage.getIteration(), "iteration", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(terminationCriterionEClass, ecorePackage.getEBoolean(), "shouldContinue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMemoryPackage.getIteration(), "iteration", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(selectionEClass, Selection.class, "Selection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(selectionEClass, theMemoryPackage.getIterationStep(), "select", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMemoryPackage.getIterationStep(), "input", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(optimisationValueEClass, OptimisationValue.class, "OptimisationValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(optimisationValueEClass, ecorePackage.getEBoolean(), "isBetter", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptimisationValue(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(optimisationValueEClass, ecorePackage.getEBoolean(), "isEqual", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptimisationValue(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(optimisationValueEClass, ecorePackage.getEBoolean(), "isWorse", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptimisationValue(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(optimisationValueEClass, theOptimisationPackage.getTypedEObject(), "toOptmisationSpace", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(optimisationValueEClass, null, "toStatistics", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theOptimisationPackage.getList());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(optimisationValueWithDistanceEClass, OptimisationValueWithDistance.class, "OptimisationValueWithDistance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(optimisationValueWithDistanceEClass, ecorePackage.getEDouble(), "distanceFrom", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptimisationValue(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create annotations
		// https://evoal.de/v202610/models/core/configured-by
		createConfiguredbyAnnotations();
	}

	/**
	 * Initializes the annotations for <b>https://evoal.de/v202610/models/core/configured-by</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createConfiguredbyAnnotations() {
		String source = "https://evoal.de/v202610/models/core/configured-by";
		addAnnotation
		  (optimisationFunctionEClass,
		   source,
		   new String[] {
			   "type", "de.evoal.optimisation.core.optimisation-function"
		   });
		addAnnotation
		  (terminationCriterionEClass,
		   source,
		   new String[] {
			   "type", "de.evoal.optimisation.core.stopping-criterion"
		   });
	}

} //ExecutionPackageImpl
