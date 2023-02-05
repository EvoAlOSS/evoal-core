/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.util;

import de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses;
import de.evoal.languages.model.el.ValueReference;

import de.evoal.languages.model.ol.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.ol.OLPackage
 * @generated
 */
public class OLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OLPackage.eINSTANCE;
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
	protected OLSwitch<Adapter> modelSwitch =
		new OLSwitch<Adapter>() {
			@Override
			public Adapter caseOptimisationModel(OptimisationModel object) {
				return createOptimisationModelAdapter();
			}
			@Override
			public Adapter caseUse(Use object) {
				return createUseAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseConstraintStatement(ConstraintStatement object) {
				return createConstraintStatementAdapter();
			}
			@Override
			public Adapter caseFunctionName(FunctionName object) {
				return createFunctionNameAdapter();
			}
			@Override
			public Adapter caseDataReference(DataReference object) {
				return createDataReferenceAdapter();
			}
			@Override
			public Adapter caseEL_FunctionName(de.evoal.languages.model.el.FunctionName object) {
				return createEL_FunctionNameAdapter();
			}
			@Override
			public Adapter caseCallOrLiteralOrReferenceOrParantheses(CallOrLiteralOrReferenceOrParantheses object) {
				return createCallOrLiteralOrReferenceOrParanthesesAdapter();
			}
			@Override
			public Adapter caseValueReference(ValueReference object) {
				return createValueReferenceAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ol.OptimisationModel <em>Optimisation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ol.OptimisationModel
	 * @generated
	 */
	public Adapter createOptimisationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ol.Use <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ol.Use
	 * @generated
	 */
	public Adapter createUseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ol.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ol.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ol.ConstraintStatement <em>Constraint Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ol.ConstraintStatement
	 * @generated
	 */
	public Adapter createConstraintStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ol.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ol.FunctionName
	 * @generated
	 */
	public Adapter createFunctionNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ol.DataReference <em>Data Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ol.DataReference
	 * @generated
	 */
	public Adapter createDataReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.el.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.el.FunctionName
	 * @generated
	 */
	public Adapter createEL_FunctionNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses <em>Call Or Literal Or Reference Or Parantheses</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses
	 * @generated
	 */
	public Adapter createCallOrLiteralOrReferenceOrParanthesesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.el.ValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.el.ValueReference
	 * @generated
	 */
	public Adapter createValueReferenceAdapter() {
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

} //OLAdapterFactory
