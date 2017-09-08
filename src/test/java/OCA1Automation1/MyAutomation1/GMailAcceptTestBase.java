package OCA1Automation1.MyAutomation1;

import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GMailAcceptTestBase {
	public WebDriver driver;
	Instant start = Instant.now();
  @Test
  public void testCaseOne() {
	  //Starting Stop watch
	  
	  System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='identifierId']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='passwordNext']/div[2]"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();
			try {
				Thread.sleep(2000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	  //Open Email 
	  	//First find number emails
		  //Before going to click Menu links, selenimum will wait 10 sec(max) to see email is clickable or not
		 WebDriverWait waitforNumberOfEmail = new WebDriverWait(driver,10);
		 waitforNumberOfEmail.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//[contains(text(),'Confirm Assignment to Event')]//preceding-sibling::span[@name='me']/../..")));
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//b[contains(text(),'Confirm Assignment to Event')]//preceding-sibling::span[@name='me']/../.."));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 int EmailNumber=0;
	  	 for(WebElement emaliLink : NumberOfEmail)
	  	 	{
	  	    if(emaliLink.isDisplayed()){
	  	    	//Click Email link
	  	    	highlight.highlightElement(driver,emaliLink);
	  	    	emaliLink.click();
	  	    //Find and click ACCEPT link
		  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
		  		highlight.highlightElement(driver,AcceptLink);
		  		 AcceptLink.click();
		  		
				System.out.println("Clicking ACCEPT Link fro email :" +(EmailNumber+1));
				EmailNumber++;
		
		  		 //System.out.println(driver.getCurrentUrl());
		  		
		  		String parentWindow = driver.getWindowHandle();
		  		Set<String> handles =  driver.getWindowHandles();
		  		   for(String windowHandle  : handles)
		  		       {
		  		       if(!windowHandle.equals(parentWindow))
		  		          {
		  		          driver.switchTo().window(windowHandle);
		  		          System.out.println(driver.getCurrentUrl());
		  		          driver.close(); //closing child window
		  		          driver.switchTo().window(parentWindow); //cntrl to parent window
		  		          }
		  		       }
		  		 
		  		   //click ARC Inbox folder again
		  		 WebElement ARCInbocFolderLink1=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  		   highlight.highlightElement(driver,ARCInbocFolderLink1);  
		  		 ARCInbocFolderLink1.click();
		  		try {
					Thread.sleep(2000);
				  } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	  	    }
	  	    else
	  	    {
	  	    	System.out.println(emaliLink.getText() + "Element is InVisible");	
	  	    } 		   
	  			
	  	 }
	  	 
  }
  

  @BeforeClass
  
  public void setup() throws InterruptedException{
	  
	 //Prints Out the Test Case Name in the console for debugging purpose
	  String TestCaseName = this.getClass().getName();
	  System.out.println("TEST CASE RUNNING :"+ TestCaseName);
	  
	// Optional, if not specified, WebDriver will search your path for chromedriver.
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	  driver = new ChromeDriver();
	  //Add 10 secs implicit wait for each web elements
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  //Add 60 secs for all page load
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  //Maximize browser window
	  driver.manage().window().maximize();
	  
	  driver.get("https://mail.google.com/");
	  
  }

  @AfterClass
  public void close(){
	  Instant end = Instant.now();
	  Duration timeElapsed = Duration.between(start, end);
	  System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
	  driver.quit();
  }

}
