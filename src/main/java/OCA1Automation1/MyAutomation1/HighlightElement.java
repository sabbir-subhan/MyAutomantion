package OCA1Automation1.MyAutomation1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {
	//static WebDriver driver;
    public void highlightElement(WebDriver driver,WebElement element) {
    	
    	JavascriptExecutor js=(JavascriptExecutor)driver; 

    	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    	//a half seceond pause after highlighting
    	try 
    	{
    	Thread.sleep(100);
    	} 
    	catch (InterruptedException e) {

    	System.out.println(e.getMessage());
    	} 

    	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
    	
    }
}