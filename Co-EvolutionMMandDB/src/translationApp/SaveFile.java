package translationApp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.liquibase.xml.ns.dbchangelog.DocumentRoot;
import org.liquibase.xml.ns.dbchangelog.util.DbchangelogResourceFactoryImpl;

public class SaveFile
{
	public static void saveChangeLogFile(DocumentRoot docuRoot, String changeLogFilePath) throws Exception
	{
		String fileName = changeLogFilePath;
		File file = new File(fileName);

		if (!file.exists())
		{
			file.createNewFile();
		}

		ResourceSet res = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml",
				new DbchangelogResourceFactoryImpl());
		Resource resource = res.createResource(URI.createFileURI(fileName));
		resource.getContents().add(docuRoot);
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		//options.put(XMLResource.NO_NAMESPACE_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		resource.save(options);
		
		System.out.println("Fertig!");
	}
}
