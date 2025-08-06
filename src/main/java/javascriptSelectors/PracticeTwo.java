package javascriptSelectors;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeTwo {

    @Description("Open Polymer project and click on mens outerwear ")
    @Test
    public void selectMensOuterwear(){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement registration = driver.findElement(By.xpath("//*[text()=\"Registration\"]"));

        js.executeScript("arguments[0].scrollIntoView(true)", registration);

        //js.executeScript("window.ScrollBy(0,500)");

        driver.quit();


    }
}


