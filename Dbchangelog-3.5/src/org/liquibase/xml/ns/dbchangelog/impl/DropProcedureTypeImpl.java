/**
 */
package org.liquibase.xml.ns.dbchangelog.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.liquibase.xml.ns.dbchangelog.DbchangelogPackage;
import org.liquibase.xml.ns.dbchangelog.DropProcedureType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Drop Procedure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.DropProcedureTypeImpl#getCatalogName <em>Catalog Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.DropProcedureTypeImpl#getProcedureName <em>Procedure Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.DropProcedureTypeImpl#getSchemaName <em>Schema Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DropProcedureTypeImpl extends MinimalEObjectImpl.Container implements DropProcedureType
{
	/**
	 * The default value of the '{@link #getCatalogName() <em>Catalog Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogName()
	 * @generated
	 * @ordered
	 */
	protected static final String CATALOG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCatalogName() <em>Catalog Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogName()
	 * @generated
	 * @ordered
	 */
	protected String catalogName = CATALOG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcedureName() <em>Procedure Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedureName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCEDURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcedureName() <em>Procedure Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedureName()
	 * @generated
	 * @ordered
	 */
	protected String procedureName = PROCEDURE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaName()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaName()
	 * @generated
	 * @ordered
	 */
	protected String schemaName = SCHEMA_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DropProcedureTypeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return DbchangelogPackage.eINSTANCE.getDropProcedureType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCatalogName()
	{
		return catalogName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatalogName(String newCatalogName)
	{
		String oldCatalogName = catalogName;
		catalogName = newCatalogName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.DROP_PROCEDURE_TYPE__CATALOG_NAME, oldCatalogName, catalogName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcedureName()
	{
		return procedureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureName(String newProcedureName)
	{
		String oldProcedureName = procedureName;
		procedureName = newProcedureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.DROP_PROCEDURE_TYPE__PROCEDURE_NAME, oldProcedureName, procedureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchemaName()
	{
		return schemaName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemaName(String newSchemaName)
	{
		String oldSchemaName = schemaName;
		schemaName = newSchemaName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.DROP_PROCEDURE_TYPE__SCHEMA_NAME, oldSchemaName, schemaName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__CATALOG_NAME:
				return getCatalogName();
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__PROCEDURE_NAME:
				return getProcedureName();
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__SCHEMA_NAME:
				return getSchemaName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__CATALOG_NAME:
				setCatalogName((String)newValue);
				return;
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__PROCEDURE_NAME:
				setProcedureName((String)newValue);
				return;
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__SCHEMA_NAME:
				setSchemaName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__CATALOG_NAME:
				setCatalogName(CATALOG_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__PROCEDURE_NAME:
				setProcedureName(PROCEDURE_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__SCHEMA_NAME:
				setSchemaName(SCHEMA_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__CATALOG_NAME:
				return CATALOG_NAME_EDEFAULT == null ? catalogName != null : !CATALOG_NAME_EDEFAULT.equals(catalogName);
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__PROCEDURE_NAME:
				return PROCEDURE_NAME_EDEFAULT == null ? procedureName != null : !PROCEDURE_NAME_EDEFAULT.equals(procedureName);
			case DbchangelogPackage.DROP_PROCEDURE_TYPE__SCHEMA_NAME:
				return SCHEMA_NAME_EDEFAULT == null ? schemaName != null : !SCHEMA_NAME_EDEFAULT.equals(schemaName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (catalogName: ");
		result.append(catalogName);
		result.append(", procedureName: ");
		result.append(procedureName);
		result.append(", schemaName: ");
		result.append(schemaName);
		result.append(')');
		return result.toString();
	}

} //DropProcedureTypeImpl
