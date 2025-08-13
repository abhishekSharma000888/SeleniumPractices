package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FirstDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/frames");

        driver.manage().window().maximize();

       driver.switchTo().frame("frame1");

        String actualText = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Actual text: " + actualText);


        String expectedText = "This is a sample page";

        Assert.assertEquals(actualText,expectedText, "There is a mismatch!");

        driver.quit();
    }
}
