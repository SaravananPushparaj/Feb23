package PageObject_Component;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_Signin extends Pf_Keyword{
	
	
	@FindBy(name="logid")
	public WebElement txt_uname;
	
	@FindBy(name="pswd")
	public WebElement txt_pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btn_login;
	
	
	@FindBy(xpath="//b[contains(text(),'Sorry we were unable')]")
	public WebElement Invalid_msg;
	
	public Pf_Signin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public void cl_login(String uname, String pwd)
	{
//		txt_uname.sendKeys(uname);
//		txt_pwd.sendKeys(pwd);
//		btn_login.click();
		
		//Keyword
		Enter(txt_uname, uname);
		Enter(txt_pwd, pwd);
		Click(btn_login);
		
	}
	
}
