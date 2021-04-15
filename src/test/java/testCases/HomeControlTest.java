package testCases;

import org.junit.Test;
import testFunctions.HomeControl;
import utils.BaseTest;

public class HomeControlTest extends BaseTest {

    @Test
    public void homeControl(){
        HomeControl homeControl = new HomeControl(driver);
        homeControl.titleControl();
    }
}
