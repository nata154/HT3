package pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://github.com/login";

	@FindBy(id = "login_field")
	private WebElement inputLogin;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//meta[@name='user-login']")
	private WebElement linkLoggedInUser;
	
	@FindBy(xpath = "//ul[@id='user-links']/li[3]/details/summary/span")
	private WebElement findPathToProfile;
	
	@FindBy(xpath = "//ul[@id='user-links']/li[3]/details/details-menu/ul/li[3]/a")
	private WebElement findButtonMyProfile;
		
	@FindBy(xpath = "//div[@id='js-pjax-container']/div/div[1]/div[4]/button")
	private WebElement findButtonAddBio;
	
	@FindBy(xpath = "//div[@id='js-pjax-container']/div/div[1]/form/div/textarea")
	private WebElement findTextArea;
	
	@FindBy(xpath = "//div[@id='js-pjax-container']/div/div[1]/form/div/div/div/button[1]")
	private WebElement findButtonSaveBio;
	
	@FindBy(xpath = "//div[@id='js-pjax-container']//div[text()='Junior Java Automation Engineer']/text()")
	private WebElement findLineWithNewBio;
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}

	public String getLoggedInUserName()
	{
		return linkLoggedInUser.getAttribute("content");
	}
	
	public void addBio(String newBIO) {
		findPathToProfile.click();
		findButtonMyProfile.click();
		findButtonAddBio.click();
		findTextArea.clear();
		findTextArea.sendKeys(newBIO);
		findButtonSaveBio.click();
	}
	
	public String findlineWasAddedInBio()
	{
		return findLineWithNewBio.getText();//get Text dont work - returns empty lin
	}
	
//	public String getDeleteUserText() {
//		return text.getText().substring(0, text.getText().indexOf('?') + 1);
//	}
	
	public boolean findlineWasAddedInBio2()
	{
		//<div>Junior Java Automation Engineer </div>
		return findLineWithNewBio.getText().contains("Junior Java Automation Engineer");//returns empty line
	}
	
//	public boolean pageContains_lineNewUserName(String enter_username) {
//		try {
//			lineNewUserName.isDisplayed();
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
	
//	public String pageContains_lineNewUserName() {
//		return lineNewUserName.getText();
//	}

}