/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.liquibase.xml.ns.dbchangelog.AndType;
import org.liquibase.xml.ns.dbchangelog.ChangeLogPropertyDefinedType;
import org.liquibase.xml.ns.dbchangelog.ChangeSetExecutedType;
import org.liquibase.xml.ns.dbchangelog.ColumnExistsType;
import org.liquibase.xml.ns.dbchangelog.CustomPreconditionType;
import org.liquibase.xml.ns.dbchangelog.DbmsType;
import org.liquibase.xml.ns.dbchangelog.ExpectedQuotingStrategyType;
import org.liquibase.xml.ns.dbchangelog.ForeignKeyConstraintExistsType;
import org.liquibase.xml.ns.dbchangelog.IndexExistsType;
import org.liquibase.xml.ns.dbchangelog.NotType;
import org.liquibase.xml.ns.dbchangelog.OrType;
import org.liquibase.xml.ns.dbchangelog.PrimaryKeyExistsType;
import org.liquibase.xml.ns.dbchangelog.RowCountType;
import org.liquibase.xml.ns.dbchangelog.RunningAsType;
import org.liquibase.xml.ns.dbchangelog.SequenceExistsType;
import org.liquibase.xml.ns.dbchangelog.SqlCheckType;
import org.liquibase.xml.ns.dbchangelog.TableExistsType;
import org.liquibase.xml.ns.dbchangelog.TableIsEmptyType;
import org.liquibase.xml.ns.dbchangelog.ViewExistsType;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.AndType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AndTypeValidator
{
	boolean validate();

	boolean validateGroup(FeatureMap value);
	boolean validateAnd(EList<AndType> value);
	boolean validateOr(EList<OrType> value);
	boolean validateNot(EList<NotType> value);
	boolean validateDbms(EList<DbmsType> value);
	boolean validateRunningAs(EList<RunningAsType> value);
	boolean validateChangeSetExecuted(EList<ChangeSetExecutedType> value);
	boolean validateTableExists(EList<TableExistsType> value);
	boolean validateColumnExists(EList<ColumnExistsType> value);
	boolean validateSequenceExists(EList<SequenceExistsType> value);
	boolean validateForeignKeyConstraintExists(EList<ForeignKeyConstraintExistsType> value);
	boolean validateIndexExists(EList<IndexExistsType> value);
	boolean validatePrimaryKeyExists(EList<PrimaryKeyExistsType> value);
	boolean validateViewExists(EList<ViewExistsType> value);
	boolean validateTableIsEmpty(EList<TableIsEmptyType> value);
	boolean validateRowCount(EList<RowCountType> value);
	boolean validateSqlCheck(EList<SqlCheckType> value);
	boolean validateChangeLogPropertyDefined(EList<ChangeLogPropertyDefinedType> value);
	boolean validateExpectedQuotingStrategy(EList<ExpectedQuotingStrategyType> value);
	boolean validateCustomPrecondition(EList<CustomPreconditionType> value);
	boolean validateAny(FeatureMap value);
}
