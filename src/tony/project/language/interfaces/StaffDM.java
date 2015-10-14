package tony.project.language.interfaces;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.Condition;

import tony.project.language.domain.Staff;
import tony.project.language.initial.Initial;

public interface StaffDM {

	public void saveAStaff(Staff staff);
	
	public Staff loadAStaff(Integer staffID);
	
	public void deleteAStaff(Integer staffID);
	
	public Staff loadStaffByAccountName(String accountName);
	
	static List<Staff> scanByAccountName(Condition condition){
		DynamoDBMapper mapper = Initial.getMapper();
		
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		
		scanExpression.addFilterCondition("AccountName-index", condition);
		
		List<Staff> scanResult = mapper.scan(Staff.class, scanExpression);
		
		
		return scanResult;
	}
}
