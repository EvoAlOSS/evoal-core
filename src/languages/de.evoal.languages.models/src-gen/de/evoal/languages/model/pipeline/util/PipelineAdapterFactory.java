/**
 * EvoAl project
 */
package de.evoal.languages.model.pipeline.util;

import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.execution.Variable;

import de.evoal.languages.model.pipeline.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.pipeline.PipelinePackage
 * @generated
 */
public class PipelineAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PipelinePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipelineAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PipelinePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipelineSwitch<Adapter> modelSwitch =
		new PipelineSwitch<Adapter>() {
			@Override
			public Adapter casePipelineModule(PipelineModule object) {
				return createPipelineModuleAdapter();
			}
			@Override
			public Adapter casePipelineDefinition(PipelineDefinition object) {
				return createPipelineDefinitionAdapter();
			}
			@Override
			public Adapter caseStep(Step object) {
				return createStepAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseNamedVariable(NamedVariable object) {
				return createNamedVariableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.pipeline.PipelineModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.pipeline.PipelineModule
	 * @generated
	 */
	public Adapter createPipelineModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.pipeline.PipelineDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.pipeline.PipelineDefinition
	 * @generated
	 */
	public Adapter createPipelineDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.pipeline.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.pipeline.Step
	 * @generated
	 */
	public Adapter createStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.execution.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.execution.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.execution.NamedVariable <em>Named Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.execution.NamedVariable
	 * @generated
	 */
	public Adapter createNamedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PipelineAdapterFactory
