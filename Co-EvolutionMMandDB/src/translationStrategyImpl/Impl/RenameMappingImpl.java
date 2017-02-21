package translationStrategyImpl.Impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;
import org.liquibase.xml.ns.dbchangelog.RenameColumnType;
import org.liquibase.xml.ns.dbchangelog.RenameTableType;

import translationStrategyImpl.Interface.IRenameMapping;
import translationStrategyImpl.Util.DataTypeMapping;

public class RenameMappingImpl implements IRenameMapping
{
	// Rename contains class column and reference.
	@Override
	public void handleRenameMapping(Set set, ChangeSetType changeSet)
	{
		if (set.getFeatureName().equals("name"))
		{
			if (set.getElement() instanceof EClass)
			{
				changeSet.getRenameTable().add(renameClass(set));
			}

			if (set.getElement() instanceof EAttribute)
			{
				renameAttribute(set, changeSet);
			}

			if (set.getElement() instanceof EReference)
			{
				renameReference(set, changeSet);

			}
		}

	}

	private RenameTableType renameClass(Set s)
	{

		RenameTableType renameTable = DbchangelogFactory.eINSTANCE.createRenameTableType();
		String newTableName = s.getDataValue();
		String oldTableName = s.getOldDataValue();

		renameTable.setNewTableName(newTableName);
		renameTable.setOldTableName(oldTableName);

		return renameTable;

	}

	private void renameAttribute(Set s, ChangeSetType changeSet)
	{

		// String eType = ((ETypedElement)
		// s.getElement()).getEType().getName();

		RenameColumnType renameColumn = DbchangelogFactory.eINSTANCE.createRenameColumnType();

		String newColunmName = s.getDataValue();
		String odlColumnName = s.getOldDataValue();
		String eDateTypeName = ((ETypedElement) s.getElement()).getEType().getName();

		String dataType = DataTypeMapping.getDataType(eDateTypeName);
		renameColumn.setColumnDataType(dataType);

		String tableName = ((EStructuralFeature) s.getElement()).getEContainingClass().getName();
		renameColumn.setNewColumnName(newColunmName);
		renameColumn.setOldColumnName(odlColumnName);
		renameColumn.setTableName(tableName);

		changeSet.getRenameColumn().add(renameColumn);

	}

	public void renameReference(Set s, ChangeSetType changeSet)
	{
		if (((EReference) s.getElement()).isContainment())
		{
			rnReferWithContainment(s, changeSet);
		} else
		{
			rnReferWithoutConstainment(s, changeSet);
		}

	}

	private void rnReferWithContainment(Set s, ChangeSetType changeSet)
	{
		String tableName = ((ETypedElement) s.getElement()).getEType().getName();
		String eClassName = ((EStructuralFeature) s.getElement()).getEContainingClass().getName();

		RenameColumnType renameColumn1 = DbchangelogFactory.eINSTANCE.createRenameColumnType();
		RenameColumnType renameColumn2 = DbchangelogFactory.eINSTANCE.createRenameColumnType();

		String newColunmName1 = eClassName + "_" + s.getDataValue() + "_e_idx";
		String odlColumnName1 = eClassName + "_" + s.getOldDataValue() + "_e_idx";
		renameColumn1.setNewColumnName(newColunmName1);
		renameColumn1.setOldColumnName(odlColumnName1);
		renameColumn1.setTableName(tableName);

		String newColunmName2 = eClassName + "_" + s.getDataValue() + "_idx";
		String odlColumnName2 = eClassName + "_" + s.getOldDataValue() + "_idx";
		renameColumn2.setNewColumnName(newColunmName2);
		renameColumn2.setOldColumnName(odlColumnName2);
		renameColumn2.setTableName(tableName);

		changeSet.getRenameColumn().add(renameColumn1);
		changeSet.getRenameColumn().add(renameColumn2);

	}

	private void rnReferWithoutConstainment(Set s, ChangeSetType changeSet)
	{
		RenameTableType renameTable = DbchangelogFactory.eINSTANCE.createRenameTableType();

		// eClassName which refer belonged to.
		String eClassName = ((EStructuralFeature) s.getElement()).getEContainingClass().getName();

		String newTableName = eClassName + "_" + s.getDataValue();
		String oldTableName = eClassName + "_" + s.getOldDataValue();

		renameTable.setNewTableName(newTableName);
		renameTable.setOldTableName(oldTableName);
		changeSet.getRenameTable().add(renameTable);

		RenameColumnType renameColumn = DbchangelogFactory.eINSTANCE.createRenameColumnType();

		String newColunmName = eClassName + "_" + s.getDataValue() + "_idx";
		String odlColumnName = eClassName + "_" + s.getOldDataValue() + "_idx";
		renameColumn.setNewColumnName(newColunmName);
		renameColumn.setOldColumnName(odlColumnName);
		renameColumn.setTableName(newTableName);
		changeSet.getRenameColumn().add(renameColumn);

	}

}
