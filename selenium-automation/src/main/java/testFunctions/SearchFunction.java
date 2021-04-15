package testFunctions;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;
import java.util.Random;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchFunction extends BasePage {

    final static Logger logger = Logger.getLogger(SearchFunction.class);

    public SearchFunction(WebDriver driver) {
        super(driver);
        logger.setLevel(Level.DEBUG);
    }

    // İhtiyacımız olan elementler belirlenir
    private By searchField = By.name("k");
    private By addToBasketField = By.xpath("//*[@id=\"add-to-basket\"]");
    private By productPrice = By.xpath("//*[@id=\"sp-price-discountPrice\"]");
    private By chartPrice = By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p");
    private By allProds = By.xpath("//*[@id=\"best-match-right\"]/div[3]/div[2]/ul");

    public void search(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));

        String word = "bilgisayar";

        WebElement nameSpace = driver.findElement(searchField);
        nameSpace.click();
        nameSpace.sendKeys(word, Keys.ENTER);
        logger.debug("'bilgisayar' sent to search field.");
    }

    public void selectPage2() {

        driver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        logger.debug("Page 2 selected.");
        /* go to page 2
        'org.openqa.selenium.ElementClickInterceptedException: element click intercepted' hatasını
        çözemediğim için böyle bir yönteme başvurdum

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")));

        if(driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).isDisplayed()){
            String previousURL = driver.getCurrentUrl();
            driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            ExpectedCondition e = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return (d.getCurrentUrl() != previousURL);
                }
            };

            wait.until(e);
            currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
        }*/
    }

    public void page2Control(){
        assertEquals("2. sayfa açılamadı!","Bilgisayar - GittiGidiyor - 2/100",title());
        logger.debug("Page 2 controlled.");
    }

    public void getRandomElem() throws InterruptedException{
        /*List<WebElement> allProduct = driver.findElements(By.xpath("//*[@id=\"best-match-right\"]/div[3]/div[2]/ul"));
        System.out.println("size: "+allProduct.size());*/
        WebDriverWait wait=new WebDriverWait(driver, 50);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(allProds));

        WebElement allProducts = driver.findElement(allProds);
        List<WebElement> allItems=allProducts.findElements(By.tagName("li"));

        Random random = new Random();
        int rnd = random.nextInt(allItems.size());
        Thread.sleep(5000);
        int counter = 0;
        for( WebElement product : allItems){
            if(counter == rnd){
                logger.debug("Random item selected: "+product.getText());
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()", product);
                break;
            }
            counter++;
        }
        /*
        int counter = 0;
        for( WebElement product : allProduct){
            if(counter == rnd){
                product.click();
            }
            counter++;
        }*/
    }

    public void addToBasket() throws InterruptedException{
        Thread.sleep(5000);
        WebDriverWait wait=new WebDriverWait(driver, 50);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(addToBasketField));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", el);
        logger.debug("Item added to chart.");

        Thread.sleep(3000);
        WebElement price = driver.findElement(productPrice);
        String currentPrice = price.getText().strip();
        System.out.println("currentPrice: "+currentPrice);
        logger.debug("Item's current price: "+currentPrice);

        Thread.sleep(3000);
        // Open basket
        driver.get("https://www.gittigidiyor.com/sepetim");
        WebElement basketPrice = driver.findElement(chartPrice);
        Thread.sleep(3000);
        String bPrice = basketPrice.getText();
        System.out.println("bPrice: "+bPrice);
        logger.debug("Item's chart price: "+bPrice);

        assertEquals("Fiyatlar eşleşmiyor!",bPrice,currentPrice);
        logger.debug("Prices controlled.");

    }

}
