package steps;

import driver.DriverSingleton;
import pages.CreateNewRepositoryPage;
import pages.DeleteRepositoryPage;
import pages.LoginPage;
import pages.MainPage;
import utils.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void openBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeBrowser()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public String getLoggedInUserName()
	{
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.getLoggedInUserName().trim().toLowerCase();
	}

	public void createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

	public String getCurrentRepositoryName(){
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.getCurrentRepositoryName();
	}

	public String generateRandomRepositoryNameWithCharLength(int howManyChars){
		String repositoryNamePrefix = "testRepo_";
		return repositoryNamePrefix.concat(Utils.getRandomString(howManyChars));
	}
	
	public String createFixNameRepository(){
		String repositoryNamePrefix = "MyTest_";
		return repositoryNamePrefix.concat("123");
	}
	
	public void deleteRepository(String repositoryName, String password)
	{
		DeleteRepositoryPage deleteRepositoryName = new DeleteRepositoryPage(driver);
		deleteRepositoryName.deleteRepository(repositoryName, password);
	}
	
	public boolean ensureDeleteRepository()
	{
		DeleteRepositoryPage deleteRepositoryName = new DeleteRepositoryPage(driver);
		return deleteRepositoryName.hasDeletedSuchRepo();
	}

}
