package tony.project.language.domain;

import java.util.List;

public class Course {

	private String courseCode;
	private String semester;
	private String courseName;
	private String levelID;
	private String instructorID;
	private Integer studentAmount;
	private List<Integer> students;
	private Double attendance;
	private Integer failStudentAmount;
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLevelID() {
		return levelID;
	}
	public void setLevelID(String levelID) {
		this.levelID = levelID;
	}
	public String getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}
	public Integer getStudentAmount() {
		return studentAmount;
	}
	public void setStudentAmount(Integer studentAmount) {
		this.studentAmount = studentAmount;
	}
	public List<Integer> getStudents() {
		return students;
	}
	public void setStudents(List<Integer> students) {
		this.students = students;
	}
	public Double getAttendance() {
		return attendance;
	}
	public void setAttendance(Double attendance) {
		this.attendance = attendance;
	}
	public Integer getFailStudentAmount() {
		return failStudentAmount;
	}
	public void setFailStudentAmount(Integer failStudentAmount) {
		this.failStudentAmount = failStudentAmount;
	}
	
	
	
	
	
	
}
