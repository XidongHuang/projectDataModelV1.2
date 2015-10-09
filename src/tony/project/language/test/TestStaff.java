package tony.project.language.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;

import tony.project.language.domain.Staff;
import tony.project.language.initial.Initial;
import tony.project.language.interfaces.StaffDM;

public class TestStaff {

	private StaffDM staffDM = new Staff();
	
	@Test
	public void testSave(){
		
		Staff staff = new Staff(004, "HardyChen","Hardy" , "67890", 
				"algoamu.com", 0);
		
		staffDM.saveAStaff(staff);
	}
	
	@Test
	public void testLoad(){
		
		Staff staff = staffDM.loadAStaff(004);
		System.out.println(staff);
		
		List<Staff> staffs = staffDM.loadStaffByAccountName("Hardy");
		Iterator sta = staffs.iterator();
		while(sta.hasNext()){
			System.out.println(sta.next());
		}
	}
	
	@Test
	public void testDelete(){
		
		staffDM.deleteAStaff(004);
		
	}
	
}
