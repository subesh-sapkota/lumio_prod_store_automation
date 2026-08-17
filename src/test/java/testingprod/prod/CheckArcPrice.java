package testingprod.prod;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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

public class CheckArcPrice {

	
	private String mainWebsitePriceArc5;
	private String storeWebsitePriceArc5;
	
	private String mainWebsitePriceArc7;
	private String storeWebsitePriceArc7;
	

	
	
	  public WebDriver driver;
	    WebDriverWait wait;
	    Actions act;
	    SoftAssert soft;
	   
	    private static final Logger log =
	            LoggerFactory.getLogger(AppTest.class);
	    
	    @Test(priority = 1)
	    public void TC_01_LumioHomepage() throws IOException, InterruptedException {

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
	    

@Test(priority = 2,enabled=true)
public void TC_02_getArc5() throws IOException, InterruptedException {

    driver.get("https://lumio.co.in/arc5");

    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    log.info("Opening browser");

    // Wait for main page HTML
    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

    // Scroll gradually to bottom to trigger lazy loading
    long lastHeight = 0;

    for (int i = 0; i < 2; i++) {

        js.executeScript(
            "window.scrollBy(0, 800);"
        );

        Thread.sleep(1000);

        long newHeight = ((Number) js.executeScript(
            "return document.body.scrollHeight"
        )).longValue();

        System.out.println("Scroll " + i + " | Page height: " + newHeight);

        if (newHeight == lastHeight && i > 5) {
            break;
        }

        lastHeight = newHeight;
    }

    // Force scroll to bottom
    js.executeScript(
        "window.scrollTo(0, document.body.scrollHeight);"
    );

    Thread.sleep(3000);


    
 


    WebElement priceElement = wait.until(
    	    ExpectedConditions.visibilityOfElementLocated(
    	        By.xpath("//img[@alt='arc5 logo']/parent::div//p//span")
    	    )
    	);

      mainWebsitePriceArc5 = priceElement.getText();

    System.out.println("Arc5 Price: " +  mainWebsitePriceArc5);


  
    
    
}
	


@Test(priority = 3,enabled=true)
public void TC_03_getArc7() throws IOException, InterruptedException {

    driver.get("https://lumio.co.in/arc7");

    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    log.info("Opening browser");

    // Wait for main page HTML
    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

    // Scroll gradually to bottom to trigger lazy loading
    long lastHeight = 0;

    for (int i = 0; i < 2; i++) {

        js.executeScript(
            "window.scrollBy(0, 800);"
        );

        Thread.sleep(1000);

        long newHeight = ((Number) js.executeScript(
            "return document.body.scrollHeight"
        )).longValue();

        System.out.println("Scroll " + i + " | Page height: " + newHeight);

        if (newHeight == lastHeight && i > 5) {
            break;
        }

        lastHeight = newHeight;
    }

    // Force scroll to bottom
    js.executeScript(
        "window.scrollTo(0, document.body.scrollHeight);"
    );

    Thread.sleep(3000);


    
 


    WebElement priceElement = wait.until(
    	    ExpectedConditions.visibilityOfElementLocated(
    	        By.xpath("//img[@alt='arc7 logo']/parent::div//p//span")
    	    )
    	);

    mainWebsitePriceArc7 = priceElement.getText();

    System.out.println("Arc7 Price: " + mainWebsitePriceArc7);


  
    
    
}



@Test(priority = 4)
public void TC_03_getPriceLumioStoreArc5() {

    driver.get("https://store.lumio.co.in/arc5");

    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    act = new Actions(driver);
    soft = new SoftAssert();

    log.info("Opening browser");

    String currentUrl = driver.getCurrentUrl();
    log.info("Current URL: {}", currentUrl);

    WebElement priceElement = wait.until(
    	    ExpectedConditions.visibilityOfElementLocated(
    	        By.xpath("//span[contains(@class,'text-2xl') and contains(@class,'font-bold') and contains(@class,'darker-grotesque')]")
    	    )
    	);

    	 storeWebsitePriceArc5 = priceElement.getText();
    	System.out.println("Price: " + storeWebsitePriceArc5);
    	
  
}


@Test(priority = 5)
public void TC_04_getPriceLumioStoreArc7() {

    driver.get("https://store.lumio.co.in/arc7");

    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    act = new Actions(driver);
    soft = new SoftAssert();

    log.info("Opening browser");

    String currentUrl = driver.getCurrentUrl();
    log.info("Current URL: {}", currentUrl);

    WebElement priceElement = wait.until(
    	    ExpectedConditions.visibilityOfElementLocated(
    	        By.xpath("//span[contains(@class,'text-2xl') and contains(@class,'font-bold') and contains(@class,'darker-grotesque')]")
    	    )
    	);

    storeWebsitePriceArc7 = priceElement.getText();
    	System.out.println("Price: " +  storeWebsitePriceArc7);
    	
    	
  
}


@Test(priority = 6)
public void TC_05_comparePriceLumioStoreArc5()
{
	
	int mainPrice = Integer.parseInt(
			mainWebsitePriceArc5.substring(mainWebsitePriceArc5.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
			storeWebsitePriceArc5.substring(storeWebsitePriceArc5.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
}




@Test(priority = 7)
public void TC_07_comparePriceLumioStoreArc7()
{
	
	int mainPrice = Integer.parseInt(
			mainWebsitePriceArc7.substring(mainWebsitePriceArc7.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
			storeWebsitePriceArc7.substring(storeWebsitePriceArc7.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
}





@AfterTest	
public void tearDown(){
	

	driver.close();
}
	
	
}
