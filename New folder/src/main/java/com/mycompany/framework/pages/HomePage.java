package com.mycompany.framework.pages;

import com.mycompany.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) { super(driver); }

    @FindBy(css = "h1.home-title") private WebElement homeTitle;

    public String getHomeTitle() { return homeTitle.getText().trim(); }
}
