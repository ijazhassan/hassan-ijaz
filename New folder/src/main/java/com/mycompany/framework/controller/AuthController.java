 package com.mycompany.framework.controller;

import com.mycompany.framework.pages.HomePage;
import com.mycompany.framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Controller sits in the main code (not tests) and orchestrates page objects.
 * Tests call controller methods, or controller can be used for manual programmatic runs.
 */
public class AuthController {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public AuthController(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public HomePage login(String username, String password) {
        loginPage.login(username, password);
        return homePage; // caller should validate
    }
}
