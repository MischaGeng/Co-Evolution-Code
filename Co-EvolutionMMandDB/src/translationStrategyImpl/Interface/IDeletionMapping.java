package translationStrategyImpl.Interface;

import org.eclipse.emf.edapt.spi.history.Delete;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;

public interface IDeletionMapping
{
	public void handleDeletionMapping(Delete delete, ChangeSetType changeSet);
}
