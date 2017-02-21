package translationStrategyImpl.Interface;

import org.eclipse.emf.edapt.spi.history.Add;
import org.eclipse.emf.edapt.spi.history.Create;
import org.eclipse.emf.edapt.spi.history.Remove;
import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;

public interface ICreationMapping
{
	public void handleCreationMapping(Create c, ChangeSetType changeSet);
	
	public void handleContainment(Set set, ChangeSetType changeSet);
	
	public void handleNotWellFormat(Set set, ChangeSetType changeSet);
	
	public void addInheritance(Add add);
	
	public void removeInheritance(Remove remove);
}
