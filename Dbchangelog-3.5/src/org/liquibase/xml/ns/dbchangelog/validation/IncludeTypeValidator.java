/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.IncludeType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface IncludeTypeValidator
{
	boolean validate();

	boolean validateContext(String value);
	boolean validateFile(String value);
	boolean validateRelativeToChangelogFile(Object value);
	boolean validateAnyAttribute(FeatureMap value);
}
