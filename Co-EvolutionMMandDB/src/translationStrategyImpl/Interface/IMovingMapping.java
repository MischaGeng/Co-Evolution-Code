package translationStrategyImpl.Interface;

import org.eclipse.emf.edapt.spi.history.Move;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;


public interface IMovingMapping
{
	public void handleMovingMapping(Move move, ChangeSetType changeSet);

}
