package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CaptureText {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://onecompiler.com/html/43trjgbya");
        driver.manage().window().maximize();

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));

        svgElements.get(18).click();

        List<WebElement> tagSearch = driver.findElements(By.xpath("//p[not(@class)]"));

        String text = tagSearch.get(7).getText();

        System.out.println("The text is: "+ text);

        driver.quit();
    }
}
