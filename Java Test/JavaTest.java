import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.net.URL;


class JavaTest {

//  public static final String USERNAME = "phillipramirez";
//  public static final String ACCESS_KEY = "8d1823e8-289b-4737-b678-87e93623ca94";
  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
//  public static String id;
  
  
  public static void main(String[] args) throws Exception {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 10");
    caps.setCapability("version", "latest");
    caps.setCapability("name", "Java Test - Checkmark for pass/fail");
    caps.setCapability("build", "Java Testing - Yay");

 
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    WebDriverWait wait = new WebDriverWait(driver, 30);
//    id = ((RemoteWebDriver) driver).getSessionId().toString();
    WebElement messageElement = null;
 
    driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

    
    driver.findElement(By.xpath("//div[2]/div/div/div/button")).click();
   
    messageElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(
            By.id("finish")));
//            		By.tagName('Open Menu')));
        
//            By.ByClassName("logo navbar-brand")));
    String pageTitle = driver.getTitle();
    System.out.println("title of page is: " + pageTitle);
//    assertEquals(pageTitle, "Pageroni");
 
    driver.quit();
  }
  
/*  @AfterMethod
  	public void after(ITestResult testResult()) {
		SauceREST restAPI = new SauceREST(phillipamirez,ACCESSKEY);
	  
		if (testResult.isSuccess()) {
				rest.API.jobPassed(id);
		  	} else {
			  	restAPI.jobFailed(id);
		  	}
		}
    }	
	*/
    
}