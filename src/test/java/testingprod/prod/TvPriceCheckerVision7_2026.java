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

public class TvPriceCheckerVision7_2026 {

	private String storeWebsitePrice_43;
	private String storeWebsitePrice_55;
	
	private String mainWebsitePriceVision7_43;
	private String mainWebsitePriceVision7_55;
	

	
	
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
public void TC_02_getPriceMainWebsiteVision7() throws IOException, InterruptedException {

    driver.get("https://lumio.co.in/vision7-2026");

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

    String price43 = priceElement.getText();

    System.out.println("43 Inch Price: " + price43);


    // Find visible 65 inch button
    List<WebElement> buttons55 = productSection.findElements(
        By.xpath(".//button[normalize-space()='55\"']")
    );

    WebElement button55inch = null;

    for (WebElement button : buttons55) {

        if (button.isDisplayed()) {
            button55inch = button;
            break;
        }
    }

    Assert.assertNotNull(
        button55inch,
        "65 inch button was not found"
    );


    js.executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        button55inch
    );

    wait.until(
        ExpectedConditions.elementToBeClickable(button55inch)
    ).click();

    log.info("Clicked 65 inch button");


    // Wait for price to change
    String oldPrice = price43;

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
    String price55 = productSection
        .findElement(priceLocator)
        .getText();

    System.out.println("55 Inch Price: " + price55);


    Assert.assertNotEquals(
        price55,
        price43,
        "Price should change after selecting 55 inch"
    );

    Assert.assertTrue(
        price55.contains("55"),
        "Expected 55 inch price but found: " + price55
    );

    log.info("TC_09_comparePrice : PASSED");
    
    mainWebsitePriceVision7_43=price43;
    mainWebsitePriceVision7_55=price55;
    
    
    
}
	

@Test(priority = 3,enabled=true)
public void TC_03_getPriceLumioStoreVision7_43_2026() {

    driver.get("https://store.lumio.co.in/vision7-43inch-2026");

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
    	
    	storeWebsitePrice_43=price;
  
}


@Test(priority = 4, enabled=true)
public void TC_04_getPriceLumioStoreVision7_55() {

    driver.get("https://store.lumio.co.in/vision7-55inch-2026");

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
    	
    	storeWebsitePrice_55=price;
  
}


@Test(priority = 5)
public void TC_05_comparePriceLumioStoreVision7_43()
{
	
	int mainPrice = Integer.parseInt(
			mainWebsitePriceVision7_43.substring(mainWebsitePriceVision7_43.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
			storeWebsitePrice_43.substring(storeWebsitePrice_43.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	//Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
	Assert.assertTrue(storePrice <= mainPrice,
	        "Store price should be less than or equal to main price!");
	
}






@Test(priority = 6)
public void TC_06_comparePriceLumioStoreVision7_55()
{
	
	int mainPrice = Integer.parseInt(
			 mainWebsitePriceVision7_55.substring( mainWebsitePriceVision7_55.indexOf("₹") + 1)
	                        .replaceAll("[^0-9]", "")
	);

	int storePrice = Integer.parseInt(
			 storeWebsitePrice_55.substring( storeWebsitePrice_55.indexOf("₹") + 1)
	                         .replaceAll("[^0-9]", "")
	);

	System.out.println("Main Website Price: " + mainPrice);
	System.out.println("Store Website Price: " + storePrice);

	//Assert.assertEquals(storePrice, mainPrice, "Prices do not match!");
	
	Assert.assertTrue(storePrice <= mainPrice,
	        "Store price should be less than or equal to main price!");
	
	
	
}





@AfterTest	
public void tearDown(){
	

	driver.close();
}
	
	
	
}
