package translationStrategyImpl.Util;

public class DataTypeMapping
{
	static String DbDataType;
	public static String getDataType(String eDataType){
		/*
		 * data type mapping between Ecore and H2
		 * return the data type of the H2 database
		 */
		
		if(eDataType.equals("EString"))
		{
			DbDataType = "VARCHAR(255)";
		} else if (eDataType.equals("EInt")){
			DbDataType = "INT(10)";
		} else if (eDataType.equals("EBoolean")){
			DbDataType = "BOOLEAN";
		} else if (eDataType.equals("EByte")){
			DbDataType = "TINYINT";
		} else if (eDataType.equals("EChar")){
			DbDataType = "CHAR(10)";
		} else if (eDataType.equals("EDouble")){
			DbDataType = "DOUBLE(10)";
		} else if (eDataType.equals("EFloat")){
			DbDataType = "REAL(10)";
		} else if (eDataType.equals("ELong")) {
			DbDataType = "BIGINT(10)";
		} else if (eDataType.equals("EShort")) {
			DbDataType = "SMALLINT(10)";
		} else {
			throw new IllegalArgumentException("Unhandled Data Types");
		}
		
		return DbDataType;
	}
}
