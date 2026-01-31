package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    //before - log in, add contact
    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "manuel@gm.com");
        type(By.name("password"), "Manuel1234$");
        click(By.name("login"));

        click(By.cssSelector("[href='/add']"));
        type(By.xpath("//input[1]"), "Oliver");
        type(By.xpath("//input[2]"), "Kan");
        type(By.xpath("//input[3]"), "1234567890");
        type(By.xpath("//input[4]"), "kan@gm.com");
        type(By.xpath("//input[5]"), "Berlin");
        type(By.xpath("//input[6]"), "goalkeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();
        //click on card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on Remove button
        click(By.xpath("//button[.='Remove']"));
        int sizeAfter = sizeOfContacts();
        //assert
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

    public int sideOfContacts() {
        if ( (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            driver.findElements(By.cssSelector("\".contact-item_card__2SOIM")).size();

        }
        return  0;

    }

    //click on card
    //click on Remove button
    //assert by size
}
