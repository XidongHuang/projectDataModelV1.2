package tony.project.language.interfaces;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.Condition;

import tony.project.language.domain.Instructor;
import tony.project.language.initial.Initial;

public interface InstructorDM {

	public void savaAInstructor(Instructor instructor);
	
	public Instructor loadAnInstructor(Integer staffID);
	
	public void deleteAnInstructor(Integer staffID);
	
	public List<Instructor> loadInstructorByUpload(Integer upload);
	
	public static List<Instructor> scanByUpload(Condition condition){
		
		DynamoDBMapper mapper = Initial.getMapper();
		
		DynamoDBScanExpression scanExpression = 
				new DynamoDBScanExpression();
		
		scanExpression.addFilterCondition("Upload", condition);

		List<Instructor> scanResult = mapper.scan(Instructor.class, scanExpression);
	
		
		return scanResult;
	}
	
}
