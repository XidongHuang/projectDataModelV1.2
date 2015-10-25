package tony.project.language.test;

import java.io.IOException;
import java.util.ArrayList;
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
	
	Map<String, String> requiredField = new JSONHashMap<>();
	
	@Test
	public void testPOI() throws JsonParseException, JsonMappingException, IOException{
		
		String excelJson = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L1_Grammar_Ildiko Horvath.xlsx");
		String excelJson2 = excelToJSONOM.getJSON("/home/tony/Desktop/Spread_Sheet_Simple/2015 Winter_Final Marks_L2_ReadingWriting_Ashley.xlsx");
//		System.out.println(excelJson2);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, String>> jsons = mapper.readValue(excelJson2, List.class);
		
		
		
		System.out.println(jsons);
		Iterator it = jsons.iterator();
		
		while(it.hasNext()){
			
			Map<String, String> item = (HashMap<String, String>)it.next();
//			System.out.println(item);
			
			Iterator mapIt = item.entrySet().iterator();
			
			
			while(mapIt.hasNext()) {
				Map.Entry<String,String> e = (Entry) mapIt.next();
				if(e.getKey().equals("StudentID") || e.getKey().equals("FirstName")
						|| e.getKey().equals("Surname")){
					
					requiredField.put(e.getKey(), e.getValue());

				} else {
					
					grades.put(e.getKey(), e.getValue());
					requiredField.put("Grades", grades.toString());
				}
				
			}
			
			objectJSON.add(requiredField);
		}
		
		
		System.out.println(objectJSON);
		
		String oj = objectJSON.toString();
		
		
		
		
		List<ScoresDetail> scores = scoresDetailDM.getScoresDetailFromJSON(oj);
		System.out.println(scores);
//
//		for(ScoresDetail score:scores){
//			
//			score.setCourseCode("15WinL1Gar");
//			scoresDetailDM.saveAScore(score);
//		}
//		System.out.println(scores);
		
	}	
		
//		ObjectMapper mapper = new ObjectMapper();
//		JsonFactory jsonFactory = new MappingJsonFactory();
//		try {
//			@SuppressWarnings("deprecation")
//			JsonParser parser = jsonFactory.createJsonParser(excelJson);
//			JsonNode ob = mapper.readTree(excelJson);
//			System.out.println(ob);
//			
//			while(parser.nextToken() != JsonToken.END_OBJECT){
//				parser.nextToken();
//				Map<String, String> item = new JSONHashMap<>();
//				System.out.println(parser.getCurrentName());
//				if(parser.getCurrentName().equals("StudentID") || parser.getCurrentName().equals("FirstName")
//						|| parser.getCurrentName().equals("Surname")){
//					
//					item.put(parser.getCurrentName(), parser.getText());
//					objectJSON.add(item);
//					
//				} else {
//					
//					grades.put(parser.getCurrentName(), parser.getText());
//					
//					
//				}
//				
//				
//				
//			}
//			
//			objectJSON.add(grades);
//			
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		System.out.println(objectJSON);
//		
		
		
//
//		ScoresDetail s = scoresDetailDM.loadAScore(907435252, "15WinL1Gar");
//		System.out.println(s);
//		
//	}
	

}
