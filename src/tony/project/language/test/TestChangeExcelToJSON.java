package tony.project.language.test;

import org.junit.Test;

import tony.project.language.formatter.ExcelToJSON;
import tony.project.language.interfaces.ExcelToJSONOM;

public class TestChangeExcelToJSON {

	ExcelToJSONOM excelToJSONOM = new ExcelToJSON();
	
	@Test
	public void testPOI(){
		
		String excelJson = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L1_Grammar_Ildiko Horvath.xlsx");
		
		System.out.println(excelJson);
		
		
	}
	
	
}
