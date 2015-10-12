package tony.project.language.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import tony.project.language.domain.Instructor;
import tony.project.language.domain.Staff;
import tony.project.language.interfaces.InstructorDM;
import tony.project.language.interfaces.StaffDM;

public class TestInstructor {

	StaffDM staffDM = new Staff();
	InstructorDM instructorDM = new Instructor();
	
	@Test
	public void testSave(){
		List<Staff> staff = staffDM.loadStaffByAccountName("ashley");
		Integer staffID = staff.get(0).getStaffID();
		
		String instructorName = staff.get(0).getStaffName();
		
		List<Integer> levelID = new ArrayList<Integer>();
		levelID.add(1);
		levelID.add(2);
		
		List<String> courses = new ArrayList<>();
		courses.add("L1Gra");
		courses.add("L2Wri");
		
		Boolean upload = false;
		Boolean evaluation = true;
		
		Instructor instructor = new Instructor(staffID, instructorName, 
				levelID, courses, upload, evaluation);
		
		instructorDM.savaAInstructor(instructor);
		
		staff = staffDM.loadStaffByAccountName("XiongHuang");
		staffID = staff.get(0).getStaffID();
		instructorName = staff.get(0).getStaffName();
		
		levelID.clear();
		levelID.add(3);
		levelID.add(4);
		
		courses.clear();
		courses.add("L3Lis");
		courses.add("L4Wri");
		
		upload = false;
		evaluation = false;
		
		instructor = new Instructor(staffID, instructorName, levelID, courses, upload, evaluation);
		instructorDM.savaAInstructor(instructor);
		
	}
	
	
	@Test
	public void testLoad(){
		
		Instructor instructor = instructorDM.loadAnInstructor(002);
		System.out.println(instructor);
		
		List<Instructor> instructors = instructorDM.loadInstructorByUpload(0);
		Iterator<Instructor> ins = instructors.iterator();
		
		
		while(ins.hasNext()){
			System.out.println(ins.next());
			
		}
	}
	
	
	@Test
	public void testDelete(){
		
		instructorDM.deleteAnInstructor(002);
		
	}
	
	
}
