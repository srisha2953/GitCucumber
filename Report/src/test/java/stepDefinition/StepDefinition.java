package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	public static WebDriver driver;
	@Given("^User in the login page$")
    public void user_in_the_login_page() throws Throwable {
       WebDriverManager.firefoxdriver().setup();
       driver= new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
       driver.get("https://www.stealmylogin.com/demo.html");
       
    }

    @When("^User enter the data and click on login button$")
    public void user_enter_the_data_and_click_on_login_button() throws Throwable {
      driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123213213");
      driver.findElement(By.xpath("//input[@type='password1']")).sendKeys("132465465");
      driver.findElement(By.xpath("//input[@value='login']")).click();
    }

    @Then("^Home page displayed is verified$")
    public void home_page_displayed_is_verified() throws Throwable {
       String url = driver.getCurrentUrl();
       if(url.equals("example.com"))
       {
    	   System.out.println(true);
       }
    }


}
