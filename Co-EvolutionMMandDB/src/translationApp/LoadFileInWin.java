package translationApp;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edapt.spi.history.HistoryPackage;
import org.liquibase.xml.ns.dbchangelog.DocumentRoot;

import translationStrategyImpl.Impl.StructureMappingImpl;
import translationStrategyImpl.Interface.IStructureMapping;



public class LoadFileInWin
{
	protected static void initPackages()
	{
		EPackage.Registry.INSTANCE.put(HistoryPackage.eNS_URI, HistoryPackage.eINSTANCE);
		EcorePackage.eINSTANCE.getName();
		HistoryPackage.eINSTANCE.getName();
	}

	IStructureMapping structureMapping = new StructureMappingImpl();
	public void LoadFile(String ecoreFilePath, String hitoryFilePath, String changeLogFilePath) throws Exception
	{
		initPackages();
		
		// init ECore and history Factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("history", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet res = new ResourceSetImpl();

		// load ECore
		Resource ecoreRes = res
				.createResource(URI.createFileURI(ecoreFilePath));
		ecoreRes.load(Collections.emptyMap());

		// load history
		Resource input = res
				.createResource(URI.createFileURI(hitoryFilePath));
		input.load(Collections.emptyMap());
		EcoreUtil.resolveAll(res);

		DocumentRoot docuRoot = structureMapping.handleStructureMapping(input);
		
		SaveFile.saveChangeLogFile(docuRoot, changeLogFilePath);
		
	}
}
