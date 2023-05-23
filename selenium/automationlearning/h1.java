package automationlearning;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class h1 {
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
  @Test
  public void dangnhap() throws InterruptedException {
	  WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
	  WebElement pw = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
	  WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	  username.sendKeys("Admin") ;
	  pw.sendKeys("admin123");
	  submitbtn.click();
	  
	  Thread.sleep(5000);
  }
  @Test 
  public void getUsername() throws InterruptedException {
	  WebElement lbusrname = driver.findElement(By.className("oxd-userdropdown-name"));
	  WebElement adminpage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
	  
	  System.out.print(lbusrname);
	  adminpage.click();
	  Thread.sleep(10000);
  }
  
  
  @AfterClass
	public void afterClass() {
		driver.quit();
	}
}
