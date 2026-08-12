package testingprod.prod;



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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.Reporter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest {

   
	
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

	        log.info("TC_01_OpenBrowser: PASSED");
	        
	        
	    }
	    
	    
	 @Test(priority = 2,enabled = true)
public void TC_02_checkNavBar() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String[] expectedMenuItems = {
        "VISION",
        "ARC",
        "TLDR",
        "Company",
        "Support",
        "Shop Now"
    };

    // =========================
    // NAV BAR TEXT VALIDATION
    // =========================

    List<WebElement> menuItems = driver.findElements(
        By.xpath("//nav//span[@class and contains(@class, 'group cursor-pointer')]//div[@class and contains(@class, 'font-gia')]")
    );

    for (int i = 0; i < 2; i++) {

        String actualText = menuItems.get(i).getText();

        log.info("Menu item: " + actualText);

        Assert.assertEquals(
            actualText,
            expectedMenuItems[i],
            "Menu item mismatch at index " + i
        );
    }


    // =========================
    // TLDR NAVIGATION
    // =========================

    WebElement tldrLink = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@href='/tldr']")
        )
    );

    String actualTextTLDR = tldrLink.getText();

    Assert.assertEquals(
        actualTextTLDR,
        "TLDR",
        "TLDR text is incorrect"
    );

    tldrLink.click();

    wait.until(
        ExpectedConditions.urlContains("/tldr")
    );

    String currentUrl = driver.getCurrentUrl();

    log.info("TLDR Current URL: " + currentUrl);

    Assert.assertTrue(
        currentUrl.endsWith("/tldr"),
        "TLDR URL did not launch. Current URL: " + currentUrl
    );


    // =========================
    // COMPANY / ABOUT NAVIGATION
    // =========================

    WebElement about = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@href='/about']")
        )
    );

    String actualTextAbout = about.getText();

    Assert.assertEquals(
        actualTextAbout,
        "COMPANY",
        "Company menu text is incorrect"
    );

    about.click();

    wait.until(
        ExpectedConditions.urlContains("/about")
    );

    String currentUrl1 = driver.getCurrentUrl();

    log.info("Company Current URL: " + currentUrl1);

    Assert.assertTrue(
        currentUrl1.endsWith("/about"),
        "Company URL did not launch. Current URL: " + currentUrl1
    );


    // =========================
    // SUPPORT NAVIGATION
    // =========================

    WebElement supportLink = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@href='/support' and .//div[normalize-space()='Support']]")
        )
    );

    String actualTextSupport = supportLink.getText();

    Assert.assertEquals(
        actualTextSupport,
        "SUPPORT",
        "Support menu text is incorrect"
    );

    supportLink.click();

    wait.until(
        ExpectedConditions.urlContains("/support")
    );

    String currentUrl2 = driver.getCurrentUrl();

    log.info("Support Current URL: " + currentUrl2);

    Assert.assertTrue(
        currentUrl2.endsWith("/support"),
        "Support URL did not launch. Current URL: " + currentUrl2
    );


    // =========================
    // SHOP NOW BUTTON
    // =========================

    WebElement shopNowbutton =driver.findElement(By.xpath("//button[.//span[normalize-space()='Shop Now']]")); 
    String shopNowButtonText = shopNowbutton.getText(); 
    Assert.assertEquals(shopNowButtonText, "SHOP NOW"); 
   // List<WebElement> shopNowButtons = driver.findElements( By.xpath("//button[normalize-space()='Shop Now']") ); 
    
   
    
    log.info("TC_02_NavBar and shop now check: PASSED");
    
        	
    	    

    	 
    	 
    
}
	        
	
	 
	 @Test(priority = 3 ,enabled=true)
	 public void SubMenuValidation() {
		 
		   List<WebElement> menuItems = driver.findElements(
			        By.xpath("//nav//span[@class and contains(@class, 'group cursor-pointer')]//div[@class and contains(@class, 'font-gia')]")
			    );

			   

			     menuItems.get(0).click();
		

		    List<WebElement> products = driver.findElements(
		    	    By.xpath("//div[contains(@class,'grid')]/a[@href]")
		    	);
		    
		    
		    WebElement firstProduct = products.get(0);
		    WebElement secondProduct = products.get(1);
		    WebElement thirdProduct = products.get(2);

		    System.out.println("First Product: " + firstProduct.getText());
		    System.out.println("First Product URL: " + firstProduct.getAttribute("href"));
		    
		    
		    String[] expectedNames = {
		    	    "Vision 9 2026",
		    	    "Vision 7 2026",
		    	    "Vision 7"
		    	};

		    	String[] expectedDescriptions = {
		    	    "Fast. Fluid. Flagship.",
		    	    "Speed with QLED excellence",
		    	    "Speed with QLED excellence"
		    	};

		    	String[] expectedLinks = {
		    	    "/vision9-2026",
		    	    "/vision7-2026",
		    	    "/vision7"
		    	};

		    	Assert.assertEquals(products.size(), 5, "Product count mismatch");

		    	
		    	    // Product name
		    	    String actualName =  firstProduct.findElement(
		    	        By.xpath("//p//span[normalize-space()='Vision 9 2026']")
		    	    ).getText();

		    	    // Description
		    	    String actualDescription =  firstProduct .findElement(
		    	        By.xpath("//p[contains(@class,'text-[#525252]') and normalize-space()='Fast. Fluid. Flagship.']")
		    	    ).getText();

		    	    // Link
		    	    String actualLink =  firstProduct.getAttribute("href");

		    	    System.out.println("Product: " + actualName);
		    	    System.out.println("Description: " + actualDescription);
		    	    System.out.println("Link: " + actualLink);

		    	    Assert.assertEquals(actualName, "Vision 9 2026");
		    	    Assert.assertEquals( actualDescription, "Fast. Fluid. Flagship.");
		    	    Assert.assertEquals(actualLink, "https://lumio.co.in/vision9-2026");
		    	    
		    	    
		    	    System.out.println("Second Product: " + secondProduct.getText());
				    System.out.println("Second Product URL: " + secondProduct.getAttribute("href"));
				    
				 

				   
				   Assert.assertEquals(products.size(), 5, "Product count mismatch");

				    	
				    	    // Product name
				   String actualName1 =  secondProduct .findElement(
			    	        By.xpath("//p//span[normalize-space()='Vision 7 2026']")
			    	    ).getText();

			    	    // Description
			    	    String actualDescription1 =  secondProduct.findElement(
			    	        By.xpath("//p[contains(@class,'text-[#525252]') and normalize-space()='Speed with QLED excellence']")
			    	    ).getText();

			    	    // Link
			    	    String actualLink1 =  secondProduct.getAttribute("href");

			    	    System.out.println("Product: " + actualName1);
			    	    System.out.println("Description: " + actualDescription1);
			    	    System.out.println("Link: " + actualLink1);   
			    	    
			    	    Assert.assertEquals(actualName1, "Vision 7 2026");
			    	    Assert.assertEquals( actualDescription1, "Speed with QLED excellence");
			    	    Assert.assertEquals(actualLink1, "https://lumio.co.in/vision7-2026");
			    	    
			      	    // Product name
						   String actualName2 =  thirdProduct .findElement(
					    	        By.xpath("//p//span[normalize-space()='Vision 7']")
					    	    ).getText();

					    	    // Description
					    	    String actualDescription2 =  thirdProduct.findElement(
					    	        By.xpath("//p[contains(@class,'text-[#525252]') and normalize-space()='Speed with QLED excellence']")
					    	    ).getText();

					    	    // Link
					    	    String actualLink2 =  thirdProduct.getAttribute("href");

					    	    System.out.println("Product: " + actualName2);
					    	    System.out.println("Description: " + actualDescription2);
					    	    System.out.println("Link: " + actualLink2);   	
					    	    
					    	    Assert.assertEquals(actualName2, "Vision 7");
					    	    Assert.assertEquals( actualDescription2, "Speed with QLED excellence");
					    	    Assert.assertEquals(actualLink2, "https://lumio.co.in/vision7");
					    	    

					    	    WebElement supportLink = driver.findElement(
					    	    	    By.xpath("//h1//a[@href='/support' and normalize-space()='Support']")
					    	    	);

					    	    	Assert.assertEquals(supportLink.getText().trim(), "SUPPORT");
				    	    
				    	    
		    	    
		 
		 
		 
	 }
	 
	 

	
		 
	 
	@Test(priority= 4 , enabled=true )
		public void openshopdilog() {
		
		WebElement shopNowbutton =driver.findElement(By.xpath("//button[.//span[normalize-space()='Shop Now']]")); 
	    String shopNowButtonText = shopNowbutton.getText(); 
	    Assert.assertEquals(shopNowButtonText, "SHOP NOW");
	    shopNowbutton.click();
	    
	    
	    WebElement shopHeading = driver.findElement(
	    	    By.xpath("//h2[normalize-space()='Choose where to Shop']")
	    	);

	    	Assert.assertTrue(shopHeading.isDisplayed());
	    	Assert.assertEquals(shopHeading.getText(), "Choose where to Shop");
	    	
	    	
	    	WebElement lumioStore = driver.findElement(
	    		    By.xpath("//button[.//span[normalize-space()='Lumio Store']]")
	    		);

	    		WebElement amazon = driver.findElement(
	    		    By.xpath("//a[@aria-label='amazon' and .//span[normalize-space()='Amazon']]")
	    		);

	    		WebElement flipkart = driver.findElement(
	    		    By.xpath("//a[@aria-label='flipkart' and .//span[normalize-space()='Flipkart']]")
	    		);
	    
	    		
	    		Assert.assertEquals(lumioStore.getText().trim(), "Lumio Store",
	    		        "Lumio Store text is incorrect");

	    		Assert.assertEquals(amazon.getText().trim(), "Amazon",
	    		        "Amazon text is incorrect");

	    		Assert.assertEquals(flipkart.getText().trim(), "Flipkart",
	    		        "Flipkart text is incorrect");
	    		
	    		
	    		
			
		}
	
	 
@Test(priority = 5)
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
	
	@Test (priority=6 )
	public void footerNote()
	{
		
		// Footer notes container
		WebElement footerNotes = driver.findElement(
		    By.xpath("//div[contains(@class,'text-gray-500')]")
		);

		// Note 1
		WebElement note1 = footerNotes.findElement(
		    By.xpath(".//p[@id='footer-note-1']")
		);

		// Note 2
		WebElement note2 = footerNotes.findElement(
		    By.xpath(".//p[@id='footer-note-2']")
		);

		// Note 3
		WebElement note3 = footerNotes.findElement(
		    By.xpath(".//p[@id='footer-note-3']")
		);

		// Notes 4–7
		List<WebElement> notes4to7 = footerNotes.findElements(
		    By.xpath(".//p[@id='footer-note-4']")
		);

		// Assertions
		Assert.assertTrue(
		    note1.getText().contains("As per"),
		    "Footer Note 1 text is incorrect"
		);

		Assert.assertTrue(
		    note1.findElement(By.xpath(".//a[@aria-label='techarc study']")).isDisplayed(),
		    "Techarc study link is not displayed"
		);

		Assert.assertEquals(
		    note2.getText(),
		    "2. Smart TVs using Android / Google OS priced under Rs 1 Lakh.",
		    "Footer Note 2 text mismatch"
		);

		Assert.assertEquals(
		    note3.getText(),
		    "3. Google TV is the name of this device’s software experience and a trademark of Google LLC. Google, Google Photos, Google Cast and YouTube are trademarks of Google LLC.",
		    "Footer Note 3 text mismatch"
		);

		// Note 4
		Assert.assertEquals(
		    notes4to7.get(0).getText(),
		    "4. Dolby, Dolby Vision, Dolby Atmos, Dolby Audio, and the double-D symbol are trademarks of Dolby Laboratories Licensing Corporation. Manufactured under license from Dolby Laboratories. Confidential unpublished works. Copyright © 1992-2024 Dolby Laboratories. All rights reserved.",
		    "Footer Note 4 text mismatch"
		);

		// Note 5
		Assert.assertEquals(
		    notes4to7.get(1).getText(),
		    "5. All Rec.2020 colour values are highest values as measured internally in production line from the series.",
		    "Footer Note 5 text mismatch"
		);

		// Note 6
		Assert.assertEquals(
		    notes4to7.get(2).getText(),
		    "6. Lumio Vision 7 (2026) 43-inch/1.09m variant and 55-inch/1.4m is now on sale.",
		    "Footer Note 6 text mismatch"
		);

		// Note 7
		Assert.assertEquals(
		    notes4to7.get(3).getText(),
		    "7. Lumio products are designed to comply with standard HDMI CEC, ARC, and Bluetooth protocols; however, 100% interoperability with all third-party devices cannot be assured, as functionality may vary depending on factors such as the third-party device’s hardware or firmware implementation.",
		    "Footer Note 7 text mismatch"
		);
		

	}
	
	
	@Test  (priority=7 )
	
	public void checkWarrenty() {
		
		
		WebElement warrantyButton = driver.findElement(
			    By.xpath("//button[normalize-space()='Check Warranty & Services']")
			);

			Assert.assertTrue(
			    warrantyButton.isDisplayed(),
			    "Check Warranty & Services button is not displayed"
			);

			Assert.assertEquals(
			    warrantyButton.getText().trim(),
			    "CHECK WARRANTY & SERVICES",
			    "Button text mismatch"
			);
		
	}
	
	
	

	
	
	
	    @AfterTest	
	    public void tearDown(){
	    	

	    	driver.close();
	    }
	
}
