package tony.project.language.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tony.project.language.domain.ScoresDetail;
import tony.project.language.formatter.ExcelToJSON;
import tony.project.language.formatter.JSONHashMap;
import tony.project.language.interfaces.ExcelToJSONOM;
import tony.project.language.interfaces.ScoresDetailDM;

public class TestChangeExcelToJSON {

	ExcelToJSONOM excelToJSONOM = new ExcelToJSON();
	
	ScoresDetailDM scoresDetailDM = new ScoresDetail();
	
	List<Map<String, String>> objectJSON = new ArrayList<>();
	Map<String, String> grades =  new JSONHashMap<>();
	
	Map<String, String> requiredField = null;
	
	@Test
	public void testPOI() throws JsonParseException, JsonMappingException, IOException{
		
		String excelJson = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L1_Grammar_Ildiko Horvath.xlsx");
		String excelJson2 = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L2_ReadingWriting_Ashley.xlsx");


		
		
		
		List<ScoresDetail> scores = scoresDetailDM.getScoresDetailFromJSON(excelJson2);
		System.out.println(scores);

		List<ScoresDetail> l = new ArrayList<>();
		
		
		for(ScoresDetail score:scores){
			
			score.setCourseCode("15FL2Gar");
			l.add(score);
		
		}
		
		
		scoresDetailDM.batchSaveScoresDetail(scores);
		
		
//		System.out.println(scores);
//		ScoresDetail s1 = scoresDetailDM.loadAScore(907435252, "15WinL1Gar");
//		ScoresDetail s2 = scoresDetailDM.loadAScore(525445445, "15WinL1Gar");
//		System.out.println(s1);
//		System.out.println(mapper.writeValueAsString(Arrays.asList(s1, s2)));
		
	}	
	

}
