package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Component.Base_Class;
import PageObject_Component.Pf_Homepage;
import PageObject_Component.Pf_Signin;

public class Scenario_Login extends Base_Class {
	
	@Test(dataProvider="dp_Invalidlogin",dataProviderClass=DataProvider_Component.Dataprovider_Login.class,enabled=true,groups={"smoke"})
	public void testInvalidlogin(Map<String,String> loginMap) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		String TC_ID = loginMap.get("TC_ID");
		String Order_Set = loginMap.get("Order_Set");
		
		log.info("Executing the Testcase " +TC_ID+ " Order set is "+Order_Set);
		extenttest= extentreport.startTest(TC_ID);
		extenttest.log(LogStatus.PASS, "Executing the Testcase " +TC_ID+ " Order set is "+Order_Set);
		
		
		String Exp_Result = loginMap.get("Exp_Result");
		System.out.println("Expected result is "+Exp_Result);
		String Uname = loginMap.get("Uname");
		String Pwd = loginMap.get("Pwd");
		
		Pf_Homepage homepage= new Pf_Homepage(driver);
		homepage.click_signin();
		
		Pf_Signin siginpage= new Pf_Signin(driver);
		siginpage.cl_login(Uname, Pwd);
		
		String Actual_Result = siginpage.Invalid_msg.getText();
		System.out.println(Actual_Result);
		
				
		if(Actual_Result.equals(Exp_Result))
		{
			//System.out.println("Passed");
			log.info("Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
			extenttest.log(LogStatus.PASS, "Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result,extenttest.addScreenCapture(Capture_Screenshot(TC_ID, Order_Set)));
		}
		else
		{
			//System.out.println("Failed");
			log.info("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
			extenttest.log(LogStatus.FAIL, "Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result,extenttest.addScreenCapture(Capture_Screenshot(TC_ID, Order_Set)));
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
		}
		
		
		sAssert.assertAll();
		
		
	}
	
	
	@Test(dataProvider="dp_Validlogin",dataProviderClass=DataProvider_Component.Dataprovider_Login.class,enabled=true,groups={"regression"})
	public void testValidlogin(Map<String,String> loginMap) throws IOException
	{
		 SoftAssert sAssert= new SoftAssert();
		String TC_ID = loginMap.get("TC_ID");
		String Order_Set = loginMap.get("Order_Set");
		
		log.info("Executing the Testcase " +TC_ID+ " Order set is "+Order_Set);
		
		extenttest= extentreport.startTest(TC_ID);
		extenttest.log(LogStatus.PASS, "Executing the Testcase " +TC_ID+ " Order set is "+Order_Set);
		
		
		String Exp_Result = loginMap.get("Exp_Result");
		System.out.println("Expected result is "+Exp_Result);
		String Uname = loginMap.get("Uname");
		String Pwd = loginMap.get("Pwd");
		
		Pf_Homepage homepage= new Pf_Homepage(driver);
		homepage.click_signin();
		
		Pf_Signin siginpage= new Pf_Signin(driver);
		siginpage.cl_login(Uname, Pwd);
		
		String Actual_Result = homepage.lbl_username.getText();
		System.out.println(Actual_Result);
		
				
		if(Actual_Result.contains(Exp_Result))
		{
			//System.out.println("Passed");
			log.info("Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
			extenttest.log(LogStatus.PASS, "Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result,extenttest.addScreenCapture(Capture_Screenshot(TC_ID, Order_Set)));
		}
		else
		{
			//System.out.println("Failed");
			log.info("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
			extenttest.log(LogStatus.FAIL, "Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result,extenttest.addScreenCapture(Capture_Screenshot(TC_ID, Order_Set)));
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
		}
		
		
		homepage.click_signout();
		sAssert.assertAll();
		
	}

}
