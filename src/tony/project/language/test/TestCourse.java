package tony.project.language.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tony.project.language.domain.Course;
import tony.project.language.interfaces.CourseDM;

public class TestCourse {

	CourseDM courseDM = new Course();
	
	@Test
	public void testSave(){
		
		String courseCode = "16WWri";
		String semester = "2016S";
		String courseName = "Writing";
		Integer levelID = 3;
		Integer instructorID = 2;
		Integer studentAmount = 13;
		
		List<Integer> students = new ArrayList<>();
		students.add(487287011);
		students.add(653525252);
		students.add(876434532);
		students.add(245435427);
		
		Double attendance = 0.05;
		
		Double passRate = 0.97;
		
		Integer failStudentAmount = 2;
		
		
		
		Course course = new Course(courseCode, semester, courseName, levelID, 
				instructorID, studentAmount, students, 
				attendance, passRate, failStudentAmount);
		
		
		courseCode = "16SSpe";
		semester = "2016S";
		courseName = "Speaking";
		levelID = 4;
		instructorID = 2;
		studentAmount = 7;
		
		students.clear();
		students.add(198745780);
		students.add(724524545);
		students.add(345687965);
		students.add(227675674);
		
		attendance = 0.03;
		failStudentAmount = 1;
		
		course = new Course(courseCode, semester, courseName, 
				levelID, instructorID, studentAmount, 
				students, attendance, passRate, failStudentAmount);
		
		
		
		
		courseDM.saveACourse(course);
		
	}
	
}
