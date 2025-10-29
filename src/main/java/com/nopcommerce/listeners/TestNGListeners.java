//package com.nopcommerce.listeners;
//import com.nopcommerce.drivers.WebDriverProvider;
//import com.nopcommerce.utils.*;
//import com.nopcommerce.utils.allurereport.AllureAttachmentManager;
//import com.nopcommerce.utils.allurereport.AllureConstants;
//import com.nopcommerce.utils.allurereport.AllureEnvironmentManager;
//import com.nopcommerce.utils.allurereport.AllureReportGenerator;
//import com.nopcommerce.validations.SoftAssertions;
//import org.openqa.selenium.WebDriver;
//import org.testng.*;
//import java.io.File;
//import static com.nopcommerce.utils.PropertiesUtils.loadProperties;
//
//
//public class TestNGListeners implements IExecutionListener, IInvokedMethodListener, ITestListener, ISuiteListener {
//    File screenshots = new File("test-outputs/screenshots");
//    File recordings = new File("test-outputs/recordings");
//    File logs = new File("test-outputs/Logs");
//
//    @Override
//    public void onExecutionStart() {
//        LogUtils.info("Test Execution started");
//
//
//        cleanTestOutputDirectories();
//        LogUtils.info("Directories cleaned");
//
//        createTestOutputDirectories();
//        LogUtils.info("Directories created");
//
//        loadProperties();
//        LogUtils.info("Properties loaded");
//
//
//        AllureEnvironmentManager.setEnvironmentVariables();
//        LogUtils.info("Allure environment set");
//    }
//
//
//    @Override
//    public void onExecutionFinish() {
//        AllureReportGenerator.generateReports(false);
//        AllureReportGenerator.copyHistory();
//        LogUtils.info("History copied");
//        AllureReportGenerator.generateReports(true);
//        String newFileName = AllureReportGenerator.renameReport();
//        AllureReportGenerator.openReport(newFileName);
//        LogUtils.info("Test Execution Finished");
//    }
//
//    @Override
//    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
//        if (method.isTestMethod()) {
//            ScreenRecorderUtils.startRecording();
//            LogUtils.info("Test Case " + testResult.getName() + " started");
//        }
//    }
//
//
//    @Override
//    public void afterInvocation(IInvokedMethod method, ITestResult result) {
//        WebDriver driver = null;
//        if (method.isTestMethod()) {
//            ScreenRecorderUtils.stopRecording(result.getName());
//            SoftAssertions.AssertIfUsed();
//            if (result.getInstance() instanceof WebDriverProvider provider)
//                driver = provider.getWebDriver();
//            switch (result.getStatus()) {
//                case ITestResult.FAILURE -> ScreenshotUtils.takeScreenShot(driver, "failed-" + result.getName());
//
//                case ITestResult.SUCCESS -> ScreenshotUtils.takeScreenShot(driver, "passed-" + result.getName());
//
//                case ITestResult.SKIP -> ScreenshotUtils.takeScreenShot(driver, "skipped-" + result.getName());
//
//            }
//            AllureAttachmentManager.attachLogs();
//            AllureAttachmentManager.attachRecords();
//        } else if (method.isConfigurationMethod()) {
//            // For Configuration Methods: Log Only
//            switch (result.getStatus()) {
//                case ITestResult.FAILURE -> LogUtils.info("Configuration Method ", result.getName(), "failed");
//                case ITestResult.SUCCESS -> LogUtils.info("Configuration Method ", result.getName(), "passed");
//                case ITestResult.SKIP -> LogUtils.info("Configuration Method ", result.getName(), "skipped");
//            }
//        }
//    }
//
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        LogUtils.info("Test case", result.getName(), "passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        LogUtils.info("Test case", result.getName(), "failed");
//
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        LogUtils.info("Test case", result.getName(), "skipped");
//    }
//
//    public void onFinish(ISuite suite) {
//
//    }
//
//    private void cleanTestOutputDirectories() {
//        FilesUtils.cleanDirectory(AllureConstants.RESULTS_FOLDER.toFile());
//        FilesUtils.cleanDirectory(screenshots);
//        FilesUtils.cleanDirectory(recordings);
//        FilesUtils.cleanDirectory(logs);
//    }
//
//    private void createTestOutputDirectories() {
//        FilesUtils.createDirs(ScreenshotUtils.SCREENSHOTS_PATH);
//        FilesUtils.createDirs(ScreenRecorderUtils.RECORDINGS_PATH);
//    }
//
//}
