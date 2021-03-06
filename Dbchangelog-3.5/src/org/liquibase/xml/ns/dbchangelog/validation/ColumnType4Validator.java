/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import java.math.BigInteger;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.ColumnType4}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ColumnType4Validator
{
	boolean validate();

	boolean validateAfterColumn(String value);
	boolean validateBeforeColumn(String value);
	boolean validatePosition(BigInteger value);
}
