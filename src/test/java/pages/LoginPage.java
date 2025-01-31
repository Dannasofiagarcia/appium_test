package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage {
	
	private AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
	private WebElement openMenuButton;
	
	@AndroidFindBy(accessibility = "menu item log in")
	private WebElement loginMenuButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Username input field']")
	private WebElement usernameField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
	private WebElement passwordField;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Login'])[2]")
	private WebElement loginButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Provided credentials do not match any user in this service.']")
	private WebElement errorMessage;
	//Provided credentials do not match any user in this service.
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Username is required']")
	private WebElement emptyErrorMessage;
	//Username is required
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='container header']")
	private WebElement productHeader;
	//Username is required
	
	
	 public LoginPage(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	 }
	 
	 public void clearLogin() {
		 usernameField.clear();
		 passwordField.clear();
	 }
	 
	 public void goToLogin() {
		 openMenuButton.click();
		 loginMenuButton.click();
	 }
	 
	 public void login(String username, String password) {
		 usernameField.sendKeys(username);
	     passwordField.sendKeys(password);
	     loginButton.click();
	 }
	 
	 public String getErrorMessage() {
		 return errorMessage.getText();
	 }
	 
	 public String getHeaderMessage() {
		 return productHeader.getText();
	 }
	 
	 public String getEmptyErrorMessage() {
		 return emptyErrorMessage.getText();
	 }
	
	
}
