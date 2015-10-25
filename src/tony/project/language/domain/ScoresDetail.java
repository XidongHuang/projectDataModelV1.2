package tony.project.language.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.type.TypeReference;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import tony.project.language.interfaces.ScoresDetailDM;

@DynamoDBTable(tableName = "ScoresDetail")
public class ScoresDetail extends RootObject<ScoresDetail>implements ScoresDetailDM {

	@JsonProperty("FirstName")
	private String FirstName;

	@JsonProperty("Surname")
	private String Surname;

	@JsonProperty("StudentID")
	private Integer StudentID;

	@JsonProperty("Grades")
	private Map<String, String> Grades;

	@JsonProperty("CourseCode")
	private String CourseCode;

	@DynamoDBAttribute(attributeName="FirstName")
	public String getFirstName() {return FirstName;}
	public void setFirstName(String firstName) {FirstName = firstName;}

	@DynamoDBAttribute(attributeName="Surname")
	public String getSurname() {return Surname;}
	public void setSurname(String surname) {Surname = surname;}

	@DynamoDBHashKey(attributeName="StudentID")
	public Integer getStudentID() {return StudentID;}
	public void setStudentID(Integer studentID) {StudentID = studentID;}

	@DynamoDBAttribute(attributeName="Grades")
	public Map<String, String> getGrades() {return Grades;}
	public void setGrades(Map<String, String> grades) {Grades = grades;}

	@DynamoDBRangeKey(attributeName="CourseCode")
	public String getCourseCode() {return CourseCode;}
	public void setCourseCode(String courseCode) {CourseCode = courseCode;}

	public ScoresDetail() {
		super();
	}
	
	public ScoresDetail(String firstName, String surname, Integer studentID, Map<String, String> grades,
			String courseCode) {
		super();
		FirstName = firstName;
		Surname = surname;
		StudentID = studentID;
		Grades = grades;
		CourseCode = courseCode;
	}
	
	@Override
	public String toString() {
		return "ScoresDetail [FirstName=" + FirstName + ", Surname=" + Surname + ", StudentID=" + StudentID
				+ ", Grades=" + Grades + ", CourseCode=" + CourseCode + "]";
	}
	
	@Override
	public void saveAScore(ScoresDetail score) {

		saveByMapper(score);

	}

	@Override
	public ScoresDetail loadAScore(Integer studentID, String courseCode) {

		ScoresDetail scoresDetail = loadByMapper(studentID, courseCode);

		return scoresDetail;
	}

	@Override
	public void deleteAScore(Integer studentID, String courseCode) {

		deleteByMapper(studentID, courseCode);

	}

	@Override
	public ArrayList<ScoresDetail> getScoresDetailFromJSON(String json) {

		List<ScoresDetail> scoresDetails = 
				getObjectsFromJSON(json, new TypeReference<List<ScoresDetail>>() {});

		return (ArrayList<ScoresDetail>) scoresDetails;
	}

}
