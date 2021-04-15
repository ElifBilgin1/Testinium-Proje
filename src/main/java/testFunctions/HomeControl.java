package testFunctions;
import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class HomeControl extends BasePage {
    final static Logger logger = Logger.getLogger(HomeControl.class);

    public HomeControl(WebDriver driver) {
        super(driver);
        logger.setLevel(Level.DEBUG);
    }

    public void titleControl(){
        assertEquals("Anasayfaya giriş sağlanamadı.","GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",title());
        logger.debug("Homepage controlled.");
    }
}
