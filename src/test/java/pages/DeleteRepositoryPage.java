package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import runner.GitHubAutomationTest;

public class DeleteRepositoryPage extends AbstractPage{

		private final String BASE_URL = "https://github.com/";//there isn't a page for deleting repository
		private final Logger logger = LogManager.getRootLogger();
		
		@FindBy(xpath = "//*[@id='user-links']/li[3]/details/summary")
		private WebElement findPopToRepo;
		
		@FindBy(xpath = "//*[@id='user-links']/li[3]/details/details-menu/ul/li[4]/a")
		private WebElement findExistingRepositories;
			
//		@FindBy(xpath = "//*[@id='js-pjax-container']/div/div[2]/div[2]/nav/a[2]")
//		private WebElement findExistingRepositories2;
		
		@FindBy(xpath = "//*[@id=\"user-repositories-list\"]/ul/li[1]/div[1]/div[1]/h3/a[@href='/nata154/MyTest_123']")
		private WebElement findCertainRepository;
		
//		@FindBy(xpath = "//div[@id='user-repositories-list']/ul/li[@href='/nata154/MyTest_123']/div[1]/div[1]/h3/a")
//		private WebElement findCertainRepository2;
		
		@FindBy(xpath = "//div[@id='js-repo-pjax-container']/div[1]/nav/a[@href='/nata154/MyTest_123/settings']")
		private WebElement findCertainRepositorySettings;
		
	
//		@FindBy(xpath = "//*[@id='user-links']/li[3]/details/summary")
//		private WebElement findCertainRepositorySettings2;
		
//		@FindBy(xpath = "//*[@id='js-repo-pjax-container']/div[1]/nav/a[4]")
//		private WebElement findCertainRepositorySettings2;
		
		@FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/summary")
		private WebElement findButtonDeleteRepository;
	  		
		@FindBy(xpath = "//*[@id='options_bucket']/div[8]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
		private WebElement buttonPleaseTypeNameRepositoryToDelete;
		
		@FindBy(xpath = "//*[@id='options_bucket']/div[8]/ul/li[4]/details/details-dialog/div[3]/form/button")
		private WebElement buttonUnderstandConsequencesDeleteThisRepository;
				
		@FindBy(xpath = "//*[@id='sudo_password']")
		private WebElement enterPassword;
		
		@FindBy(xpath = "//*[@id='login']/form/div[3]/button")
		private WebElement buttonConfirmPassword;
		
		@FindBy(xpath = "//*[@id='js-flash-container']/div/div")
		private WebElement ensureDeleteRepository;
		
		public DeleteRepositoryPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(this.driver, this);
		}

		public void deleteRepository(String repositoryName, String password)
		{
			driver.navigate().to(BASE_URL);
			findPopToRepo.click();
			findExistingRepositories.click();
			//findExistingRepositories2.click();
			findCertainRepository.click();
			findCertainRepositorySettings.click();
			findButtonDeleteRepository.click();
			buttonPleaseTypeNameRepositoryToDelete.sendKeys(repositoryName);
			buttonUnderstandConsequencesDeleteThisRepository.click();
			//enterPassword.sendKeys(password);
			//buttonConfirmPassword.click();
			logger.info("Repository was deleted.");
		}
		
		public boolean hasDeletedSuchRepo()
		{
			return ensureDeleteRepository.isDisplayed();
		}

		@Override
		public void openPage()
		{
			driver.navigate().to(BASE_URL);
		}

	}
