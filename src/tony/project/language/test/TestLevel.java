package tony.project.language.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tony.project.language.domain.Level;
import tony.project.language.interfaces.LevelDM;

public class TestLevel {
	
	LevelDM LevelDM = new Level();
	
	@Test
	public void testSave(){
		
		List<String> courses = new ArrayList<>();
		courses.add("Writing");
		courses.add("Listening");
		courses.add("Speaking");
		courses.add("Reading");
		
		Integer studentAmount = 16;
		
		List<Integer> students = new ArrayList<>();
		students.add(149635870);
		students.add(234234134);
		students.add(989237498);
		
		Double failRate = 0.13;
		Integer failStudentAmount = 3;
		List<Integer> failStudent = new ArrayList<>();
		failStudent.add(149635870);
		
		Level level = new Level(1, "2016W", "Level1", courses, 
				studentAmount, students, failRate, failStudentAmount, 
				failStudent);
		
		Integer levelID = 2;
		String semester = "2016F";
		String levelNO = "Leve2";
		studentAmount = 17;
		
		students.clear();
		students.add(356531113);
		students.add(754323542);
		students.add(234645411);
		students.add(345655445);
		
		failRate = 0.09;
		failStudent.clear();
		
		failStudent.add(345655445);
		
		level = new Level(levelID, semester, levelNO, 
				courses, studentAmount, students, failRate, failStudentAmount, failStudent);
		
		LevelDM.saveALevel(level);
		
	}
	
	
	@Test
	public void testLoad(){
		
		Level level = LevelDM.loadALevel(2, "2016F");
		
		System.out.println(level);
		
	}
	
	
	@Test
	public void testDelete(){
		
		
		LevelDM.deleteALevel(2, "2016F");
		
	}
	
}
