package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends AbstractPage{

	private final String BASE_URL = "https://github.com/settings/";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(xpath = "//div[@id='js-pjax-container']/div/div[1]/nav[1]/a[3]")
	private WebElement findEmailSettings;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement findLineAddAdress;
	
	@FindBy(xpath = "//form[@id=\"new_user_email\"]/dl/dd/button")
	private WebElement buttonAddEmail;
	
	@FindBy(xpath = "//ul[@id='settings-emails']/li[2]")
	private WebElement checkAddedEmail;
	
	
	public SettingsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void addEmails(String newAdress)
	{
		driver.navigate().to(BASE_URL);
		findEmailSettings.click();
		findLineAddAdress.clear();
		findLineAddAdress.sendKeys(newAdress);
		buttonAddEmail.click();
		logger.info("Email was added.");
	}
	
	public boolean wasEmailAdded()
	{
		return checkAddedEmail.isDisplayed();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

	
		
}
