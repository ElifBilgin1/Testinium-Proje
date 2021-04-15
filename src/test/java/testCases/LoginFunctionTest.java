package testCases;

import org.junit.Test;
import testFunctions.LoginFunction;
import utils.BaseTest;

public class LoginFunctionTest extends BaseTest {
    @Test
    public void loginTest(){
        LoginFunction logInFunction = new LoginFunction(driver);
        logInFunction.loginForm();
        logInFunction.loginControl();
    }
}
