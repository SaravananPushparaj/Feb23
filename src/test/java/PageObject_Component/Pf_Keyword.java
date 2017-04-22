package PageObject_Component;

import org.openqa.selenium.WebElement;

public class Pf_Keyword {
	
	public void Enter(WebElement ele, String Val)
	{
		ele.clear();
		ele.sendKeys(Val);
	}
	
	
	public void Click(WebElement ele)
	{
		ele.click();
		
	}

}
