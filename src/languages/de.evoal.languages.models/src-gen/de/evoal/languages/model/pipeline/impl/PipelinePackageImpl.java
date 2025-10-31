/**
 * EvoAl project
 */
package de.evoal.languages.model.pipeline.impl;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.execution.ExecutionPackage;

import de.evoal.languages.model.pipeline.ConcreteStep;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.languages.model.pipeline.PipelineFactory;
import de.evoal.languages.model.pipeline.PipelineModule;
import de.evoal.languages.model.pipeline.PipelinePackage;
import de.evoal.languages.model.pipeline.PipelineStep;
import de.evoal.languages.model.pipeline.Step;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipelinePackageImpl extends EPackageImpl implements PipelinePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineStepEClass = null;

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
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PipelinePackageImpl() {
		super(eNS_URI, PipelineFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PipelinePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PipelinePackage init() {
		if (isInited) return (PipelinePackage)EPackage.Registry.INSTANCE.getEPackage(PipelinePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPipelinePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PipelinePackageImpl thePipelinePackage = registeredPipelinePackage instanceof PipelinePackageImpl ? (PipelinePackageImpl)registeredPipelinePackage : new PipelinePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DefinitionsPackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		BasePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ExecutionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePipelinePackage.createPackageContents();

		// Initialize created meta-data
		thePipelinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePipelinePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PipelinePackage.eNS_URI, thePipelinePackage);
		return thePipelinePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipelineModule() {
		return pipelineModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineModule_Imports() {
		return (EReference)pipelineModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPipelineModule_Name() {
		return (EAttribute)pipelineModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineModule_Program() {
		return (EReference)pipelineModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipelineDefinition() {
		return pipelineDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineDefinition_Steps() {
		return (EReference)pipelineDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStep() {
		return stepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConcreteStep() {
		return concreteStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConcreteStep_Instance() {
		return (EReference)concreteStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConcreteStep_Reads() {
		return (EReference)concreteStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConcreteStep_Writes() {
		return (EReference)concreteStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipelineStep() {
		return pipelineStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineStep_Definition() {
		return (EReference)pipelineStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelineFactory getPipelineFactory() {
		return (PipelineFactory)getEFactoryInstance();
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
		pipelineModuleEClass = createEClass(PIPELINE_MODULE);
		createEReference(pipelineModuleEClass, PIPELINE_MODULE__IMPORTS);
		createEAttribute(pipelineModuleEClass, PIPELINE_MODULE__NAME);
		createEReference(pipelineModuleEClass, PIPELINE_MODULE__PROGRAM);

		pipelineDefinitionEClass = createEClass(PIPELINE_DEFINITION);
		createEReference(pipelineDefinitionEClass, PIPELINE_DEFINITION__STEPS);

		stepEClass = createEClass(STEP);

		concreteStepEClass = createEClass(CONCRETE_STEP);
		createEReference(concreteStepEClass, CONCRETE_STEP__INSTANCE);
		createEReference(concreteStepEClass, CONCRETE_STEP__READS);
		createEReference(concreteStepEClass, CONCRETE_STEP__WRITES);

		pipelineStepEClass = createEClass(PIPELINE_STEP);
		createEReference(pipelineStepEClass, PIPELINE_STEP__DEFINITION);
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
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		ExecutionPackage theExecutionPackage = (ExecutionPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pipelineDefinitionEClass.getESuperTypes().add(theExecutionPackage.getNamedVariable());
		stepEClass.getESuperTypes().add(theExpressionsPackage.getLiteral());
		concreteStepEClass.getESuperTypes().add(this.getStep());
		pipelineStepEClass.getESuperTypes().add(this.getStep());

		// Initialize classes and features; add operations and parameters
		initEClass(pipelineModuleEClass, PipelineModule.class, "PipelineModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelineModule_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, PipelineModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipelineModule_Name(), ecorePackage.getEString(), "name", null, 1, 1, PipelineModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPipelineModule_Program(), theExecutionPackage.getProgram(), null, "program", null, 1, 1, PipelineModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelineDefinitionEClass, PipelineDefinition.class, "PipelineDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelineDefinition_Steps(), this.getStep(), null, "steps", null, 0, -1, PipelineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepEClass, Step.class, "Step", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(stepEClass, this.getStep(), "getValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(concreteStepEClass, ConcreteStep.class, "ConcreteStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcreteStep_Instance(), theExpressionsPackage.getInstance(), null, "instance", null, 1, 1, ConcreteStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteStep_Reads(), ecorePackage.getEStructuralFeature(), null, "reads", null, 0, -1, ConcreteStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConcreteStep_Writes(), ecorePackage.getEStructuralFeature(), null, "writes", null, 0, -1, ConcreteStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pipelineStepEClass, PipelineStep.class, "PipelineStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelineStep_Definition(), this.getPipelineDefinition(), null, "definition", null, 1, 1, PipelineStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/OCL/Collection
		createCollectionAnnotations();
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
			   "base", "platform:/resource/de.evoal.languages.model.base/model/model.ecore#/",
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			   "exec", "execution.ecore#/",
			   "expr", "platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://www.eclipse.org/OCL/Collection";
		addAnnotation
		  (getPipelineDefinition_Steps(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getConcreteStep_Reads(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getConcreteStep_Writes(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //PipelinePackageImpl
