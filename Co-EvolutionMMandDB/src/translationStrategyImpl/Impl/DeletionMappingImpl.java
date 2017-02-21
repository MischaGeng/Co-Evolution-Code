package translationStrategyImpl.Impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edapt.spi.history.Delete;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;
import org.liquibase.xml.ns.dbchangelog.DropColumnType;
import org.liquibase.xml.ns.dbchangelog.DropTableType;

import translationStrategyImpl.Interface.IDeletionMapping;

public class DeletionMappingImpl implements IDeletionMapping
{
	@Override
	public void handleDeletionMapping(Delete delete, ChangeSetType changeSet)
	{

		/*
		 * delete contains delete tables, delete columns and delete references.
		 */

		// drop table
		if (delete.getReferenceName().equals("eClassifiers"))
		{

			if (((EClass) delete.getElement()).getName() == null)
			{

			} else
			{

				DropTableType dropTable = DbchangelogFactory.eINSTANCE.createDropTableType();

				dropTable.setTableName(((ENamedElement) (delete.getElement())).getName());

				changeSet.getDropTable().add(dropTable);
			}
		}

		// delete column and reference
		if (delete.getReferenceName().equals("eStructuralFeatures"))
		{

			if (delete.getElement() instanceof EAttribute)
			{
				// to ensure the deleted objects are not null.
				if (null == ((EAttribute) delete.getElement()).getName()
						|| null == ((EAttribute) delete.getElement()).getEAttributeType().getName())
				{
				} else
				{

					changeSet.getDropColumn().add(deleteColumn(delete));
				}
			}

			if (delete.getElement() instanceof EReference)
			{
				// to ensure the deleted objects are not null.
				if (null == ((EReference) delete.getElement()).getName()
						|| null == ((EReference) delete.getElement()).getEReferenceType().getName())
				{

				} else
				{
					if (((EReference) delete.getElement()).isContainment())
					{
						changeSet.getDropColumn().addAll(DRWithConstainment(delete));
					} else
					{
						changeSet.getDropTable().add(DRWithoutConstainment(delete));
					}
				}

			}

		}

	}

	public DropColumnType deleteColumn(Delete d)
	{
		DropColumnType dropColumn = DbchangelogFactory.eINSTANCE.createDropColumnType();

		String tableName = ((ENamedElement) d.getTarget()).getName();

		dropColumn.setColumnName(((ENamedElement) (d.getElement())).getName());
		dropColumn.setTableName(tableName);

		return dropColumn;

	}

	// delete the reference which has the containment. its complex. We should
	// delete the column from the referenced table.
	public EList<DropColumnType> DRWithConstainment(Delete d)
	{
		EList<DropColumnType> dropColumns = new BasicEList<DropColumnType>();

		DropColumnType dropColumn1 = DbchangelogFactory.eINSTANCE.createDropColumnType();
		DropColumnType dropColumn2 = DbchangelogFactory.eINSTANCE.createDropColumnType();

		String tableName = ((EReference) d.getElement()).getEReferenceType().getName();

		String name = ((EReference) (d.getElement())).getName();

		String TarTN = ((ENamedElement) d.getTarget()).getName();

		String columnName1 = TarTN + "_" + name + "_e_id";
		String columnName2 = TarTN + "_" + name + "_idx";

		dropColumn1.setColumnName(columnName1);
		dropColumn1.setTableName(tableName);
		dropColumn2.setColumnName(columnName2);
		dropColumn2.setTableName(tableName);

		dropColumns.add(dropColumn1);
		dropColumns.add(dropColumn2);

		return dropColumns;

	}

	// just drop the table.
	public DropTableType DRWithoutConstainment(Delete d)
	{
		DropTableType dropTable = DbchangelogFactory.eINSTANCE.createDropTableType();
		String name = ((EReference) (d.getElement())).getName();
		String TarTableName = ((ENamedElement) d.getTarget()).getName();

		String tableName = TarTableName + "_" + name;
		dropTable.setTableName(tableName);
		return dropTable;

	}

}
