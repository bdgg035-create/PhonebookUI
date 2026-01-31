package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegisterPositiveTest() {
        click(By.cssSelector("[href='/register']"));
        type(By.id("FirstName"), "Karl");
        type(By.id("LastName"), "Adam");
        type(By.name("Email"), newEmail());
        type(By.name("Password"), "Karl1234");
        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".header [href='/customer/info']")));

    }

    public void click(By locator) {
        click(locator);
    }
}
