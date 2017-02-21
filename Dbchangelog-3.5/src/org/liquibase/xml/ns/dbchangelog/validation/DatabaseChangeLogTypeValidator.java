/**
 *
 * $Id$
 */
package org.liquibase.xml.ns.dbchangelog.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.IncludeAllType;
import org.liquibase.xml.ns.dbchangelog.IncludeType;
import org.liquibase.xml.ns.dbchangelog.ObjectQuotingStrategy;
import org.liquibase.xml.ns.dbchangelog.PreConditionsType1;
import org.liquibase.xml.ns.dbchangelog.PropertyType;

/**
 * A sample validator interface for {@link org.liquibase.xml.ns.dbchangelog.DatabaseChangeLogType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DatabaseChangeLogTypeValidator
{
	boolean validate();

	boolean validateProperty(EList<PropertyType> value);
	boolean validatePreConditions(PreConditionsType1 value);
	boolean validateGroup(FeatureMap value);
	boolean validateChangeSet(EList<ChangeSetType> value);
	boolean validateInclude(EList<IncludeType> value);
	boolean validateIncludeAll(EList<IncludeAllType> value);
	boolean validateContext(String value);
	boolean validateLogicalFilePath(String value);
	boolean validateObjectQuotingStrategy(ObjectQuotingStrategy value);
	boolean validateAnyAttribute(FeatureMap value);
}
