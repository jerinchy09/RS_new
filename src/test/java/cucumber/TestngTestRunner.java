package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//how do you wanna decide which runner class to us
//it completely depends on project
//assertion you have in your code. 
//if you junit asssertions in your framework then pick junit for cucumber
//

@CucumberOptions(
		features="src/test/java/cucumber"
		,glue ="RS.stepDefinitions"
		,monochrome = true
				,tags= "@Regression"
		,plugin = {"html:target/cucumber.html"}
		
		)
public class TestngTestRunner extends AbstractTestNGCucumberTests{
	
}
