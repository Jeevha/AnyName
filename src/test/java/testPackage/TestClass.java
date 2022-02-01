package testPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mainPackage.MainClass;
import pageObjectRepository.HomepageObject;
import pageObjectRepository.PaymentObject;
import pageObjectRepository.PlanObject;
import pageObjectRepository.ReenterNameObject;

public class TestClass extends MainClass {
	
	
	@Test(dataProvider="Enroll_Names",description="Dental Customer Enroll", priority=1)
	void Customer_Enroll(String FirstName, String LastName, String EmailID,String DOB) throws InterruptedException {
		logger=extent.startTest("New_customer");
		HomepageObject obj=new HomepageObject(driver);
		obj.Customer_Enroll(FirstName, LastName, EmailID, DOB);
	}
	
	@Test(dataProvider="Slct_plan",description="Enter address and select plan coverage", priority=2)
	void Select_plan(String Address,String City,String Zipcode) {
		logger=extent.startTest("Select_plan");
		PlanObject obj=new PlanObject(driver);
		obj.Select_plan(Address, City, Zipcode);
	}
	
	@Test(dataProvider="Re-enter_Customer_data",description="Re-enter customer data's", priority=3)
	void Reenter_Name(String FirstName, String LastName, String EmailID, String DOB) throws InterruptedException {
		logger=extent.startTest("Reenter_Name");
		ReenterNameObject obj=new ReenterNameObject(driver);
		obj.Reenter_Name(FirstName, LastName, EmailID, DOB);
	}
	
	@Test(dataProvider="Account_Payment_data",description="Account payment data's", priority=4)
	void Payment(String FirstName, String LastName, String EmailID, String DOB) {
		logger=extent.startTest("Reenter_Name");
		PaymentObject obj=new PaymentObject(driver);
		obj.Account_Payment(FirstName, LastName, EmailID, DOB);
	}
	
	@DataProvider(name="Enroll_Names")
	public Object[][] DentalEnroll(){Object[][] data = getExcelData("GuardianData.xlsx", "Customer");
	return data;
	}
	
	@DataProvider(name="Slct_plan")
	public Object[][] SelectPlan(){Object[][] data = getExcelData("GuardianData.xlsx", "Address");
	return data;
	}
	
	@DataProvider(name="Re-enter_Customer_data")
	public Object[][] Reenter_Data(){Object[][] data = getExcelData("GuardianData.xlsx", "Customer");
	return data;
	}
	
	@DataProvider(name="Account_Payment_data")
	public Object[][] Accunt_Payment(){Object[][] data = getExcelData("GuardianData.xlsx", "Customer");
	return data;
	}
}
