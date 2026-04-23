package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentReportManager {
    private static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent == null) {
            new File("reports").mkdirs();
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/index.html");
            spark.config().setReportName("QualityHR Automation - Sriya Putty");
            spark.config().setDocumentTitle("Sriya QA Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("QA Engineer", "Sriya Putty");
            extent.setSystemInfo("Environment", "Production-Demo");
        }
        return extent;
    }
}
