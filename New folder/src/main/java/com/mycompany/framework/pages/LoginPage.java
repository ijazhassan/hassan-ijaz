package com.mycompany.framework.pages;

import com.mycompany.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) { super(driver); }

    @FindBy(id = "username") private WebElement inputUsername;
    @FindBy(id = "password") private WebElement inputPassword;
    @FindBy(css = "button[type='submit']") private WebElement btnLogin;

    public void enterUsername(String u) { inputUsername.clear(); inputUsername.sendKeys(u); }
    public void enterPassword(String p) { inputPassword.clear(); inputPassword.sendKeys(p); }
    public void clickLogin() { btnLogin.click(); }

    // controller-friendly method
    public void login(String u, String p) {
        enterUsername(u);
        enterPassword(p);
        clickLogin();
    }
}
