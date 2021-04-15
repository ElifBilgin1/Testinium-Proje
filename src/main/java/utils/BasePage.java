package utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testFunctions.HomeControl;

public class BasePage {
    final static Logger logger = Logger.getLogger(BasePage.class);

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        logger.setLevel(Level.DEBUG);
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public String title(){
        String title = driver.getTitle();
        logger.debug("Title getted: "+title);
        return title;
    }

    public WebElement element(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
