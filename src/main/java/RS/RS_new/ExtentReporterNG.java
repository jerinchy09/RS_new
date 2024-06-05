package RS.RS_new;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

//	public static ExtentReports getReportObject() {
//		
//		String path = System.getProperty("user.dir")+"/reports/index.html";
//		
//		ExtentSparkReporter esparkreporter = new ExtentSparkReporter(path);
////		esparkreporter.config().setReportName("Web Automation Results");
////		esparkreporter.config().setDocumentTitle("Test Results");
//		
//		ExtentReports exReport = new ExtentReports();
//		exReport.attachReporter(esparkreporter);
//		exReport.setSystemInfo("Tester", "Jerin");
//		return exReport;
//		
//		//exReport.createTest(path);	
//		
//	}
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports reports =new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "Jerin");
		return reports;	
	}
}
