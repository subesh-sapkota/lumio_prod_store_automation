package testingprod.prod;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lumio_co_in {

	  public WebDriver driver;
	    WebDriverWait wait;
	    Actions act;
	    SoftAssert soft;
	   
	    private static final Logger log =
	            LoggerFactory.getLogger(AppTest.class);

	    @Test(priority = 1)
	    public void TC_01_LumioHomepage() {

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

	        driver.get("https://lumio.co.in/");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("lumio.co.in"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"Lumio");

	        log.info("TC_01_Homepage lumio.com : PASSED");
	        
	        
	    }
	    
	    @Test(priority = 2)
	    public void TC_02_vision9_2026() {

	       

	        driver.get("https://lumio.co.in/vision9-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/vision9-2026"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );

	        Assert.assertEquals(driver.getTitle(),"Lumio Vision 9 2026");
	        
	        log.info("TC_02_vision9_2026 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 3)
	    public void TC_03_vision7_2026() {

	       

	        driver.get("https://lumio.co.in/vision7-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/vision7-2026"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );

	        
	        Assert.assertEquals(driver.getTitle(),"Lumio Vision 7 2026");
	        
	        log.info("TC_03_vision7_2026 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 4)
	    public void TC_04_vision7() {

	       

	        driver.get("https://lumio.co.in/vision7");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/vision7"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );

	        Assert.assertEquals(driver.getTitle(),"Lumio Vision 7");
	        
	        log.info("TC_04_vision 7 : PASSED");
	        
	        
	    }
	    
	    
	    
	    
	    @Test(priority = 5)
	    public void TC_05_arc5() {

	       

	        driver.get("https://lumio.co.in/arc5");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/arc5"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"Lumio Arc 5");

	        log.info("TC_05_arc5 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 6)
	    public void TC_06_arc7() {

	       

	        driver.get("https://lumio.co.in/arc7");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/arc7"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );

	        Assert.assertEquals(driver.getTitle(),"Lumio Arc 7");
	        
	        log.info("TC_06_arc7 : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 7)
	    public void TC_07_tldr() {

	       

	        driver.get("https://lumio.co.in/tldr");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/tldr"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"TLDR");

	        log.info("TC_07_tldr : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 8)
	    public void TC_08_about() {

	       

	        driver.get("https://lumio.co.in/about");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/about"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"Lumio");

	        log.info("TC_08_about : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 9)
	    public void TC_09_support() {

	       

	        driver.get("https://lumio.co.in/support");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/support"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"Support");
	        
	        WebElement searchBox = driver.findElement(
	        	    By.xpath("//input[@placeholder='Search products, warranty, services and more']")
	        	);
	        
	        searchBox.sendKeys("Arc 5");
	        searchBox.sendKeys(Keys.ENTER);
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        WebElement arc5Description = wait.until(
	        	    ExpectedConditions.visibilityOfElementLocated(
	        	        By.xpath("//div[contains(@class,'prose-invert') and contains(@class,'text-white') and .//b[normalize-space()='Arc 5']]")
	        	    )
	        	);

	        String answer = arc5Description.getText();

	        System.out.println("Answer: " + answer);

	        Assert.assertTrue(
	            answer != null && !answer.trim().isEmpty(),
	            "Answer should not be empty"
	        );
	        	
	        	

	        	

	        	log.info("TC_09_support : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 10,enabled=false)
	    public void footerCheck() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for page to load
	        wait.until(driver ->
	            ((JavascriptExecutor) driver)
	                .executeScript("return document.readyState")
	                .equals("complete")
	        );

	        // Scroll to bottom
	        ((JavascriptExecutor) driver).executeScript(
	            "window.scrollTo(0, document.body.scrollHeight);"
	        );

	        // Wait for footer
	        WebElement footer = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.id("footer")
	            )
	        );

	        Assert.assertTrue(
	            footer.isDisplayed(),
	            "Footer is not displayed"
	        );

	        System.out.println("Footer is displayed successfully.");

	        // Get all links inside footer
	        List<WebElement> footerLinks = footer.findElements(
	            By.xpath(".//a[@href]")
	        );

	        Assert.assertTrue(
	            footerLinks.size() > 0,
	            "No links found inside footer"
	        );

	        System.out.println("Total footer links: " + footerLinks.size());

	        // Get and validate all URLs
	        for (WebElement link : footerLinks) {

	            String url = link.getAttribute("href");
	            String text = link.getText().trim();

	            System.out.println(
	                "Text: " + text + " | URL: " + url
	            );

	            Assert.assertNotNull(
	                url,
	                "Footer link URL is null"
	            );

	            Assert.assertFalse(
	                url.trim().isEmpty(),
	                "Footer link has empty URL. Text: " + text
	            );
	        }
	    } 
	    
	    
	    @Test(priority = 11)
	    
	    public void TC_10_installation_Request()
	    {
	    
      driver.get("https://forms.lumio.co.in/s/qgx2ee63vqg0jo2e4r2kt7s9");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://forms.lumio.co.in/s/qgx2ee63vqg0jo2e4r2kt7s9"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"Welcome! | Formbricks");

	        log.info("TC_10_installation_Request : PASSED");
	    	
	    	
	    }
	    
	    
	    
	    
	    @Test(priority = 11)
	    
	    public void TC_11_registration()
	    {
	    
      driver.get("https://lumio.co.in/registration");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("https://lumio.co.in/registration"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        Assert.assertEquals(driver.getTitle(),"Register Your Lumio Product");

	        log.info("TC_11_registration : PASSED");
	    	
	    	
	    }
	    
	    
	    
	    
	    

	    @AfterTest	
	    public void tearDown(){
	    	

	    	driver.close();
	    }
	
	
	
}
