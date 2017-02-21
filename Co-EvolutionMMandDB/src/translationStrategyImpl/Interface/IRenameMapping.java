package translationStrategyImpl.Interface;

import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;

public interface IRenameMapping
{
	public void handleRenameMapping(Set set, ChangeSetType changeSet);
}
