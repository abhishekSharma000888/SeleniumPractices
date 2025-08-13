package PracticeTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class FlipkartDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));

        searchBox.sendKeys("Samsung");

        List<WebElement> optionsList = driver.findElements(By.xpath("//*[contains(@class,'YGcVZ')]"));

        for(WebElement e: optionsList){

            if(e.getText().contains("s24")){

                e.click();
            }
        }

        driver.quit();


    }
}
