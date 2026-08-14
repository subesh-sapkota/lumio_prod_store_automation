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

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Lumio_co_in {

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
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");

	        log.info("TC_01_Homepage lumio.com : PASSED");
	        
	        
	    }
	    
	    @Test(priority = 2)
	    public void TC_02_vision9_2026() throws IOException, InterruptedException {

	       

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
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/vision9-2026");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");
	        
	        log.info("TC_02_vision9_2026 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 3)
	    public void TC_03_vision7_2026() throws IOException, InterruptedException {

	       

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
	        
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/vision7-2026");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");
	        
	        log.info("TC_03_vision7_2026 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 4)
	    public void TC_04_vision7() throws IOException, InterruptedException {

	       

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
	        
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/vision7");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");
	        
	        log.info("TC_04_vision 7 : PASSED");
	        
	        
	    }
	    
	    
	    
	    
	    @Test(priority = 5)
	    public void TC_05_arc5() throws IOException, InterruptedException {

	       

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
	        
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/arc5");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");

	        log.info("TC_05_arc5 : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 6)
	    public void TC_06_arc7() throws IOException, InterruptedException {

	       

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
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/arc7");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");
	        
	        log.info("TC_06_arc7 : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 7)
	    public void TC_07_tldr() throws IOException, InterruptedException {

	       

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
	        
	      
	        int statusCode = getHttpStatusCode("https://lumio.co.in/tldr");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");
	        
	        log.info("TC_07_tldr : PASSED");
	        
	        
	    }
	    
	    
	    @Test(priority = 8)
	    public void TC_08_about() throws IOException, InterruptedException {

	       

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
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/about");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");

	        log.info("TC_08_about : PASSED");
	        
	        
	    }
	    
	    
	    
	    @Test(priority = 9)
	    public void TC_09_support() throws IOException, InterruptedException {

	        driver.get("https://lumio.co.in/support");

	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        log.info("Opening Support page");

	        Assert.assertTrue(
	            driver.getCurrentUrl().contains("lumio.co.in/support"),
	            "Incorrect Support page URL"
	        );

	        Assert.assertEquals(driver.getTitle(), "Support");

	        By searchBoxLocator = By.xpath(
	            "//input[@placeholder='Search products, warranty, services and more']"
	        );

	        // Wait for a fresh clickable element
	        WebElement searchBox = wait.until(
	            ExpectedConditions.elementToBeClickable(searchBoxLocator)
	        );

	        // Scroll using JavaScript
	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            searchBox
	        );

	        // Find again after scroll because React/Next may re-render
	        searchBox = wait.until(
	            ExpectedConditions.elementToBeClickable(searchBoxLocator)
	        );

	        // Click and type immediately
	        searchBox.click();
	        searchBox.sendKeys("Arc 5");

	        log.info("Searching for Arc 5");

	        // Wait for search result
	        By arc5Locator = By.xpath(
	            "//*[contains(normalize-space(), 'Arc 5')]"
	        );

	        WebElement arc5Description = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(arc5Locator)
	        );

	        String answer = arc5Description.getText();

	        System.out.println("==============================");
	        System.out.println("Answer: " + answer);
	        System.out.println("==============================");

	        Assert.assertFalse(
	            answer.trim().isEmpty(),
	            "Answer should not be empty"
	        );

	        int statusCode = getHttpStatusCode(
	            "https://lumio.co.in/support"
	        );

	        Assert.assertEquals(
	            statusCode,
	            200,
	            "Website did not return HTTP 200"
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
	    
	    public void TC_10_installation_Request() throws IOException, InterruptedException
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
	        
	        int statusCode = getHttpStatusCode("https://forms.lumio.co.in/s/qgx2ee63vqg0jo2e4r2kt7s9");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");

	        log.info("TC_10_installation_Request : PASSED");
	    	
	    	
	    }
	    
	    
	    
	    
	    @Test(priority = 11)
	    
	    public void TC_11_registration() throws IOException, InterruptedException
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
	        
	        int statusCode = getHttpStatusCode("https://lumio.co.in/registration");

	        Assert.assertEquals(statusCode, 200, "Website did not return HTTP 200");

	        log.info("TC_11_registration : PASSED");
	    	
	    	
	    }
	    
	    
	    
	    
	    

	    @AfterTest	
	    public void tearDown(){
	    	

	    	driver.close();
	    }
	
	
	
}
