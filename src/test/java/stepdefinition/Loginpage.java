package stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfractory.Driversetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Loginpg;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class Loginpage extends Base {
	String excelpath = ".\\src\\test\\resources\\ExcelData\\loginExcelData.xlsx";
	String message = "";
	WebDriver driver;
	int rowval = 0;
	String actmsg;
	
	@Given("The user is on login page")
	public void the_user_is_on_login_page() throws Throwable{
		driver = Driversetup.getDriver();
		Driversetup.openPage("https://dsportalapp.herokuapp.com/login");
	
	   
	}

	@When("The user enter sheet\"Sheet1\" and {int}")
	public void the_user_enter_sheet_sheet1_and(Integer int1)throws InvalidFormatException, IOException, InterruptedException {
		login = new Loginpg(driver);
		ExcelReader reader = new ExcelReader();
		
		List<Map<String, String>> testdata = reader.getData(excelpath, "sheet1");
	   String username = testdata.get(int1).get("username");
	   String password = testdata.get(int1).get("password");
	   message = testdata.get(int1).get("expectedmessage");
	   
	   rowval=int1;

	   LoggerLoad.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		login.enternamepasswrd(username, password);
	}

	@Then("click login button")
	public void click_login_button() {
		LoggerLoad.info("User clicks on login button");
		LoggerLoad.info("Expected Message - Excel Sheet :  " + message);
		login.loginbtnclk();
		
		if (rowval==0) {
			   WebElement hidtext=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
				System.out.println(hidtext.getAttribute("validationMessage"));
				LoggerLoad.info(hidtext.getAttribute("validationMessage"));
				actmsg=hidtext.getAttribute("validationMessage");
							
				//Assert.assertEquals(actmsg, message);
				
			}
			else if(rowval==1)  {
				 WebElement hidtext=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
					System.out.println(hidtext.getAttribute("validationMessage"));
					LoggerLoad.info(hidtext.getAttribute("validationMessage"));
					actmsg=hidtext.getAttribute("validationMessage");
					//Assert.assertEquals(actmsg, message);
			}
			else{
				
				actmsg=login.alertdismsg();
				
			}
		//Assert.assertEquals(actmsg, message);
		
	}

	}





