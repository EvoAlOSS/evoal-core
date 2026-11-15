/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Expression;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Description Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A data description module corresponds to a 'ddl' file.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModule#getTypes <em>Types</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModule#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link de.evoal.languages.model.ddl.DataDescriptionModule#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModule()
 * @model
 * @generated
 */
public interface DataDescriptionModule extends de.evoal.languages.model.base.Module {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.Definition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Defined types that can be used or creating multiple
	 *   data descriptions with same constraints.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModule_Types()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Definition> getTypes();

	/**
	 * Returns the value of the '<em><b>Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * All data descriptions of the module.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Descriptions</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModule_Descriptions()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getDescriptions();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of global constraints
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getDataDescriptionModule_Constraints()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Expression> getConstraints();

} // DataDescriptionModule
