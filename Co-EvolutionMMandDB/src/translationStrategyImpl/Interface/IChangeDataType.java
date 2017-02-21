package translationStrategyImpl.Interface;

import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;

public interface IChangeDataType
{
	public  void handleChangeDataType(Set set, ChangeSetType changeSet);
}
