package tony.project.language.test;

import java.util.List;

import org.junit.Test;

import tony.project.language.domain.ScoresDetail;
import tony.project.language.formatter.ExcelToJSON;
import tony.project.language.interfaces.ExcelToJSONOM;
import tony.project.language.interfaces.ScoresDetailDM;

public class TestChangeExcelToJSON {

	ExcelToJSONOM excelToJSONOM = new ExcelToJSON();
	
	ScoresDetailDM scoresDetailDM = new ScoresDetail();
	
	@Test
	public void testPOI(){
		
		String excelJson = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L1_Grammar_Ildiko Horvath.xlsx");
		
		System.out.println(excelJson);
		
		List<ScoresDetail> scores = scoresDetailDM.getScoresDetailFromJSON(excelJson);
		System.out.println(scores);
		
	}
	
	
}
