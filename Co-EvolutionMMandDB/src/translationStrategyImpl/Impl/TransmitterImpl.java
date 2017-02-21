package translationStrategyImpl.Impl;

import java.util.Arrays;

import org.eclipse.emf.edapt.spi.history.Add;
import org.eclipse.emf.edapt.spi.history.Change;
import org.eclipse.emf.edapt.spi.history.CompositeChange;
import org.eclipse.emf.edapt.spi.history.ContentChange;
import org.eclipse.emf.edapt.spi.history.Create;
import org.eclipse.emf.edapt.spi.history.Delete;
import org.eclipse.emf.edapt.spi.history.MigrationChange;
import org.eclipse.emf.edapt.spi.history.Move;
import org.eclipse.emf.edapt.spi.history.OperationChange;
import org.eclipse.emf.edapt.spi.history.Remove;
import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;

import translationStrategyImpl.Interface.IChangeDataType;
import translationStrategyImpl.Interface.ICreationMapping;
import translationStrategyImpl.Interface.IDeletionMapping;
import translationStrategyImpl.Interface.IMovingMapping;
import translationStrategyImpl.Interface.IRenameMapping;
import translationStrategyImpl.Interface.ITransmitter;

public class TransmitterImpl implements ITransmitter
{
	/*
	 * 
	 */

	ICreationMapping creationMapping;
	IDeletionMapping deletionMapping;
	IMovingMapping movingMapping;
	IRenameMapping renameMapping;
	IChangeDataType changeDataType;

	public void init(){
		creationMapping = new CreationMappingImpl();
		deletionMapping = new DeletionMappingImpl();
		movingMapping = new MovingMappingImpl();
		renameMapping = new RenameMappingImpl();
		changeDataType = new ChangeDataTypeImpl();

	}
	
	public void transmitter(Change change, ChangeSetType changeSet)
	{
		init();
		if (change instanceof OperationChange)
		{
			handleOperationChange((OperationChange) change, changeSet);
		} else if (change instanceof MigrationChange)
		{
			handleMigrationChange((MigrationChange) change, changeSet);
		} else if (change instanceof CompositeChange)
		{
			handleCompositeChange((CompositeChange) change, changeSet);
		} else if (change instanceof Create)
		{
			creationMapping.handleCreationMapping((Create) change, changeSet);
		} else if (change instanceof Set)
		{
			/*
			 * Set is complex. Because if the history file is not well-form, the
			 * information of the Set tag must be analysis. which information
			 * should be belonged to which class or reference or attribute.
			 * 
			 */

			/*
			 * eType means the data type changing getOldDataValue and
			 * getOldReferenceValue means the rename in order to deal with the
			 * non-well format, if the feature name is eType and
			 * OldReferenceValue is not null, go ChangeDataType if the feature
			 * name is only eType, do nothing, because
			 */

			if (((Set) change).getFeatureName().equals("eType") && ((Set) change).getOldReferenceValue() != null)
			{
				changeDataType.handleChangeDataType((Set) change, changeSet);
			} else if (((Set) change).getFeatureName().equals("containment"))
			{
				creationMapping.handleContainment((Set) change, changeSet);
			} else if (null == ((Set) change).getOldDataValue())
			{

				creationMapping.handleNotWellFormat((Set) change, changeSet);
			} else
			{
				renameMapping.handleRenameMapping((Set) change, changeSet);
			}
		}

		else if (change instanceof Delete)
		{
			deletionMapping.handleDeletionMapping((Delete) change, changeSet);
		} else if (change instanceof Move)
		{
			movingMapping.handleMovingMapping((Move) change, changeSet);

		} else if (change instanceof Add)
		{
			creationMapping.addInheritance((Add) change);
		} else if (change instanceof Remove)
		{
			creationMapping.removeInheritance((Remove) change);
		} else
		{
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.<Object> asList(change).toString());
		}

	}

	public void handleOperationChange(OperationChange operationChange, ChangeSetType changeSet)
	{

		// in operationChange there are also create and set, we dont need to
		// handle operation and paramaters.
		for (Change change : operationChange.getChanges())
		{

			if (change instanceof Create)
			{
				if (null == ((Create) change).getReferenceName())
				{
					continue;
				}
			}
			transmitter(change, changeSet);
		}
	}

	public void handleMigrationChange(MigrationChange migrationChange, ChangeSetType changeSet)
	{
		for (Change change : migrationChange.getChanges())
		{
			if (change instanceof Create)
			{
				if (null == ((Create) change).getReferenceName())
				{
					continue;
				}
			}
			transmitter(change, changeSet);
		}

	}

	public void handleCompositeChange(CompositeChange compositeChange, ChangeSetType changeSet)
	{
		// tree search the compositeChange Node

		for (Change change : compositeChange.getChanges())
		{
			if (change instanceof Create)
			{
				if (null == ((ContentChange) change).getReferenceName())
				{
					continue;
				}
			}
			transmitter(change, changeSet);
		}

	}
}
