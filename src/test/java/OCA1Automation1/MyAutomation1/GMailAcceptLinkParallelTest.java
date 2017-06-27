package OCA1Automation1.MyAutomation1;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GMailAcceptLinkParallelTest {
		
  @Test
  public void testCaseOne() {
	  WebDriver driver;
	  System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //setting up browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
  }

  
  @Test
  public void testCaseTwo() {
	  WebDriver driver;
	  System.out.println("Test Case Two with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Setting Up Browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
  }

  @Test
  public void testCaseThree() {
	  WebDriver driver;
	  System.out.println("Test Case Three with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Setting Up Browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
  }
  
  @Test
  public void testCaseFour() {
	  WebDriver driver;
	  System.out.println("Test Case Four with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Setting Up Browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
  }
@Test
  public void testCaseFive() {
	  WebDriver driver;
	  System.out.println("Test Case Five with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Setting Up Browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
  }

@Test
public void testCaseSix() {
	  WebDriver driver;
	  System.out.println("Test Case Six with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Setting Up Browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
}

@Test
public void testCaseSeven() {
	  WebDriver driver;
	  System.out.println("Test Case Seven with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
	  //Setting Up Browser
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
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  //Enter Email address
	  WebElement googleEmail=driver.findElement(By.xpath("//*[@id='Email']"));
	  highlight.highlightElement(driver, googleEmail);
	  googleEmail.sendKeys("ssubhan@noggin.com.au");
	  
	  //Click Next button
	  WebElement googleNextButton=driver.findElement(By.xpath("//*[@id='next']"));
	  highlight.highlightElement(driver, googleNextButton);
	  googleNextButton.click();
	  
	  //Now find and enter google password
	  WebElement googlePassword=driver.findElement(By.xpath("//*[@id='Passwd']"));
	  highlight.highlightElement(driver,googlePassword);
	  googlePassword.sendKeys("different #77 thought house");
	  //Now find and click sign in button
	  WebElement googleSigninButton=driver.findElement(By.xpath("//*[@id='signIn']"));
	  highlight.highlightElement(driver,googleSigninButton);
	  googleSigninButton.click();
	  
	//In the inoxfolder click in ARC Folder
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("Inbox/ARC"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();

	  //Open Email 
	  	//First find number emails
	  	List<WebElement> NumberOfEmail=driver.findElements(By.xpath("//table[@id=':j2']/tbody/tr"));
	  	System.out.println("The total number of emails are " + NumberOfEmail.size());
	  	
	  	//Loop through the email and open email
	  	 for(int i=0;i<NumberOfEmail.size();i++)
	  	 	{
	  	
	  		//Click Email link
	  		 WebElement EmailLink=driver.findElement(By.xpath("//table[@id=':j2']/tbody/tr["+(i+1)+"]/td[6]"));
	  		highlight.highlightElement(driver,EmailLink);
	  		 EmailLink.click();
	  		try {
				Thread.sleep(3000);
			  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	  		 //Find and click ACCEPT link
	  		 WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
	  		highlight.highlightElement(driver,AcceptLink);
	  		 AcceptLink.click();
	  		System.out.println("Clicking ACCEPT Link fro email" +(i+1));
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
	  		   highlight.highlightElement(driver,ARCInbocFolderLink);  
	  		 ARCInbocFolderLink.click();   	  		
	  		
	  	 	}
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
}
  @BeforeClass
  
  public void setup() throws InterruptedException{
	  
	 //Prints Out the Test Case Name in the console for debugging purpose
	  String TestCaseName = this.getClass().getName();
	  System.out.println("TEST CASE RUNNING :"+ TestCaseName);
	  
  }

 

}
