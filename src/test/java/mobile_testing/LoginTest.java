package mobile_testing;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.LoginPage;
import utils.ScreenshotUtil;

public class LoginTest extends BaseTest{
	
	private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        //loginPage.clearLogin();
    }
    
    @Test
    public void testLogin() {
        loginPage.goToLogin();
    }
    
    @Test
    public void testLoginCamposVacios() {
    	loginPage.login("", "");
        Assert.assertEquals(loginPage.getEmptyErrorMessage(), "Username is required");
    }

    @Test
    public void testLoginEmailIncorrecto() throws InterruptedException {
        loginPage.login("invalid@example.com", "10203040");
        Assert.assertEquals(loginPage.getErrorMessage(), "Provided credentials do not match any user in this service.");
        Thread.sleep(2000);
    }
    
    @Test
    public void testLoginContrasenaIncorrecta() throws InterruptedException {
    	loginPage.clearLogin();
    	Thread.sleep(2000);
        loginPage.login("bob@example.com", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Provided credentials do not match any user in this service.");
        Thread.sleep(2000);
    }
    
    @Test
    public void testLoginCorrecto() throws InterruptedException {
    	loginPage.clearLogin();
    	Thread.sleep(2000);
        loginPage.login("bob@example.com", "10203040");
    } 
    
    @AfterMethod
	public void tearDownTest(ITestResult result) { 
	   ScreenshotUtil.captureScreenshot(driver, result.getName());
	}

}
