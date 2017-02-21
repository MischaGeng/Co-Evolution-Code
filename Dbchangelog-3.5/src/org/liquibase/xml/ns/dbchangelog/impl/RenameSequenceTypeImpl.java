/**
 */
package org.liquibase.xml.ns.dbchangelog.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.liquibase.xml.ns.dbchangelog.DbchangelogPackage;
import org.liquibase.xml.ns.dbchangelog.RenameSequenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rename Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.RenameSequenceTypeImpl#getCatalogName <em>Catalog Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.RenameSequenceTypeImpl#getNewSequenceName <em>New Sequence Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.RenameSequenceTypeImpl#getOldSequenceName <em>Old Sequence Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.RenameSequenceTypeImpl#getSchemaName <em>Schema Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenameSequenceTypeImpl extends MinimalEObjectImpl.Container implements RenameSequenceType
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
	 * The default value of the '{@link #getNewSequenceName() <em>New Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewSequenceName() <em>New Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String newSequenceName = NEW_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldSequenceName() <em>Old Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldSequenceName() <em>Old Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String oldSequenceName = OLD_SEQUENCE_NAME_EDEFAULT;

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
	protected RenameSequenceTypeImpl()
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
		return DbchangelogPackage.eINSTANCE.getRenameSequenceType();
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
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.RENAME_SEQUENCE_TYPE__CATALOG_NAME, oldCatalogName, catalogName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewSequenceName()
	{
		return newSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewSequenceName(String newNewSequenceName)
	{
		String oldNewSequenceName = newSequenceName;
		newSequenceName = newNewSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.RENAME_SEQUENCE_TYPE__NEW_SEQUENCE_NAME, oldNewSequenceName, newSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldSequenceName()
	{
		return oldSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldSequenceName(String newOldSequenceName)
	{
		String oldOldSequenceName = oldSequenceName;
		oldSequenceName = newOldSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.RENAME_SEQUENCE_TYPE__OLD_SEQUENCE_NAME, oldOldSequenceName, oldSequenceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.RENAME_SEQUENCE_TYPE__SCHEMA_NAME, oldSchemaName, schemaName));
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
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__CATALOG_NAME:
				return getCatalogName();
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__NEW_SEQUENCE_NAME:
				return getNewSequenceName();
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__OLD_SEQUENCE_NAME:
				return getOldSequenceName();
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__SCHEMA_NAME:
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
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__CATALOG_NAME:
				setCatalogName((String)newValue);
				return;
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__NEW_SEQUENCE_NAME:
				setNewSequenceName((String)newValue);
				return;
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__OLD_SEQUENCE_NAME:
				setOldSequenceName((String)newValue);
				return;
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__SCHEMA_NAME:
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
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__CATALOG_NAME:
				setCatalogName(CATALOG_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__NEW_SEQUENCE_NAME:
				setNewSequenceName(NEW_SEQUENCE_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__OLD_SEQUENCE_NAME:
				setOldSequenceName(OLD_SEQUENCE_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__SCHEMA_NAME:
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
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__CATALOG_NAME:
				return CATALOG_NAME_EDEFAULT == null ? catalogName != null : !CATALOG_NAME_EDEFAULT.equals(catalogName);
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__NEW_SEQUENCE_NAME:
				return NEW_SEQUENCE_NAME_EDEFAULT == null ? newSequenceName != null : !NEW_SEQUENCE_NAME_EDEFAULT.equals(newSequenceName);
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__OLD_SEQUENCE_NAME:
				return OLD_SEQUENCE_NAME_EDEFAULT == null ? oldSequenceName != null : !OLD_SEQUENCE_NAME_EDEFAULT.equals(oldSequenceName);
			case DbchangelogPackage.RENAME_SEQUENCE_TYPE__SCHEMA_NAME:
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
		result.append(", newSequenceName: ");
		result.append(newSequenceName);
		result.append(", oldSequenceName: ");
		result.append(oldSequenceName);
		result.append(", schemaName: ");
		result.append(schemaName);
		result.append(')');
		return result.toString();
	}

} //RenameSequenceTypeImpl
