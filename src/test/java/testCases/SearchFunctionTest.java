package testCases;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import org.junit.Test;
import testFunctions.SearchFunction;

public class SearchFunctionTest extends BaseTest{
    final static Logger logger = Logger.getLogger(SearchFunctionTest.class);
    @Test
    public void searchTest() throws InterruptedException {
        SearchFunction searchFunction = new SearchFunction(driver);
        searchFunction.search();

        searchFunction.selectPage2();
        searchFunction.page2Control();
        searchFunction.getRandomElem();

        searchFunction.addToBasket();


    }


}
