package tony.project.language.test;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import tony.project.language.domain.ScoresDetail;
import tony.project.language.formatter.ExcelToJSON;
import tony.project.language.interfaces.ExcelToJSONOM;
import tony.project.language.interfaces.ScoresDetailDM;

public class TestChangeExcelToJSON {

	ExcelToJSONOM excelToJSONOM = new ExcelToJSON();
	
	ScoresDetailDM scoresDetailDM = new ScoresDetail();
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void testPOI(){
		
		String excelJson = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L1_Grammar_Ildiko Horvath.xlsx");
		
		System.out.println(excelJson);
		
		try {
			
			List<ScoresDetail> scores = objectMapper.readValue(excelJson, new TypeReference<List<ScoresDetail>>(){});
//			System.out.println(scores);
			
		} catch (JsonParseException e) {

			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
//		List<ScoresDetail> scores = scoresDetailDM.getScoresDetailFromJSON(excelJson);
//
//		for(ScoresDetail score:scores){
//			
//			score.setCourseCode("15WinL1Gar");
//			scoresDetailDM.saveAScore(score);
//		}
//		System.out.println(scores);

		ScoresDetail s = scoresDetailDM.loadAScore(907435252, "15WinL1Gar");
		System.out.println(s);
		
	}
	
	
}
