package cucumberTest;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class stepDefinition {
	//global variable
	WebDriver driver;
	

	@Given("^I navigate to HealthDriect Home Page$")
	public void i_navigate_to_HealthDriect_Home_Page() throws Throwable {
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		  driver = new ChromeDriver();
		  //Add 10 secs implicit wait for each web elements
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //Add 60 secs for all page load
		  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		  //Maximize browser window
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.healthdirect.gov.au/");
		  try {
			Thread.sleep(2000);
		  } catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  }	  
	    
	}

	@Then("^I check the Title of the home$")
	public void i_check_the_Title_of_the_home() throws Throwable {
	    System.out.println("Check Ttile of Home page");
	    //System.out.println(driver.getTitle());
	    String HomePageTitle=driver.getTitle();
	    //check if Title contains health direct
	    assertTrue(HomePageTitle.contains("healthdirect"));
	  
	}

	@Then("^I type \"([^\"]*)\" in Header Search$")
	public void i_type_in_Header_Search(String Keyword) throws Throwable {
		//find Header Search element
		WebElement HearderSearchtextBox=driver.findElement(By.xpath("//*[@id='search-form-node-desktop-mode']//input[@id='header-search']"));
		//Type keyword on Header Search text box
		HearderSearchtextBox.sendKeys(Keyword);
		//Then we press enter
		HearderSearchtextBox.sendKeys(Keys.RETURN);
		
	}

	@Then("^I verify the search results of keyword \"([^\"]*)\"$")
	public void i_verify_the_search_results_of_keyword(String keyword) throws Throwable {
	   //check if page title contains key word
		String SearchResultPageTitle=driver.getTitle();
	    System.out.println(driver.getTitle());
	    //check if Title contains keyword
	    assertTrue(SearchResultPageTitle.contains(keyword.toLowerCase()));
	    
	   //check if Symptom checker section 
	    WebElement SymptomCheckerButton=driver.findElement(By.xpath("//*[@id='searchResults']/a/button"));
	    String SymptomCheckerButtonText=SymptomCheckerButton.getText().toLowerCase();
	    System.out.println(SymptomCheckerButtonText);
	    assertTrue(SymptomCheckerButtonText.contains(keyword.toLowerCase()));
	    
	    //Now check the content of all Search heading that identified using h4 tag 
	    
	  //First find List of h4 element
	  	List<WebElement> SearchHeadings=driver.findElements(By.xpath("//*[@id='searchResults']//h4"));
	  	
	  //Loop through the list and print Search Results
	  //Loop through the email and open email
	  	 for(int i=0;i<SearchHeadings.size();i++){
	  		WebElement SearchHeading=SearchHeadings.get(i);
	  		//System.out.println(SearchHeading.getText());
	  		String serachResultText=SearchHeading.getText().toLowerCase();
	  		System.out.println(serachResultText);
	  		assertTrue(serachResultText.contains(keyword.toLowerCase()));
	  	 }
	  	}
	    
	  
	
	
	@Then("^I close browser$")
	public void i_close_browser() throws Throwable {
		 driver.quit();	    
	}
	
      
		/*@Given("^sample feature file is ready$")

       public void givenStatment(){

              System.out.println("Given statement executed successfully");

       }

       @When("^I run the feature file$")

       public void whenStatement(){

              System.out.println("When statement execueted successfully");

       }
       
       @When("^Another test$")
       public void another_test(){
    	   System.out.println("When Another test statement execueted successfully");
           //throw new PendingException();
       }

       @Then("^run should be successful$")

       public void thenStatment(){

              System.out.println("Then statement executed successfully");

       }

	@When("^I run the feature file-new$")
	public void iRunTheFeatureFileNew()  {
		System.out.println("I run the feature file-new-step executes");

	}*/

}