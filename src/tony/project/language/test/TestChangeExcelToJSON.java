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
		String excelJson2 = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L2_ReadingWriting_Ashley.xlsx");
		System.out.println(excelJson2);
		
		List<ScoresDetail> scores = scoresDetailDM.getScoresDetailFromJSON(excelJson2);
		System.out.println(scores);
//
//		for(ScoresDetail score:scores){
//			
//			score.setCourseCode("15WinL1Gar");
//			scoresDetailDM.saveAScore(score);
//		}
//		System.out.println(scores);

//		ScoresDetail s = scoresDetailDM.loadAScore(907435252, "15WinL1Gar");
//		System.out.println(s);
		
	}
	
	
}
