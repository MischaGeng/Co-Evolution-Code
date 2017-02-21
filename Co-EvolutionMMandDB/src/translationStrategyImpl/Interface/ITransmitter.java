package translationStrategyImpl.Interface;

import org.eclipse.emf.edapt.spi.history.Change;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;

public interface ITransmitter
{
	public void transmitter(Change change, ChangeSetType changeSet);
}
