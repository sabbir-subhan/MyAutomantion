package OCA1Automation1.MyAutomation1;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GMailTestConfirmAssigmentEmailR3TC1 {
	public WebDriver driver;
	Instant start = Instant.now();
  @Test
  public void testCaseOne() {
	  //Starting Stop watch
	  
	  System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
	  HighlightElement highlight=new HighlightElement();
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
		  WebElement ARCInbocFolderLink=driver.findElement(By.partialLinkText("ARCAssignment"));
		  highlight.highlightElement(driver,ARCInbocFolderLink);
		  ARCInbocFolderLink.click();
			try {
				Thread.sleep(2000);
			  } catch (InterruptedException e) {
				// 
				e.printStackTrace();
			}
		
	 //Make all email as unread
	/*
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//span[@role='checkbox']/div[@role='presentation']"));
		for(WebElement checkBox : checkBoxes){
			if(checkBox.isDisplayed()){
				highlight.highlightElement(driver, checkBox);
				checkBox.click();
				
			}
		}
		
		List<WebElement> MoreElements=driver.findElements(By.xpath("//span[text()='More']"));
		for(WebElement More : MoreElements){
			if(More.isDisplayed()){
				highlight.highlightElement(driver, More);
				More.click();
				
			}
		}
		*/
	

	  //Open Email 
	  	//First find number emails
		  //Before going to click Menu links, selenimum will wait 10 sec(max) to see email is clickable or not
		 WebDriverWait waitforNumberOfEmailFirst = new WebDriverWait(driver,10);
		 waitforNumberOfEmailFirst.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//b[contains(text(),'Confirm Assignment to Event')]//preceding-sibling::span[@name='ARC RCView UAT']/../..")));
	  	List<WebElement> NumberOfEmailFirst=driver.findElements(By.xpath("//b[contains(text(),'Confirm Assignment to Event')]//preceding-sibling::span[@name='ARC RCView UAT']/../.."));
	  	System.out.println("The total number of emails are first " + NumberOfEmailFirst.size());
	  	
	  	//Loop through the email and open email
	  	 int EmailNumber=0;
	  	 this.csvReader();
	  	for(WebElement emaliLink : NumberOfEmailFirst)
	  	 	{
	  	    if(emaliLink.isDisplayed()){
	  	    	//Click Email link
	  	    	highlight.highlightElement(driver,emaliLink);
	  	    	emaliLink.click();
	  	    //Find Email Received Date and time
	  	    	WebElement EmailRecievedDateandTime=driver.findElement(By.xpath("//span[contains(text(),'ago')]"));
	  	    	highlight.highlightElement(driver, EmailRecievedDateandTime);
	  	    	String EmailRecievedDateandTimeStrFull=EmailRecievedDateandTime.getAttribute("title").trim();
	  	    	System.out.println(EmailRecievedDateandTimeStrFull);
	  	    	String[] EmailReceviedTimeSplit=EmailRecievedDateandTimeStrFull.split("at");
	  	    	String EmailRecievedTimeFinal=EmailReceviedTimeSplit[1].trim();
	  	    	Date Currentdate = new Date();
	  	    	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	  	    	String formattedEmailRecievedTime = df.format(Currentdate)+EmailRecievedTimeFinal;
	  	    	DateTime EmailRecievedTimeDate=this.convertEmailRecivedDate(formattedEmailRecievedTime);
	  	    	//System.out.println(EmailRecievedTimeDate);
	  	    	
	  	    //Find random variable in the first name with random variable
	  	    	WebElement CallerNamewithRandom=driver.findElement(By.xpath("//strong[text()='Caller Name:']/../following-sibling::div[1]"));
	  	    	highlight.highlightElement(driver,CallerNamewithRandom);
	  	    	System.out.println(CallerNamewithRandom.getText());
	  	    	String CallerName=CallerNamewithRandom.getText();
	  	    	//String[] output=CallerName.split(":");
	  	    	//System.out.println(output[0]);
	  	    	//System.out.println(output[1]);
	  	    	String RandomStr=CallerName.trim().substring(0, 6);
	  	    	String EventID=this.MatchRandomNumbertoEventID(RandomStr);
	  	    	String EventCreationTime=this.MatchRandomNumbertoEventCreateTime(RandomStr);
	  	    	
	  	    	String formattedEventCreationTime = df.format(Currentdate)+EventCreationTime;
	  	    	DateTime EventCreationTimeDate=this.convertEventTime(formattedEventCreationTime);
	  	    	//System.out.println(EventCreationTimeDate);
	  	    	
	  	    	int durationHours=(Hours.hoursBetween(EventCreationTimeDate,EmailRecievedTimeDate).getHours())% 24;
	  	    	int durationMinutes=(Minutes.minutesBetween(EventCreationTimeDate,EmailRecievedTimeDate).getMinutes()) % 60;
	  	    	String Duration=durationHours+ " hours, "+durationMinutes+" minutes";
	  	    	System.out.println(Duration);
	  	    	
	  	    	
	  	    	//System.out.println(RandomStr);
	  	    //Find whom the email is sent aka DAT Leader,Responder or Trainee
	  	    	WebElement NotificationSentToElement=driver.findElement(By.xpath("//strong[text()='PLEASE CONFIRM ASSIGNMENT TO EVENT']/../preceding-sibling::div[2]"));
	  	    	highlight.highlightElement(driver, NotificationSentToElement);
	  	    	String NotificationSentTo=NotificationSentToElement.getText().substring(2);
	  	    //Find and click ACCEPT link
		  		WebElement AcceptLink=driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]/a[1]"));
		  		highlight.highlightElement(driver,AcceptLink);
		  		String LinkText=AcceptLink.getAttribute("href");
		  		String PathOfLinkTest=LinkText.substring(26);
		 	  	//Write Data to file	
		  		String DataToWirte=RandomStr+","+EventID+","+EventCreationTime+","+EmailRecievedTimeFinal+","+Duration+","+AcceptLink.getAttribute("href")+","+PathOfLinkTest+","+NotificationSentTo;
		  		System.out.println(DataToWirte);
		  		String fileName="C:/Jmeter Test Case/data/TestOutPutEventDataEmailConfirmAssignment.csv";
		  		System.out.println("Data saved on" + fileName);
	  	    	this.storeDataToFile(DataToWirte,fileName);
	  	    		    	 	    
	  	  	    		  	  		
		  		EmailNumber++;
	  			
				
		  		   //click ARC Inbox folder again
		  		 WebElement ARCInbocFolderLink1=driver.findElement(By.partialLinkText("ARCAssignment"));
		  		  highlight.highlightElement(driver,ARCInbocFolderLink1);  
		  		 ARCInbocFolderLink1.click();
		  		try {
					Thread.sleep(2000);
				  } catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		
	  	    }
	  	    else
	  	    {
	  	    	System.out.println(emaliLink.getText() + "Element is InVisible");	
	  	    } 		   
	  			
	  	 }
	  	 
  }
  

  private DateTime convertEmailRecivedDate(String emailRecievedTimeFinal) {
	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyyhh:mm a");
	  try{
		   Date EmailRcTime=formatter.parse(emailRecievedTimeFinal);
		   DateTime EmailRcTimeDT= new DateTime(EmailRcTime);
		   System.out.println(EmailRcTimeDT);
		   return EmailRcTimeDT;
	  }
	  catch (ParseException e) {
          e.printStackTrace();
      }
	return null;
}


private DateTime convertEventTime(String eventCreationTime) {
	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyyhh:mm:ssa");
	  try{
		   Date EventCreateTime=formatter.parse(eventCreationTime);
		   DateTime EventCreateTimeDT=new DateTime(EventCreateTime);
		   System.out.println(EventCreateTimeDT);
		   return EventCreateTimeDT;
	  }
	  catch (ParseException e) {
          e.printStackTrace();
      }
	
	return null;
}


private String MatchRandomNumbertoEventCreateTime(String randomStr) {
	  String csvFile ="C:/Jmeter Test Case/data/TestOutPutEvenDataR3TestRequested.csv";
	  String line = "";
      String cvsSplitBy = ",";

      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] EventData = line.split(cvsSplitBy);
              
              if(Arrays.asList(EventData).contains(randomStr)){
            	  System.out.println("random= "+randomStr+" matching eventCreateTime "+EventData[2]);
            	  return EventData[2].trim().substring(11);
              }

              //System.out.println("random= " +EventData[0] + " , EventID=" + EventData[1] + ",CreationTime="+EventData[3]);

          }

      } catch (IOException e) {
          e.printStackTrace();
      }

	return null;

	
}


private String MatchRandomNumbertoEventID(String randomStr) {
	  String csvFile ="C:/Jmeter Test Case/data/TestOutPutEvenDataR3TestRequested.csv";
	  String line = "";
      String cvsSplitBy = ",";

      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] EventData = line.split(cvsSplitBy);
              
              if(Arrays.asList(EventData).contains(randomStr)){
            	  System.out.println("random= "+randomStr+" matching eventID "+EventData[1]);
            	  return EventData[1];
              }

              //System.out.println("random= " +EventData[0] + " , EventID=" + EventData[1] + ",CreationTime="+EventData[3]);

          }

      } catch (IOException e) {
          e.printStackTrace();
      }

	return null;
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
  
  private void csvReader(){
	  String csvFile ="C:/Jmeter Test Case/data/TestOutPutEventDatassubhan.csv";
	  String line = "";
      String cvsSplitBy = ",";

      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] EventData = line.split(cvsSplitBy);

              System.out.println("random= " +EventData[0] + " , EventID=" + EventData[1] + ",CreationTime="+EventData[3]);

          }

      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
  private void storeDataToFile(String data,String FileName){
	    try{
		FileWriter fstream = new FileWriter(FileName, true);
	 	BufferedWriter out = new BufferedWriter(fstream);
	 	out.write(data);
		out.write(System.getProperty("line.separator"));
		out.close();
	 	fstream.close();
	    }
	    catch (Exception ex) {
	    	System.out.println("Script execution failed"+ex);
	    }
  }

}
