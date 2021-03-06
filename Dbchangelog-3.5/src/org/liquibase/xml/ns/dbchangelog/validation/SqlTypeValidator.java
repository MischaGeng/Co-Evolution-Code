/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.SqlType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SqlTypeValidator
{
	boolean validate();

	boolean validateMixed(FeatureMap value);
	boolean validateComment(String value);
	boolean validateDbms(String value);
	boolean validateEndDelimiter(String value);
	boolean validateSplitStatements(Object value);
	boolean validateStripComments(Object value);
}
