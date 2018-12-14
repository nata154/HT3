package driver;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


	/**
	 * Created by Vitali_Shulha on 20-Oct-16.
	 */
	public class DriverSingleton {

	    private static WebDriver driver;
	    private static final Logger logger = LogManager.getRootLogger();
		private static final String CHROME_DRIVER = "webdriver.chrome.driver";
		private static final String CHROME_DRIVER_EXE_PATH = "c:\\Program Files\\eclipse-workspace\\HT3\\src\\test\\resources\\chromedriver.exe";
	   // private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	    //private static final String GECKODRIVER_GECKODRIVER_EXE_PATH = ".\\geckodriver\\geckodriver.exe";

	    private DriverSingleton(){};


	    public static WebDriver getDriver(){
	        if (null == driver){
	            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_EXE_PATH);
	            driver = new ChromeDriver();
	            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.manage().window().maximize();
	            logger.info("Browser started");
	        }

	        return driver;
	    }

	    public static void closeDriver(){
	        driver.quit();
	        driver = null;
	    }
	}
	

