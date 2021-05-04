package BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {

	public WebDriver driver;
	public SoftAssert softAssertion;
	public JavascriptExecutor js;


	@BeforeClass
	@Parameters({ "browser", "pageUrl"})
	public void Setup(String browser, String pageUrl) {
		switch (browser) {
		case "chrome": 
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		    break; 
		case "edge": 
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		    break; 
		
		case "IEDriver": 
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Drivers\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		    break; 
	
		default: 
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
				    break; 

		}
		driver.manage().window().maximize();
		driver.get(pageUrl);
		js = (JavascriptExecutor) driver;

		softAssertion= new SoftAssert();
	}

	@AfterClass
	public void TearDown() {
		driver.close();
	}

}
