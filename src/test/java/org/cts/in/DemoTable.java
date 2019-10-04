package org.cts.in;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoTable {
static WebDriver driver;
@Given("User launch the browser with URL")
public void user_launch_the_browser_with_URL() {
	System.setProperty("webdriver.chrome.driver","D:\\SATHYA ECLIPSE FILES\\CucumberDay1\\drivers\\chromedriver.exe");
	
ChromeOptions g=new ChromeOptions();
	ChromeOptions ag = g.addArguments("--disable-notifications");
	driver=new ChromeDriver(ag);
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/telecom/index.html");
	WebElement d = driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]"));
	d.click();
	WebElement dd = driver.findElement(By.xpath("//label[text()='Done']"));
	dd.click();
}

@When("User enter the details")
public void user_enter_the_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	List<String> l = dataTable.asList(String.class);
	driver.findElement(By.id("fname")).sendKeys(l.get(0));
	driver.findElement(By.id("lname")).sendKeys(l.get(1));
	driver.findElement(By.id("email")).sendKeys(l.get(2));
	driver.findElement(By.name("addr")).sendKeys(l.get(3));
	driver.findElement(By.id("telephoneno")).sendKeys(l.get(4));
   
}

@Then("User get the promocode")
public void user_get_the_promocode() throws InterruptedException {
	
	/*try {
		WebDriverWait w=new WebDriverWait(driver, 100);
		//w.until(ExpectedConditions.alertIsPresent());
		WebElement al = driver.findElement(By.xpath("//div[@id='closeBtn']"));
		al.click();	
	}
	catch(Throwable e) {
		e.printStackTrace();
	}
*/	WebDriverWait w=new WebDriverWait(driver, 100);

	  WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
	  JavascriptExecutor jk=(JavascriptExecutor)driver;
	  jk.executeScript("arguments[0].click()",submit);
	//  String cu = driver.getCurrentUrl();
	//  if(cu.contains("telecom/access")) {
	//	  System.out.println("successfully");
	  }
	  

}

