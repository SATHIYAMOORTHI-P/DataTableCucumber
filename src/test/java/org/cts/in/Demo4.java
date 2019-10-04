package org.cts.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Demo4 {
	static WebDriver driver;
	@Given("User launch the Browser with URL..")
	public void user_launch_the_Browser_with_URL() {
		System.setProperty("webdriver.chrome.driver","D:\\SATHYA ECLIPSE FILES\\CucumberDay1\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/telecom/index.html");
		WebElement d = driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]"));
		d.click();
		
	}

	@When("User Enter the Details {string},{string},{string},{string},{string}")
	public void user_Enter_the_Details(String name1, String name2, String name3, String name4, String name5) throws InterruptedException {
	driver.findElement(By.id("fname")).sendKeys(name1);
	driver.findElement(By.id("lname")).sendKeys(name2);
	driver.findElement(By.id("email")).sendKeys(name3);
	driver.findElement(By.name("addr")).sendKeys(name4);
	driver.findElement(By.id("telephoneno")).sendKeys(name5);
	
	}

	@Then("User get the Customer code..")
	public void user_get_the_Customer_code() {
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  String cu = driver.getCurrentUrl();
		  if(cu.contains("telecom/access")) {
			  System.out.println("successfully");
		  }
		  else{
			  System.out.println("not open");
		  }
	  driver.quit();
	}
}
