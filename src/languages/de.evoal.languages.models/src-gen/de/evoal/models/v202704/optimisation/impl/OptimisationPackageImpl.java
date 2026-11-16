/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.impl;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.models.v202704.core.CorePackage;

import de.evoal.models.v202704.optimisation.OptimisationFactory;
import de.evoal.models.v202704.optimisation.OptimisationPackage;

import de.evoal.models.v202704.optimisation.execution.ExecutionPackage;

import de.evoal.models.v202704.optimisation.execution.impl.ExecutionPackageImpl;

import de.evoal.models.v202704.optimisation.memory.MemoryPackage;

import de.evoal.models.v202704.optimisation.memory.impl.MemoryPackageImpl;

import de.evoal.models.v202704.optimisation.model.ModelPackage;

import de.evoal.models.v202704.optimisation.model.impl.ModelPackageImpl;

import java.lang.Comparable;

import java.util.List;

import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OptimisationPackageImpl extends EPackageImpl implements OptimisationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType spaceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typedEObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberEDataType = null;

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
	 * @see de.evoal.models.v202704.optimisation.OptimisationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OptimisationPackageImpl() {
		super(eNS_URI, OptimisationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OptimisationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OptimisationPackage init() {
		if (isInited) return (OptimisationPackage)EPackage.Registry.INSTANCE.getEPackage(OptimisationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOptimisationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OptimisationPackageImpl theOptimisationPackage = registeredOptimisationPackage instanceof OptimisationPackageImpl ? (OptimisationPackageImpl)registeredOptimisationPackage : new OptimisationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MemoryPackage.eNS_URI);
		MemoryPackageImpl theMemoryPackage = (MemoryPackageImpl)(registeredPackage instanceof MemoryPackageImpl ? registeredPackage : MemoryPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);
		ExecutionPackageImpl theExecutionPackage = (ExecutionPackageImpl)(registeredPackage instanceof ExecutionPackageImpl ? registeredPackage : ExecutionPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(registeredPackage instanceof ModelPackageImpl ? registeredPackage : ModelPackage.eINSTANCE);

		// Create package meta-data objects
		theOptimisationPackage.createPackageContents();
		theMemoryPackage.createPackageContents();
		theExecutionPackage.createPackageContents();
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theOptimisationPackage.initializePackageContents();
		theMemoryPackage.initializePackageContents();
		theExecutionPackage.initializePackageContents();
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOptimisationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OptimisationPackage.eNS_URI, theOptimisationPackage);
		return theOptimisationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComparable() {
		return comparableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStream() {
		return streamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getList() {
		return listEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSpace() {
		return spaceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getTypedEObject() {
		return typedEObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getNumber() {
		return numberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OptimisationFactory getOptimisationFactory() {
		return (OptimisationFactory)getEFactoryInstance();
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
		comparableEClass = createEClass(COMPARABLE);

		streamEClass = createEClass(STREAM);

		listEClass = createEClass(LIST);

		// Create data types
		spaceEDataType = createEDataType(SPACE);
		typedEObjectEDataType = createEDataType(TYPED_EOBJECT);
		numberEDataType = createEDataType(NUMBER);
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
		MemoryPackage theMemoryPackage = (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage(MemoryPackage.eNS_URI);
		ExecutionPackage theExecutionPackage = (ExecutionPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theMemoryPackage);
		getESubpackages().add(theExecutionPackage);
		getESubpackages().add(theModelPackage);

		// Create type parameters
		addETypeParameter(comparableEClass, "T");
		addETypeParameter(streamEClass, "T");
		addETypeParameter(listEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(comparableEClass, Comparable.class, "Comparable", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(streamEClass, Stream.class, "Stream", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(listEClass, List.class, "List", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(spaceEDataType, Space.class, "Space", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typedEObjectEDataType, TypedEObject.class, "TypedEObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numberEDataType, Number.class, "Number", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "core", "core.ecore#/",
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //OptimisationPackageImpl
