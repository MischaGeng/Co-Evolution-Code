package translationStrategyImpl.Impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edapt.spi.history.Move;
import org.liquibase.xml.ns.dbchangelog.AddColumnType;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.ColumnType4;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;
import org.liquibase.xml.ns.dbchangelog.DropColumnType;
import org.liquibase.xml.ns.dbchangelog.SqlType;

import translationStrategyImpl.Interface.IMovingMapping;
import translationStrategyImpl.Util.DataTypeMapping;

public class MovingMappingImpl implements IMovingMapping
{

	@Override
	public void handleMovingMapping(Move move, ChangeSetType changeSet)
	{

		/*
		 * 
		 */
		if (move.getElement() instanceof EAttribute)
		{

			// targetTable is the name of new table
			String targetTable = ((ENamedElement) move.getTarget()).getName();

			// sourceTable is the name of the old table.
			String sourceTable = ((ENamedElement) move.getSource()).getName();

			// movedColomn is the attribute which be moved from the old table.
			String movedColomn = ((ENamedElement) move.getElement()).getName();

			// eDataType is the dataType of the movedColomn (attribute).

			String eDataType = ((EAttribute) move.getElement()).getEAttributeType().getName();

			// h2DataType is the dataTyep of the h2 Database.
			String h2DataType = DataTypeMapping.getDataType(eDataType);

			AddColumnType addColumn = DbchangelogFactory.eINSTANCE.createAddColumnType();
			ColumnType4 column = DbchangelogFactory.eINSTANCE.createColumnType4();

			column.setName(movedColomn);
			column.setType(h2DataType);
			addColumn.setTableName(targetTable);
			addColumn.getColumn().add(column);
			changeSet.getAddColumn().add(addColumn);

			// InsertType insert =
			// DbchangelogFactory.eINSTANCE.createInsertType();
			// ColumnType2 columnT2 =
			// DbchangelogFactory.eINSTANCE.createColumnType2();
			//
			// insert.setTableName(targetTable);
			// columnT2.setName(movedColomn);
			//
			// String value = "SELECT "+ movedColomn + " FROM " + sourceTable;
			// columnT2.setValueComputed(value);
			//
			// insert.getColumn().add(columnT2);
			//
			// changeSet.getInsert().add(insert);
			//

			SqlType sqlType = DbchangelogFactory.eINSTANCE.createSqlType();

			String sqlText = "INSERT INTO " + targetTable + " (E_ID, " + movedColomn + ") SELECT E_ID, " + movedColomn
					+ " FROM " + sourceTable;

			sqlType.getMixed().add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text(), sqlText);

			changeSet.getSql().add(sqlType);

			DropColumnType dropColumn = DbchangelogFactory.eINSTANCE.createDropColumnType();

			String tableName = sourceTable;

			dropColumn.setColumnName(movedColomn);
			dropColumn.setTableName(tableName);

			changeSet.getDropColumn().add(dropColumn);
		} else {
			System.out.println("Translation don't support !");
		}

	}
}
