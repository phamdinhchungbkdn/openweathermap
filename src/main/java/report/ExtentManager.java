package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./test-report/api/ApiAutomationReport.html");
        reporter.config().setReportName("API Testing Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "VDC Home Test");
        extentReports.setSystemInfo("Author", "Chung Pham");
        return extentReports;
    }
}
