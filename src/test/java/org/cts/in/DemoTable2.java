package org.cts.in;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoTable2 {
	static WebDriver driver;
	
	@Given("User launch the browser with URL of webpage")
	public void user_launch_the_browser_with_URL_of_webpage() {
		System.setProperty("webdriver.chrome.driver","D:\\SATHYA ECLIPSE FILES\\CucumberDay1\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://demo.guru99.com/telecom/index.html");
			WebElement d = driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]"));
			d.click();
			WebElement dd = driver.findElement(By.xpath("//label[text()='Done']"));
			dd.click();
	   
	}

	@When("User enter the details of user")
	public void user_enter_the_details_of_user(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> l = dataTable.asLists(String.class);
		driver.findElement(By.id("fname")).sendKeys(l.get(0).get(0));
		driver.findElement(By.id("lname")).sendKeys(l.get(1).get(1));
		driver.findElement(By.id("email")).sendKeys(l.get(0).get(2));
		driver.findElement(By.name("addr")).sendKeys(l.get(0).get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(l.get(0).get(4));
	}
	
	@Then("User get the promocode of booking")
	public void user_get_the_promocode_of_booking() {
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
