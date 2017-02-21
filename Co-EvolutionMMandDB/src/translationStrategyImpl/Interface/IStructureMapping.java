package translationStrategyImpl.Interface;

import org.eclipse.emf.ecore.resource.Resource;
import org.liquibase.xml.ns.dbchangelog.DocumentRoot;

public interface IStructureMapping
{
	public DocumentRoot handleStructureMapping(Resource res);
}
