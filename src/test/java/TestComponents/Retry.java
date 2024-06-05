package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	//whenever test fails test comes here to check do i need to rerun again 
	//in case of flaky test
	
	//if you think one class might give a failure test case/flaky then go to that method and 
	//write retryAnalyzer= *classname*.class as a parameter on @Test annotation
	int count =0;
	int maxTry =1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count< maxTry) {
			count++;
			return true;
		}
		return false;
	}

}
