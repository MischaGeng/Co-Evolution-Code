package translationStrategyImpl.Impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edapt.spi.history.Change;
import org.eclipse.emf.edapt.spi.history.History;
import org.eclipse.emf.edapt.spi.history.Release;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.DatabaseChangeLogType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;
import org.liquibase.xml.ns.dbchangelog.DocumentRoot;

import translationStrategyImpl.Interface.IStructureMapping;
import translationStrategyImpl.Interface.ITransmitter;


public class StructureMappingImpl implements IStructureMapping
{

	ITransmitter transmitter = new TransmitterImpl();
	
	int indexID = 1;
	
	@Override
	public DocumentRoot handleStructureMapping(Resource res)
	{
		// Tree search for the history file.
		// Maybe there are many history tag in one history file. But until now I have seen only one history node in a history file.
		// create the root node

		DocumentRoot docuRoot = DbchangelogFactory.eINSTANCE.createDocumentRoot();
		
		res.getContents().stream().filter(f -> f instanceof History).forEach(h ->
		{
			// history node maps databaseChangeLog node of LiquiBase.
			DatabaseChangeLogType dbChangeLogType = historyMapping();

			// tree search loop for every tag.
			((History) h).getReleases().forEach(r ->
			{

				// if there are nothing in the release, skip
				if (0 == r.getChanges().size())
				{
					return;
				}

				// add the changeSet into databaseChangeLog
				dbChangeLogType.getChangeSet().add(releaseMapping(r));

				// for one release mapping one changeSet, this means the ID will
				// be automatically increased.
			
			});

			// add the databaseChangeLog into the document file.
			docuRoot.setDatabaseChangeLog(dbChangeLogType);


		});

		return docuRoot;

	}
	
	
	public DatabaseChangeLogType historyMapping()
	{
		return DbchangelogFactory.eINSTANCE.createDatabaseChangeLogType();
	}

	
	public ChangeSetType releaseMapping(Release release)
	{

		/*
		 * there are maybe many releases in one history file. So it't better to
		 * use the loop for release.
		 */
		// for one release there should be only one changeSet which to bemapped.
		ChangeSetType changeSet = DbchangelogFactory.eINSTANCE.createChangeSetType();

		changeSet.setId(Integer.toString(indexID));

		// the author can be changed. here is only an example.
		changeSet.setAuthor("Zengchao");
		
		for (Change change : release.getChanges())
		{
			transmitter.transmitter(change, changeSet);
		}
		indexID++;
		return changeSet;
	}


}
