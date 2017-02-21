package translationStrategyImpl.Util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.liquibase.xml.ns.dbchangelog.ColumnType2;
import org.liquibase.xml.ns.dbchangelog.ConstraintsType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;

public class AutoAddColumn
{

	// the index is for the constraint. And the index should be increased automatically.
	// when we call the addColumn, the index should increase by 1.
	static int index = 1;
	public static EList<ColumnType2> addColumn(){
		
		
		DbchangelogFactory factory = DbchangelogFactory.eINSTANCE;
		
		EList<ColumnType2> columns = new BasicEList<ColumnType2>();
		ColumnType2 column1 = factory.createColumnType2();
		ConstraintsType constraint1 = factory.createConstraintsType();
		
		/*
		 *	I used the teneo to generate the hibernate-mapping for the Ecore. Teneo will automatically generate the E_ID
		 *	dtype and E_VERSION for every new table.
		 *	So I referenced the information of the hibernate-mapping. 
		 */
		column1.setAutoIncrement(true);
		column1.setName("E_ID");
		column1.setType("BIGINT(19)");
		constraint1.setPrimaryKey("true");
		constraint1.setPrimaryKeyName("CONSTRAINT_"+Integer.toString(index));
		column1.setConstraints(constraint1);
		
		//increase by 1.
		index++;
		

		
		ColumnType2 column2 = factory.createColumnType2();
		ConstraintsType constraint2 = factory.createConstraintsType();
		
		column2.setName("E_VERSION");
		column2.setType("INT(10)");
		constraint2.setNullable("true");
		column2.setConstraints(constraint2);
		
		columns.add(column1);
		columns.add(column2);
		
		return columns;
	}
}
