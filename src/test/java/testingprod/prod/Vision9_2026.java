package testingprod.prod;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Vision9_2026 {

	

	  public WebDriver driver;
	    WebDriverWait wait;
	    Actions act;
	    SoftAssert soft;
	   
	    private static final Logger log =
	            LoggerFactory.getLogger(AppTest.class);
  
	    @Test(priority = 1)
	    public void TC_01_OpenBrowser() {

	        ChromeOptions options = new ChromeOptions();

	      //  options.addArguments("--headless=new");
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

	        driver.get("https://lumio.co.in/vision9-2026");
	        

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        act = new Actions(driver);
	        soft = new SoftAssert();
	        log.info("Opening browser");

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("/vision9-2026"),
	            "Expected URL to contain lumio.co.in but was: " + currentUrl
	        );
	        
	        WebElement productTitle = driver.findElement(
	        	    By.xpath("//h2[normalize-space()='65\" QD-MINILED 2026']")
	        	);
	        
	        Assert.assertEquals(
	        	    driver.getTitle(),
	        	    "Lumio Vision 9 2026",
	        	    "Page title does not match"
	        	);
	        
	        

	        log.info("TC_02_Vision9_2026: PASSED");
	        
	        
	        
	        //A Grander Vision.
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        By visionHeading = By.xpath(
	            "//h3[contains(.,'A Grander') and contains(.,'Vision')]"
	        );

	        WebElement heading = wait.until(
	            ExpectedConditions.presenceOfElementLocated(visionHeading)
	        );

	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            heading
	        );

	        wait.until(ExpectedConditions.visibilityOf(heading));

	        String actualText = (String) ((JavascriptExecutor) driver)
	                .executeScript("return arguments[0].textContent;", heading);

	        actualText = actualText.replaceAll("\\s+", " ").trim();

	       System.out.println("Actual: [" + actualText + "]");

	        Assert.assertEquals(actualText, "A Grander Vision.");
	        
	        
	        
	        //The biggest Lumio Vision yet. 65 inches of flagship engineering. More immersive, more commanding in any room.
	       

	        WebElement visionText = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//p[contains(.,'The biggest Lumio Vision yet.') and contains(.,'65 inches of flagship engineering.')]")
	            )
	        );

	        String actualText1 = visionText.getText().replaceAll("\\s+", " ").trim();

	        System.out.println("Actual text: [" + actualText1 + "]");

	        Assert.assertEquals(
	            actualText1,
	            "The biggest Lumio Vision yet. 65 inches of flagship engineering. More immersive, more commanding in any room."
	        );
	        
	        
	        
	        //India's Fastest Smart TV, Now Faster.
	        
	        
	        WebElement heading1 = driver.findElement(
	        	    By.xpath("//h3[.//span[normalize-space()='Fastest'] and contains(., \"India's\") and contains(., 'Now Faster')]")
	        	);

	        	String actualText2 = heading1.getText().replaceAll("\\s+", " ").trim();

	        	System.out.println("Heading: [" + actualText2 + "]");

	        	Assert.assertEquals(
	        	    actualText2,
	        	    "India's Fastest Smart TV, Now Faster."
	        	);
	        
	        
	    }
	    

	    @AfterTest	
	    public void tearDown(){
	    	

	    	driver.close();
	    }
	
	
}
