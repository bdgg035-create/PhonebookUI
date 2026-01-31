package de.phonebook.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests extends TestBase {
     WebDriver driver;

     @BeforeMethod
     public void setup() {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get("https://telranedu.web.app");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }

     @AfterMethod(enabled = false)
     public void teardown() {
         if (driver != null) {
             driver.quit();
         }
     }

    @Test
    public void isHomeComponentPresentTest() {
        //System.out.println("Home Component is" + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
         return driver.findElements(By.xpath("//div[2]//h6")).size() > 0;
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
