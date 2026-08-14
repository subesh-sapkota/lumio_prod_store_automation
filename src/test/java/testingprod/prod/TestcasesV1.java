package testingprod.prod;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class TestcasesV1 {

	
	
	  public WebDriver driver;
	    WebDriverWait wait;
	    Actions act;
	    SoftAssert soft;
	   
	    private static final Logger log =
	            LoggerFactory.getLogger(AppTest.class);
	    
	    public int getHttpStatusCode(String url) throws IOException, InterruptedException {

	        HttpClient client = HttpClient.newHttpClient();

	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .GET()
	                .build();

	        HttpResponse<Void> response = client.send(
	                request,
	                HttpResponse.BodyHandlers.discarding());

	        log.info("URL: {}", url);
	        log.info("HTTP Status Code: {}", response.statusCode());

	        return response.statusCode();
	    }
	    

	    @Test(priority = 1)
	    public void TC_01_LumioHomepage() throws IOException, InterruptedException {

	        ChromeOptions options = new ChromeOptions();

	       // options.addArguments("--headless=new");
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
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");

	        log.info("TC_01_Homepage lumio.com : PASSED");
	        
	        
	    }
	
	    @Test(priority = 9)
	    public void TC_09_support() throws IOException, InterruptedException {

	        log.info("Opening Support page");

	        driver.get("https://lumio.co.in/support");

	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        act = new Actions(driver);
	        soft = new SoftAssert();

	        // Wait for page completely loaded
	        wait.until(webDriver ->
	            "complete".equals(
	                ((JavascriptExecutor) webDriver)
	                    .executeScript("return document.readyState")
	            )
	        );

	        String currentUrl = driver.getCurrentUrl();

	        log.info("Current URL: {}", currentUrl);

	        Assert.assertTrue(
	            currentUrl.contains("lumio.co.in/support"),
	            "Expected URL to contain lumio.co.in/support but was: " + currentUrl
	        );

	        // Wait for title
	        wait.until(ExpectedConditions.titleIs("Support"));

	        Assert.assertEquals(
	            driver.getTitle(),
	            "Support",
	            "Page title does not match"
	        );

	        // Search box
	        By searchBoxLocator = By.xpath(
	            "//input[@placeholder='Search products, warranty, services and more']"
	        );

	        // Wait for search box
	        WebElement searchBox = wait.until(
	            ExpectedConditions.elementToBeClickable(searchBoxLocator)
	        );

	        // Scroll into view - useful for headless mode
	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block: 'center'});",
	            searchBox
	        );

	        // Click search box
	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();",
	            searchBox
	        );

	        // Clear existing text
	        searchBox.sendKeys(Keys.COMMAND + "a");
	        searchBox.sendKeys(Keys.BACK_SPACE);

	        log.info("Searching for Arc 7");

	        // Enter search text
	        searchBox.sendKeys("Arc 7");

	        // Verify text entered successfully
	        wait.until(ExpectedConditions.attributeToBe(
	            searchBoxLocator,
	            "value",
	            "Arc 7"
	        ));

	        Thread.sleep(1000);

	        // Press Enter
	        searchBox.sendKeys(Keys.ENTER);

	        log.info("Waiting for COMPLETE Arc 7 search result");

	        // Wait up to 90 seconds for complete response
	        WebDriverWait resultWait =
	            new WebDriverWait(driver, Duration.ofSeconds(90));

	        resultWait
	            .pollingEvery(Duration.ofSeconds(1))
	            .ignoring(StaleElementReferenceException.class);

	        // Wait until ALL expected Arc 7 information is available
	        String pageText = resultWait.until(webDriver -> {

	            try {

	                String text = webDriver
	                    .findElement(By.tagName("body"))
	                    .getText();

	                boolean hasArc7 =
	                    text.contains("Arc 7");

	                boolean hasPower =
	                    text.contains("120W");

	                boolean hasResolution =
	                    text.contains("1080p");

	          

	                log.info(
	                    "Checking result -> Arc7: {}, 120W: {}, 1080p: {}, 2.36kg: {}",
	                    hasArc7,
	                    hasPower,
	                    hasResolution
	                    
	                );

	                // Return text only when COMPLETE result is available
	                if (hasArc7
	                        && hasPower
	                        && hasResolution
	                     ) {

	                    return text;
	                }

	                return null;

	            } catch (StaleElementReferenceException e) {

	                log.info(
	                    "Page is re-rendering. Waiting for complete result..."
	                );

	                return null;
	            }
	        });

	        log.info("Complete Arc 7 result received");

	        System.out.println("=================================");
	        System.out.println("COMPLETE ARC 7 ANSWER:");
	       
	        System.out.println("=================================");

	        // Validate Arc 7
	        Assert.assertTrue(
	            pageText.contains("Arc 7"),
	            "Arc 7 was not found in the search result"
	        );

	        Assert.assertTrue(
	            pageText.contains("120W"),
	            "Expected power consumption 120W was not found"
	        );

	        Assert.assertTrue(
	            pageText.contains("1080p"),
	            "Expected Full HD 1080p information was not found"
	        );

	    

	        log.info("TC_09_support PASSED");
	    }
	  
	  @AfterTest	
	    public void tearDown(){
	    	

	    	driver.close();
	    }
}
