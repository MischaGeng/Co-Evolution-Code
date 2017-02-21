package translationStrategyImpl.Impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;
import org.liquibase.xml.ns.dbchangelog.ModifyDataTypeType;
import org.liquibase.xml.ns.dbchangelog.RenameColumnType;
import org.liquibase.xml.ns.dbchangelog.RenameTableType;

import translationStrategyImpl.Interface.IChangeDataType;
import translationStrategyImpl.Util.DataTypeMapping;

public class ChangeDataTypeImpl implements IChangeDataType
{
	public  void handleChangeDataType(Set set, ChangeSetType changeSet)
	{
		
		if (set.getElement() instanceof EAttribute)
		{
			changeSet.getModifyDataType().add(changeDTofAttri(set));
		}

		if (set.getElement() instanceof EReference)
		{
			if (((EReference) set.getElement()).isContainment())
			{
				changeDTofReferWcon(set, changeSet);
			} else
			{
				changeDTofReferWOcon(set, changeSet);
			}

		}

	}

	private  ModifyDataTypeType changeDTofAttri(Set set)
	{
		ModifyDataTypeType modifyDataType = DbchangelogFactory.eINSTANCE.createModifyDataTypeType();
		String colunmName = ((ENamedElement) set.getElement()).getName();
		String eDataType = ((EDataType) set.getReferenceValue()).getName();
		String tableName = ((EStructuralFeature) set.getElement()).getEContainingClass().getName();

		// get the DataType
		String dataType = DataTypeMapping.getDataType(eDataType);
		modifyDataType.setNewDataType(dataType);

		modifyDataType.setColumnName(colunmName);
		modifyDataType.setTableName(tableName);

		return modifyDataType;
	}
	
	private  void changeDTofReferWcon(Set set, ChangeSetType changeSet){
		
		System.out.println(set.getElement());
		RenameTableType renameTable = DbchangelogFactory.eINSTANCE.createRenameTableType();
		String newTableName = ((EClass) set.getReferenceValue()).getName();
		String oldTableName = ((EClass) set.getOldReferenceValue()).getName();

		renameTable.setNewTableName(newTableName);
		renameTable.setOldTableName(oldTableName);
		
		changeSet.getRenameTable().add(renameTable);

	}
	
	
	private  void changeDTofReferWOcon(Set s, ChangeSetType changeSet){
		
		RenameColumnType renameColumn = DbchangelogFactory.eINSTANCE.createRenameColumnType();
		
		String referEClass = ((EReference) s.getElement()).getEContainingClass().getName();
		String newDataType = ((EClass) s.getReferenceValue()).getName();
		String referName = ((EReference) s.getElement()).getName();
		
		String oldDataType = ((EClass) s.getOldReferenceValue()).getName();
		
		String TableName = referEClass + "_" + referName;
		
		renameColumn.setTableName(TableName);
		
		String newColunmName = newDataType + "_e_id";
		String odlColumnName = oldDataType + "_e_id";
		renameColumn.setNewColumnName(newColunmName);
		renameColumn.setOldColumnName(odlColumnName);
		changeSet.getRenameColumn().add(renameColumn);
		
	}
	
}
