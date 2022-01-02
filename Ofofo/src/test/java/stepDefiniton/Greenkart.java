package stepDefiniton;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Automation.Ofofo.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;


public class Greenkart extends Base{
	public static WebDriver driver;
	public static Properties prop;
	HomePage h;
	@Given("^User is on Greenkart Landing page$")
    public void user_is_on_greenkart_landing_page() throws Throwable {
        driver=Base.getDriver();
		
    }

    @When("^User search for \"([^\"]*)\" vegetable$")
    public void user_search_for_something_vegetable(String strArg1) throws Throwable {
        h= new HomePage(driver);
    		h.getSearch().sendKeys("Hello");
    }

    @Then("^\"([^\"]*)\" results are displayed$")
    public void something_results_are_displayed(String strArg1) throws Throwable {
       driver.findElement(By.cssSelector("h4.product-name")).getText().contains(strArg1);
    }
    

    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
        driver.findElement(By.cssSelector("a.increment")).click();
        driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
    }

    @And("^User proceeded to checkout page for purchase$")
    public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
        driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
        driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
        
      }
    @When("^User search for (.+) vegetable$")
    public void user_search_for_vegetable(String name) throws Throwable {
        
    }

    @Then("^(.+) results are displayed$")
    public void results_are_displayed(String name) throws Throwable {
        
    }


}
