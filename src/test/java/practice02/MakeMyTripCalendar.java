package practice02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class MakeMyTripCalendar {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.makemytrip.com/railways/listing?classCode=1A&className=1st%20Class%20AC&cmp=SEM%7CD%7CRail%7CG%7CRoute%7CDelhi-HV-HC-Route%7CDelhi-Mumbai%7CRSA%7CRegular%7C710809636794&date=20250718&destCity=Secunderabad&destStn=SC&gad_campaignid=21626248760&gad_source=1&gbraid=0AAAAAD5Az1TyjO2JTLOKNx7uQXkEZzRor&gclid=Cj0KCQjwsNnCBhDRARIsAEzia4BH8TC4LApETbHmOJAAythbZlpDmmMAB1B5BKVr7RIIYjffgUc2CqYaAgwSEALw_wcB&s_kwcid=AL%211631%213%21710809636794%21b%21%21g%21%21rajdhani%20express&srcCity=Delhi&srcStn=NDLS");
        driver.manage().window().maximize();

        WebElement travelDate = driver.findElement(By.xpath("//input[@id=\"travelDate\"]"));
        travelDate.click();

        List<WebElement> dateOptions = driver.findElements(By.xpath("//button[@name=\"day\"]"));

        for(WebElement e : dateOptions){

            if(e.getText().contains("30")){
                e.click();
            }
        }

        driver.quit();
    }
}
