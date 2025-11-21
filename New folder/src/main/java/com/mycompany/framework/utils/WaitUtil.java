package com.mycompany.framework.utils;

import com.mycompany.framework.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    public static WebElement waitForVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(ConfigReader.getInt("explicit.wait")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
