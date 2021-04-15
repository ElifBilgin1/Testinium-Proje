package testFunctions;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BasePage;
import static org.junit.Assert.*;

public class LoginFunction extends BasePage {

    final static Logger logger = Logger.getLogger(LoginFunction.class);

    public LoginFunction(WebDriver driver) {
        super(driver);
        logger.setLevel(Level.DEBUG);
    }

    // İhtiyacımız olan elementler belirlenir
    private By userName = By.id("L-UserNameField");
    private By password = By.id("L-PasswordField");
    private By loginButton = By.id("gg-login-enter");

    public void loginForm(){
        String username = "elifbilginnn";
        String pass = "1998053e";

        Actions actions = new Actions(driver);
        actions.moveToElement(element(By.name("profile"))).build().perform();
        element(By.linkText("Giriş Yap")).click();
        logger.debug("Login button clicked.");

        WebElement usernameField = driver.findElement(userName);
        usernameField.click();
        usernameField.sendKeys(username);
        logger.debug("Username set: "+username);

        WebElement passwordField = driver.findElement(password);
        passwordField.click();
        passwordField.sendKeys(pass);
        logger.debug("Password set: "+pass);

        element(loginButton).click();
        logger.debug("Login successfully.");
    }

    // Yönlendirilen sayfanın title'ı eşleşirse işlem başarılıdır.
    public void loginControl(){
        assertEquals("Üye girişi yapılamadı.","GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",title());
        logger.debug("Login controlled.");
    }
}
