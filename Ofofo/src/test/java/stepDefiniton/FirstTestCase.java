package stepDefiniton;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {
	
	WebDriver driver;
	
	@Given("^user launch firefox browser$")
    public void user_launch_firefox_browser() throws Throwable {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
    }

    @Given("^when user enter$")
    public void when_user_enter(DataTable table) throws Throwable {
    	List<List<String>> value = table.asLists();
    	
    	driver.findElement(By.id("firstName")).sendKeys(value.get(0).get(0));
    	driver.findElement(By.id("lastName")).sendKeys(value.get(0).get(1));
    	driver.findElement(By.id("email")).sendKeys(value.get(0).get(2));
    	driver.findElement(By.id("phone")).sendKeys(value.get(0).get(3));
    	driver.findElement(By.id("websiteUrl")).sendKeys(value.get(0).get(4));
    	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(value.get(0).get(5));
    	driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(value.get(0).get(6));
    	
        
        
    	WebElement registerAsSellerBuyer = driver.findElement(By.xpath("(//select[@id='role'])[2]")); 
    	new Select(registerAsSellerBuyer).selectByVisibleText("Seller"); 
    }

    @Then("^check wheather the otp page is displayed$")
    public void check_wheather_the_otp_page_is_displayed() throws Throwable {
        String ele = driver.getCurrentUrl();
        if(ele.contains("otp-verification"))
        {
        	System.out.println(true);
        }
        else
        {
        	System.out.println(false);
        }
    }

    @And("^goes to landing page$")
    public void goes_to_landing_page() throws Throwable {
        driver.navigate().to("https://landingpage-stage.ofofo.io/#/landingpage");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn']//p[1]")).click();
        Thread.sleep(3000);
    }

    @SuppressWarnings("unused")
	@And("^click on register$")
    public void click_on_register() throws Throwable {
        WebElement wait= new WebDriverWait(driver,Duration.ofHours(1)).until(
        		ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Register ']")));
        
        driver.findElement(By.xpath("//button[text()=' Register ']")).click();
        Thread.sleep(5000);
    }
    @Then("^Verify selected \"([^\"]*)\" items are displayed in checkout page$")
    public void verify_selected_something_items_are_displayed_in_checkout_page(String strArg1) throws Throwable {
       driver.findElement(By.cssSelector("p.product-name")).getText().contains(strArg1);
    }

}
