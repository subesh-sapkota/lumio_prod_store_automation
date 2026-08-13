package testingprod.prod;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LumioStore {
	
	  public WebDriver driver;
	    WebDriverWait wait;
	    Actions act;
	    SoftAssert soft;
	   
	    private static final Logger log =
	            LoggerFactory.getLogger(AppTest.class);

	    @Test(priority = 1)
	    public void TC_01_LumioStoreHomepage() throws IOException, InterruptedException {

	        ChromeOptions options = new ChromeOptions();

	      options.addArguments("--headless=new");
	        options.addArguments("--window-size=1920,1080");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-software-rasterizer");
	        options.addArguments("--disable-blink-features=AutomationControlled");

	        options.setExperimentalOption(
	            "excludeSwitches",
	            Arrays.asList("enable-automation")
	        );

	        options.setExperimentalOption(
	            "useAutomationExtension",
	            false
	        );

	        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) " +
	                "AppleWebKit/537.36 (KHTML, like Gecko) " +
	                "Chrome/120.0.0.0 Safari/537.36");

	        driver = new ChromeDriver(options);

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://store.lumio.co.in/");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://store.lumio.co.in/"),
	            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
	        );
	        
	       // Assert.assertEquals(driver.getTitle(),"Lumio Store | Buy official Lumio products online");
	        Assert.assertTrue(driver.getTitle().contains("Lumio Store | Buy official Lumio products online"));

	       
	    
	        
	        
	        log.info("TC_01_LumioStoreHomepage : PASSED");
	        
	        
	    }
	
	    @Test(priority = 2)
	    public void TC_02_LumioStoreVision7_43_2026() {

	     

	        driver.get("https://store.lumio.co.in/vision7-43inch-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://store.lumio.co.in/"),
	            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertTrue(driver.getTitle().contains("Lumio Vision 7 QLED TV"));
	        
	        

	        log.info("TC_02_LumioStoreVision7_43_2026 : PASSED");
	        
	        
	    }
	    
	    @Test(priority = 3)
	    public void TC_03_LumioStoreVision7_55_2026() {

	      

	        driver.get("https://store.lumio.co.in/vision7-55inch-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://store.lumio.co.in/"),
	            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
	        );
	        
	        
	        log.info(driver.getTitle());
	        
	       // Assert.assertEquals(driver.getTitle(),"Lumio Vision 7 QLED TV | Google TV by Lumio | Lumio");
	        Assert.assertTrue(driver.getTitle().contains("Lumio Vision 7 QLED TV | Google TV by Lumio"));
	       

	        log.info("TC_03_LumioStoreVision7_55_2026 : PASSED");
	        
	        
	    }
	    
	    @Test(priority = 4)
	    public void TC_04_LumioStoreVision9_55() {


	        driver.get("https://store.lumio.co.in/vision9-55inch");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://store.lumio.co.in/"),
	            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
	        );
	        
	     //   Assert.assertEquals(driver.getTitle(),"Lumio Vision 9 Mini LED TV | Flagship Google TV | Lumio");\
	        
	        
	        log.info(driver.getTitle());

	        Assert.assertTrue(driver.getTitle().contains("Lumio Vision 9 Mini LED TV | Flagship Google TV"));

	        
	        log.info("TC_04_LumioStoreVision9_55 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 5)
	    public void TC_05_LumioStoreVision9_55_2026() {

	       
	        driver.get("https://store.lumio.co.in/vision9-65inch-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://store.lumio.co.in/"),
	            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
	        );
	        
	      //  Assert.assertEquals(driver.getTitle(),"Lumio Vision 9 Mini LED TV | Flagship Google TV");
	        
	        
	        log.info(driver.getTitle());
	        
	      //  Assert.assertTrue(driver.getTitle().contains("Lumio Vision 9 Mini LED TV | Flagship Google TV"));


	        log.info("TC_05_LumioStoreVision9_55 : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 5)
	    public void TC_06_LumioStoreVision9_65() {

	        driver.get("https://store.lumio.co.in/vision9-65inch-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://store.lumio.co.in/"),
	            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
	        );
	        
	      //  Assert.assertEquals(driver.getTitle(),"Lumio Vision 9 65-inch 2026 4K MiniLED Google TV | Lumio");
	        
	        Assert.assertTrue(driver.getTitle().contains("Lumio Vision 9 65-inch 2026 4K MiniLED Google TV"));
	     

	        log.info("TC_06_LumioStoreVision9_65 : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 6)
	    public void TC_07_LumioStoreArc5() {
	    	
	    	 driver.get("https://store.lumio.co.in/arc5");
		        

		        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        act = new Actions(driver);
		        soft = new SoftAssert();
		        log.info("Opening browser");

		        String currentUrl = driver.getCurrentUrl();

		        log.info("Current URL: {}", currentUrl);

		        Assert.assertTrue(
		            currentUrl.contains("https://store.lumio.co.in/"),
		            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
		        );
		        
		      //  Assert.assertEquals(driver.getTitle(),"Lumio Vision 9 65-inch 2026 4K MiniLED Google TV | Lumio");
		        
		        Assert.assertTrue(driver.getTitle().contains("Lumio Arc 5 Google TV Projector"));


		        log.info("TC_07_LumioStoreArc5 : PASSED");
	    	
	    	
	    }
	    
	    @Test(priority = 7)
	    public void TC_08_LumioStoreArc7() {
	    	
	    	
	    	 driver.get("https://store.lumio.co.in/arc7");
		        

		        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        act = new Actions(driver);
		        soft = new SoftAssert();
		        log.info("Opening browser");

		        String currentUrl = driver.getCurrentUrl();

		        log.info("Current URL: {}", currentUrl);

		        Assert.assertTrue(
		            currentUrl.contains("https://store.lumio.co.in/"),
		            "Expected URL to contain store.lumio.co.in but was: " + currentUrl
		        );
		        
		      //  Assert.assertEquals(driver.getTitle(),"Lumio Vision 9 65-inch 2026 4K MiniLED Google TV | Lumio");
		        
		        Assert.assertTrue(driver.getTitle().contains("Lumio Arc 7 Google TV Projector"));


		        log.info("TC_08_LumioStoreArc7 : PASSED");
	    	
	    }
	    
	    

	    @AfterTest	
	    public void tearDown(){
	    	

	    	driver.close();
	    }
	    
	    
}
