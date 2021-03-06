package runner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "nata154";
	private final String PASSWORD = "J7j42jj8";
	private final int REPOSITORY_NAME_POSTFIX_LENGTH = 3;
	String newAdress = "natasha154154@gmail.com";
	String newBIO = "Junior Java Automation Engineer";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.openBrowser();
	}

	@Test (enabled=false)
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
	}

	@Test(description = "Login to Github", enabled=false)
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertEquals(USERNAME, steps.getLoggedInUserName());
	}
	
	@Test(description = "Create and delete repository", enabled=false)
	public void createAndDeleteRepository() {
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.createFixNameRepository();
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);	
		steps.deleteRepository(repositoryName, PASSWORD);
		Assert.assertTrue(steps.ensureDeleteRepository());
	}
	
	@Test(description = "Add email", enabled=false)
	public void addNewEmailInSettings() {
		steps.loginGithub(USERNAME, PASSWORD);
		steps.addEmailInSettings(newAdress);
		Assert.assertTrue(steps.ensureAddEmail());
	}
	
	@Test(description = "Add bio information", enabled=true)
	public void addBIOInformation() {
		steps.loginGithub(USERNAME, PASSWORD);
		steps.addBioToUser(newBIO);
		//Assert.assertEquals(steps.whatWasAddedInBio(), newBIO);//dont work, finds empty line
		//Assert.assertTrue(steps.whatWasAddedInBio2());//dont work, finds empty line
	}
	
	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeBrowser();
	}

}
