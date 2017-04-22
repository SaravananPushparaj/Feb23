package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.Pf_Homepage;
import PageObject_Component.Pf_Signin;

public class Scenario_Search extends Base_Class {
	
	@Test(dataProvider="dp_invalidsearch",dataProviderClass=DataProvider_Component.Dataprovider_Login.class,enabled=true,groups={"smoke"})
	public void testInvalidsearch(Map<String,String> Search) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		
		log.info("Executing the Testcase " +TC_ID+ " Order set is "+Order_Set);
		
		String Exp_Result = Search.get("Exp_Result");
		System.out.println("Expected result is "+Exp_Result);
		
		Pf_Homepage homepage= new Pf_Homepage(driver);
		homepage.Search(Search_Item);
		
		String Actual_Result = homepage.Search_res_invalid.getText();
		System.out.println(Actual_Result);
		
				
		if(Actual_Result.equals(Exp_Result))
		{
			//System.out.println("Passed");
			log.info("Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
		}
		else
		{
			//System.out.println("Failed");
			log.info("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
		}
		
		
		sAssert.assertAll();
		
		
	}
	
	
	@Test(dataProvider="dp_validsearch",dataProviderClass=DataProvider_Component.Dataprovider_Login.class,enabled=true,groups={"smoke"})
	public void testvalidSearch(Map<String,String> Search) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		
		log.info("Executing the Testcase " +TC_ID+ " Order set is "+Order_Set);
		
		String Exp_Result = Search.get("Exp_Result").replace(".0", "");
		System.out.println("Expected result is "+Exp_Result);
		
		Pf_Homepage homepage= new Pf_Homepage(driver);
		homepage.Search(Search_Item);
		
		String Actual_Result = homepage.Search_res_valid.getText();
		System.out.println(Actual_Result);
		
				
		if(Actual_Result.equals(Exp_Result))
		{
			//System.out.println("Passed");
			log.info("Passed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
		}
		else
		{
			//System.out.println("Failed");
			log.info("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result  "+Actual_Result + " Expected Resut is  "+Exp_Result);
		}
		
		
		sAssert.assertAll();
		
		
	}

}
