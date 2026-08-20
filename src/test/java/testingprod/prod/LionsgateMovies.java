package testingprod.prod;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LionsgateMovies {

	
	@Test(priority=1)
	
    public  void lionsgate() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://lionsgateplay.com/movies");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Set<String> movieUrls = new LinkedHashSet<>();

        long lastHeight = 0;

        for (int i = 0; i < 10; i++) {

            List<WebElement> movies = driver.findElements(
                    By.xpath("//a[contains(@href, '/movies/')]")
            );

            for (WebElement movie : movies) {

                String href = movie.getAttribute("href");

                if (href != null && !href.isEmpty()) {
                    movieUrls.add(href);
                }
            }

            System.out.println(
                    "Movies found so far: " + movieUrls.size()
            );

            js.executeScript(
                    "window.scrollTo(0, document.body.scrollHeight);"
            );

            Thread.sleep(3000);

            long newHeight = (Long) js.executeScript(
                    "return document.body.scrollHeight"
            );

            if (newHeight == lastHeight) {
                break;
            }

            lastHeight = newHeight;
        }

        System.out.println("\n========== MOVIES ==========\n");

        int count = 1;

        for (String url : movieUrls) {
            System.out.println(count + ". " + url);
            count++;
        }

        driver.quit();
    }
}