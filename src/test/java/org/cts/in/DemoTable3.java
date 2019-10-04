package org.cts.in;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoTable3 {
static WebDriver driver;
@Given("Customer launch the browser with URL of webpage")
public void customer_launch_the_browser_with_URL_of_webpage() {
	System.setProperty("webdriver.chrome.driver","D:\\SATHYA ECLIPSE FILES\\CucumberDay1\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/telecom/index.html");
	WebElement d = driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]"));
	d.click();
	WebElement dd = driver.findElement(By.xpath("//label[text()='Done']"));
	dd.click();
}

@When("Customer enter the details of user")
public void customer_enter_the_details_of_user(io.cucumber.datatable.DataTable dataTable) {
Map<String,String> m = dataTable.asMap(String.class,String.class);
driver.findElement(By.id("fname")).sendKeys(m.get("fname"));
driver.findElement(By.id("lname")).sendKeys(m.get("lname"));
driver.findElement(By.id("email")).sendKeys(m.get("email"));
driver.findElement(By.name("addr")).sendKeys(m.get("address"));
driver.findElement(By.id("telephoneno")).sendKeys(m.get("phno"));
}

@Then("Customer get the promocode of booking")
public void customer_get_the_promocode_of_booking() {
	WebDriverWait w=new WebDriverWait(driver, 100);

	  WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
	  JavascriptExecutor jk=(JavascriptExecutor)driver;
	  jk.executeScript("arguments[0].click()",submit);
	  String cl = driver.getCurrentUrl();
	  if(cl.equals("telecom")) {
		  System.out.println("successfully");
	  }
    
}


}
