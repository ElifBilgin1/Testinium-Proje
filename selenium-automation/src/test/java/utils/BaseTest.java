package utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testCases.SearchFunctionTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    BasePage basePage;
    final static Logger logger = Logger.getLogger(BaseTest.class);

    @Before
    public void setUp(){
        logger.setLevel(Level.DEBUG);
        logger.debug("");
        logger.debug("****************************************************");
        logger.debug("Elif's test starting...");
        logger.debug("Current Time: " + new Date().toString());
        logger.debug("****************************************************");
        logger.debug("");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        basePage = new BasePage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.quit();
        logger.debug("");
        logger.debug("Test finished successfully");
        logger.debug("");
    }

}
