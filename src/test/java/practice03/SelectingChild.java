package practice03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectingChild {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();

        WebElement nameInputField = driver.findElement(By.xpath("//label[normalize-space()='Name:']/following-sibling::input[1]"));

        nameInputField.sendKeys("user name");

        driver.quit();

    }
}
