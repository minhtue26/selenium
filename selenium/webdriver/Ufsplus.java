package webdriver;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ufsplus {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() { 
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://beta.ufsplus.kwe.com/web/secure/landing/");
	}
	@Test
	public void TC_01_OpenLandingPage() throws InterruptedException {
		// Login Page Url matching
		driver.get("https://beta.ufsplus.kwe.com/web/secure/landing/");
		WebElement email = driver.findElement(By.id("inputEmail"));
		WebElement password = driver.findElement(By.id("inputPassword"));
		email.sendKeys("dev_kcr1");
		password.sendKeys("password1");;
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/button"));
		loginBtn.click();
		Thread.sleep(5000);
		WebElement SignOuttext = driver.findElement(By.cssSelector("#header > div.userDetailsContainer > span.logout"));
		System.out.println(SignOuttext.getText());
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
