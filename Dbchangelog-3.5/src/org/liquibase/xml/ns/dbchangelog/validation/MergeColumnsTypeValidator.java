/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;


/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.MergeColumnsType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MergeColumnsTypeValidator
{
	boolean validate();

	boolean validateCatalogName(String value);
	boolean validateColumn1Name(String value);
	boolean validateColumn2Name(String value);
	boolean validateFinalColumnName(String value);
	boolean validateFinalColumnType(String value);
	boolean validateJoinString(String value);
	boolean validateSchemaName(String value);
	boolean validateTableName(String value);
}
