/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;


/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.DropTableType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DropTableTypeValidator
{
	boolean validate();

	boolean validateCascadeConstraints(Object value);
	boolean validateCatalogName(String value);
	boolean validateSchemaName(String value);
	boolean validateTableName(String value);
}
