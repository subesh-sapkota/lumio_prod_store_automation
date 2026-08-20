package testingprod.prod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JioHotstar {

	
	   @Test(priority = 1)
	public static void jiotest() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
       // https://www.hotstar.com/in/browse/top10/top-10-shows-hindi/reco-top_CgZwYWdlLTISATkgAQ
        //https://www.hotstar.com/in/browse/top10/top-10-movies/reco-top_CgZwYWdlLTMSBW1peGVkIAEoAg

        driver.get("https://www.hotstar.com/in/browse/top10/top-10-movies/reco-top_CgZwYWdlLTMSBW1peGVkIAEoAg");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait until movie cards are loaded
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@data-testid='action' and contains(@aria-label, ',Movie')]")
        ));

        // Get all movie cards
        List<WebElement> movies = driver.findElements(
                By.xpath("//div[@data-testid='action' and contains(@aria-label, ',Movie')]")
        );

        System.out.println("Total Movies: " + movies.size());

        for (int i = 0; i < movies.size(); i++) {

            String movieName = movies.get(i)
                    .getAttribute("aria-label")
                    .replace(",Movie", "")
                    .trim();

            System.out.println((i + 1) + ". " + movieName);
        }

        driver.quit();
    }
	
	
}
