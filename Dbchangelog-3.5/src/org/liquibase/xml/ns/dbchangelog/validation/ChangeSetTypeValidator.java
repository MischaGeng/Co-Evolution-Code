/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.liquibase.xml.ns.dbchangelog.AddAutoIncrementType;
import org.liquibase.xml.ns.dbchangelog.AddColumnType;
import org.liquibase.xml.ns.dbchangelog.AddDefaultValueType;
import org.liquibase.xml.ns.dbchangelog.AddForeignKeyConstraintType;
import org.liquibase.xml.ns.dbchangelog.AddLookupTableType;
import org.liquibase.xml.ns.dbchangelog.AddNotNullConstraintType;
import org.liquibase.xml.ns.dbchangelog.AddPrimaryKeyType;
import org.liquibase.xml.ns.dbchangelog.AddUniqueConstraintType;
import org.liquibase.xml.ns.dbchangelog.AlterSequenceType;
import org.liquibase.xml.ns.dbchangelog.CreateIndexType;
import org.liquibase.xml.ns.dbchangelog.CreateProcedureType;
import org.liquibase.xml.ns.dbchangelog.CreateSequenceType;
import org.liquibase.xml.ns.dbchangelog.CreateTableType;
import org.liquibase.xml.ns.dbchangelog.CreateViewType;
import org.liquibase.xml.ns.dbchangelog.CustomChangeType;
import org.liquibase.xml.ns.dbchangelog.DeleteType;
import org.liquibase.xml.ns.dbchangelog.DropAllForeignKeyConstraintsType;
import org.liquibase.xml.ns.dbchangelog.DropColumnType;
import org.liquibase.xml.ns.dbchangelog.DropDefaultValueType;
import org.liquibase.xml.ns.dbchangelog.DropForeignKeyConstraintType;
import org.liquibase.xml.ns.dbchangelog.DropIndexType;
import org.liquibase.xml.ns.dbchangelog.DropNotNullConstraintType;
import org.liquibase.xml.ns.dbchangelog.DropPrimaryKeyType;
import org.liquibase.xml.ns.dbchangelog.DropProcedureType;
import org.liquibase.xml.ns.dbchangelog.DropSequenceType;
import org.liquibase.xml.ns.dbchangelog.DropTableType;
import org.liquibase.xml.ns.dbchangelog.DropUniqueConstraintType;
import org.liquibase.xml.ns.dbchangelog.DropViewType;
import org.liquibase.xml.ns.dbchangelog.ExecuteCommandType;
import org.liquibase.xml.ns.dbchangelog.InsertType;
import org.liquibase.xml.ns.dbchangelog.LoadDataType;
import org.liquibase.xml.ns.dbchangelog.LoadUpdateDataType;
import org.liquibase.xml.ns.dbchangelog.MergeColumnsType;
import org.liquibase.xml.ns.dbchangelog.ModifyDataTypeType;
import org.liquibase.xml.ns.dbchangelog.ModifySqlType;
import org.liquibase.xml.ns.dbchangelog.ObjectQuotingStrategy;
import org.liquibase.xml.ns.dbchangelog.OnChangeSetValidationFail;
import org.liquibase.xml.ns.dbchangelog.OutputType;
import org.liquibase.xml.ns.dbchangelog.PreConditionsType;
import org.liquibase.xml.ns.dbchangelog.RenameColumnType;
import org.liquibase.xml.ns.dbchangelog.RenameSequenceType;
import org.liquibase.xml.ns.dbchangelog.RenameTableType;
import org.liquibase.xml.ns.dbchangelog.RenameViewType;
import org.liquibase.xml.ns.dbchangelog.RollbackType;
import org.liquibase.xml.ns.dbchangelog.SetColumnRemarksType;
import org.liquibase.xml.ns.dbchangelog.SetTableRemarksType;
import org.liquibase.xml.ns.dbchangelog.SqlFileType;
import org.liquibase.xml.ns.dbchangelog.SqlType;
import org.liquibase.xml.ns.dbchangelog.StopType;
import org.liquibase.xml.ns.dbchangelog.TagDatabaseType;
import org.liquibase.xml.ns.dbchangelog.UpdateType;
import org.liquibase.xml.ns.dbchangelog.ValidCheckSumType;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.ChangeSetType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ChangeSetTypeValidator
{
	boolean validate();

	boolean validateValidCheckSum(EList<ValidCheckSumType> value);
	boolean validatePreConditions(PreConditionsType value);
	boolean validateTagDatabase(TagDatabaseType value);
	boolean validateChangeSetChildren(FeatureMap value);
	boolean validateComment(EList<String> value);
	boolean validateCreateTable(EList<CreateTableType> value);
	boolean validateDropTable(EList<DropTableType> value);
	boolean validateCreateView(EList<CreateViewType> value);
	boolean validateRenameView(EList<RenameViewType> value);
	boolean validateDropView(EList<DropViewType> value);
	boolean validateInsert(EList<InsertType> value);
	boolean validateAddColumn(EList<AddColumnType> value);
	boolean validateSql(EList<SqlType> value);
	boolean validateCreateProcedure(EList<CreateProcedureType> value);
	boolean validateDropProcedure(EList<DropProcedureType> value);
	boolean validateSqlFile(EList<SqlFileType> value);
	boolean validateRenameTable(EList<RenameTableType> value);
	boolean validateRenameColumn(EList<RenameColumnType> value);
	boolean validateDropColumn(EList<DropColumnType> value);
	boolean validateMergeColumns(EList<MergeColumnsType> value);
	boolean validateModifyDataType(EList<ModifyDataTypeType> value);
	boolean validateCreateSequence(EList<CreateSequenceType> value);
	boolean validateAlterSequence(EList<AlterSequenceType> value);
	boolean validateDropSequence(EList<DropSequenceType> value);
	boolean validateRenameSequence(EList<RenameSequenceType> value);
	boolean validateCreateIndex(EList<CreateIndexType> value);
	boolean validateDropIndex(EList<DropIndexType> value);
	boolean validateAddNotNullConstraint(EList<AddNotNullConstraintType> value);
	boolean validateDropNotNullConstraint(EList<DropNotNullConstraintType> value);
	boolean validateAddForeignKeyConstraint(EList<AddForeignKeyConstraintType> value);
	boolean validateDropForeignKeyConstraint(EList<DropForeignKeyConstraintType> value);
	boolean validateDropAllForeignKeyConstraints(EList<DropAllForeignKeyConstraintsType> value);
	boolean validateAddPrimaryKey(EList<AddPrimaryKeyType> value);
	boolean validateDropPrimaryKey(EList<DropPrimaryKeyType> value);
	boolean validateAddLookupTable(EList<AddLookupTableType> value);
	boolean validateAddAutoIncrement(EList<AddAutoIncrementType> value);
	boolean validateAddDefaultValue(EList<AddDefaultValueType> value);
	boolean validateDropDefaultValue(EList<DropDefaultValueType> value);
	boolean validateAddUniqueConstraint(EList<AddUniqueConstraintType> value);
	boolean validateDropUniqueConstraint(EList<DropUniqueConstraintType> value);
	boolean validateSetTableRemarks(EList<SetTableRemarksType> value);
	boolean validateSetColumnRemarks(EList<SetColumnRemarksType> value);
	boolean validateCustomChange(EList<CustomChangeType> value);
	boolean validateUpdate(EList<UpdateType> value);
	boolean validateDelete(EList<DeleteType> value);
	boolean validateLoadData(EList<LoadDataType> value);
	boolean validateLoadUpdateData(EList<LoadUpdateDataType> value);
	boolean validateExecuteCommand(EList<ExecuteCommandType> value);
	boolean validateStop(EList<StopType> value);
	boolean validateOutput(EList<OutputType> value);
	boolean validateEmpty(EList<EObject> value);
	boolean validateRollback(EList<RollbackType> value);
	boolean validateAny(FeatureMap value);
	boolean validateModifySql(EList<ModifySqlType> value);
	boolean validateAuthor(String value);
	boolean validateContext(String value);
	boolean validateCreated(String value);
	boolean validateDbms(String value);
	boolean validateFailOnError(Object value);
	boolean validateId(String value);
	boolean validateLabels(String value);
	boolean validateLogicalFilePath(String value);
	boolean validateObjectQuotingStrategy(ObjectQuotingStrategy value);
	boolean validateOnValidationFail(OnChangeSetValidationFail value);
	boolean validateRunAlways(Object value);
	boolean validateRunInTransaction(Object value);
	boolean validateRunOnChange(Object value);
	boolean validateRunOrder(String value);
	boolean validateAnyAttribute(FeatureMap value);
}