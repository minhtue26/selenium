package assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class beforeTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  @AfterClass
  public void afterClass() {
		driver.quit();
	}
}
