/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.liquibase.xml.ns.dbchangelog.ConstraintsType;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.ColumnType2}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ColumnType2Validator
{
	boolean validate();

	boolean validateMixed(FeatureMap value);
	boolean validateConstraints(ConstraintsType value);
	boolean validateAutoIncrement(Object value);
	boolean validateComputed(Object value);
	boolean validateDefaultValue(String value);
	boolean validateDefaultValueBoolean(Object value);
	boolean validateDefaultValueComputed(String value);
	boolean validateDefaultValueDate(String value);
	boolean validateDefaultValueNumeric(String value);
	boolean validateDefaultValueSequenceCurrent(String value);
	boolean validateDefaultValueSequenceNext(String value);
	boolean validateEncoding(String value);
	boolean validateIncrementBy(long value);
	boolean validateName(String value);
	boolean validateRemarks(String value);
	boolean validateStartWith(long value);
	boolean validateType(String value);
	boolean validateValue(String value);
	boolean validateValueBlobFile(String value);
	boolean validateValueBoolean(String value);
	boolean validateValueClobFile(String value);
	boolean validateValueComputed(String value);
	boolean validateValueDate(String value);
	boolean validateValueNumeric(String value);
	boolean validateValueSequenceCurrent(String value);
	boolean validateValueSequenceNext(String value);
	boolean validateAnyAttribute(FeatureMap value);
}