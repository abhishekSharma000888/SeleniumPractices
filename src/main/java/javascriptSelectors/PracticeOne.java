package javascriptSelectors;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PracticeOne {

    @Description("Open Polymer project and click on mens outerwear ")
    @Test
    public void selectMensOuterwear(){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");

        WebElement alertButton= driver.findElement(By.id("alert1"));
        js.executeScript("arguments[0].click",alertButton);

        driver.quit();


    }
}
