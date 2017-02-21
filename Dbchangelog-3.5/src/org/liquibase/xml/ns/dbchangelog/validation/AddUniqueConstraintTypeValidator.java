/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;


/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.AddUniqueConstraintType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AddUniqueConstraintTypeValidator
{
	boolean validate();

	boolean validateCatalogName(String value);
	boolean validateColumnNames(String value);
	boolean validateConstraintName(String value);
	boolean validateDeferrable(Object value);
	boolean validateDisabled(Object value);
	boolean validateForIndexCatalogName(String value);
	boolean validateForIndexName(String value);
	boolean validateForIndexSchemaName(String value);
	boolean validateInitiallyDeferred(Object value);
	boolean validateSchemaName(String value);
	boolean validateTableName(String value);
	boolean validateTablespace(String value);
}
