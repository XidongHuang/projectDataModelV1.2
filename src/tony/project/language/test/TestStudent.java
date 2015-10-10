package tony.project.language.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import tony.project.language.domain.Student;
import tony.project.language.interfaces.StudentDM;

public class TestStudent {

	StudentDM studentDM = new Student();
	
	@Test
	public void testSave(){
		
		
		Integer studentID = 982387437;
		String firstName = "Xidong";
		String lastName = "Huang";
		Integer levelID = 4;
		List<String> courses = new ArrayList<>();
		courses.add("16FWri");
		courses.add("16FSpe");
		courses.add("16FLis");
		courses.add("16FRea");
		
		String nationlity = "China";
		String gender = "Male";
		String email = "xhuang@algomau.ca";
		Map<String, Double> attendance = new HashMap<String, Double>();
		attendance.put("16FWri", 1.0);
		attendance.put("16FSpe", 1.0);
		attendance.put("16FLis", 1.0);
		attendance.put("16FRea", 0.9);
		
		Map<String, Double> scores = new HashMap<>();
		scores.put("16FWri", 89.0);
		scores.put("16FSpe", 88.0);
		scores.put("16FLis", 84.0);
		scores.put("16FRea", 82.0);
		
		Integer graduation = 0;
		Integer pass = 1;
		
		Student student = new Student(
				studentID, firstName, lastName, 
				levelID, courses, nationlity, 
				gender, email, attendance, 
				scores, graduation, pass);
	
		studentDM.saveAStudent(student);
	}
	
	@Test
	public void testLoad(){
		
		Student student = studentDM.loadAStudent(982387437);
		System.out.println(student);
	}
	
	@Test
	public void testDelete(){
		
		studentDM.deleteAStudent(982387437);
	}
	
	
	
}
