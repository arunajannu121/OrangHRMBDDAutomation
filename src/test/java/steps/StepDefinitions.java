package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

	WebDriver driver;
	
	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	}

	@Given("user launch app using URL {string}")
	public void user_launch_app_using_url(String url) {
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@When("user enters text {string} using xpath {string}")
	public void user_enters_text_using_xpath(String text, String xpath) {
		
		driver.findElement(By.xpath(xpath)).sendKeys(text);

	}

	@When("user clicks on button using xpath {string}")
	public void user_clicks_on_button_using_xpath(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user validate the URL to be {string}")
	public void user_validate_the_url_to_be(String expURL) {
		
		Assert.assertEquals(driver.getCurrentUrl(), expURL);

	}
	
	//hooks
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@When("user clicks on linktext using xpath {string}")
	public void user_clicks_on_linktext_using_xpath(String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();
	    
	}
	@When("user clicks check box using xpath {string}")
	public void user_clicks_check_box_using_xpath(String xpath) {
		
		if(!driver.findElement(By.xpath(xpath)).isSelected())
		{
			driver.findElement(By.xpath(xpath)).click();
		}
	    
	}

	@Then("validate text on element using xpath {string} to be {string}")
	public void validate_text_on_element_using_xpath_to_be(String xpath, String expectedText) {
	   
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), expectedText);
	}


@When("user enters details in registration form")
public void user_enters_details_in_registration_form(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	List<List<String>> allData=dataTable.asLists();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allData.get(0).get(0));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allData.get(0).get(1));
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(allData.get(0).get(2));
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allData.get(0).get(3));
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allData.get(0).get(4));
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(allData.get(0).get(5));
	
    
}


@When("user enters details in registration form2")
public void user_enters_details_in_registration_form2(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	List<Map<String, String>> allData=dataTable.asMaps();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allData.get(0).get("username"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allData.get(0).get("password"));
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(allData.get(0).get("confirm password"));
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allData.get(0).get("full name"));
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allData.get(0).get("email address"));
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(allData.get(0).get("captcha"));
	
    
}

}
