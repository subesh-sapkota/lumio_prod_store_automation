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

public class TvPriceChecker {

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
public void TC_09_getPriceMainWebsiteVision9() throws IOException, InterruptedException {

    driver.get("https://lumio.co.in/vision9-2026");

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

    // NOW wait for Choose Size section
    By chooseSizeLocator = By.xpath(
        "//p[contains(normalize-space(.),'Choose Size')]"
    );

    WebElement chooseSize = wait.until(
        ExpectedConditions.presenceOfElementLocated(chooseSizeLocator)
    );

    // Bring section into center of screen
    js.executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        chooseSize
    );

    Thread.sleep(1000);

    System.out.println("Choose Size section found");


    // Find parent container
    WebElement productSection = chooseSize.findElement(
        By.xpath("./parent::div")
    );


    // Find current price
    By priceLocator = By.xpath(
        ".//p[contains(@class,'font-darkergrotesque')]//span"
    );

    WebElement priceElement = productSection.findElement(priceLocator);

    String price55 = priceElement.getText();

    System.out.println("55 Inch Price: " + price55);


    // Find visible 65 inch button
    List<WebElement> buttons65 = productSection.findElements(
        By.xpath(".//button[normalize-space()='65\"']")
    );

    WebElement button65inch = null;

    for (WebElement button : buttons65) {

        if (button.isDisplayed()) {
            button65inch = button;
            break;
        }
    }

    Assert.assertNotNull(
        button65inch,
        "65 inch button was not found"
    );


    js.executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        button65inch
    );

    wait.until(
        ExpectedConditions.elementToBeClickable(button65inch)
    ).click();

    log.info("Clicked 65 inch button");


    // Wait for price to change
    String oldPrice = price55;

    wait.until(driver -> {

        try {

            String newPrice = productSection
                .findElement(priceLocator)
                .getText();

            return !newPrice.isEmpty()
                    && !newPrice.equals(oldPrice);

        } catch (Exception e) {
            return false;
        }

    });


    // Get new price
    String price65 = productSection
        .findElement(priceLocator)
        .getText();

    System.out.println("65 Inch Price: " + price65);


    Assert.assertNotEquals(
        price55,
        price65,
        "Price should change after selecting 65 inch"
    );

    Assert.assertTrue(
        price65.contains("65"),
        "Expected 65 inch price but found: " + price65
    );

    log.info("TC_09_comparePrice : PASSED");
    
    mainWebsitePrice=price55;
    mainWebsitePriceVision9_65=price65;
    
    
    
}
	

@Test(priority = 3,enabled=true)
public void TC_09_getPriceLumioStoreVision9_55() {

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


@Test(priority = 7,enabled=true)
public void TC_09_getPriceLumioStoreVision9_55_2026() {

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


@Test(priority = 4)
public void TC_09_comparePriceLumioStoreVision9_55()
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




@Test(priority = 5,enabled=true)
public void TC_09_getPriceLumioStoreVision9_65() {

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


@Test(priority = 6)
public void TC_09_comparePriceLumioStoreVision9_65()
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


@Test(priority = 8)
public void TC_09_comparePriceLumioStoreVision9_55_2026()
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

	Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
}




@AfterTest	
public void tearDown(){
	

	driver.close();
}
	
	
}
