package de.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

public class AddContactTests extends TestBase {

    //before -log in
    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "manuel@gm.com");
        type(By.name("password"), "Manuel1234$");
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest(){
        //click on add link
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.xpath("//input[1]"), "Oliver");
        //enter lastname
        type(By.xpath("//input[2]"), "Kan");
        //enter phone
        type(By.xpath("//input[3]"), "1234567890");
        //enter email
        type(By.xpath("//input[4]"), "kan@gm.com");
        //enter address
        type(By.xpath("//input[5]"), "Berlin");
        //enter description
        type(By.xpath("//input[6]"), "goalkeeper");
        //save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        // assert by name(text)
        Assert.assertTrue(verifyByName("Oliver"));
}

    public boolean verifyByName(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    @AfterMethod
    public void postConditions() {
        //click on car
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on Remove button
        click(By.xpath("//button[.='Remove']"));
    }
}

