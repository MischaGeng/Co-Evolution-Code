/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.liquibase.xml.ns.dbchangelog.ColumnType2;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.CreateIndexType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CreateIndexTypeValidator
{
	boolean validate();

	boolean validateGroup(FeatureMap value);
	boolean validateColumn(EList<ColumnType2> value);
	boolean validateAny(FeatureMap value);
	boolean validateAssociatedWith(String value);
	boolean validateCatalogName(String value);
	boolean validateClustered(Object value);
	boolean validateIndexName(String value);
	boolean validateSchemaName(String value);
	boolean validateTableName(String value);
	boolean validateTablespace(String value);
	boolean validateUnique(Object value);
}