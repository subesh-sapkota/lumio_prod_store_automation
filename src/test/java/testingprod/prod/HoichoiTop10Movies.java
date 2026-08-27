package testingprod.prod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HoichoiTop10Movies {

    @Test(priority = 1)
  public void hoichoi() throws InterruptedException {

    WebDriver driver = new ChromeDriver();

    WebDriverWait wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(30)
    );

    JavascriptExecutor js = (JavascriptExecutor) driver;

    try {

        driver.manage().window().maximize();

        driver.get("https://hoichoi.tv/");

        // Wait for page load
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        Thread.sleep(5000);

        System.out.println(
                "Page Title: " + driver.getTitle()
        );

        // ============================================
        // HEADING XPATH
        // ============================================

        By top10Heading = By.xpath(
                "//h2[normalize-space()='Top 10 Movies this Week']"
        );

        // ============================================
        // SCROLL UNTIL TOP 10 MOVIES APPEARS
        // ============================================

        WebElement heading = null;

        for (int i = 0; i < 40; i++) {

            List<WebElement> headings =
                    driver.findElements(top10Heading);

            if (!headings.isEmpty()) {

                heading = headings.get(0);

                System.out.println(
                        "Top 10 Movies section found!"
                );

                js.executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        heading
                );

                break;
            }

            // Scroll down
            js.executeScript(
                    "window.scrollBy(0, 700);"
            );

            Thread.sleep(1000);
        }

        // ============================================
        // VALIDATE HEADING
        // ============================================

        if (heading == null) {

            throw new RuntimeException(
                    "Top 10 Movies this Week section not found"
            );
        }

        // Wait until heading is visible
        wait.until(
                ExpectedConditions.visibilityOf(heading)
        );

        // ============================================
        // GET SECTION CONTAINER
        // ============================================

        WebElement section = heading.findElement(
                By.xpath("./parent::*")
        );

        // ============================================
        // FIND MOVIE CARDS
        // EXCLUDE /plans
        // ============================================

        List<WebElement> movies =
                section.findElements(
                        By.xpath(
                                ".//a[.//img and not(contains(@href, '/plans'))]"
                        )
                );

        // ============================================
        // FALLBACK
        // ============================================

        if (movies.isEmpty()) {

            section = heading.findElement(
                    By.xpath("./ancestor::*[2]")
            );

            movies = section.findElements(
                    By.xpath(
                            ".//a[.//img and not(contains(@href, '/plans'))]"
                    )
            );
        }

        // ============================================
        // PRINT HEADER
        // ============================================

        System.out.println();

        System.out.println(
                "===== TOP 10 MOVIES THIS WEEK ====="
        );

        System.out.println(
                "Total movie elements found: "
                        + movies.size()
        );

        System.out.println();

        // ============================================
        // LOOP THROUGH MOVIES
        // ============================================

        int count = 1;

        for (WebElement movie : movies) {

            // Only get TOP 10
            if (count > 10) {
                break;
            }

            try {

                // ====================================
                // GET MOVIE URL
                // ====================================

                String movieUrl =
                        movie.getAttribute("href");

                // Extra safety:
                // Skip /plans URL
                if (movieUrl == null ||
                        movieUrl.contains("/plans")) {

                    continue;
                }

                // ====================================
                // GET MOVIE NAME
                // ====================================

                String movieName = "";

                // Get image
                List<WebElement> images =
                        movie.findElements(
                                By.xpath(".//img")
                        );

                if (!images.isEmpty()) {

                    movieName =
                            images.get(0)
                                    .getAttribute("alt");
                }

                // ====================================
                // FALLBACK 1 - ARIA LABEL
                // ====================================

                if (movieName == null ||
                        movieName.trim().isEmpty()) {

                    movieName =
                            movie.getAttribute(
                                    "aria-label"
                            );
                }

                // ====================================
                // FALLBACK 2 - VISIBLE TEXT
                // ====================================

                if (movieName == null ||
                        movieName.trim().isEmpty()) {

                    movieName =
                            movie.getText();
                }

                // ====================================
                // PRINT RESULT
                // ====================================

                System.out.println(
                        count + ". " + movieName
                );

                System.out.println(
                        "URL: " + movieUrl
                );

                System.out.println(
                        "-----------------------------"
                );

                count++;

            } catch (Exception e) {

                System.out.println(
                        "Unable to read movie "
                                + count
                                + ": "
                                + e.getMessage()
                );
            }
        }

        // ============================================
        // FINAL COUNT
        // ============================================

        System.out.println();

        System.out.println(
                "Total movies printed: "
                        + (count - 1)
        );

    } finally {

        Thread.sleep(3000);

        driver.quit();
    }
}
}