/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.liquibase.xml.ns.dbchangelog.ParamType1;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.WhereParamsType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WhereParamsTypeValidator
{
	boolean validate();

	boolean validateMixed(FeatureMap value);
	boolean validateParam(EList<ParamType1> value);
}
