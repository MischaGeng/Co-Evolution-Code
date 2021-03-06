/**
 */
package org.liquibase.xml.ns.dbchangelog.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.liquibase.xml.ns.dbchangelog.ColumnType2;
import org.liquibase.xml.ns.dbchangelog.CreateTableType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Table Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getCatalogName <em>Catalog Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getRemarks <em>Remarks</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getSchemaName <em>Schema Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getTableName <em>Table Name</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getTablespace <em>Tablespace</em>}</li>
 *   <li>{@link org.liquibase.xml.ns.dbchangelog.impl.CreateTableTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateTableTypeImpl extends MinimalEObjectImpl.Container implements CreateTableType
{
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

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
	 * The default value of the '{@link #getRemarks() <em>Remarks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemarks()
	 * @generated
	 * @ordered
	 */
	protected static final String REMARKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemarks() <em>Remarks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemarks()
	 * @generated
	 * @ordered
	 */
	protected String remarks = REMARKS_EDEFAULT;

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
	 * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected String tableName = TABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTablespace() <em>Tablespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTablespace()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTablespace() <em>Tablespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTablespace()
	 * @generated
	 * @ordered
	 */
	protected String tablespace = TABLESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateTableTypeImpl()
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
		return DbchangelogPackage.eINSTANCE.getCreateTableType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup()
	{
		if (group == null)
		{
			group = new BasicFeatureMap(this, DbchangelogPackage.CREATE_TABLE_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ColumnType2> getColumn()
	{
		return getGroup().list(DbchangelogPackage.eINSTANCE.getCreateTableType_Column());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny()
	{
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(DbchangelogPackage.eINSTANCE.getCreateTableType_Any());
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
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.CREATE_TABLE_TYPE__CATALOG_NAME, oldCatalogName, catalogName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemarks()
	{
		return remarks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemarks(String newRemarks)
	{
		String oldRemarks = remarks;
		remarks = newRemarks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.CREATE_TABLE_TYPE__REMARKS, oldRemarks, remarks));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.CREATE_TABLE_TYPE__SCHEMA_NAME, oldSchemaName, schemaName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTableName()
	{
		return tableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableName(String newTableName)
	{
		String oldTableName = tableName;
		tableName = newTableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.CREATE_TABLE_TYPE__TABLE_NAME, oldTableName, tableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTablespace()
	{
		return tablespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTablespace(String newTablespace)
	{
		String oldTablespace = tablespace;
		tablespace = newTablespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbchangelogPackage.CREATE_TABLE_TYPE__TABLESPACE, oldTablespace, tablespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute()
	{
		if (anyAttribute == null)
		{
			anyAttribute = new BasicFeatureMap(this, DbchangelogPackage.CREATE_TABLE_TYPE__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case DbchangelogPackage.CREATE_TABLE_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case DbchangelogPackage.CREATE_TABLE_TYPE__COLUMN:
				return ((InternalEList<?>)getColumn()).basicRemove(otherEnd, msgs);
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case DbchangelogPackage.CREATE_TABLE_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case DbchangelogPackage.CREATE_TABLE_TYPE__COLUMN:
				return getColumn();
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case DbchangelogPackage.CREATE_TABLE_TYPE__CATALOG_NAME:
				return getCatalogName();
			case DbchangelogPackage.CREATE_TABLE_TYPE__REMARKS:
				return getRemarks();
			case DbchangelogPackage.CREATE_TABLE_TYPE__SCHEMA_NAME:
				return getSchemaName();
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLE_NAME:
				return getTableName();
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLESPACE:
				return getTablespace();
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case DbchangelogPackage.CREATE_TABLE_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__COLUMN:
				getColumn().clear();
				getColumn().addAll((Collection<? extends ColumnType2>)newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__CATALOG_NAME:
				setCatalogName((String)newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__REMARKS:
				setRemarks((String)newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__SCHEMA_NAME:
				setSchemaName((String)newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLE_NAME:
				setTableName((String)newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLESPACE:
				setTablespace((String)newValue);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case DbchangelogPackage.CREATE_TABLE_TYPE__GROUP:
				getGroup().clear();
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__COLUMN:
				getColumn().clear();
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY:
				getAny().clear();
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__CATALOG_NAME:
				setCatalogName(CATALOG_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__REMARKS:
				setRemarks(REMARKS_EDEFAULT);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__SCHEMA_NAME:
				setSchemaName(SCHEMA_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLE_NAME:
				setTableName(TABLE_NAME_EDEFAULT);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLESPACE:
				setTablespace(TABLESPACE_EDEFAULT);
				return;
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case DbchangelogPackage.CREATE_TABLE_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case DbchangelogPackage.CREATE_TABLE_TYPE__COLUMN:
				return !getColumn().isEmpty();
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY:
				return !getAny().isEmpty();
			case DbchangelogPackage.CREATE_TABLE_TYPE__CATALOG_NAME:
				return CATALOG_NAME_EDEFAULT == null ? catalogName != null : !CATALOG_NAME_EDEFAULT.equals(catalogName);
			case DbchangelogPackage.CREATE_TABLE_TYPE__REMARKS:
				return REMARKS_EDEFAULT == null ? remarks != null : !REMARKS_EDEFAULT.equals(remarks);
			case DbchangelogPackage.CREATE_TABLE_TYPE__SCHEMA_NAME:
				return SCHEMA_NAME_EDEFAULT == null ? schemaName != null : !SCHEMA_NAME_EDEFAULT.equals(schemaName);
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLE_NAME:
				return TABLE_NAME_EDEFAULT == null ? tableName != null : !TABLE_NAME_EDEFAULT.equals(tableName);
			case DbchangelogPackage.CREATE_TABLE_TYPE__TABLESPACE:
				return TABLESPACE_EDEFAULT == null ? tablespace != null : !TABLESPACE_EDEFAULT.equals(tablespace);
			case DbchangelogPackage.CREATE_TABLE_TYPE__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(", catalogName: ");
		result.append(catalogName);
		result.append(", remarks: ");
		result.append(remarks);
		result.append(", schemaName: ");
		result.append(schemaName);
		result.append(", tableName: ");
		result.append(tableName);
		result.append(", tablespace: ");
		result.append(tablespace);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //CreateTableTypeImpl
