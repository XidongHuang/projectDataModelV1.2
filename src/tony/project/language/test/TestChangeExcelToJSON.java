package tony.project.language.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
//		System.out.println(excelJson2);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, String>> jsons = mapper.readValue(excelJson, List.class);
		
		
		
//		System.out.println("--"+jsons);
		Iterator it = jsons.iterator();
		
		while(it.hasNext()){
			
			Map<String, String> item = (HashMap<String, String>)it.next();
//			System.out.println(item);
			
			Iterator mapIt = item.entrySet().iterator();
			
			requiredField = new JSONHashMap<>();
			
			while(mapIt.hasNext()) {
				
//				System.out.println(mapIt.next());
				
				Map.Entry<String,String> e = (Entry) mapIt.next();
				
				if(e.getKey().equals("StudentID") || e.getKey().equals("FirstName")
						|| e.getKey().equals("Surname")){
					
					requiredField.put(e.getKey(), e.getValue());

				} else {
					
					grades.put(e.getKey(), e.getValue());
					requiredField.put("Grades", grades.toString());
					
				}
				
			}
//			System.out.println(requiredField);
			objectJSON.add(requiredField);
//			System.out.println();
//			System.out.println(objectJSON);
		}
		
		
		System.out.println(objectJSON);
		
		String oj = objectJSON.toString();
		
		
		
		List<ScoresDetail> scores = scoresDetailDM.getScoresDetailFromJSON(oj);
		System.out.println(scores);

		//Arrays.asList();
		
		
//		for(ScoresDetail score:scores){
//			
//			score.setCourseCode("15WinL1Gar");
//			scoresDetailDM.saveAScore(score);
//		}
		
		
		System.out.println(scores);
		ScoresDetail s1 = scoresDetailDM.loadAScore(907435252, "15WinL1Gar");
		ScoresDetail s2 = scoresDetailDM.loadAScore(525445445, "15WinL1Gar");
		System.out.println(s1);
		System.out.println(mapper.writeValueAsString(Arrays.asList(s1, s2)));
		
	}	
	

}
