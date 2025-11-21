package com.mycompany.tests;

import com.mycompany.framework.config.ConfigReader;
import com.mycompany.framework.controller.AuthController;
import com.mycompany.framework.driver.DriverFactory;
import com.mycompany.framework.extensions.ExtentTestWatcher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ExtentTestWatcher.class)
public class LoginTest {

    private static WebDriver driver;
    private AuthController authController;

    @BeforeAll
    public static void beforeAll() {
        String browser = System.getProperty("browser", ConfigReader.get("browser"));
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", ConfigReader.get("headless")));
        DriverFactory.initDriver(browser, headless);
        driver = DriverFactory.getDriver();
    }
  
    @AfterAll
    public static void afterAll() {
        DriverFactory.quitDriver();
    }

    @BeforeEach
    public void setUp() {
        authController = new AuthController(driver);
    }

    @Test
    public void validLoginTest() {
        driver.get(ConfigReader.get("base.url") + "/login");
        assertTrue(true, "placeholder - implement asserts based on your application");
    }
}
