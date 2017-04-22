package DataProvider_Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import Generic_Component.ExcelRW;

public class Dataprovider_Login {
	
	@DataProvider(name="dp_Invalidlogin")
	public static Iterator<Object[]> getInvalidlogin() throws Exception
	{
		return commondp_Logic("Login","Invalid_Login");
		
	}
	
	@DataProvider(name="dp_Validlogin")
	public static Iterator<Object[]> getvalidLogin() throws Exception
	{
		return commondp_Logic("Login","Valid_Login");
		
	}
	
	@DataProvider(name="dp_invalidsearch")
	public static Iterator<Object[]> getInvalidsearch() throws Exception
	{
		return commondp_Logic("Search","invalidsearch");
		
	}
	
	@DataProvider(name="dp_validsearch")
	public static Iterator<Object[]> getvalidSearch() throws Exception
	{
		return commondp_Logic("Search","validsearch");
		
	}
	
	public static Iterator<Object[]> commondp_Logic(String Sheetname,String Sname) throws Exception
	{
		ExcelRW xl= new ExcelRW("D:\\Jan_Framework\\TestData\\Testdata.xlsx");
		int Rowcount = xl.getRow(Sheetname);
		int Colcount = xl.getColum(Sheetname);
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=Rowcount;i++)
		{
			String Execute_Flag = xl.readCell(Sheetname, i, 2);
			String Script_name = xl.readCell(Sheetname, i, 3);
			
			if((Execute_Flag.equals("Y")) && (Script_name.equals(Sname)))
			{
				Map<String,String> dMap= new HashMap<String,String>();
				for(int j=0;j<Colcount;j++)
				{
					
					String Skey = xl.readCell(Sheetname, 0, j);
					String Value = xl.readCell(Sheetname, i, j);
					
					dMap.put(Skey, Value);
					
				}//end of for loop
				
				Object[] x = new Object[1];
				x[0]=dMap;
				arr_list.add(x);
				
			}//end of if
			
			
		}//end of for loop
		
		return arr_list.iterator();
		
	}

}
