package PracticeTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FlipkartDemoTwo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));

        searchBox.sendKeys("Samsung");


        driver.findElement(By.xpath("//*[text()=\"Search Icon\"]")).click();

        driver.quit();


    }
}
