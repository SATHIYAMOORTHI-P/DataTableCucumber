package org.cts.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutoDemo {
public static WebDriver driver;
@Given("user launch the browser with url")
public void user_launch_the_browser_with_url() {
    System.setProperty("webdriver.chrome.driver","D:\\SATHYA ECLIPSE FILES\\CucumberDay1\\drivers\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://demo.guru99.com/telecom/index.html");
WebElement d = driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]"));
d.click();

}

@When("user entering the details {string},{string},{string},{string},{string}")
public void user_entering_the_details(String name1, String name2, String name3, String name4, String name5) {
	   driver.findElement(By.xpath("//label[@for='done']"));
   driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(name1);
   driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(name2);
   driver.findElement(By.xpath("//input[@type='email']")).sendKeys(name3);
   driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(name4);
   driver.findElement(By.xpath("//input[@type='submit']")).sendKeys(name5);
}

@Then("user get registeration id")
public void user_get_registeration_id() {
driver.getCurrentUrl().contains("uid");
WebElement txt = driver.findElement(By.xpath("(//td[@align='center'])[2]"));
String text = txt.getText();	
System.out.println(text);
}
}



