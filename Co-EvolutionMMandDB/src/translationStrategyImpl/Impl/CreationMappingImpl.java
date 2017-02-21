package translationStrategyImpl.Impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edapt.spi.history.Add;
import org.eclipse.emf.edapt.spi.history.Create;
import org.eclipse.emf.edapt.spi.history.Remove;
import org.eclipse.emf.edapt.spi.history.Set;
import org.liquibase.xml.ns.dbchangelog.AddColumnType;
import org.liquibase.xml.ns.dbchangelog.ChangeSetType;
import org.liquibase.xml.ns.dbchangelog.ColumnType2;
import org.liquibase.xml.ns.dbchangelog.ColumnType4;
import org.liquibase.xml.ns.dbchangelog.ConstraintsType;
import org.liquibase.xml.ns.dbchangelog.CreateTableType;
import org.liquibase.xml.ns.dbchangelog.DbchangelogFactory;
import org.liquibase.xml.ns.dbchangelog.DropColumnType;
import org.liquibase.xml.ns.dbchangelog.DropTableType;

import translationStrategyImpl.Interface.ICreationMapping;
import translationStrategyImpl.Util.AutoAddColumn;
import translationStrategyImpl.Util.DataTypeMapping;



public class CreationMappingImpl implements ICreationMapping
{
		// for the creation there are several situations. Create the table , column and reference.

		/*
		 * Map handledAttribute is to store the mapping of class and its Attributes
		 * Map handledRefer is to store the mapping of class and its Reference
		 * Map containment is to store the containment of a reference and the value of the containment.
		 * Map storeInheritance is to store the relationship of the inheritacne. Mapping of class and its subclasses.
		 */

		Map<String, HashSet<String>> handledAttribute = new HashMap<String, HashSet<String>>();

		Map<String, HashSet<String>> handledRefer = new HashMap<String, HashSet<String>>();

		Map<String, Boolean> containment = new HashMap<String, Boolean>();

		Map<String, HashSet<String>> storeInheritance = new HashMap<String, HashSet<String>>();

		@Override
		public void handleCreationMapping(Create create, ChangeSetType changeSet)
		{
			// get the information of ReferenceName.
			String referName = ((Create) create).getReferenceName();

			// eClassifiers stand for the class
			if ("eClassifiers".equals(referName))
			{
				if (((EClass) create.getElement()).getName() != null)
				{
					changeSet.getCreateTable().add(createTable(create));
				}
			}
			// eStructuralFeatures has two situation: attribute and reference.
			if ("eStructuralFeatures".equals(referName))
			{

				// Attribute.
				if (create.getElement() instanceof EAttribute)
				{

					// if no name or no date type , jump
					if (null == ((EAttribute) create.getElement()).getName()
							|| null == ((EAttribute) create.getElement()).getEAttributeType().getName())
					{
					} else
					{
						changeSet.getAddColumn().add(createColumn(create));
					}
				}
				if (create.getElement() instanceof EReference)
				{

					// if no name or no date type , jump
					if (null == ((EReference) create.getElement()).getName()
							|| null == ((EReference) create.getElement()).getEReferenceType().getName())
					{

					} else
					{

						handleReference(create, changeSet);
					}
				}
			}

		}
		
		
		/*
		 *  operator  create containment
		 */
		public void handleContainment(Set set, ChangeSetType changeSet)
		{
			String referName = ((ENamedElement) set.getElement()).getName();
			Boolean contain = ((EReference) set.getElement()).isContainment();

			if (containment.get(referName) != contain)
			{
				if (contain)
				{
					setConTrue(set, changeSet);
				} else
				{
					setConFalse(set, changeSet);
				}

			}

		}

		String conValue;

		private void handleReference(Create create, ChangeSetType changeSet)
		{
			/*
			 * there is a situation in reference. The reference is deleted before
			 * used Robustheit
			 */
			if (create.getChanges().isEmpty())
			{
				if (((EReference) create.getElement()).isContainment())
				{
					changeSet.getAddColumn().add(referWithContainment(create));
				} else
				{
					changeSet.getCreateTable().add(referWithOutContainment(create));
				}

			} else
			{

				create.getChanges().forEach(s ->
				{
					if (s.getFeatureName().equals("containment"))
					{
						conValue = s.getDataValue();
					}
				});

				if (null == conValue || conValue.equals("false"))
				{
					changeSet.getCreateTable().add(referWithOutContainment(create));
				} else
				{
					changeSet.getAddColumn().add(referWithContainment(create));
				}

			}

		}

		public void addInheritance(Add add)
		{
			String SuperTypeName = ((EClass) (add.getReferenceValue())).getName();
			
			String className = ((EClass)add.getElement()).getName();
			
			if (storeInheritance.containsKey(SuperTypeName))
			{
				HashSet<String> addSubClasses = storeInheritance.get(SuperTypeName);
				addSubClasses.add(className);
				storeInheritance.put(SuperTypeName, addSubClasses);

			} else
			{
				HashSet<String> addSubClasses = new HashSet<String>();
				addSubClasses.add(className);
				storeInheritance.put(SuperTypeName, addSubClasses);
			}
			
		}

		public void removeInheritance(Remove remove)
		{
			String SuperTypeName = ((EClass) (remove.getReferenceValue())).getName();
			
			String className = ((EClass)remove.getElement()).getName();
			
			if (storeInheritance.containsKey(SuperTypeName)){
				HashSet<String> addSubClasses = storeInheritance.get(SuperTypeName);
				addSubClasses.remove(className);
				storeInheritance.put(SuperTypeName, addSubClasses);
			}
		}

		// table name is from the class name
		String tableName;

		private CreateTableType createTable(Create create)
		{

			CreateTableType table = DbchangelogFactory.eINSTANCE.createCreateTableType();

			// non_well format check
			if (create.getChanges().isEmpty())
			{
				tableName = ((ENamedElement) create.getElement()).getName();
			} else
			{
				create.getChanges().forEach(s ->
				{
					if (s.getFeatureName().equals("name"))
					{
						tableName = s.getDataValue();
					}

					if (s instanceof Add)
					{
						addInheritance((Add) s);
					} else if (s instanceof Remove)
					{
						removeInheritance((Remove) s);
					}
				});
			}

			table.setTableName(tableName);
			table.getColumn().addAll(AutoAddColumn.addColumn());

			return table;

		}

		String columnName;
		String eDataType;

		private AddColumnType createColumn(Create create)
		{

			AddColumnType addColumn = DbchangelogFactory.eINSTANCE.createAddColumnType();
			ColumnType4 column = DbchangelogFactory.eINSTANCE.createColumnType4();
			ConstraintsType constraint = DbchangelogFactory.eINSTANCE.createConstraintsType();

			String tableName = ((ENamedElement) create.getTarget()).getName();

			if (create.getChanges().isEmpty())
			{
				columnName = ((ENamedElement) create.getElement()).getName();

				eDataType = ((EAttribute) create.getElement()).getEAttributeType().getName();
			} else
			{
				create.getChanges().forEach(s ->
				{

					if (s.getFeatureName().equals("name"))
					{
						columnName = s.getDataValue();
					}

					if (s.getFeatureName().equals("eType"))
					{
						eDataType = ((EDataType) (s.getReferenceValue())).getName();
					}
				});
			}

			
			// set table name
			addColumn.setTableName(tableName);
			// set Attribute name
			column.setName(columnName);
			// set Etype
			String dataType = DataTypeMapping.getDataType(eDataType);
			column.setType(dataType);
			// set constraints
			constraint.setNullable("true");
			column.setConstraints(constraint);

			// add the addcolumn into changeSet
			addColumn.getColumn().add(column);

			// add the handled attribute into the hashmapp
			if (handledAttribute.containsKey(tableName))
			{
				HashSet<String> addAttri = handledAttribute.get(tableName);
				addAttri.add(columnName);
				handledAttribute.put(tableName, addAttri);

			} else
			{
				HashSet<String> addAttri = new HashSet<String>();
				addAttri.add(columnName);
				handledAttribute.put(tableName, addAttri);
			}

			return addColumn;
		}

		// referEClassName means the class has reference
		String referEClassName;

		// The referName means the name of the reference.
		String referName;

		// referredEClassName means the referred EClass
		String referredEClassName;

		public void setRelativName(Create create)
		{

			EReference handleRefer = ((EReference) create.getElement());
			if (create.getChanges().isEmpty())
			{

				referName = handleRefer.getName();
				referredEClassName = handleRefer.getEReferenceType().getName();
			} else
			{

				create.getChanges().forEach(s ->
				{
					if (s.getFeatureName().equals("name"))
					{
						referName = s.getDataValue();
					}

					if (s.getFeatureName().equals("eType"))
					{
						referredEClassName = ((EClass) (s.getReferenceValue())).getName();
					}
				});
			}
		}

		public AddColumnType referWithContainment(Create create)
		{

			/*
			 * handle the reference with containment When the reference has
			 * containment, the reference value will be added into the class which
			 * is referenced.
			 */

			AddColumnType addColumn = columnForRefer();
			referEClassName = ((ENamedElement) create.getTarget()).getName();

			setRelativName(create);
			addColumn.setTableName(referredEClassName);

			// generate the column which will be added into the referenced table.
			/*
			 * why two column? I have used the Teneo to generate the
			 * Hibernate-mapping for the Ecore. In accordance with the information
			 * from the Hibernate-Mapping I think there should be two column.
			 */

			// the columnName is also referenced by the Hibernate-Mapping
			String columnName1 = referEClassName + "_" + referName + "_e_id";
			String columnName2 = referEClassName + "_" + referName + "_idx";
			// the data type is referenced by the Hibernate-Mapping
			addColumn.getColumn().get(0).setName(columnName1);
			addColumn.getColumn().get(1).setName(columnName2);

			// add the handled attribute into the hashmapp
			if (handledRefer.containsKey(referEClassName))
			{
				HashSet<String> addRefer = handledRefer.get(referEClassName);
				addRefer.add(referName);
				handledRefer.put(tableName, addRefer);

			} else
			{
				HashSet<String> addRefer = new HashSet<String>();
				addRefer.add(referName);
				handledRefer.put(referEClassName, addRefer);
			}

			// true is 1
			containment.put(referName, true);

			return addColumn;
		}

		public CreateTableType referWithOutContainment(Create create)
		{
			/*
			 * when the reference has no containment, we should generate a new table
			 * for this reference. The idea is referenced by Hibernate-Mapping of
			 * the history file.
			 */
			CreateTableType table = tableForRefer();

			// set the refername and referredEClassName
			setRelativName(create);
			/*
			 * the newTableName the columnNames and the data type of the columns are
			 * all referenced by the Hiberante-Mapping.
			 */

			referEClassName = ((ENamedElement) create.getTarget()).getName();

			String newTableName = referEClassName + "_" + referName;

			table.setTableName(newTableName);

			String columnName1 = referEClassName + "_e_id";
			String columnName2 = referredEClassName + "_e_id";
			String columnName3 = newTableName + "_idx";

			table.getColumn().get(0).setName(columnName1);
			table.getColumn().get(1).setName(columnName2);
			table.getColumn().get(2).setName(columnName3);

			if (handledRefer.containsKey(referEClassName))
			{
				HashSet<String> addRefer = handledRefer.get(referEClassName);
				addRefer.add(referName);
				handledRefer.put(tableName, addRefer);

			} else
			{
				HashSet<String> addRefer = new HashSet<String>();
				addRefer.add(referName);
				handledRefer.put(referEClassName, addRefer);
			}
			containment.put(referName, false);

			return table;

		}

		private AddColumnType columnForRefer()
		{
			AddColumnType addColumn = DbchangelogFactory.eINSTANCE.createAddColumnType();

			// generate the column which will be added into the referenced table.
			/*
			 * why two column? I have used the Teneo to generate the
			 * Hibernate-mapping for the Ecore. In accordance with the information
			 * from the Hibernate-Mapping I think there should be two column.
			 */
			ColumnType4 column1 = DbchangelogFactory.eINSTANCE.createColumnType4();
			ColumnType4 column2 = DbchangelogFactory.eINSTANCE.createColumnType4();
			ConstraintsType constraint1 = DbchangelogFactory.eINSTANCE.createConstraintsType();
			ConstraintsType constraint2 = DbchangelogFactory.eINSTANCE.createConstraintsType();
			constraint1.setNullable("true");
			constraint2.setNullable("true");

			// the columnName is also referenced by the Hibernate-Mapping
			// the data type is referenced by the Hibernate-Mapping
			column1.setConstraints(constraint1);
			column1.setType("BIGINT(19)");
			column1.setConstraints(constraint2);
			column2.setType("INT(10)");

			addColumn.getColumn().add(column1);
			addColumn.getColumn().add(column2);

			return addColumn;

		}

		private CreateTableType tableForRefer()
		{
			CreateTableType table = DbchangelogFactory.eINSTANCE.createCreateTableType();

			ColumnType2 column1 = DbchangelogFactory.eINSTANCE.createColumnType2();
			ColumnType2 column2 = DbchangelogFactory.eINSTANCE.createColumnType2();
			ColumnType2 column3 = DbchangelogFactory.eINSTANCE.createColumnType2();

			ConstraintsType constraint1 = DbchangelogFactory.eINSTANCE.createConstraintsType();
			ConstraintsType constraint2 = DbchangelogFactory.eINSTANCE.createConstraintsType();
			ConstraintsType constraint3 = DbchangelogFactory.eINSTANCE.createConstraintsType();
			constraint1.setNullable("true");
			constraint2.setNullable("true");
			constraint3.setNullable("true");

			column1.setType("BIGINT(19)");
			column1.setConstraints(constraint1);
			column2.setType("BIGINT(19)");
			column2.setConstraints(constraint2);
			column3.setType("INT(10)");
			column3.setConstraints(constraint3);

			table.getColumn().add(column1);
			table.getColumn().add(column2);
			table.getColumn().add(column3);

			return table;

		}

		// if the history file is not-well format 
		public void handleNotWellFormat(Set set, ChangeSetType changeSet)
		{

			Object object = set.getElement();

			if (object instanceof EAttribute)
			{
				if (((EAttribute) object).getEContainingClass() == null)
				{
				} else
				{
					String conEClass = ((EAttribute) object).getEContainingClass().getName();
					String columnName = ((ENamedElement) set.getElement()).getName();

					/*
					 * handel the non-well form, if they are handled, escapes. if
					 * the feature is "eType", escapes
					 */
					if (handledAttribute.containsKey(conEClass) && handledAttribute.get(conEClass).contains(columnName))
					{
					} else
					{
						if (set.getFeatureName().equals("name"))
						{
						
							AddColumnType addColumn = DbchangelogFactory.eINSTANCE.createAddColumnType();
							ColumnType4 column = DbchangelogFactory.eINSTANCE.createColumnType4();
							ConstraintsType constraint = DbchangelogFactory.eINSTANCE.createConstraintsType();

							String eType = ((EAttribute) set.getElement()).getEAttributeType().getName();

							// set table name
							addColumn.setTableName(conEClass);
							// set Attribute name
							column.setName(columnName);
							// set Etype
							String dataType = DataTypeMapping.getDataType(eType);
							column.setType(dataType);
							// set constraints
							constraint.setNullable("true");
							column.setConstraints(constraint);

							// add the addcolumn into changeSet
							addColumn.getColumn().add(column);
							changeSet.getAddColumn().add(addColumn);
						}
					}
				}
			}

			if (object instanceof EReference)
			{
				if (((EReference) object).getEContainingClass() == null)
				{
				} else
				{
					referEClassName = ((EReference) object).getEContainingClass().getName();
					referName = ((ENamedElement) set.getElement()).getName();

					if (handledRefer.containsKey(referEClassName) && handledRefer.get(referEClassName).contains(referName))
					{

					}

					else if (set.getFeatureName().equals("name"))
					{
						if (((EReference) object).isContainment())
						{

							AddColumnType addColumn = columnForRefer();

							referredEClassName = ((EReference) object).getEReferenceType().getName();

							addColumn.setTableName(referredEClassName);

							// generate the column which will be added into the
							// referenced table.
							/*
							 * why two column? I have used the Teneo to generate the
							 * Hibernate-mapping for the Ecore. In accordance with
							 * the information from the Hibernate-Mapping I think
							 * there should be two column.
							 */

							// the columnName is also referenced by the
							// Hibernate-Mapping
							String columnName1 = referEClassName + "_" + referName + "_e_id";
							String columnName2 = referEClassName + "_" + referName + "_idx";
							// the data type is referenced by the Hibernate-Mapping
							addColumn.getColumn().get(0).setName(columnName1);
							addColumn.getColumn().get(1).setName(columnName2);

							// add the handled attribute into the hashmapp
							if (handledRefer.containsKey(referEClassName))
							{
								HashSet<String> addRefer = handledRefer.get(referEClassName);
								addRefer.add(referName);
								handledRefer.put(tableName, addRefer);

							} else
							{
								HashSet<String> addRefer = new HashSet<String>();
								addRefer.add(referName);
								handledRefer.put(referEClassName, addRefer);
							}

							// true is 1
							containment.put(referName, true);

							changeSet.getAddColumn().add(addColumn);

						} else
						{
							CreateTableType table = tableForRefer();

							String newTableName = referEClassName + "_" + referName;

							table.setTableName(newTableName);

							EReference handleRefer = ((EReference) object);
							referredEClassName = handleRefer.getEReferenceType().getName();

							String columnName1 = referEClassName + "_e_id";
							String columnName2 = referredEClassName + "_e_id";
							String columnName3 = newTableName + "_idx";

							table.getColumn().get(0).setName(columnName1);
							table.getColumn().get(1).setName(columnName2);
							table.getColumn().get(2).setName(columnName3);

							/*
							 * the newTableName the columnNames and the data type of
							 * the columns are all referenced by the
							 * Hiberante-Mapping.
							 */

							if (handledRefer.containsKey(referEClassName))
							{
								HashSet<String> addRefer = handledRefer.get(referEClassName);
								addRefer.add(referName);
								handledRefer.put(tableName, addRefer);

							} else
							{
								HashSet<String> addRefer = new HashSet<String>();
								addRefer.add(referName);
								handledRefer.put(referEClassName, addRefer);
							}
							containment.put(referName, false);

							table.setTableName(newTableName);

							changeSet.getCreateTable().add(table);
						}
					}
				}
			}
		}

		public void setConTrue(Set set, ChangeSetType changeSet)
		{

			referEClassName = ((EReference) set.getElement()).getEContainingClass().getName();
			referName = ((ENamedElement) set.getElement()).getName();

			// delete the table which is create by the reference whose containment
			// is false.

			DropTableType dropTable = DbchangelogFactory.eINSTANCE.createDropTableType();
			String delTableName = referEClassName + "_" + referName;
			dropTable.setTableName(delTableName);
			changeSet.getDropTable().add(dropTable);

			// add the new column to the referred table
			AddColumnType addColumn = columnForRefer();

			referredEClassName = ((EReference) set.getElement()).getEReferenceType().getName();

			addColumn.setTableName(referredEClassName);

			// generate the column which will be added into the
			// referenced table.
			/*
			 * why two column? I have used the Teneo to generate the
			 * Hibernate-mapping for the Ecore. In accordance with the information
			 * from the Hibernate-Mapping I think there should be two column.
			 */

			// the columnName is also referenced by the
			// Hibernate-Mapping
			String columnName1 = referEClassName + "_" + referName + "_e_id";
			String columnName2 = referEClassName + "_" + referName + "_idx";
			// the data type is referenced by the Hibernate-Mapping
			addColumn.getColumn().get(0).setName(columnName1);
			addColumn.getColumn().get(1).setName(columnName2);

			containment.put(referName, true);
			changeSet.getAddColumn().add(addColumn);

		}

		public void setConFalse(Set set, ChangeSetType changeSet)
		{

			// drop the two column
			DropColumnType dropColumn1 = DbchangelogFactory.eINSTANCE.createDropColumnType();
			DropColumnType dropColumn2 = DbchangelogFactory.eINSTANCE.createDropColumnType();

			referEClassName = ((EReference) set.getElement()).getEContainingClass().getName();
			referName = ((ENamedElement) set.getElement()).getName();
			referredEClassName = ((EReference) set.getElement()).getEReferenceType().getName();

			String columnName1 = referEClassName + "_" + referName + "_e_id";
			String columnName2 = referEClassName + "_" + referName + "_idx";

			dropColumn1.setColumnName(columnName1);
			dropColumn2.setColumnName(columnName2);
			dropColumn1.setTableName(referredEClassName);
			dropColumn2.setTableName(referredEClassName);

			changeSet.getDropColumn().add(dropColumn1);
			changeSet.getDropColumn().add(dropColumn2);

			// create the table

			CreateTableType table = tableForRefer();

			String newTableName = referEClassName + "_" + referName;

			table.setTableName(newTableName);

			String columnN1 = referEClassName + "_e_id";
			String columnN2 = referredEClassName + "_e_id";
			String columnN3 = newTableName + "_idx";

			table.getColumn().get(0).setName(columnN1);
			table.getColumn().get(1).setName(columnN2);
			table.getColumn().get(2).setName(columnN3);

			/*
			 * the newTableName the columnNames and the data type of the columns are
			 * all referenced by the Hiberante-Mapping.
			 */

			containment.put(referName, false);

			table.setTableName(newTableName);
			changeSet.getCreateTable().add(table);

		}
}
