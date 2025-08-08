package practiceOne;

import jdk.jfr.Description;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlipkartDynamicDropDown {

    @Description("Enter Samsung and select samsung ultra")
    @Test
    public void validPhoneSelection() {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));
        searchBox.sendKeys("Samsung");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> searchOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[contains(@class,\"_1sFryS\")]/li")));

        for(WebElement e : searchOptions){

            String expectedProduct = "mobile";
            String actualProduct = e.getText();

            if(actualProduct.contains(expectedProduct)){

                e.click();
                break;
            }

            driver.quit();
        }
    }
    }

