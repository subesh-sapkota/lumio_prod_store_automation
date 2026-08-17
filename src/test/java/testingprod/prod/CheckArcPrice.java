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

	
	private String mainWebsitePrice;
	private String storeWebsitePrice;
	
	private String mainWebsitePriceVision9_65;
	private String storeWebsitePriceVision9_65;
	
	private String storeWebsitePriceVision9_55_2026;
	
	
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
public void TC_02_getPriceMainWebsiteVision9() throws IOException, InterruptedException {

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
    	        By.xpath("//img[@alt='arc7 logo']/parent::div//p//span")
    	    )
    	);

    String price55 = priceElement.getText();

    System.out.println("55 Inch Price: " + price55);


  
    
    
}
	

@Test(priority = 3,enabled=false)
public void TC_03_getPriceLumioStoreVision9_55() {

    driver.get("https://store.lumio.co.in/vision9-55inch");

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

    	String price = priceElement.getText();
    	System.out.println("Price: " + price);
    	
    	 storeWebsitePrice=price;
  
}


@Test(priority = 7,enabled=false)
public void TC_04_getPriceLumioStoreVision9_55_2026() {

    driver.get("https://store.lumio.co.in/vision9-55inch-2026");

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

    	String price = priceElement.getText();
    	System.out.println("Price: " + price);
    	
    	 storeWebsitePriceVision9_55_2026=price;
  
}


@Test(priority = 4,enabled=false)
public void TC_05_comparePriceLumioStoreVision9_55()
{
	
	int mainPrice = Integer.parseInt(
	        mainWebsitePrice.substring(mainWebsitePrice.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
	        storeWebsitePrice.substring(storeWebsitePrice.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
}




@Test(priority = 5,enabled=false)
public void TC_06_getPriceLumioStoreVision9_65() {

    driver.get("https://store.lumio.co.in/vision9-65inch-2026");

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

    	String price = priceElement.getText();
    	System.out.println("Price: " + price);
    	
    	storeWebsitePriceVision9_65=price;
  
}


@Test(priority = 6,enabled=false)
public void TC_07_comparePriceLumioStoreVision9_65()
{
	
	int mainPrice = Integer.parseInt(
			mainWebsitePriceVision9_65.substring(mainWebsitePriceVision9_65.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
			storeWebsitePriceVision9_65.substring(storeWebsitePriceVision9_65.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
}


@Test(priority = 8,enabled=false)
public void TC_08_comparePriceLumioStoreVision9_55_2026()
{
	
	int mainPrice = Integer.parseInt(
	        mainWebsitePrice.substring(mainWebsitePrice.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
			storeWebsitePriceVision9_55_2026.substring(storeWebsitePriceVision9_55_2026.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	//Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
    Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
	
}




@AfterTest	
public void tearDown(){
	

	driver.close();
}
	
	
}
