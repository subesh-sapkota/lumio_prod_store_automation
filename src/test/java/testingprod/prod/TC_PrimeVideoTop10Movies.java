package testingprod.prod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_PrimeVideoTop10Movies{

	
	WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }

  @Test
public void getTop10Movies() {

    driver.get(
            "https://www.primevideo.com/movie?ref_=atv_hom_pri_c_9zZ8D2_hom"
    );

    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Wait for page load
    wait.until(webDriver ->
            ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState")
                    .equals("complete")
    );

    // Locator for Top 10 section title
    By top10Title = By.xpath(
            "//span[contains(normalize-space(),'Top 10 movies in India')]"
    );

    // Scroll until Top 10 title is found
    WebElement title = null;

    for (int i = 0; i < 20; i++) {

        List<WebElement> titles = driver.findElements(top10Title);

        if (!titles.isEmpty()) {
            title = titles.get(0);

            js.executeScript(
                    "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                    title
            );

            break;
        }

        js.executeScript(
                "window.scrollBy(0, window.innerHeight);"
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    Assert.assertNotNull(
            title,
            "Top 10 movies in India section was not found"
    );

    // Top 10 movie cards
    By movieCards = By.xpath(
            "//span[contains(normalize-space(),'Top 10 movies in India')]"
            + "/ancestor::*[.//article[@data-testid='card']][1]"
            + "//article[@data-testid='card']"
    );

    // Wait until 10 movies are loaded
    List<WebElement> movies = wait.until(
            ExpectedConditions.numberOfElementsToBeMoreThan(
                    movieCards, 9
            )
    );

    System.out.println("\n========== TOP 10 MOVIES ==========\n");

    for (int i = 0; i < movies.size(); i++) {

        String movieName =
                movies.get(i).getAttribute("data-card-title");

        System.out.println(
                (i + 1) + ". " + movieName
        );

        Assert.assertNotNull(
                movieName,
                "Movie name is null at position " + (i + 1)
        );

        Assert.assertFalse(
                movieName.trim().isEmpty(),
                "Movie name is empty at position " + (i + 1)
        );
    }

    // Validate exactly 10 movies
    Assert.assertEquals(
            movies.size(),
            10,
            "Expected exactly 10 movies"
    );

    System.out.println(
            "\nTotal movies found: " + movies.size()
    );
}
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
	
}
