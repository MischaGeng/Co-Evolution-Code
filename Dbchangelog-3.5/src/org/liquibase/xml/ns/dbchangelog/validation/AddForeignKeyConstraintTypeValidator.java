/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.liquibase.xml.ns.dbchangelog.FkCascadeActionOptions;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.AddForeignKeyConstraintType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AddForeignKeyConstraintTypeValidator
{
	boolean validate();

	boolean validateBaseColumnNames(String value);
	boolean validateBaseTableCatalogName(String value);
	boolean validateBaseTableName(String value);
	boolean validateBaseTableSchemaName(String value);
	boolean validateConstraintName(String value);
	boolean validateDeferrable(Object value);
	boolean validateDeleteCascade(Object value);
	boolean validateInitiallyDeferred(Object value);
	boolean validateOnDelete(FkCascadeActionOptions value);
	boolean validateOnUpdate(FkCascadeActionOptions value);
	boolean validateReferencedColumnNames(String value);
	boolean validateReferencedTableCatalogName(String value);
	boolean validateReferencedTableName(String value);
	boolean validateReferencedTableSchemaName(String value);
	boolean validateReferencesUniqueColumn(Object value);
}