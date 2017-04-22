package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_Homepage extends Pf_Keyword {
	
	
	@FindBy(linkText="Sign In")
	public WebElement lk_Signin;
	
	@FindBy(id="username")
	public WebElement lbl_username;
	
	@FindBy(id="srchword")
	public WebElement Search_txtbox;
	
	@FindBy(className="newsrchbtn")
	public WebElement Search_btn;
	
	@FindBy(id="find")
	public WebElement Search_res_valid;
	
	@FindBy(className="sorrymsg")
	public WebElement Search_res_invalid;
	
	@FindBy(linkText="Sign Out")
	public WebElement lk_Signout;
	
	
	public Pf_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void click_signin()
	{
		//lk_Signin.click();
		Click(lk_Signin);
	}
	
	public void click_signout()
	{
		//lk_Signout.click();
		Click(lk_Signout);
	}
	
	public void Search(String Search_Item)
	{
		Enter(Search_txtbox, Search_Item);
		Click(Search_btn);
	}

}
