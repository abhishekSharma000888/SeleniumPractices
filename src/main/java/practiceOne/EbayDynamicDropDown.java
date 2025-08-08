package practiceOne;

import jdk.jfr.Description;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EbayDynamicDropDown {

    @Description("Given the user enters cars in search, when the dropdown appears, user selects car toys")
    @Test
    public void validCarToysSelection(){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("car toys");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> dropdownOptions =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(@class,'suggestion')]")));

        for(WebElement e: dropdownOptions){

            String expectedToy = "car toys black wagons";
            String actualToy = e.getText();

            if(actualToy.contains(expectedToy)){

                e.click();
                break;
            }
        }

        driver.quit();
    }
}
