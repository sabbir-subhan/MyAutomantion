package cucumberTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {

       @Given("^sample feature file is ready$")

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

	}

}