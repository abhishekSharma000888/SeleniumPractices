package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class Speed {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://fast.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // The main speed value and units on fast.com commonly use these IDs:
            By speedValue = By.id("speed-value");
            By speedUnits = By.id("speed-units");

            wait.until(ExpectedConditions.visibilityOfElementLocated(speedValue));

            // Capture all changes (keeps insertion order)
            Map<Instant, String> readings = new LinkedHashMap<>();

            String last = "";
            Instant start = Instant.now();
            Duration maxTime = Duration.ofSeconds(45);         // stop after 45s
            Duration stableWindow = Duration.ofSeconds(4);     // stop if stable for 4s
            Instant lastChange = Instant.now();

            while (Duration.between(start, Instant.now()).compareTo(maxTime) < 0) {
                // read displayed value + unit
                String value = driver.findElement(speedValue).getText().trim();
                String unit  = safeGetText(driver, speedUnits).trim(); // sometimes empty briefly
                String current = unit.isEmpty() ? value : value + " " + unit;

                if (!current.isBlank() && !current.equals(last)) {
                    readings.put(Instant.now(), current);
                    System.out.println("Reading: " + current);
                    last = current;
                    lastChange = Instant.now();
                }

                // break if stable for a while
                if (Duration.between(lastChange, Instant.now()).compareTo(stableWindow) > 0) break;

                // small poll interval
                Thread.sleep(200);
            }

            System.out.println("\nCaptured changes in order:");
            readings.forEach((t, v) -> System.out.println(t + " -> " + v));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static String safeGetText(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return "";
        }
    }
}
