/**
 * (c) EvoAl project
 */
package de.evoal.models.v202704.pipeline;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.execution.ExecutionPackage;

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
 * @see de.evoal.models.v202704.pipeline.PipelineFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' core='core.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' exec='execution.ecore#/' expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
 * @generated
 */
public interface PipelinePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pipeline";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://evoal.de/v202704/models/pipeline";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pipeline";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PipelinePackage eINSTANCE = de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.pipeline.impl.PipelineModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.pipeline.impl.PipelineModuleImpl
	 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getPipelineModule()
	 * @generated
	 */
	int PIPELINE_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_MODULE__IMPORTS = BasePackage.MODULE__IMPORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_MODULE__NAME = BasePackage.MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_MODULE__PROGRAM = BasePackage.MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_MODULE_FEATURE_COUNT = BasePackage.MODULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.pipeline.impl.PipelineDefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.pipeline.impl.PipelineDefinitionImpl
	 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getPipelineDefinition()
	 * @generated
	 */
	int PIPELINE_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_DEFINITION__NAME = ExecutionPackage.NAMED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_DEFINITION__STEPS = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_DEFINITION_FEATURE_COUNT = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.pipeline.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.pipeline.impl.StepImpl
	 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getStep()
	 * @generated
	 */
	int STEP = 2;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = ExpressionsPackage.LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl <em>Concrete Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl
	 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getConcreteStep()
	 * @generated
	 */
	int CONCRETE_STEP = 3;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_STEP__CONFIGURATION = STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reads</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_STEP__READS = STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Writes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_STEP__WRITES = STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Concrete Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.evoal.models.v202704.pipeline.impl.PipelineStepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.models.v202704.pipeline.impl.PipelineStepImpl
	 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getPipelineStep()
	 * @generated
	 */
	int PIPELINE_STEP = 4;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_STEP__DEFINITION = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.pipeline.PipelineModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see de.evoal.models.v202704.pipeline.PipelineModule
	 * @generated
	 */
	EClass getPipelineModule();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.models.v202704.pipeline.PipelineModule#getProgram <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Program</em>'.
	 * @see de.evoal.models.v202704.pipeline.PipelineModule#getProgram()
	 * @see #getPipelineModule()
	 * @generated
	 */
	EReference getPipelineModule_Program();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.pipeline.PipelineDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see de.evoal.models.v202704.pipeline.PipelineDefinition
	 * @generated
	 */
	EClass getPipelineDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.models.v202704.pipeline.PipelineDefinition#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see de.evoal.models.v202704.pipeline.PipelineDefinition#getSteps()
	 * @see #getPipelineDefinition()
	 * @generated
	 */
	EReference getPipelineDefinition_Steps();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.pipeline.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see de.evoal.models.v202704.pipeline.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.pipeline.ConcreteStep <em>Concrete Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Step</em>'.
	 * @see de.evoal.models.v202704.pipeline.ConcreteStep
	 * @generated
	 */
	EClass getConcreteStep();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.models.v202704.pipeline.ConcreteStep#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see de.evoal.models.v202704.pipeline.ConcreteStep#getConfiguration()
	 * @see #getConcreteStep()
	 * @generated
	 */
	EReference getConcreteStep_Configuration();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.models.v202704.pipeline.ConcreteStep#getReads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reads</em>'.
	 * @see de.evoal.models.v202704.pipeline.ConcreteStep#getReads()
	 * @see #getConcreteStep()
	 * @generated
	 */
	EReference getConcreteStep_Reads();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.models.v202704.pipeline.ConcreteStep#getWrites <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Writes</em>'.
	 * @see de.evoal.models.v202704.pipeline.ConcreteStep#getWrites()
	 * @see #getConcreteStep()
	 * @generated
	 */
	EReference getConcreteStep_Writes();

	/**
	 * Returns the meta object for class '{@link de.evoal.models.v202704.pipeline.PipelineStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see de.evoal.models.v202704.pipeline.PipelineStep
	 * @generated
	 */
	EClass getPipelineStep();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.models.v202704.pipeline.PipelineStep#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.models.v202704.pipeline.PipelineStep#getDefinition()
	 * @see #getPipelineStep()
	 * @generated
	 */
	EReference getPipelineStep_Definition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PipelineFactory getPipelineFactory();

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
		 * The meta object literal for the '{@link de.evoal.models.v202704.pipeline.impl.PipelineModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.pipeline.impl.PipelineModuleImpl
		 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getPipelineModule()
		 * @generated
		 */
		EClass PIPELINE_MODULE = eINSTANCE.getPipelineModule();

		/**
		 * The meta object literal for the '<em><b>Program</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_MODULE__PROGRAM = eINSTANCE.getPipelineModule_Program();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.pipeline.impl.PipelineDefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.pipeline.impl.PipelineDefinitionImpl
		 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getPipelineDefinition()
		 * @generated
		 */
		EClass PIPELINE_DEFINITION = eINSTANCE.getPipelineDefinition();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_DEFINITION__STEPS = eINSTANCE.getPipelineDefinition_Steps();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.pipeline.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.pipeline.impl.StepImpl
		 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl <em>Concrete Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl
		 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getConcreteStep()
		 * @generated
		 */
		EClass CONCRETE_STEP = eINSTANCE.getConcreteStep();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_STEP__CONFIGURATION = eINSTANCE.getConcreteStep_Configuration();

		/**
		 * The meta object literal for the '<em><b>Reads</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_STEP__READS = eINSTANCE.getConcreteStep_Reads();

		/**
		 * The meta object literal for the '<em><b>Writes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_STEP__WRITES = eINSTANCE.getConcreteStep_Writes();

		/**
		 * The meta object literal for the '{@link de.evoal.models.v202704.pipeline.impl.PipelineStepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.models.v202704.pipeline.impl.PipelineStepImpl
		 * @see de.evoal.models.v202704.pipeline.impl.PipelinePackageImpl#getPipelineStep()
		 * @generated
		 */
		EClass PIPELINE_STEP = eINSTANCE.getPipelineStep();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_STEP__DEFINITION = eINSTANCE.getPipelineStep_Definition();

	}

} //PipelinePackage
