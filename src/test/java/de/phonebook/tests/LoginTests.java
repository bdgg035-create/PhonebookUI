package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "manuel@gm.com");
        //enter password
        type(By.name("password"), "Manuel1234$");
        // click on Login button
        click(By.name("login"));
        //assert Sign Out is present
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }
}
