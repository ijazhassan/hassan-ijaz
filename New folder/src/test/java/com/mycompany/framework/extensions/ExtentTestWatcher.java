package com.mycompany.framework.extensions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mycompany.framework.driver.DriverFactory;
import com.mycompany.framework.reporting.ExtentManager;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExtentTestWatcher implements TestWatcher, BeforeAllCallback, AfterAllCallback, BeforeEachCallback {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void beforeAll(ExtensionContext context) throws Exception { /* nothing */ }

    @Override
    public void afterAll(ExtensionContext context) throws Exception { extent.flush(); }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        ExtentTest t = extent.createTest(context.getDisplayName());
        test.set(t);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            Path dest = Path.of("target/screenshots/" + context.getDisplayName() + ".png");
            Files.createDirectories(dest.getParent());
            Files.copy(src.toPath(), dest);
            test.get().addScreenCaptureFromPath(dest.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.get().log(Status.FAIL, "Test failed: " + cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, java.util.Optional<String> reason) { test.get().log(Status.SKIP, "Test disabled"); }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) { test.get().log(Status.SKIP, "Test aborted"); }
}
